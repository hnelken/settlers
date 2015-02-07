package settlers.catan;

public class GameManager {
	
	private Board gameBoard;
	private Player[] players;
	private Player winner;
	private int turn;
	private boolean gameOver;
	private GameState state;
	private enum GameState {
		PLAYERTURNROLL, PLAYERTURNCHOICE, WINCHECK, GAMEOVER
	}
	
	public GameManager(Player[] players) {
		gameBoard = new Board();
		this.players = players;
		gameOver = false;
		winner = null;
		int turn = (int) (players.length * Math.random());
		state = GameState.PLAYERTURNROLL;
	}
	
	public void main(String... args) {
		/* Game Logic
		 * 1. Take turn
		 * 		- Roll Dice
		 * 		- Dole out resources
		 * 		- Free Choice
		 * 			- Build
		 * 			- Play Card
		 * 			- Trade
		 * 		- End turn
		 * 2. Check for 10 VP
		 * 3. Change player turn
		 * 4. Repeat from Step 3
		 */
		
		while (state != GameState.GAMEOVER) {
			//Take Turn
			
			//Check for 10 VP
			checkForWin();
			
			//Change player turn
			nextPlayer();
		}
		
	}
	
	private void checkForWin() {
		for (int i = 0; i < players.length; i++) {
			if (players[i].getVictoryPoints() == 10) {
				
			}
		}
	}
	
	private void nextPlayer() {
		if (turn == players.length - 1) {
			turn = 0;
		}
		else {
			turn++;
		}
	}
}
