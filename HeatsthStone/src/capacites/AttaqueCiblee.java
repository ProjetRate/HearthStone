package capacites;

import capacite.Capacite;
import carte.*;
import exception.HearthStoneException;
import heros.Heros;

public class AttaqueCiblee extends Capacite {
	int degats;

	public AttaqueCiblee(int degats) throws HearthStoneException {
		super("Attaque cibl�e", "Cette	capacit� permet	� la carte qui la poss�de d'attaquer une cible,	soit le	h�ros, soit	l'un de	ses	serviteurs.	Cette capacit� est sensible � la provocation");
		if(degats < 0)
			throw new HearthStoneException("Erreur: D�gats de l'attaque n�gatif");
		this.degats = degats;
	}	
	
	@Override
	public void executerAction(Object cible ) throws HearthStoneException {	
		super.executerAction(cible);
		if(!(cible instanceof Serviteur || cible instanceof Heros))
            throw new HearthStoneException("Vous ne pouvez pas attaquer cette cible.");
		
		if (cible instanceof Heros)
			((Heros) cible).setPointsVie(((Heros) cible).getPointsVie() - 1);
		
		if (cible instanceof Serviteur){
			Serviteur serviteur = (Serviteur) cible;
			if(!serviteur.estAttaquable())
				throw new HearthStoneException("Vous ne pouvez pas attaquer ce serviteur.");
			(serviteur).setPointsVie((serviteur).getPointsVie() - 1);
		}
	}
	

}
