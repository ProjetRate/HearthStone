package main;

import carte.Sort;
import carte.ICarte;
import carte.Serviteur;
import exception.HearthStoneException;
import javafx.collections.FXCollections;
import jeu.Plateau;
import joueur.Joueur;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        List<ICarte> cartes = FXCollections.observableArrayList(
                new Serviteur(1, "",1,1),
                new Serviteur(1, "",1,1),
                new Sort(1, "")
        );
        System.out.println("");
        Scanner sc = new Scanner(System.in);
        Joueur joueur = new Joueur(sc.nextLine());
        Plateau plateau = new Plateau();
        try {
            plateau.ajouterJoueur(joueur);
        } catch (HearthStoneException e) {
            e.printStackTrace();
        }
    }
}
