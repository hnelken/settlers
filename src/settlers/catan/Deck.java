package settlers.catan;

public class Deck {
	
	// fields
	DevCard[] cards = new DevCard[25];
	
	// constructors
	
	public Deck() {
		for (int i = 0; i < 14; i++) {
			cards[i] = new DevCard(Type.Trooper);
		}
		cards[14] = new DevCard("Cantina Band");
		cards[15] = new DevCard("Death Sticks");
		cards[16] = new DevCard("Pod Racer");
		cards[17] = new DevCard("Power Converters");
		cards[18] = new DevCard("T-16 Skyhopper");
		for (int i = 19; i < 19+2; i++) {
			cards[i] = new DevCard(Type.Trooper);
		}
	}
	
	// methods
	
	
	
}
