package settlers.catan;

import settlers.catan.DevCard.Type;

<<<<<<< HEAD
=======
import settlers.catan.DevCard.Type;

>>>>>>> e9e5c094a695d41ff111c9d44373ede8584129c3
import java.util.Scanner;

public class GameManager {

	private Board gameBoard;
	private Player[] players;
	private Player winner;
	private int turn;
	private boolean gameOver;
	private GameState state;
	private Deck deck;
	private enum GameState {
		PLAYERTURNROLL, PLAYERTURNCHOICE, WINCHECK, GAMEOVER
	}

	public GameManager(Player[] players) {
		gameBoard = new Board();
		this.players = players;
		gameOver = false;
		winner = null;

		turn = (int) (players.length * Math.random());

		turn = (int)(players.length * Math.random());

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
			takePlayerActionInput();
			//End Turn
			endTurn();
			//Check for 10 VP
			state = GameState.WINCHECK;
			checkForWin();

			//Change player turn
			nextPlayer();
		}
	}

	private void takePlayerActionInput() {
		Scanner scan = new Scanner(System.in);
		System.out.println("What do you want to do?");
		System.out.println("Build? Play? End?");
		String input = scan.nextLine();
		input = input.toLowerCase();
		switch (input) {
		case "build":
			break;
		case "play":
			break;
		case "end":
			break;
		default:
			System.out.println("Invalid input!");
			takePlayerActionInput();
		}
	}

	private int diceRoll() {
		int firstRoll = (int)(6.0 * Math.random()) + 1;
		int secondRoll = (int)(6.0 * Math.random()) + 1;
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


	//player can play card in his/her hand
	public void play(int i){
		if (players[turn].getHand().get(i).getType() == Type.TROOPER){
			this.trooperPlay();
		} else if (players[turn].getHand().get(i).getType() == Type.SANDSTORM){
			this.sandstormPlay();
		} else if (players[turn].getHand().get(i).getType() == Type.SANDCRAWLER){
			this.sandcrawlerPlay();
		} else if (players[turn].getHand().get(i).getType() == Type.BLUEHARVEST){
			this.blueHarvestPlay();
		} else if (players[turn].getHand().get(i).getType() == Type.VP){
			this.vpPlay();
		}
		players[turn].getHand().remove(i);
	}

	private void trooperPlay(){
		this.moveSmuggler();
		players[turn].addTrooper();
	}

	private void vpPlay(){
		players[turn].modifyVictoryPoints(1);
	}

	private void blueHarvestPlay(){

	}

	private void sandcrawlerPlay(){

	}

	private void sandstormPlay(){

	}

	//move the smuggler around
	private void moveSmuggler(){

	}
}
