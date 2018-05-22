package capacites;

import capacite.Capacite;

public class TirAssure extends Capacite {

	public TirAssure() {
		super("Tir assuré", "Pouvoir héroique: inflige 2 point de dégât au héros adverse");
	}
	
	@Override
	public void executerAction(Object cible) {		
		super.executerAction(cible);
	}

}
