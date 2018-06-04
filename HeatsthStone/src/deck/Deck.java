package deck;

import carte.*;
import exception.HearthStoneException;
import joueur.IJoueur;
import serviteurs.*;
import sorts.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public abstract class Deck {
    protected ArrayList<ICarte> deck = null;
    /*
    public Deck(ArrayList<ICarte> cartes){
    	if(cartes == null){
    		new Deck();
    	}
    	else
    		deck = cartes;
    }*/
    public Deck(){ //cartes neutres
    	 try {
			deck = new ArrayList<ICarte>(Arrays.asList(
			        new ChefDeRaid(),
			        new ChampionDuHurlevent(),
			        new ChasseMareeMurloc(),
			        new LaMissiliereTemeraire(),
			        new Charge(),
			        new OgreMagi()
			));
		} catch (HearthStoneException e) {
			e.printStackTrace();
		}
         Collections.shuffle(deck);

    }
    
    public ICarte prendreCarte(IJoueur proprietaire) throws HearthStoneException{
    	if(deck.isEmpty())
    		throw new HearthStoneException("Le deck est vide.");
		ICarte carte = deck.get(0);
		carte.setProprietaire(proprietaire);
    	deck.remove(0);
		return carte;
    	
    }


}
