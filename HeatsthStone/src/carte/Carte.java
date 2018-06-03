package carte;

import capacite.ICapacite;
import joueur.IJoueur;

import java.util.ArrayList;

public abstract class Carte implements ICarte{

    private int cout;
    private String nom;
    private ArrayList<ICapacite> capacites;

    public Carte(int cout, String nom, ArrayList<ICapacite> capacite) {
        this.cout = cout;
        this.nom = nom;
        this.capacites = capacite;
    }

    @Override
    public boolean disparait() {
        return false;
    }

    @Override
    public void executerAction(Object cible) {

    }

    @Override
    public void executerEffetDebutMiseEnJeu(Object cible) {

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

    public ArrayList<ICapacite> getCapacites() {
        return capacites;
    }

	@Override
	public String toString() {
		return "Carte [cout=" + cout + ", nom=" + nom + ", capacite=" + capacites + "]";
	}
    
    
}
