package capacites;

import capacite.Capacite;
import exception.HearthStoneException;
import heros.Heros;

public class TirAssure extends Capacite {

	public TirAssure() {
		super("Tir assuré", "Pouvoir héroique: inflige 2 point de dégât au héros adverse");
	}

	@Override
	public void executerAction(Object cible) throws HearthStoneException {	
		if(!(cible instanceof Heros))
			throw new HearthStoneException("Vous ne pouvez pas attaquer cette cible.");
		((Heros) cible).setPointsVie(((Heros) cible).getPointsVie() - 2);

	}

}
