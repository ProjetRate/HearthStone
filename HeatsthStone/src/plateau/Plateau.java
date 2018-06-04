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
import capacites.AttaqueCiblee;

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
        for(int i = 0, j = 0; i < NB_CARTES_DEPART; i++, j=0) {
        	joueurs.get(j).piocher();
        	joueurs.get(j+1).piocher();        	
        }
        
        jouer();
        //Scanner sc = new Scanner(System.in);
        
        //sc.close();
    }
    
    private void jouer() {
    	while(!estTerminee){
	        String requete = "";
            while( !requete.toLowerCase().contains("0") && !requete.toLowerCase().contains("Fin")){
	        	System.out.println("Adversaire" + adversaire);
	        	System.out.println("*************************************************************");
	        	System.out.println("\t\t\t" + adversaire.getHeros());
	        	System.out.println(""+adversaire.getJeu());
	        	System.out.println("-------------------------------------------------------------");
	        	System.out.println(""+joueurCourrant.getJeu());
	        	System.out.println("\t\t\t" + joueurCourrant.getHeros());
	        	System.out.println("*************************************************************");

	        	System.out.println("Joueur" + joueurCourrant);
	        	System.out.println("Main" + joueurCourrant.getMain());
	        	System.out.println("[0] Fin du tour");
	        	System.out.println("[1] Jouer carte");
	        	System.out.println("[2] Faire attaquer un serviteur");
	        	System.out.println("[3] Utiliser pouvoir héros");
	        	System.out.println("[4] Info carte");

            	requete = sc.nextLine();
            	choisir(requete);
            	//...
            	System.out.println("");

            }
            try {
                finTour(joueurCourrant);				
			} catch (Exception e) {
				e.printStackTrace();
			}
        	System.out.println("#####################################");
        	System.out.println("\n\n\n\n ");
            
        }    	
    }
    
    private void choisir(String choix) {
    	String requete = "";
    	if (choix.equals("1") || choix.contains("1") || choix.toLowerCase().contains("jouer")) {
    		System.out.printf("Jouer -> ");
        	requete = sc.nextLine();
        	try {
				joueurCourrant.jouerCarte(joueurCourrant.getCarteEnMain(requete));
			} catch (HearthStoneException e) {
				System.out.println(e.getMessage());
			}

    	}
    	if (choix.equals("2") || choix.contains("2") || choix.toLowerCase().contains("serviteur")) {
    		System.out.printf("Serviteur -> ");
        	requete = sc.nextLine();
        	try {
        		Serviteur attaquant = (Serviteur) joueurCourrant.getCarteEnJeu(requete);
        		if (!attaquant.PeutAttaquer())
        			throw new HearthStoneException("Ce serviteur ne peut actuellement pas attaquer.");
        		System.out.printf("Attaquer -> ");
            	requete = sc.nextLine();
            	ICapacite attaque = null;
            	for (ICapacite capacite : attaquant.getCapacites()) {
					if(capacite.getNom().equals(new AttaqueCiblee(0).getNom())) {
						attaque = capacite;
					}
				}
            	
            	attaque.executerAction(adversaire.getCarteEnJeu(requete));
            	attaquant.setPeutAttaquer(false);
			} catch (HearthStoneException e) {
				System.out.println(e.getMessage());
			}

    	}
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
    		throw new HearthStoneException("" + joueur.getNom() + " a gagné!!!");
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
