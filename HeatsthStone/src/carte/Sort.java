package carte;

import capacite.ICapacite;
import jeu.Heros;

import java.util.ArrayList;

public class Sort extends Carte {

    public Sort(int cout, String nom, ArrayList<ICapacite> capacite, Heros heros) {
        super(cout, nom, capacite, heros);
    }

    public Sort(int cout, String nom, ArrayList<ICapacite> capacite) {
        super(cout, nom, capacite);
    }
}
