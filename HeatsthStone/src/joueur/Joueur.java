package joueur;

import carte.ICarte;
import deck.Deck;
import exception.HearthStoneException;
import heros.Heros;

import java.util.ArrayList;

import capacite.ICapacite;

public class Joueur implements IJoueur {
    private String nom;
    private Heros heros;
    private int mana = 1, manaMax = 1;
    private ArrayList<ICarte> cartesEnMain = new ArrayList<ICarte>(), cartesEnJeu = new ArrayList<ICarte>();
	private Deck deck;
    

    public Joueur(String pseudo, Heros heros, Deck deck) {
    	this.nom = pseudo;
        this.heros = heros;
        this.deck = deck;
    }

    public void finirTour() {   
    }

    @Override
    public ICarte getCarteEnJeu(String nomCarte) throws HearthStoneException {
    	for (ICarte carte : cartesEnJeu) {
    		 if( carte.getNom().contains(nomCarte))
    			 return carte;
		}
        throw new HearthStoneException("La carte n'est pas sur le plateau.");

    }

    public ICarte getCarteEnMain(String nomCarte) throws HearthStoneException {
    	for (ICarte carte : cartesEnMain) {
   		 if( carte.getNom().contains(nomCarte))
   			 return carte;
		}
       throw new HearthStoneException("La carte n'est pas dans votre main.");

    }    

    public ArrayList<ICarte> getJeu() {
        return cartesEnJeu;

    }

    public ArrayList<ICarte> getMain() {
        return cartesEnMain;

    }

    public void jouerCarte(ICarte carte) throws HearthStoneException {
    	if (carte == null)
			throw new IllegalArgumentException("Erreur: La carte est null.");
    	
    	if(mana - carte.getCout() <= 0)
    		throw new HearthStoneException("Vous n'avez pas assez de mana pour jouer cette carte.");
    	
    	setMana(mana - carte.getCout());
    	
		this.getMain().remove(carte);
		this.getJeu().add(carte);
		
		if (carte.getCapacites() == null)
			throw new IllegalArgumentException("Erreur: La liste de capacités est null.");
		
		for (ICapacite capacite : carte.getCapacites()) {
			capacite.executerEffetMiseEnJeu(carte);
			}
		if(carte.disparait())
			this.perdreCarte(carte);
    }

    public void jouerCarte(ICarte carte, java.lang.Object cible) {
    	

    }

    public void perdreCarte(ICarte carte) {
    	if (carte.equals(null))
			throw new IllegalArgumentException("Erreur: La carte est null.");
		try {
			carte = this.getCarteEnJeu(carte.getNom());
		} catch (HearthStoneException e) {
			// TODO: handle exception
		}
		cartesEnJeu.remove(carte);

    }

    public void piocher() throws HearthStoneException{
    	if(cartesEnMain.size() == MAX_CARTES_MAIN)
    		throw new HearthStoneException("Le nombre maximum de cartes en main est atteint.");
    	
    	try {
			cartesEnMain.add(deck.prendreCarte(this));
		} catch (HearthStoneException e) {
			System.out.println(e.getMessage());
		}

    }

    public void prendreTour() {
    	if (manaMax < MAX_MANA)
    		manaMax = manaMax + 1;
    	mana = manaMax;   	
    	
    	try {
    		piocher();
    	} catch(HearthStoneException e){
    		System.out.println(e.getMessage());
    	}
    	
    }

    public void utiliserCarte(ICarte carte, java.lang.Object cible) {

    }


    public void utiliserPouvoir(java.lang.Object cible) {

    }    

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public Heros getHeros() {
        return heros;
    }
	public void setHeros(Heros heros) {
		this.heros = heros;
	}
	
	public int getMana() {
        return mana;
    }
	public void setMana(int mana) {
		this.mana = mana;
	}

	@Override
	public String toString() {
		return "Joueur [nom=" + nom + ", heros=" + heros + ", mana=" + mana + ", manaMax=" + manaMax + ", cartesEnMain="
				+ cartesEnMain + ", cartesEnJeu=" + cartesEnJeu + "]";
	}
    
    

}
