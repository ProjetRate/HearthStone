package joueur;

import carte.ICarte;
import heros.Heros;

import java.util.ArrayList;

public class Joueur implements IJoueur {

    private String nom;
    private Heros heros;
    private int mana = 1;
    

    public Joueur(String pseudo, Heros heros) {
        this.heros = heros;
    }

    public void finirTour() {
    }

    public ICarte getCarteEnJeu(String nomCarte) {
        return null;

    }

    public ICarte getCarteEnMain(String nomCarteMain) {
        return null;

    }    

    public ArrayList<ICarte> getJeu() {
        return null;

    }

    public ArrayList<ICarte> getMain() {
        return null;

    }

    public java.lang.String getPseudo() {
        return null;

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
    
    

}
