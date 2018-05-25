package carte;

import capacite.ICapacite;
import heros.Heros;
import joueur.IJoueur;

import java.util.ArrayList;

public abstract class Carte implements ICarte{

    private int cout;
    private String nom;
    private ArrayList<ICapacite> capacite;
    private Heros heros;

    public Carte(int cout, String nom, ArrayList<ICapacite> capacite, Heros heros) {
        this.cout = cout;
        this.nom = nom;
        this.capacite = capacite;
        this.heros = heros;
    }

    public Carte(int cout, String nom, ArrayList<ICapacite> capacite) {
        this.cout = cout;
        this.nom = nom;
        this.capacite = capacite;
    }

    @Override
    public boolean disparait() {
        return false;
    }

    @Override
    public void executerAction(Object cible) {

    }

    @Override
    public void executerEffetDebutMiseEnJeu() {

    }

    @Override
    public void executerEffetDebutTour(Object cible) {

    }

    @Override
    public void executerEffetDisparition() {

    }

    @Override
    public void executerEffetFinTour(Object cible) {

    }

    @Override
    public int getCout() {
        return cout;
    }

    @Override
    public String getNom() {
        return nom;
    }

    @Override
    public IJoueur getProprietaire() {
        return null;
    }

    public ArrayList<ICapacite> getCapacite() {
        return capacite;
    }

	@Override
	public String toString() {
		return "Carte [cout=" + cout + ", nom=" + nom + ", capacite=" + capacite + ", heros=" + heros + "]";
	}
    
    
}
