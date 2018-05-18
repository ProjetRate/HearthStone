package carte;

import capacite.ICapacite;
import jeu.Heros;
import joueur.IJoueur;

import java.util.ArrayList;
import java.util.List;

public abstract class Carte implements ICarte{

    private int cout;
    private String nom;
    private List<ICapacite> capacite;
    private Heros heros;

    protected Carte(int cout, String nom, List<ICapacite> capacite, Heros heros) {
        this.cout = cout;
        this.nom = nom;
        this.capacite = capacite;
        this.heros = heros;
    }

    public Carte(int cout, String nom, ArrayList<ICapacite> capacite) {
        this.cout = cout;
        this.nom = nom;
        this.capacite = capacite;
    }

    @Override
    public boolean disparait() {
        return false;
    }

    @Override
    public void executerAction(Object cible) {

    }

    @Override
    public void executerEffetDebutMiseEnJeu() {

    }

    @Override
    public void executerEffetDebutTour(Object cible) {

    }

    @Override
    public void executerEffetDisparition() {

    }

    @Override
    public void executerEffetFinTour(Object cible) {

    }

    @Override
    public int getCout() {
        return 0;
    }

    @Override
    public String getNom() {
        return null;
    }

    @Override
    public IJoueur getProprietaire() {
        return null;
    }

    public List<ICapacite> getCapacite() {
        return capacite;
    }
}
