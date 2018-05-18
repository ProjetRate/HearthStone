package carte;

import Joueur.IJoueur;

public interface ICarte {
	boolean disparait();
	void executerAction(Object cible);
	void executerEffetDebutMiseEnJeu();
	void xecuterEffetDebutTour(Object cible);
	void executerEffetDisparition();
	void executerEffetFinTour(Object cible);
	String getCout();
	String getNom();  
	IJoueur getProprietaire();
}
