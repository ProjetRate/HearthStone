package capacites;

import capacite.Capacite;
import capacite.ICapacite;
import carte.ICarte;
import carte.Serviteur;

public class Provocation extends Capacite {

	public Provocation() {
		super("Provocation", "Oblige l'adversaire à viser ce serviteur.");
	}
	@Override
	public void executerEffetMiseEnJeu(Object cible) {
		if (cible == null)
			throw new IllegalArgumentException("Erreur: La cible est null");
		if (!(cible instanceof Serviteur))
			throw new IllegalArgumentException("Erreur: La cible doit être un serviteur.");
		Serviteur provoqueur = (Serviteur)cible;
		provoqueur.getProprietaire().getHeros().setAttaquable(false);
		for (ICarte serviteurAllie : provoqueur.getProprietaire().getJeu()) {
			if(serviteurAllie instanceof Serviteur) {
				if(((Serviteur) serviteurAllie).estAttaquable()) {
					//On vérifie que le serviteur allié ne possède pas provocation
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
		if (cible == null)
			throw new IllegalArgumentException("Erreur: La cible est null");
		if (!(cible instanceof Serviteur))
			throw new IllegalArgumentException("Erreur: La cible doit être un serviteur.");
		Serviteur provoqueur = (Serviteur)cible;
		//On vérifie que les autres serviteurs sont tous inattaquables, sinon il y a un autre serviteur avec provocation
		for (ICarte serviteurAllie : provoqueur.getProprietaire().getJeu()) {
			
		}
		provoqueur.getProprietaire().getHeros().setAttaquable(true);
		for (ICarte serviteurAllie : provoqueur.getProprietaire().getJeu()) {
			if(serviteurAllie instanceof Serviteur) {
				if(((Serviteur) serviteurAllie).estAttaquable()) {
					//On vérifie que le serviteur allié ne possède pas provocation
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
	
	
}
