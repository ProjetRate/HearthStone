package capacite;

import carte.ICarte;
import carte.Serviteur;
import exception.HearthStoneException;

public class InvocationDeServiteurs extends Capacite {
	private String nom, description;
	private ICarte carteInvoque;
	
	public InvocationDeServiteurs(String nom, String description, ICarte carte) {
		super(nom, description);
		//La carte invoquée peut être null
		this.carteInvoque = carte;
	}

	@Override
	public void executerAction(Object cible) throws HearthStoneException {
		// TODO Auto-generated method stub

	}

	@Override
	public void executerEffetDebutTour() {
		// TODO Auto-generated method stub

	}

	@Override
	public void executerEffetDisparition(Object cible) {
		// TODO Auto-generated method stub

	}

	@Override
	public void executerEffetFinTour() {
		// TODO Auto-generated method stub

	}

	@Override
	public void executerEffetMiseEnJeu(Object cible) {
		if(cible == null)
			throw new IllegalArgumentException("Erreur: La cible ne doit pas être null. Elle doit être la carte jouée.");
		Serviteur invoqueur = (Serviteur)cible;
		//On ajoute le serviteur invoqué à la suite du serviteur joué
		int index = invoqueur.getProprietaire().getJeu().indexOf(invoqueur);
		invoqueur.getProprietaire().getJeu().add(index+1, carteInvoque);		

	}
	
	@Override
	public String toString() {
		return "Capacite [" + nom + " : " + description+"]";
	}

}
