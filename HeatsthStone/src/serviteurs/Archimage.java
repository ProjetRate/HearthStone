package serviteurs;

import java.util.ArrayList;
import java.util.Arrays;

import capacite.ICapacite;
import capacites.Provocation;
import carte.Serviteur;
import exception.HearthStoneException;

public class Archimage extends Serviteur {
	
	public Archimage() throws HearthStoneException {
		super(6, "L'ogre-magi", new ArrayList<ICapacite>(Arrays.asList(
				new Provocation()
				)), 4, 7);
	}

}
