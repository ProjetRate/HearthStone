package plateau;

import exception.HearthStoneException;
import joueur.IJoueur;

public interface IPlateau {
	int JOUEURS_MAX = 2;
	int NB_CARTES_DEPART = 4;

	void ajouterJoueur(IJoueur joueur) throws HearthStoneException;
	void demarrerPartie() throws HearthStoneException;
	boolean estDemarree();
	void finTour(IJoueur joueur) throws HearthStoneException; 
	void gagnePartie(IJoueur joueur); 
	IJoueur getAdversaire();
	IJoueur getJoueurCourant();
	void setJoueurCourant(IJoueur joueur); 
	void setAdversaire(IJoueur joueur); 

}
