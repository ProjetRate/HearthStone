package capacites;

import capacite.Capacite;
import capacite.ICapacite;
import carte.ICarte;
import carte.Serviteur;

public class Provocation extends Capacite {

	public Provocation() {
		super("Provocation", "Oblige l'adversaire � viser ce serviteur.");
		// TODO Auto-generated constructor stub
	}
	@Override
	public void executerEffetMiseEnJeu(Object cible) {
		if (cible == null)
			throw new IllegalArgumentException("Erreur: La cible est null");
		if (!(cible instanceof Serviteur))
			throw new IllegalArgumentException("Erreur: La cible doit �tre un serviteur.");
		Serviteur provoqueur = (Serviteur)cible;
		provoqueur.getProprietaire().getHeros().setAttaquable(false);
		for (ICarte serviteurAllie : provoqueur.getProprietaire().getJeu()) {
			if(serviteurAllie instanceof Serviteur) {
				if(((Serviteur) serviteurAllie).estAttaquable()) {
					//On v�rifie que le serviteur alli� ne poss�de pas provocation
					boolean possedeProvocation = false;
					for (ICapacite capaciteServiteurAllie : ((Serviteur) serviteurAllie).getCapacites()) {
						if(capaciteServiteurAllie.equals(this))
							possedeProvocation = true;							
					}
					((Serviteur) serviteurAllie).setAttaquable(possedeProvocation);
					
				}
			}
		}
	}	
	
	@Override
	public void executerEffetDisparition(Object cible) {
		// TODO Auto-generated method stub
		super.executerEffetDisparition(cible);
	}
	
	
}
