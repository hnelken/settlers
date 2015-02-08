package settlers.catan;

import java.util.ArrayList;
import java.util.Arrays;

import BreezySwing.MessageBox;

import javax.swing.JButton;
public class GameManager {

	//fields
	private Board gameBoard;
	private Player[] players;
	private Player winner; //TODO
	private int turn;
	private boolean gameOver;
	private GameState state; //TODO
	private Deck deck;
	private Smuggler smuggler; //TODO
	private Player[] firstTurnOrder;
	private int firstTurn;
	private Node settlement;
	
	private enum GameState {
		FTSFORWARD, FTRFORWARD, FTSBACK, FTRBACK, PLAYERTURNROLL, PLAYERTURNCHOICE, WINCHECK, GAMEOVER
	}

	// constructor
	public GameManager(Player[] players) {
		gameBoard = new Board(this);
		this.players = players;
		gameOver = false;
		winner = null;
		deck = new Deck(this);
		turn = (int)(players.length * Math.random());
		Tile desert = null;
		for (int i = 0; i < gameBoard.getTiles().length; i++) {
			if (gameBoard.getTiles()[i].getResourceType() == Resource.DESERT) {
				desert = gameBoard.getTiles()[i];
			} //end if
		} //end for
		smuggler = new Smuggler(desert);
		state = GameState.FTSFORWARD;
		startSetup();
	}

	// methods
	private void startSetup() {
		firstTurnOrder = new Player[players.length];
		int index = 0;
		for (int player = turn; player < players.length; player++) {
			firstTurnOrder[index++] = players[player];
		}
		for (int i = 0; index < players.length; i++) {
			firstTurnOrder[index++] = players[i];
		}
		gameBoard.clickList = new ArrayList<Clickable>(Arrays.asList(gameBoard.getNodes()));
		firstTurn = 0;
		gameBoard.setPlayer(getFirstPlayer().getName());
		startLogicSettle();
	}
	
	private void startLogicSettle() {
		if (state == GameState.FTSFORWARD) {
		//BEGIN SNAKE FORWARD
			///Give resources for a civilization
			firstTurnOrder[firstTurn].addResource(Resource.ADOBE);
			firstTurnOrder[firstTurn].addResource(Resource.BANTHA);
			firstTurnOrder[firstTurn].addResource(Resource.BLUEMILK);
			firstTurnOrder[firstTurn].addResource(Resource.MOISTURE);

			Builder builder = new Builder(this, false);	//Place a settlement
		}
		else if (state == GameState.FTSBACK) {
			// SNAKE BACKWARDS
				///Give resources for a civilization
				firstTurnOrder[firstTurn].addResource(Resource.ADOBE);
				firstTurnOrder[firstTurn].addResource(Resource.BANTHA);
				firstTurnOrder[firstTurn].addResource(Resource.BLUEMILK);
				firstTurnOrder[firstTurn].addResource(Resource.MOISTURE);

				Builder builder = new Builder(this, false);	//Place a settlement
		}
	}
	
	private void startLogicRoad() {
		gameBoard.clickList = new ArrayList<Clickable>();

		Edge[] edges = gameBoard.getEdges();
		for (int j = 0; j < edges.length; j++) { 		//establish open edges
			if (!edges[j].isRoad()) {
				gameBoard.clickList.add(edges[j]);
			}
		}
		if (state == GameState.FTRFORWARD) {
			//Give resources for a road
			firstTurnOrder[firstTurn].addResource(Resource.ADOBE);
			firstTurnOrder[firstTurn].addResource(Resource.BANTHA);

			Builder builder = new Builder(this, false);		//place a road
		}
		else if (state == GameState.FTRBACK) {
			settlement = (Node)gameBoard.lastClicked;

			gameBoard.clickList = new ArrayList<Clickable>();

			for (int j = 0; j < edges.length; j++) { 		//establish open edges
				if (!edges[j].isRoad()) {
					gameBoard.clickList.add(edges[j]);
				}
			}
			//Give resources for a road
			firstTurnOrder[firstTurn].modifyResource(Resource.ADOBE, 1);
			firstTurnOrder[firstTurn].modifyResource(Resource.BANTHA, 1);

			Builder builder = new Builder(this, false);		//place a road
		}
	}
	
	private void setupNextPlayer() {
		ArrayList<Clickable> clickList = new ArrayList<Clickable>();

		Node[] nodes = gameBoard.getNodes();			//Establish open nodes
		for (int j = 0; j < nodes.length; j++) {
			if (nodes[j].status == Node.NodeStatus.EMPTY) {
				clickList.add(nodes[j]);
			}
		}
		gameBoard.setPlayer(getFirstPlayer().getName());
		startLogicSettle();
	}
	
	private void stdLogic() {
			/* Take Turn */
			//Roll Dice
			int roll = diceRoll();
			
			if (roll == 7){
				this.discardAll();
				this.moveSmuggler(null);
			} else
				distributeResources(roll);

			//Free Choice
			state = GameState.PLAYERTURNCHOICE;
	}

	private int diceRoll() {
		int firstRoll = (int)(6.0 * Math.random()) + 1;
		int secondRoll = (int)(6.0 * Math.random()) + 1;
		return firstRoll + secondRoll;
	}

	private void distributeResources(int roll) {
		Tile[] tiles = gameBoard.getTiles();
		for (int tile = 0; tile < tiles.length; tile++) {
			Tile t = tiles[tile];
			if (t.rollNum() == roll && t.getResourceType() != Resource.DESERT) {
				Node[] corners = tiles[tile].getCorners();
				for (int corner = 0; corner < corners.length; corner++) {
					Player owner = corners[corner].getOwner();
					if (null != owner) {
						owner.addResource(tiles[tile].getResourceType());
						if (corners[corner].status == Node.NodeStatus.CITY)
							owner.addResource(tiles[tile].getResourceType());
					}
				}
			}
		}
	}

	public void endTurn() {
		if (state == GameState.FTRFORWARD) {
			if (firstTurn < players.length) {
				firstTurn++;
				state = GameState.FTSFORWARD;
				setupNextPlayer();
				startLogicSettle();
			}
			else {
				firstTurn--;
				state = GameState.FTRBACK;
				setupNextPlayer();
				startLogicSettle();
			}
		}
		else if (state == GameState.FTRBACK) {
			if (firstTurn >= 0) {
				firstTurn--;
				state = GameState.FTSBACK;
				//Add resultant resources from settlement placement
				for (int t = 0; t < settlement.getTiles().size(); t++) {
					settlement.getOwner().addResource(settlement.getTiles().get(t).getResourceType());
				}
				setupNextPlayer();
			}
			else {
				state = GameState.PLAYERTURNROLL;
				stdLogic();
			}
		}
		else if (state == GameState.FTSFORWARD){
			state = GameState.FTRFORWARD;
			startLogicRoad();
		}
		else if (state == GameState.FTSBACK) {
			state = GameState.FTRBACK;
			startLogicRoad();
		}
		else {
			players[turn].makePlayable();
			
			//Check for 10 VP
			state = GameState.WINCHECK;
			checkForWin();
	
			//Change player turn
			nextPlayer();
			
			state = GameState.PLAYERTURNROLL;
			stdLogic();
		}
	}

	private void checkForWin() {
		for (int i = 0; i < players.length; i++) {
			if (players[i].getVictoryPoints() == 10) {
				state = GameState.GAMEOVER;
				gameOver = true;
				winner = players[i];
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
		gameBoard.setPlayer(getCurrPlayer().getName());
	}
	
	public Player getFirstPlayer() {
		return firstTurnOrder[firstTurn];
	}
	
	public Player getCurrPlayer(){
		return players[turn];
	}

	//player can play card in his/her hand
	public void play(int i){
		if (players[turn].getHand().get(i).getType() == DevCard.Type.TROOPER){
			this.trooperPlay();
		} else if (players[turn].getHand().get(i).getType() == DevCard.Type.SANDSTORM){
			new ResourcePicker(this, ResourcePicker.PickerType.SANDSTORM, "Pick a resource to monopolize."); //TODO
		} else if (players[turn].getHand().get(i).getType() == DevCard.Type.SANDCRAWLER){
			this.sandcrawlerPlay();
		} else if (players[turn].getHand().get(i).getType() == DevCard.Type.TWINSUNS){
			new ResourcePicker(this, ResourcePicker.PickerType.TWINSUNS, "Pick a resource you want from the bank."); //TODO
			new ResourcePicker(this, ResourcePicker.PickerType.TWINSUNS, "Pick a second resource you want from the bank."); //TODO
		} else if (players[turn].getHand().get(i).getType() == DevCard.Type.VP){
			this.vpPlay();
		}
		players[turn].getHand().remove(i);
	}

	private void trooperPlay(){
		players[turn].addTrooper();
		for (JButton b : getBoard().getButtons()){
			b.setEnabled(false);
		}
		getBoard().clickList = new ArrayList<Clickable>();
		for (Tile t : getBoard().getTiles()){
			if (t != getSmuggler().getLocation())
				getBoard().clickList.add(t);
		}
	}

	private void vpPlay(){
		players[turn].modifyVictoryPoints(1);
	}

	private void twinSunsPlay(Resource resource){
		players[turn].modifyResource(resource, 1);
	}

	private void sandcrawlerPlay(){
		for (JButton b : getBoard().getButtons()){
			b.setEnabled(false);
		}
		getCurrPlayer().modifyResource(Resource.ADOBE, 2);
		getCurrPlayer().modifyResource(Resource.BANTHA, 2);
		getBoard().doubleClick = true;
		getBoard().clickList = new ArrayList<Clickable>();
		for (Edge e : getBoard().getEdges()){
			if (e.canBeRoad(getCurrPlayer()))
				getBoard().clickList.add(e);
		}
	}

	private void sandstormPlay(Resource resource){
		for(Player player : players){
			if (!player.equals(players[turn])){
				players[turn].modifyResource(resource, player.getResource(resource));
				player.modifyResource(resource, -(player.getResource(resource)));
			}
		}
	}
	
	public void resourceChosen(Resource resource, ResourcePicker.PickerType type){
		if (type == ResourcePicker.PickerType.TWINSUNS){
			this.twinSunsPlay(resource);
		} else if (type == ResourcePicker.PickerType.SANDSTORM){
			this.sandstormPlay(resource);
		} else if (type == ResourcePicker.PickerType.TRADINGAWAY){
			this.getCurrPlayer().modifyResource(resource, -4);
		} else if (type == ResourcePicker.PickerType.TRADINGFOR){
			this.getCurrPlayer().addResource(resource);
		}
	}
	
	

	//move the smuggler around
	public void moveSmuggler(Tile t) {
		smuggler.setLocation(t);
	}
	
	private void discardAll(){
		for(Player player : players){
			if (player.getTotalResources() > 7){
				while (player.getTotalResources() != player.getTotalResources()/2){
					int i = (int) (Math.random() * 5);
					player.modifyResource(i, -1);
				}
			}
		}
	}

	public Deck getDeck() {
		return deck;
	}
	
	public Board getBoard(){
		return gameBoard;
	}

	private Smuggler getSmuggler(){
		return smuggler;
	}
}
