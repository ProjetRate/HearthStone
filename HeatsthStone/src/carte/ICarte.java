package carte;

import joueur.IJoueur;

public interface ICarte {
	boolean disparait();
	void executerAction(Object cible);
	void executerEffetDebutMiseEnJeu();
	void executerEffetDebutTour(Object cible);
	void executerEffetDisparition();
	void executerEffetFinTour(Object cible);
	int getCout();
	String getNom();  
	IJoueur getProprietaire();
}
