package sorts;

import java.util.ArrayList;
import java.util.Arrays;

import capacite.ICapacite;
import carte.Sort;
import exception.HearthStoneException;

public class ImageMirroir extends Sort {

	public ImageMirroir() throws HearthStoneException {
		super(1, "Image mirroir", new ArrayList<ICapacite>(Arrays.asList(
				new capacites.ImageMirroir(),
				new capacites.ImageMirroir()
				)));
	}

}
