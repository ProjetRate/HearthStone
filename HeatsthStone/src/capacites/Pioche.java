package capacites;

import capacite.Capacite;
import carte.ICarte;
import exception.HearthStoneException;

public class Pioche extends Capacite {

	public Pioche() {
		super("Pioche", "La carte qui possède cette capacité permet de piocher une carte.");
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void executerEffetMiseEnJeu(Object cible) {
		if(cible == null)
			throw new IllegalArgumentException("Erreur: La cible est null.");
		if(!(cible instanceof ICarte))
			throw new IllegalArgumentException("Erreur: La cible doit être la carte jouée.");
		ICarte carte = (ICarte)cible;
		try {
			carte.getProprietaire().piocher();
		} catch (HearthStoneException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}

}
