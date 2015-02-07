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
		/* Take Turn */
			//Roll Dice
			int roll = diceRoll();
			
			//Dole out resources
			distributeResources(roll);
			
			//Free Choice
			state = GameState.PLAYERTURNCHOICE;
			//End Turn
			endTurn();
		//Check for 10 VP
			state = GameState.WINCHECK;
			checkForWin();
			
		//Change player turn
			nextPlayer();
		}
	}

	private int diceRoll() {
		int firstRoll = (int) (5 * Math.random()) + 1;
		int secondRoll = (int) (5 * Math.random()) + 1;
		return firstRoll + secondRoll;
	}
	
	private void distributeResources(int roll) {
		Tile[] tiles = gameBoard.getTiles();
		for (int tile = 0; tile < tiles.length; tile++) {
			if (tiles[tile].rollNum() == roll) {
				Node[] corners = tiles[tile].getCorners();
				for (int corner = 0; corner < corners.length; corner++) {
					Player owner = corners[corner].getOwner();
					if (null != owner) {
						owner.addResource(tiles[tile].getResourceType());
					}
				}
			}
		}
	}
	
	private void endTurn() {
		players[turn].makePlayable();
	}
	
	private void checkForWin() {
		for (int i = 0; i < players.length; i++) {
			if (players[i].getVictoryPoints() == 10) {
				state = GameState.GAMEOVER;
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
