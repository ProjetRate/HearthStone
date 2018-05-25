package capacites;

import exception.HearthStoneException;
import capacite.Capacite;
import carte.Serviteur;
import heros.Heros;

public class BouleDeFeu extends Capacite {

	public BouleDeFeu() {
		super("Boule de feu", "Pouvoir héroique: inflige 1 point de dégât au personnage ciblé (le héros adverse ou l'un de ses serviteurs)");
	}

	@Override
	public void executerAction(Object cible) throws HearthStoneException {		
		super.executerAction(cible);
		
		if(!(cible instanceof Serviteur || cible instanceof Heros))
            throw new HearthStoneException("Vous ne pouvez pas attaquer cette cible.");
		
		if (cible instanceof Heros)
			((Heros) cible).setPointsVie(((Heros) cible).getPointsVie() - 1);
		
		if (cible instanceof Serviteur)
			((Serviteur) cible).setPointsVie(((Serviteur) cible).getPointsVie() - 1);
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

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
	
	

}
