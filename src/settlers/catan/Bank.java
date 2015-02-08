package settlers.catan;

public class Bank {
	
	//Pass the bank the player trading, the resources being traded, and the amount being traded.
	public static void trade(Player trader, Resource given, Resource taken, int cost) {
		trader.modifyResource(given, -cost);
		trader.modifyResource(taken, 1);
	}
}
