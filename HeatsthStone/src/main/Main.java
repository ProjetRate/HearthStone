package main;

import carte.Sort;
import carte.ICarte;
import carte.Serviteur;
import exception.HearthStoneException;
import heros.Heros;
import heros.Jaina;
import heros.Rexxar;
import joueur.Joueur;
import plateau.Plateau;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ArrayList<ICarte> cartes = new ArrayList<ICarte>(Arrays.asList(
                new Serviteur(1, "1", null,1,1),
                new Serviteur(2, "2", null,1,1),
                new Sort(2, "3", null),
                new Serviteur(1, "4", null,1,1),
                new Serviteur(2, "5", null,1,1),
                new Sort(2, "6", null),
                new Serviteur(1, "7", null,1,1),
                new Serviteur(2, "8", null,1,1),
                new Sort(2, "9", null),
                new Serviteur(1, "10", null,1,1),
                new Serviteur(2, "11", null,1,1),
                new Sort(2, "12", null)
        ));
        
        Plateau plateau = new Plateau();

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
            plateau.ajouterJoueur(joueur1);
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
            plateau.ajouterJoueur(joueur2);
        } catch (HearthStoneException e) {
            e.printStackTrace();
        }
        
        sc.close();
        
    }
}
