package capacite;

import exception.HearthStoneException;

public class Capacite implements ICapacite{
	
	private String nom, description;

    public Capacite(String nom, String description) {
		if(nom == null)
			throw new IllegalArgumentException("Erreur: Le nom de la carte est null.");
		if(description == null)
			throw new IllegalArgumentException("Erreur: La description de la carte est null.");
		this.nom = nom;
		this.description = description;
	}

	@Override
    public void executerAction(Object cible) throws HearthStoneException {
		/*
		if (this == cible)
			return;
		if (cible == null)
			return ;
		if (getClass() != cible.getClass())
			return;//throw*/
    }

    @Override
    public void executerEffetDebutTour() {

    }

    @Override
    public void executerEffetDisparition(Object cible) {

    }

    @Override
    public void executerEffetFinTour() {

    }

    @Override
    public void executerEffetMiseEnJeu(Object cible) {

    }

    @Override
    public String getNom() {
        return nom;
    }
    
    @Override
    public String getDescription() {
        return description;
    }

	@Override
	public String toString() {
		return "Capacite [nom=" + nom + ", description=" + description + "]";
	}
    
    
}
