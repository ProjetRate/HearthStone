package capacites;

import capacite.Capacite;

public class AttaqueCiblee extends Capacite {

	public AttaqueCiblee() {
		super("Attaque cibl�e", "Cette	capacit� permet	� la carte qui la poss�de d'attaquer une cible,	soit le	h�ros, soit	l'un de	ses	serviteurs.	Cette capacit� est sensible � la provocation");
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void executerAction(Object cible) {		
		super.executerAction(cible);
		
	}

}
