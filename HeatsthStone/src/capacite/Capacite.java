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
		return "[" + nom + " : " + description + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Capacite other = (Capacite) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (nom == null) {
			if (other.nom != null)
				return false;
		} else if (!nom.equals(other.nom))
			return false;
		return true;
	}
    
    
}
