package serviteurs;

import java.util.ArrayList;
import java.util.Arrays;

import capacite.ICapacite;
import capacites.Provocation;
import carte.Serviteur;
import exception.HearthStoneException;

public class OgreMagi extends Serviteur {
	
	public OgreMagi() throws HearthStoneException {
		super(4, "L'ogre-magi", new ArrayList<ICapacite>(Arrays.asList(
				new Provocation()
				)), 4, 4);
	}

}
