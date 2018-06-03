package serviteurs;

import java.util.ArrayList;
import java.util.Arrays;

import capacite.ICapacite;
import capacites.BonusDuHurlevent;
import carte.Serviteur;
import exception.HearthStoneException;

public class ChampionDuHurlevent extends Serviteur {
	public ChampionDuHurlevent() throws HearthStoneException {
		super(7, "Champion du Hurlevent", new ArrayList<ICapacite>(Arrays.asList(
				new BonusDuHurlevent()
				)), 6, 6);
		// TODO Auto-generated constructor stub
	}

}
