package deck;

import carte.ICarte;

import java.util.ArrayList;

public class Deck {
    public ArrayList<ICarte> deck = null;
    
    public Deck(ArrayList<ICarte> cartes){
    	if(cartes == null){
  
    	}
    	deck = cartes;
    }


}
