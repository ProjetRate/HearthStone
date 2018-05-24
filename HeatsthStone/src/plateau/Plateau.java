package plateau;

import exception.HearthStoneException;
import heros.Heros;
import heros.Jaina;
import heros.Rexxar;
import joueur.IJoueur;
import joueur.Joueur;

import java.util.ArrayList;
import java.util.Scanner;

public class Plateau implements IPlateau {
	boolean estDemarree = false;
	
	public Plateau(){

        System.out.println("Nom joueur 1: ");
        Scanner sc = new Scanner(System.in);
        String scPseudo = sc.nextLine();
        System.out.println("Héros ? ");
        Heros herosJ1;
        String scHeros = sc.nextLine();
        if (scHeros.equals("Jaina"))
        	herosJ1 = new Jaina();
        else
        	herosJ1 = new Rexxar();
        Joueur joueur1 = new Joueur(scPseudo, herosJ1);
        try {
            ajouterJoueur(joueur1);
        } catch (HearthStoneException e) {
            e.printStackTrace();
        }

        System.out.println("Nom joueur 2: ");
        scPseudo = sc.nextLine();
        System.out.println("Héros ? ");
        Heros herosJ2;
        scHeros = sc.nextLine();
        if (scHeros.equals("Jaina"))
        	herosJ2 = new Jaina();
        else
        	herosJ2 = new Rexxar();
        Joueur joueur2 = new Joueur(scPseudo, herosJ2);
        try {
            ajouterJoueur(joueur2);
        } catch (HearthStoneException e) {
            e.printStackTrace();
        }
        
        sc.close();
	}

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
