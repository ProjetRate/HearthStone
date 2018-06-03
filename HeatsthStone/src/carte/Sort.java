package carte;

import capacite.ICapacite;

import java.util.ArrayList;

public class Sort extends Carte {
	
    public Sort(int cout, String nom, ArrayList<ICapacite> capacites) {
        super(cout, nom, capacites);

    }
    
    @Override
    public boolean disparait() {
        return true;
    }
    
    @Override
    public void executerEffetDebutMiseEnJeu(Object cible) {
    	
    	for (ICapacite capacite : getCapacites()) {
    		capacite.executerEffetMiseEnJeu(cible);
    	}
    }
}
