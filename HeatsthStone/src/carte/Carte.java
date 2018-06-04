package carte;

import capacite.ICapacite;
import joueur.IJoueur;

import java.util.ArrayList;

public abstract class Carte implements ICarte{

    private int cout;
    private String nom;
    private ArrayList<ICapacite> capacites;
	private IJoueur proprietaire = null;


    public Carte(int cout, String nom, ArrayList<ICapacite> capacite) {
        this.cout = cout;
        this.nom = nom;
        this.capacites = capacite;
    }

    @Override
    public abstract boolean disparait();

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
        return proprietaire;
    }
    
    @Override
    public void setProprietaire(IJoueur proprietaire) {
    	if(proprietaire == null)
    		throw new IllegalArgumentException("Erreur: Le propriétaire ne peut plus être null.");
    	this.proprietaire = proprietaire;
    }

    public ArrayList<ICapacite> getCapacites() {
        return capacites;
    }

	@Override
	public String toString() {
		//return "Carte [cout=" + cout + ", nom=" + nom + ", capacite=" + capacites + "]";
		return "[" + cout +" "+ nom + "]"; 
	}
    
    
}
