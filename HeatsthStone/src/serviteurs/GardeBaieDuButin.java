package serviteurs;

import java.util.ArrayList;
import java.util.Arrays;

import capacite.ICapacite;
import capacites.Provocation;
import carte.Serviteur;
import exception.HearthStoneException;

public class GardeBaieDuButin extends Serviteur {
	
	public GardeBaieDuButin() throws HearthStoneException {
		super(5, "Garde de Baie-du-butin", new ArrayList<ICapacite>(Arrays.asList(
				new Provocation()
				)), 5, 4);
	}

}
