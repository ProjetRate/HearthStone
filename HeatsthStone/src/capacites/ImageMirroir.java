package capacites;

import capacite.InvocationDeServiteurs;
import exception.HearthStoneException;
import serviteurs.ServiteurDeJaina;

public class ImageMirroir extends InvocationDeServiteurs {

	public ImageMirroir() throws HearthStoneException {
		super("Image mirroir", "Invoque deux serviteurs de Jaina.", new ServiteurDeJaina());
	}

}
