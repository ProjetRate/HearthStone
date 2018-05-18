package Joueur;

public interface IPlateau {
	void ajouterJoueur(IJoueur joueur);
	void demarrerPartie();
	boolean estDemarree();
	void finTour(IJoueur joueur); 
	void gagnePartie(IJoueur joueur); 
	IJoueur getAdversaire(IJoueur joueur); 
	IJoueur getJoueurCourant();
	void setJoueurCourant(IJoueur joueur); 
}
