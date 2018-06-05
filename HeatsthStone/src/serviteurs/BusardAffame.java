package serviteurs;

import java.util.ArrayList;
import java.util.Arrays;

import capacite.ICapacite;
import capacites.Pioche;
import carte.Serviteur;
import exception.HearthStoneException;

public class BusardAffame extends Serviteur {
	
	public BusardAffame() throws HearthStoneException {
		super(5, "Busard affamé", new ArrayList<ICapacite>(Arrays.asList(
				new Pioche()
				)), 3, 2);
	}
}
