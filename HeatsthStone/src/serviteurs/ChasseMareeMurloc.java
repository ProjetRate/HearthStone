package serviteurs;

import java.util.ArrayList;
import java.util.Arrays;

import capacite.ICapacite;
import capacites.CriDeGuerre;
import carte.Serviteur;
import exception.HearthStoneException;

public class ChasseMareeMurloc extends Serviteur {
	public ChasseMareeMurloc() throws HearthStoneException {
		super(2, "Chasse-marée murloc", new ArrayList<ICapacite>(Arrays.asList(
				new CriDeGuerre()
				)), 2, 1);
	}

}
