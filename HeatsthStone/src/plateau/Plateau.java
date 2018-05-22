package plateau;

import exception.HearthStoneException;
import joueur.IJoueur;
import joueur.Joueur;

import java.awt.*;
import java.util.ArrayList;

public class Plateau implements IPlateau {

    ArrayList<IJoueur> joueurs = new ArrayList<IJoueur>();
    @Override
    public void ajouterJoueur(IJoueur joueur) throws HearthStoneException {
        if(joueurs.size() < 2)
            joueurs.add(joueur);
        else
            throw new HearthStoneException("Le nombre de joueur est trop elev�e. Il doit �tre �gale a 2.");
    }

    @Override
    public void demarrerPartie() {
        if(joueurs.size() == 2) {

        }
    }

    @Override
    public boolean estDemarree() {
        return false;
    }

    @Override
    public void finTour(IJoueur joueur) {

    }

    @Override
    public void gagnePartie(IJoueur joueur) {

    }

    @Override
    public IJoueur getAdversaire(IJoueur joueur) {
        return null;
    }

    @Override
    public IJoueur getJoueurCourant() {
        return null;
    }

    @Override
    public void setJoueurCourant(IJoueur joueur) {

    }
}
