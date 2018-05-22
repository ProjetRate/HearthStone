package main;

import carte.Sort;
import carte.ICarte;
import carte.Serviteur;
import exception.HearthStoneException;
import heros.Heros;
import heros.Jaina;
import joueur.Joueur;
import plateau.Plateau;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ArrayList<ICarte> cartes = new ArrayList<ICarte>(Arrays.asList(
                new Serviteur(1, "", null,1,1),
                new Serviteur(1, "", null,1,1),
                new Sort(1, "", null)
        ));
        System.out.println("Nom joueur 1: ");
        Scanner sc = new Scanner(System.in);
        Heros herosJ1 = new Jaina(); 
        Joueur joueur1 = new Joueur(sc.nextLine(), herosJ1);
        Plateau plateau = new Plateau();
        try {
            plateau.ajouterJoueur(joueur1);
        } catch (HearthStoneException e) {
            e.printStackTrace();
        }
        
        System.out.println("Nom joueur 2: ");
        sc = new Scanner(System.in);
        Heros herosJ2 = new Jaina(); 
        Joueur joueur2 = new Joueur(sc.nextLine(), herosJ2);
        try {
            plateau.ajouterJoueur(joueur2);
        } catch (HearthStoneException e) {
            e.printStackTrace();
        }
        
        
    }
}
