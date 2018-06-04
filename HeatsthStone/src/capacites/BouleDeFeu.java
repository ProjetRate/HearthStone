package capacites;

import exception.HearthStoneException;

import java.util.Scanner;

import capacite.Capacite;
import carte.Serviteur;
import heros.Heros;
import joueur.IJoueur;
import plateau.Plateau;

public class BouleDeFeu extends Capacite {

	public BouleDeFeu() { //capacité spéciale
		super("Boule de feu", "Pouvoir héroique: inflige 1 point de dégât au personnage ciblé (le héros adverse ou l'un de ses serviteurs. Coût = 2)");
	}

	@Override
	public void executerAction(Object cible) throws HearthStoneException {		
		if(cible == null)
			throw new IllegalArgumentException("Erreur: C'est pas possible, mais bon.");
		if(!(cible instanceof Plateau))
			throw new IllegalArgumentException("Erreur: La cible doit être le plateau.");
		Plateau plateau = (Plateau) cible;
		Heros herosAdversaire = plateau.getAdversaire().getHeros();		

		if(!((IJoueur) plateau.getJoueurCourant()).getHeros().peutAttaquer())
			throw new HearthStoneException("Le héros ne peut pas attaquer.");
		if(plateau.getJoueurCourant().getMana() - 2 < 0)
			throw new HearthStoneException("Vous n'avez pas assez de mana.");
		
		System.out.println("Cible -> ");
		
		
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		String requete = sc.nextLine();
		
		if(herosAdversaire.getNom().toLowerCase().contains(requete.toLowerCase())) {
			herosAdversaire.setPointsVie(herosAdversaire.getPointsVie() - 1);
			plateau.gagnePartie(plateau.getJoueurCourant());
    	} else {
    		Serviteur serviteurAdverse = (Serviteur) plateau.getAdversaire().getCarteEnJeu(requete);
    		serviteurAdverse.setPointsVie(serviteurAdverse.getPointsVie() - 1);
    		
    	}
		plateau.getJoueurCourant().getHeros().setPeutAttaquer(false);
		plateau.getJoueurCourant().setMana(plateau.getJoueurCourant().getMana() - 2);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		// TODO Auto-generated method stub
		Capacite other = (Capacite)obj;
		return super.getDescription() == other.getDescription();
	}
	

}
