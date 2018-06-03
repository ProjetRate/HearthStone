package sorts;

import java.util.ArrayList;
import java.util.Arrays;

import capacite.ICapacite;
import carte.Serviteur;
import carte.Sort;

public class Charge extends Sort {

	public Charge() {
		super(1, "Charge", new ArrayList<ICapacite>(Arrays.asList(new capacites.Charge())));
		// TODO Auto-generated constructor stub
	}

	@Override
    public void executerEffetDebutMiseEnJeu(Object cible) {
		if(cible == null)
			throw new IllegalArgumentException("Erreur: La cible ne doit pas être null. Elle doit être la carte visée.");
		if(!(cible instanceof Serviteur))
			throw new IllegalArgumentException("Erreur: La cible doit être un serviteur.");
		Serviteur serviteur = (Serviteur)cible;

		serviteur.getCapacites().add(super.getCapacites().get(0));
    }
}
