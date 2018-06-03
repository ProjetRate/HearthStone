package carte;

import java.util.ArrayList;

import capacite.ICapacite;
import joueur.IJoueur;

public interface ICarte {
	boolean disparait();
	void executerAction(Object cible);
	void executerEffetDebutMiseEnJeu(Object cible);
	void executerEffetDebutTour(Object cible);
	void executerEffetDisparition();
	void executerEffetFinTour(Object cible);
	int getCout();
	String getNom();  
	IJoueur getProprietaire();
	ArrayList<ICapacite> getCapacites();
}
