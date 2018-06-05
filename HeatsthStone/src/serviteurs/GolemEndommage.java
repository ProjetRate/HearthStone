package serviteurs;

import java.util.ArrayList;

import capacite.ICapacite;
import carte.Serviteur;
import exception.HearthStoneException;

public class GolemEndommage extends Serviteur {

	public GolemEndommage() throws HearthStoneException {
		super(1, "Golem endommagé", new ArrayList<ICapacite>(), 2, 1);
	}
	

}
