package capacites;

import capacite.Capacite;

public class TirAssure extends Capacite {

	public TirAssure() {
		super("Tir assur�", "Pouvoir h�roique: inflige 2 point de d�g�t au h�ros adverse");
	}
	
	@Override
	public void executerAction(Object cible) {		
		super.executerAction(cible);
	}

}
