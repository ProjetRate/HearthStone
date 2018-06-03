package plateau;

import exception.HearthStoneException;
import heros.*;
import joueur.*;
import carte.*;
import deck.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import capacite.ICapacite;

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
	        Heros heros; Deck deck;
	        String scHeros = sc.nextLine();
	        if (scHeros.toLowerCase().contains("jaina") || "jaina".contains(scHeros.toLowerCase())) {
	        	heros = new Jaina();
	        	deck = new DeckMagicien();
	        } else {
	        	heros = new Rexxar();
	        	deck = new DeckChasseur();
	        }
	        System.out.println(""+ heros.toString());

	        try {
	            ajouterJoueur(new Joueur(scPseudo, heros, deck));
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
	
	/** Holder 
    private static class PlateauHolder
    {       
        /** Instance unique non préinitialisée
        private final static Plateau instance = new Plateau();
    }
 
    /** Point d'accès pour l'instance unique du singleton 
    public static Plateau getInstance()
    {
        return PlateauHolder.instance;
    }*/
    

    @Override
    public void ajouterJoueur(IJoueur joueur) throws HearthStoneException {
    	if(joueur == null)
            throw new HearthStoneException("Erreur: Le joueur donnée en paramètre est null.");
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
	        String requete = "";
            while( !requete.toLowerCase().contains("fintour")){
            	System.out.println("*************************************");
	        	System.out.println("" + joueurCourrant);
	        	System.out.println("[0] Fin du tour");
	        	System.out.println("[1] Jouer carte");
	        	System.out.println("[2] Utiliser carte");
            	requete = sc.nextLine();
            	//...
            	System.out.println(""+requete);

            }
            try {
                finTour(joueurCourrant);				
			} catch (Exception e) {
				e.printStackTrace();
			}
        	System.out.println("*************************************");
        	System.out.println("\n\n\n\n ");

        //estTerminee = true;

            
        }
        //sc.close();
    }

    @Override
    public boolean estDemarree() {
        return estDemarree;
    }

    @Override
    public void finTour(IJoueur joueur) throws HearthStoneException {
    	if(joueur.getJeu() == null)
            throw new HearthStoneException("Erreur: Le jeu du joueur est null.");

    	for(ICarte carte: joueur.getJeu()) {
    		for(ICapacite capacite:carte.getCapacites()) {
    			capacite.executerEffetFinTour();
    		}
    	}
    	
    	joueurCourrant = adversaire;
    	adversaire = joueur;    	
    	joueurCourrant.prendreTour();
    }

    @Override
    public void gagnePartie(IJoueur joueur) throws HearthStoneException {
    	if(getAdversaire().getHeros().getPointsVie() <= 0)
    		throw new HearthStoneException("" + joueur + " a gagné!!!");
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
