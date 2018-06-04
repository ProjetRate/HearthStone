package capacites;

import capacite.Capacite;
import exception.HearthStoneException;
import heros.Heros;
import joueur.IJoueur;
import plateau.Plateau;

public class TirAssure extends Capacite {

	public TirAssure() {
		super("Tir assuré", "Pouvoir héroique: inflige 2 point de dégât au héros adverse. Coût = 2");
	}

	@Override
	public void executerAction(Object cible) throws HearthStoneException {
		if(cible == null)
			throw new IllegalArgumentException("Erreur: C'est pas possible, mais bon.");
		if(!(cible instanceof Plateau))
			throw new IllegalArgumentException("Erreur: La cible doit être le plateau.");
		Plateau plateau = (Plateau) cible;
		if(!((IJoueur) plateau.getJoueurCourant()).getHeros().peutAttaquer())
			throw new HearthStoneException("Le héros ne peut pas attaquer.");
		if(plateau.getJoueurCourant().getMana() - 2 < 0)
			throw new HearthStoneException("Vous n'avez pas assez de mana.");		
		if(!(plateau.getAdversaire().getHeros() instanceof Heros))
			throw new HearthStoneException("Vous ne pouvez pas attaquer cette cible.");
		Heros personnageCible = (Heros) plateau.getAdversaire().getHeros();
		personnageCible.setPointsVie(personnageCible.getPointsVie() - 2);
		plateau.getJoueurCourant().setMana(plateau.getJoueurCourant().getMana() - 2);
		plateau.getJoueurCourant().getHeros().setPeutAttaquer(false);
		plateau.gagnePartie(plateau.getJoueurCourant());

	}

}
