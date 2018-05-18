package joueur;

import carte.ICarte;
import jeu.Heros;

import java.util.ArrayList;

public class Joueur implements IJoueur {

    private String nom;

    public Joueur(String pseudo) {
        this.nom = pseudo;
    }

    public void finirTour() {
    }

    public ICarte getCarteEnJeu(String nomCarte) {
        return null;

    }

    public ICarte getCarteEnMain(String nomCarteMain) {
        return null;

    }

    public Heros getHeros() {
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

    public int getEnergie() {
        return 0;

    }

}
