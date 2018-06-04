package sorts;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import capacite.ICapacite;
import carte.ICarte;
import carte.Serviteur;
import carte.Sort;
import exception.HearthStoneException;

public class Charge extends Sort {

	public Charge() {
		super(1, "Charge", new ArrayList<ICapacite>(Arrays.asList(new capacites.Charge())));
		// TODO Auto-generated constructor stub
	}

	@Override
    public void executerEffetDebutMiseEnJeu(Object cible) {
		System.out.println("Quelle est la cible?");
		if(cible == null)
			throw new IllegalArgumentException("Erreur: La cible ne doit pas être null. Elle doit être la carte Charge.");
		if(!(cible instanceof Sort))
			throw new IllegalArgumentException("Erreur: La cible doit être un sort.");
		Sort sort = (Sort)cible;
		
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		
		try {
			ICarte carteCible = sort.getProprietaire().getCarteEnJeu(sc.nextLine().toLowerCase());
		
			//sc.close();
			if(carteCible == null)
				throw new IllegalArgumentException("Erreur: La cible ne doit pas être null. Elle doit être la carte visée.");
			if(!(carteCible instanceof Serviteur))
				throw new IllegalArgumentException("Erreur: La cible doit être un serviteur.");
			Serviteur serviteur = (Serviteur)carteCible;

			serviteur.getCapacites().add(super.getCapacites().get(0));
			super.getCapacites().get(0).executerEffetMiseEnJeu(serviteur);
		} catch (HearthStoneException e) {
			System.out.println(e.getMessage());
			sort.getProprietaire().getMain().add(this);
			sort.getProprietaire().setMana(sort.getProprietaire().getMana()+1);
		}
		
    }
}
