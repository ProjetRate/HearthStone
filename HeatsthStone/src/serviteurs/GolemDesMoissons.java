package serviteurs;

import java.util.ArrayList;
import java.util.Arrays;

import capacite.ICapacite;
import capacites.Golemisation;
import carte.Serviteur;
import exception.HearthStoneException;

public class GolemDesMoissons extends Serviteur {

	public GolemDesMoissons() throws HearthStoneException {
		super(3, "Golem des moissons", new ArrayList<ICapacite>(Arrays.asList(
				new Golemisation()
				)), 2, 3);
	}

}
