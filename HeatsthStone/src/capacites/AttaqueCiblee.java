package capacites;

import capacite.Capacite;
import carte.*;
import exception.HearthStoneException;
import heros.Heros;

public class AttaqueCiblee extends Capacite {
	int degats;	

	public AttaqueCiblee(int degats) throws HearthStoneException {
		super("Attaque ciblée", "Cette capacité permet à la carte qui la possède d'attaquer une cible, soit le héros, soit l'un de ses serviteurs. Cette capacité est sensible à la provocation");
		setDegats(degats);
	}	
	
	public void setDegats(int degats) {
		this.degats = degats;
	}
	
	@Override
	public void executerAction(Object cible ) throws HearthStoneException {	
		if(cible == null)
			throw new IllegalArgumentException("Erreur: L'objet ne peut pas être null.");
		if(!(cible instanceof Serviteur || cible instanceof Heros))
            throw new HearthStoneException("Vous ne pouvez pas attaquer cette cible.");
		
		if (cible instanceof Heros) {
			Heros heros = (Heros) cible;
			
			if(!heros.estAttaquable())
				throw new HearthStoneException("Vous ne pouvez pas attaquer le heros adverse.");
			heros.setPointsVie((heros).getPointsVie() - degats);
			
		}
		
		if (cible instanceof Serviteur){
			Serviteur serviteur = (Serviteur) cible;
			if(!serviteur.estAttaquable())
				throw new HearthStoneException("Vous ne pouvez pas attaquer ce serviteur.");
			serviteur.setPointsVie((serviteur).getPointsVie() - degats);
		}
	}
	

}
