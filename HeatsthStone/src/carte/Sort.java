package carte;

import capacite.ICapacite;
import heros.Heros;

import java.util.ArrayList;

public class Sort extends Carte {

    public Sort(int cout, String nom, ArrayList<ICapacite> capacite, Heros heros) {
        super(cout, nom, capacite, heros);
        super.executerEffetDisparition();
    }

    public Sort(int cout, String nom, ArrayList<ICapacite> capacite) {
        super(cout, nom, capacite);
        super.executerEffetDisparition();

    }
    
    @Override
    public boolean disparait() {
        return true;
    }
    
    @Override
    public void executerEffetDebutMiseEnJeu() {
    	
    }
}
