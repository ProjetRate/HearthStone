package deck;

import java.util.Collections;

import exception.HearthStoneException;
import sorts.ImageMirroir;
import sorts.IntelligenceDesArcanes;

public class DeckMagicien extends Deck {
	public DeckMagicien() {
		super();
		deck.add(new IntelligenceDesArcanes());
		try {
			deck.add(new ImageMirroir());
		} catch (HearthStoneException e) {
			e.printStackTrace();
		}
		
		
		
        Collections.shuffle(deck);

	}

}
