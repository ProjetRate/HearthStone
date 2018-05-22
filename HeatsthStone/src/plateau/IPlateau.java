package plateau;

import exception.HearthStoneException;
import joueur.IJoueur;

public interface IPlateau {
	void ajouterJoueur(IJoueur joueur) throws HearthStoneException;
	void demarrerPartie();
	boolean estDemarree();
	void finTour(IJoueur joueur); 
	void gagnePartie(IJoueur joueur); 
	IJoueur getAdversaire(IJoueur joueur);
	IJoueur getJoueurCourant();
	void setJoueurCourant(IJoueur joueur); 
}
