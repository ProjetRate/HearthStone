package capacites;

import capacite.InvocationDeServiteurs;
import exception.HearthStoneException;
import serviteurs.GolemEndommage;

public class Golemisation extends InvocationDeServiteurs {

	public Golemisation() throws HearthStoneException {
		super("Golemisation", "Râle d'agonie: Invocation d'un golem 1/2", new GolemEndommage());
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void executerEffetDisparition(Object cible) {
		super.executerEffetMiseEnJeu(cible);
	}
	
	@Override
	public void executerEffetMiseEnJeu(Object cible) {
		
	}

}
