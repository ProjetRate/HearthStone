package capacites;

import capacite.Capacite;
import carte.Serviteur;

public class Charge extends Capacite {

	public Charge() {
		super("Charge", "Peut attaquer directement.");
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void executerEffetMiseEnJeu(Object cible) {
		if(cible == null)
			throw new IllegalArgumentException("Erreur: La cible ne doit pas �tre null. Elle doit �tre la carte vis�e.");
		if(!(cible instanceof Serviteur))
			throw new IllegalArgumentException("Erreur: La cible doit �tre un serviteur.");
		Serviteur serviteur = (Serviteur)cible;
		serviteur.setAttaquable(true);
		
		

	}

}
