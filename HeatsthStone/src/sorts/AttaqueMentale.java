package sorts;

import java.util.ArrayList;
import java.util.Arrays;

import capacite.ICapacite;
import carte.Sort;
import exception.HearthStoneException;

public class AttaqueMentale extends Sort {

	public AttaqueMentale() throws HearthStoneException {
		super(1, "Image mirroir", new ArrayList<ICapacite>(Arrays.asList(
				new capacites.AttaqueMentale()
				)));
	}
	
	@Override
	public void executerEffetDebutMiseEnJeu(Object cible) {
		// TODO Auto-generated method stub
		super.executerEffetDebutMiseEnJeu(cible);
	}

}
