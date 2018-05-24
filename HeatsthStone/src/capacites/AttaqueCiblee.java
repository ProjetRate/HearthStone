package capacites;

import capacite.Capacite;
import carte.*;
import exception.HearthStoneException;
import heros.Heros;

public class AttaqueCiblee extends Capacite {

	public AttaqueCiblee() {
		super("Attaque cibl�e", "Cette	capacit� permet	� la carte qui la poss�de d'attaquer une cible,	soit le	h�ros, soit	l'un de	ses	serviteurs.	Cette capacit� est sensible � la provocation");
		// TODO Auto-generated constructor stub
	}	
	
	@Override
	public void executerAction(Object cible, int degats) throws HearthStoneException {	
		super.executerAction(cible);
		if(!(cible instanceof Serviteur || cible instanceof Heros))
            throw new HearthStoneException("Vous ne pouvez pas attaquer cette cible.");
		
		if (cible instanceof Heros)
			((Heros) cible).setPointsVie(((Heros) cible).getPointsVie() - 1);
		
		if (cible instanceof Serviteur){
			Serviteur serviteur = (Serviteur) cible;
			(serviteur).setPointsVie((serviteur).getPointsVie() - 1);
		}
	}
	

}
