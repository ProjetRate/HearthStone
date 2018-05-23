package plateau;

import exception.HearthStoneException;
import joueur.IJoueur;
import joueur.Joueur;

import java.awt.*;
import java.util.ArrayList;

public class Plateau implements IPlateau {
	boolean estDemarree = false;

    ArrayList<IJoueur> joueurs = new ArrayList<IJoueur>();
    @Override
    public void ajouterJoueur(IJoueur joueur) throws HearthStoneException {
        if(joueurs.size() < 2)
            joueurs.add(joueur);
        else
            throw new HearthStoneException("Le nombre de joueur est trop elevée. Il doit être égale a 2.");
    }

    @Override
    public void demarrerPartie() throws HearthStoneException{
        if(joueurs.size() == 2) {
        	estDemarree = true;
        }
        else
            throw new HearthStoneException("Pas assez de joueurs pour démarrer la partie.");

    }

    @Override
    public boolean estDemarree() {
        return estDemarree;
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
