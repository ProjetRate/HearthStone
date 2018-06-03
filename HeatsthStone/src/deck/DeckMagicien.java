package deck;

import java.util.Collections;

import sorts.IntelligenceDesArcanes;

public class DeckMagicien extends Deck {
	public DeckMagicien() {
		super();
		deck.add(new IntelligenceDesArcanes());
		
        Collections.shuffle(deck);

	}

}
