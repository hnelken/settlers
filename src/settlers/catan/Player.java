package settlers.catan;

import java.util.*;

public class Player {

	private String name;

	private int number;

	private int[] resources = new int[5];

	private int totalResources;

	private int victoryPoints;

	private int trooperCount;

	private ArrayList<DevCard> hand;

	public Player (String name, int number){
		this.name = name;
		this.number = number;
		for (int i : resources){
			resources[i] = 0;
		}
		this.totalResources = 0;
		this.victoryPoints = 0;
		this.trooperCount = 0;
		this.hand = new ArrayList<DevCard>(0);
	}

	public String getName() {
		return name;
	}

	public int getNumber() {
		return number;
	}


	public int getResource(Resource resource){
		switch (resource){
		case MOISTURE:
			return resources[0];
		case BLUEMILK:
			return resources[1];
		case DURASTEEL:
			return resources[2];
		case ADOBE:
			return resources[3];
		case BANTHA:
			return resources[4];
		default:
			return 0;
		}
	}
	
	public int getResource(int i){
		return resources[i];
	}

	public void addResource(Resource resource){
		switch (resource){
			case MOISTURE:
				resources[0]++;
				break;
			case BLUEMILK:
				resources[1]++;
				break;
			case DURASTEEL:
				resources[2]++;
				break;
			case ADOBE:
				resources[3]++;
				break;
			case BANTHA:
				resources[4]++;
				break;
			default:
				break;
		}
		this.totalResources++;
	}

	public void modifyResource(Resource resource, int n){
		switch (resource){
		case MOISTURE:
			resources[0] = resources[0] + n;
			break;
		case BLUEMILK:
			resources[1] = resources[1] + n;	
			break;
		case DURASTEEL:
			resources[2] = resources[2] + n;
			break;
		case ADOBE:
			resources[3] = resources[3] + n;
			break;
		case BANTHA:
			resources[4] = resources[4] + n;
			break;
		default:
			break;
		}
		this.totalResources = this.totalResources + n;
	}
	
	public void modifyResource(int i, int n){
		resources[i] = resources[i] + n;
		totalResources = totalResources + n;
	}

	public int getVictoryPoints() {
		return victoryPoints;
	}

	public void modifyVictoryPoints(int n) {
		this.victoryPoints = this.victoryPoints + n;
	}

	public int getTrooperCount() {
		return trooperCount;
	}

	public void addTrooper() {
		this.trooperCount++;
	}

	public ArrayList<DevCard> getHand() {
		return hand;
	}

	@Override
	public boolean equals(Object o) {
		return o instanceof Player && this.equals((Player)o);
	}

	public boolean equals(Player p) {
		if (null == p) {
			return false;
		}
		else {
			return this.number == p.number && this.name.equals(p.name);
		}
	}

	public void makePlayable(){
		for (DevCard card : hand) {
			card.setPlayable(true);
		}
	}

	public int[] getResources(){
		return resources;
	}

	public int getTotalResources() {
		return totalResources;
	}

}
