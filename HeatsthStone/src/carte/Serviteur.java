package carte;

import capacite.ICapacite;
import heros.Heros;

import java.util.ArrayList;

public class Serviteur extends Carte {
    private int pointsAttaque;
    private int pointsVie;
    private boolean peutEtreAttaque;

    public Serviteur(int cout, String nom, ArrayList<ICapacite> capacite, Heros heros, int pointsAttaque, int pointsVie) {
        super(cout, nom, capacite, heros);
        this.pointsAttaque = pointsAttaque;
        this.pointsVie = pointsVie;
    }

    public Serviteur(int cout, String nom, ArrayList<ICapacite> capacite, int pointsAttaque, int pointsVie) {
        super(cout, nom, capacite);
        this.pointsAttaque = pointsAttaque;
        this.pointsVie = pointsVie;
    }

    public int getPointsAttaque() {
        return pointsAttaque;
    }

    public int getPointsVie() {
        return pointsVie;
    }
    
    public void setPointsVie(int pointsVie) {
        this.pointsVie = pointsVie;
    }

    public void setPointsAttaque(int pointsAttaque) {
        this.pointsAttaque = pointsAttaque;
    }
}
