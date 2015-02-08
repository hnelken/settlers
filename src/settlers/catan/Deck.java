package settlers.catan;

import java.util.ArrayList;
import java.util.Stack;

public class Deck {
	
	// fields
	Stack<DevCard> deck;
	private GameManager manager;
	
	// constructors
	
	public Deck(GameManager g) {
		manager = g;
		deck = new Stack<DevCard>();
		// instantiate 14 trooper cards
		for (int i = 0; i < 14; i++) {
			deck.push(new DevCard(DevCard.Type.TROOPER,manager));
		}
		// instantiate 5 unique victory-point cards
		deck.push(new DevCard("Cantina Band"));
		deck.push(new DevCard("Pit Droids"));
		deck.push(new DevCard("Pod Racer"));
		deck.push(new DevCard("Power Converters"));
		deck.push(new DevCard("Sarlacc Pit"));
		// instantiate 2 blue harvest effect cards
		for (int i = 0; i < 2; i++) {
			deck.push(new DevCard(DevCard.Type.TWINSUNS,manager));
		}
		// instantiate 2 sandcrawler effect cards
		for (int i = 0; i < 2; i++) {
			deck.push(new DevCard(DevCard.Type.SANDCRAWLER,manager));
		}
		// instantiate 2 sandstorm effect cards
		for (int i = 0; i < 2; i++) {
			deck.push(new DevCard(DevCard.Type.SANDSTORM,manager));
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
	
	public void draw(Player receiver) {
		if (!deck.empty()){
			receiver.getHand().add(deck.pop());
		}
	}
	
	public boolean isEmpty() {
		return deck.empty();
	}
	
}
