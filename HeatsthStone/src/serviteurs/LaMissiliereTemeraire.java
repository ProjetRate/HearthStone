package serviteurs;

import java.util.ArrayList;
import java.util.Arrays;

import capacite.ICapacite;
import capacites.Charge;
import carte.Serviteur;
import exception.HearthStoneException;

public class LaMissiliereTemeraire extends Serviteur {

	public LaMissiliereTemeraire() throws HearthStoneException {
		super(6, "La missilière téméraire", new ArrayList<ICapacite>(Arrays.asList(
				new Charge()
				)), 5, 2);
	}

}
