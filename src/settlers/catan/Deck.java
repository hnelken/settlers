package settlers.catan;

public class Deck {
	
	// fields
	DevCard[] cards = new DevCard[25];
	
	// constructors
	
	public Deck() {
		
		for (int i = 0; i < 14; i++) {
			cards[i] = new DevCard(DevCard.Type.TROOPER);
		}
		cards[14] = new DevCard("Cantina Band");
		cards[15] = new DevCard("Death Sticks");
		cards[16] = new DevCard("Pod Racer");
		cards[17] = new DevCard("Power Converters");
		cards[18] = new DevCard("T-16 Skyhopper");
		for (int i = 19; i < 21; i++) {
			cards[i] = new DevCard(DevCard.Type.BLUEHARVEST);
		}
		for (int i = 19; i < 23; i++) {
			cards[i] = new DevCard(DevCard.Type.SANDCRAWLER);
		}
		for (int i = 23; i < 25; i++) {
			cards[i] = new DevCard(DevCard.Type.SANDSTORM);
		}
		
	}
	
	// methods
	
	
	
}
