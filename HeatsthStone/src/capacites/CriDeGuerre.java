package capacites;

import capacite.InvocationDeServiteurs;
import exception.HearthStoneException;
import serviteurs.EclaireurMurloc;

public class CriDeGuerre extends InvocationDeServiteurs {

	public CriDeGuerre() throws HearthStoneException {
		super("Cri de guerre", "Invocation d'un éclaireur murloc 1/1", new EclaireurMurloc());
		// TODO Auto-generated constructor stub
	}

}
