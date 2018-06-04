package joueur;

import carte.ICarte;
import carte.Serviteur;
import deck.Deck;
import exception.HearthStoneException;
import heros.Heros;

import java.util.ArrayList;

import capacite.EffetPermanent;
import capacite.ICapacite;
import capacites.Provocation;

public class Joueur implements IJoueur {
    private String nom;
    private Heros heros;
    private int mana = 1, manaMax = 1;
    private ArrayList<ICarte> cartesEnMain = new ArrayList<ICarte>(), cartesEnJeu = new ArrayList<ICarte>();
	private Deck deck;
    

    public Joueur(String pseudo, Heros heros, Deck deck) {
    	this.nom = pseudo;
        this.heros = heros;
        heros.setProprietaire(this);
        this.deck = deck;
    }

    public void finirTour() {   
    }

    @Override
    public ICarte getCarteEnJeu(String nomCarte) throws HearthStoneException {
    	for (ICarte carte : cartesEnJeu) {
    		 if( carte.getNom().toLowerCase().contains(nomCarte.toLowerCase()))
    			 return carte;
		}
        throw new HearthStoneException("La carte n'est pas sur le plateau.");

    }

    public ICarte getCarteEnMain(String nomCarte) throws HearthStoneException {
    	for (ICarte carte : cartesEnMain) {
   		 if( carte.getNom().toLowerCase().contains(nomCarte.toLowerCase()))
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
    	
    	if(mana - carte.getCout() < 0)
    		throw new HearthStoneException("Vous n'avez pas assez de mana pour jouer cette carte.");
    	
    	setMana(mana - carte.getCout());
    	
    	cartesEnMain.remove(carte);
		
		if (carte.getCapacites() == null)
			throw new IllegalArgumentException("Erreur: La liste de capacités est null.");
		
				
		carte.executerEffetDebutMiseEnJeu(carte);

		if(carte instanceof Serviteur) {
			for(ICarte carteEnjeu : cartesEnJeu) {
				for(ICapacite capaciteCarteEnJeu : carteEnjeu.getCapacites())
					if(capaciteCarteEnJeu instanceof EffetPermanent || capaciteCarteEnJeu instanceof Provocation)
						capaciteCarteEnJeu.executerAction((Serviteur) carte);
			}
		}
		this.getJeu().add(carte);
		if(carte.disparait())
			this.perdreCarte(carte);
    }

    public void perdreCarte(ICarte carte) {
    	if (carte.equals(null))
			throw new IllegalArgumentException("Erreur: La carte est null.");
		try {
			carte = this.getCarteEnJeu(carte.getNom());
			cartesEnJeu.remove(carte);
			carte.executerEffetDisparition();
		} catch (HearthStoneException e) {
			System.out.println(e.getMessage());
		}

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
    	heros.setPeutAttaquer(true);
    	for (ICarte carte : cartesEnJeu) {
			if(carte instanceof Serviteur) {
				((Serviteur) carte).setPeutAttaquer(true);
			}
		}
    	
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
		//return "Joueur [nom=" + nom + ", heros=" + heros + ", mana=" + mana + ", manaMax=" + manaMax + ", cartesEnMain="
		//		+ cartesEnMain + ", cartesEnJeu=" + cartesEnJeu + "]";
		return " " + nom + " mana=" + mana;
	}
    
    

}
