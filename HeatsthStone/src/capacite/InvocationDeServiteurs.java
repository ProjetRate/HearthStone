package capacite;

import carte.ICarte;
import carte.Serviteur;
import exception.HearthStoneException;

public class InvocationDeServiteurs extends Capacite {
	private ICarte carteInvoque;
	
	public InvocationDeServiteurs(String nom, String description, ICarte carte) {
		super(nom, description);
		//La carte invoqu�e peut �tre null
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
			throw new IllegalArgumentException("Erreur: La cible ne doit pas �tre null. Elle doit �tre la carte jou�e.");
		Serviteur invoqueur = (Serviteur)cible;
		invoqueur.getProprietaire().getJeu().add(carteInvoque);
		carteInvoque.setProprietaire(invoqueur.getProprietaire());

		for(ICarte carteEnjeu : carteInvoque.getProprietaire().getJeu()) {
			for(ICapacite capaciteCarteEnJeu : carteEnjeu.getCapacites())
				if(capaciteCarteEnJeu instanceof EffetPermanent)
					try {
						capaciteCarteEnJeu.executerAction(carteInvoque);
					} catch (HearthStoneException e) {
						e.printStackTrace();
					}
		}

	}

}
