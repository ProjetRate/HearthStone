package joueur;

import carte.ICarte;
import exception.HearthStoneException;
import heros.Heros;

import java.util.ArrayList;

public class Joueur implements IJoueur {
    private String nom;
    private Heros heros;
    private int mana = 1, manaMax = 1;
    private ArrayList<ICarte> cartesEnMain, cartesEnJeu;
    

    public Joueur(String pseudo, Heros heros) {
    	this.nom = pseudo;
        this.heros = heros;
    }

    public void finirTour() {   
    }

    @Override
    public ICarte getCarteEnJeu(String nomCarte) throws HearthStoneException {
    	for (ICarte carte : cartesEnJeu) {
    		 if( carte.getNom().contains(nomCarte))
    			 return carte;
		}
        throw new HearthStoneException("La carte n'est pas en jeu");

    }

    public ICarte getCarteEnMain(String nomCarte) throws HearthStoneException {
    	for (ICarte carte : cartesEnMain) {
   		 if( carte.getNom().contains(nomCarte))
   			 return carte;
		}
       throw new HearthStoneException("La carte n'est pas dans votre main");

    }    

    public ArrayList<ICarte> getJeu() {
        return cartesEnJeu;

    }

    public ArrayList<ICarte> getMain() {
        return cartesEnMain;

    }

    public int getStockEnergie() {
        return 0;

    }

    public void jouerCarte(ICarte carte) {

    }

    public void jouerCarte(ICarte carte, java.lang.Object cible) {

    }

    public void perdreCarte(ICarte carte) {

    }

    public void piocher() {

    }

    public void prendreTour() {
    	if (manaMax < MAX_MANA)
    		manaMax = manaMax + 1;
    	mana = manaMax;
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
