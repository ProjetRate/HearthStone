package plateau;

import exception.HearthStoneException;
import heros.*;
import joueur.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Plateau implements IPlateau {
	boolean estDemarree = false, estTerminee = false;
	IJoueur joueurCourrant, adversaire;
    ArrayList<IJoueur> joueurs = new ArrayList<IJoueur>();
    Scanner sc = new Scanner(System.in);

	
	public Plateau(){
		int compteur = 0;
		while(compteur < JOUEURS_MAX){
			
			compteur++;
			
			System.out.printf("Nom joueur %d: ", compteur);
	        
	        String scPseudo = sc.nextLine();
	        System.out.printf("Héros ? ");
	        Heros heros;
	        String scHeros = sc.nextLine();
	        if (scHeros.toLowerCase().contains("jaina"))
	        	heros = new Jaina();
	        else
	        	heros = new Rexxar();
	        System.out.println(""+ heros.toString());

	        try {
	            ajouterJoueur(new Joueur(scPseudo, heros));
	        } catch (HearthStoneException e) {
	            e.printStackTrace();
	        }
	        


		}
		
		try {
			demarrerPartie();
		} catch (HearthStoneException e) {
			e.printStackTrace();
		}	
		sc.close();
  
	}

    @Override
    public void ajouterJoueur(IJoueur joueur) throws HearthStoneException {
        if(joueurs.size() < JOUEURS_MAX)
            joueurs.add(joueur);
        else
            throw new HearthStoneException("Erreur: Le nombre de joueur maximal est déjà atteint. Il est égal a 2.");
    }

    @Override
    public void demarrerPartie() throws HearthStoneException{
        if(joueurs.size() < JOUEURS_MAX) {
            throw new HearthStoneException("Pas assez de joueurs pour démarrer la partie.");
        }
        estDemarree = true;

        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n ");
        Collections.shuffle(joueurs);
        
        setJoueurCourant(joueurs.get(0)); setAdversaire(joueurs.get(1));

        //Scanner sc = new Scanner(System.in);
        while(!estTerminee){
        	System.out.println("#############################################");
        	System.out.println("" + joueurCourrant);
            String requete = "";

        	
            while( !requete.toLowerCase().contains("fintour")){
            	requete = sc.nextLine();
            	//...
            	System.out.println(""+requete);

            }
            finTour(joueurCourrant);
        	System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
        	System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n ");

        //estTerminee = true;

            
        }
        //sc.close();
    }

    @Override
    public boolean estDemarree() {
        return estDemarree;
    }

    @Override
    public void finTour(IJoueur joueur) {
    	joueurCourrant = adversaire;
    	adversaire = joueur;
    	joueurCourrant.prendreTour();
    }

    @Override
    public void gagnePartie(IJoueur joueur) {

    }

    @Override
    public IJoueur getAdversaire() {
        return adversaire;
    }
    
    @Override
    public void setAdversaire(IJoueur joueur) {
    	adversaire = joueur;
    }

    @Override
    public IJoueur getJoueurCourant() {
        return joueurCourrant;
    }

    @Override
    public void setJoueurCourant(IJoueur joueur) {
    	joueurCourrant = joueur;
    }
}
