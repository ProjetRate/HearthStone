package main;

import carte.Sort;
import carte.*;
import exception.HearthStoneException;
import heros.*;
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
        
    }
}
