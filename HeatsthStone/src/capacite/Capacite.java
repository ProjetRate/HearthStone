package capacite;

import exception.HearthStoneException;

public class Capacite implements ICapacite{
	
	private String nom, description;

    public Capacite(String nom, String description) {
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
	public void executerAction(Object cible, int points) throws HearthStoneException{
		
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
    public String getDescription() {
        return description;
    }

    @Override
    public String getNom() {
        return nom;
    }
}
