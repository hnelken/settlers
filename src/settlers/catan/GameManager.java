package settlers.catan;

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
	
	private enum GameState {
		PLAYERTURNROLL, PLAYERTURNCHOICE, WINCHECK, GAMEOVER
	}

	// constructor
	public GameManager(Player[] players) {
		gameBoard = new Board(this);
		this.players = players;
		gameOver = false;
		winner = null;
		deck = new Deck();
		turn = (int)(players.length * Math.random());
		Tile desert = null;
		for (int i = 0; i < gameBoard.getTiles().length; i++)
			if (gameBoard.getTiles()[i].getResourceType() == Resource.DESERT)
				desert = gameBoard.getTiles()[i];
		smuggler = new Smuggler(desert);
		state = GameState.PLAYERTURNROLL;
		logic();
	}

	// methods
	

	
	private void logic() {
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
		players[turn].makePlayable();
		
		//Check for 10 VP
		state = GameState.WINCHECK;
		checkForWin();

		//Change player turn
		nextPlayer();
		
		state = GameState.PLAYERTURNROLL;
		logic();
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
	}
	
	public Player getCurrPlayer(){
		return players[turn];
	}

	//player can play card in his/her hand
	public void play(int i){
		if (players[turn].getHand().get(i).getType() == DevCard.Type.TROOPER){
			this.trooperPlay();
		} else if (players[turn].getHand().get(i).getType() == DevCard.Type.SANDSTORM){
			/*ResourcePicker picker = */new ResourcePicker(this, DevCard.Type.SANDSTORM, "Pick a resource to monopolize."); //TODO
		} else if (players[turn].getHand().get(i).getType() == DevCard.Type.SANDCRAWLER){
			this.sandcrawlerPlay();
		} else if (players[turn].getHand().get(i).getType() == DevCard.Type.TWINSUNS){
			/*ResourcePicker picker = */new ResourcePicker(this, DevCard.Type.TWINSUNS, "Pick a resource you want from the bank."); //TODO
			/*picker = */new ResourcePicker(this, DevCard.Type.TWINSUNS, "Pick a second resource you want from the bank."); //TODO
		} else if (players[turn].getHand().get(i).getType() == DevCard.Type.VP){
			this.vpPlay();
		}
		players[turn].getHand().remove(i);
	}

	private void trooperPlay(){
		this.moveSmuggler(null);
		players[turn].addTrooper();
	}

	private void vpPlay(){
		players[turn].modifyVictoryPoints(1);
	}

	private void twinSunsPlay(Resource resource){
		players[turn].modifyResource(resource, 1);
	}

	private void sandcrawlerPlay(){
		
	}

	private void sandstormPlay(Resource resource){
		for(Player player : players){
			if (!player.equals(players[turn])){
				players[turn].modifyResource(resource, player.getResource(resource));
				player.modifyResource(resource, -(player.getResource(resource)));
			}
		}
	}
	
	public void resourceChosen(Resource resource, DevCard.Type type){
		if (type == DevCard.Type.TWINSUNS){
			this.twinSunsPlay(resource);
		} else if (type == DevCard.Type.SANDSTORM){
			this.sandstormPlay(resource);
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

}
