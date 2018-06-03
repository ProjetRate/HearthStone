package sorts;

import java.util.ArrayList;
import java.util.Arrays;

import capacite.ICapacite;
import carte.Sort;

public class IntelligenceDesArcanes extends Sort {

	public IntelligenceDesArcanes() {
		super(1, "Intelligence des Arcanes", new ArrayList<ICapacite>(Arrays.asList(
				new capacites.Pioche(),
				new capacites.Pioche()
				)));
		// TODO Auto-generated constructor stub
	}

}
