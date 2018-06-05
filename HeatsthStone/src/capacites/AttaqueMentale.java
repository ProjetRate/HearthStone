package capacites;

import capacite.Capacite;
import exception.HearthStoneException;
import heros.Heros;

public class AttaqueMentale extends Capacite {
	int degats;
	
	public AttaqueMentale() throws HearthStoneException {
		super("Attaque mentale", "Inflige 5 points de d�g�ts au h�ros.");
		setDegats(5);
	}
	
	public void setDegats(int degats) {
		this.degats = degats;
	}
	
	@Override
	public void executerEffetMiseEnJeu(Object cible) {
		if(cible == null)
			throw new IllegalArgumentException("Erreur: La cible ne doit pas �tre null. Elle doit �tre la cible vis�e.");
		if(!(cible instanceof Heros))
			throw new IllegalArgumentException("Erreur: La cible doit �tre un h�ros.");
		Heros heros = (Heros)cible;
		try {
			heros.setPointsVie(heros.getPointsVie() - 1);
		} catch (HearthStoneException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
