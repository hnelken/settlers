package settlers.catan;

public class Deck {
	
	// fields
	DevCard[] cards = new DevCard[25];
	
	// constructors
	
	public Deck() {
		for (int i = 0; i < 14; i++) {
			cards[i] = new DevCard();
		}
	}
	
	// methods
	
	
	
}
