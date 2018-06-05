package serviteurs;

import java.util.ArrayList;
import java.util.Arrays;

import capacite.ICapacite;
import capacites.Provocation;
import carte.Serviteur;
import exception.HearthStoneException;

public class ServiteurDeJaina extends Serviteur {
	
	public ServiteurDeJaina() throws HearthStoneException {
		super(1, "Serviteur de Jaina", new ArrayList<ICapacite>(Arrays.asList(
				new Provocation()
				)), 0, 1);
	}

}
