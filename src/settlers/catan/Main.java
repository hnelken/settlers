package settlers.catan;

public class Main {

	public static void main(String[] args) {
		if (args.length != 3 && args.length != 4) {
			System.err.println("Invalid number of players!");
			System.exit(-1);
		}
		
		Player[] players = new Player[args.length];
		for (int i = 0; i < args.length; i++) {
			players[i] = new Player(args[i], i + 1);
			System.out.println("Player " + (i + 1) + " is " + args[i] + "!");
		}
		
		new GameManager(players);
	}

}
