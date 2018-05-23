package capacites;

import capacite.Capacite;

public class AttaqueCiblee extends Capacite {

	public AttaqueCiblee() {
		super("Attaque ciblée", "Cette	capacité permet	à la carte qui la possède d'attaquer une cible,	soit le	héros, soit	l'un de	ses	serviteurs.	Cette capacité est sensible à la provocation");
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void executerAction(Object cible) {		
		super.executerAction(cible);
		
	}

}
