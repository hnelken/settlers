package settlers.catan;

import java.util.ArrayList;
import java.util.Stack;

public class Deck {
	
	// fields
	Stack<DevCard> deck;
	
	// constructors
	
	public Deck() {
		deck = new Stack<DevCard>();
		// instantiate 14 trooper cards
		for (int i = 0; i < 14; i++) {
			deck.push(new DevCard(DevCard.Type.TROOPER));
		}
		// instantiate 5 unique victory-point cards
		deck.push(new DevCard("Cantina Band"));
		deck.push(new DevCard("Death Sticks"));
		deck.push(new DevCard("Pod Racer"));
		deck.push(new DevCard("Power Converters"));
		deck.push(new DevCard("T-16 Skyhopper"));
		// instantiate 2 blue harvest effect cards
		for (int i = 0; i < 2; i++) {
			deck.push(new DevCard(DevCard.Type.BLUEHARVEST));
		}
		// instantiate 2 sandcrawler effect cards
		for (int i = 0; i < 2; i++) {
			deck.push(new DevCard(DevCard.Type.SANDCRAWLER));
		}
		// instantiate 2 sandstorm effect cards
		for (int i = 0; i < 2; i++) {
			deck.push(new DevCard(DevCard.Type.SANDSTORM));
		}
		// shuffle deck
		shuffle();
	}
	
	// methods
	
	private void shuffle() {
		// randomly arrange cards in ArrayList
		ArrayList<DevCard> cards = new ArrayList<DevCard>(25);
		while (!deck.empty()) {
			int index = (int)(Math.random() * (double)(cards.size()+1));
			cards.add(index,deck.pop());
		}
		// put cards back into a Stack
		while (!cards.isEmpty()) {
			deck.push(cards.remove(0));
		}
	}
	
	public DevCard draw(Player receiver) {
		if (deck.empty())
			return null;
		return deck.pop();
	}
	
	public boolean isEmpty() {
		return deck.empty();
	}
	
}
