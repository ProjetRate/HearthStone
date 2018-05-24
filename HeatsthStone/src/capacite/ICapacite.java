package capacite;

import exception.HearthStoneException;

public interface ICapacite {
	void executerAction(Object cible) throws HearthStoneException;
	void executerAction(Object cible, int points) throws HearthStoneException;
	void executerEffetDebutTour();
	void executerEffetDisparition(Object cible);
	void executerEffetFinTour();
	void executerEffetMiseEnJeu(Object cible);
	String getDescription();
	String getNom();
	
}
