package deck;

import exception.HearthStoneException;
import serviteurs.BusardAffame;

public class DeckChasseur extends Deck {
	public DeckChasseur() {
		super();
		try {
			deck.add(new BusardAffame());
		} catch (HearthStoneException e) {
			e.printStackTrace();
		}
	}
}
