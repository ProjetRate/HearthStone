package serviteurs;

import java.util.ArrayList;
import java.util.Arrays;

import capacite.ICapacite;
import capacites.BonusDuChefDeRaid;
import carte.Serviteur;
import exception.HearthStoneException;

public class ChefDeRaid extends Serviteur {
	public ChefDeRaid() throws HearthStoneException {
		super(3, "Chef de raid", new ArrayList<ICapacite>(Arrays.asList(
				new BonusDuChefDeRaid()
				)), 2, 2);
		// TODO Auto-generated constructor stub
	}

}
