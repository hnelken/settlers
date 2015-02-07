package settlers.catan;

import java.util.*;

public class Player {
	
	private String name;
	
	private int number;
	
	private int[] resources = new int[5];
			
	private int victoryPoints;
	
	private int trooperCount;
	
	private ArrayList<DevCard> hand;
	
	public Player (String name, int number){
		this.name = name;
		this.number = number;
		for (int i : resources){
			resources[i] = 0;
		}
		this.victoryPoints = 0;
		this.trooperCount = 0;
		this.hand = new ArrayList<DevCard>(0);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public int getResource(int i){
		return resources[i];
	}
	
	public void addResource(int i){
		resources[i]++;
	}
	
	public void addResource(int i, int n){
		resources[i] = resources[i] + n;
	}
	
	public int getVictoryPoints() {
		return victoryPoints;
	}

	public void setVictoryPoints(int victoryPoints) {
		this.victoryPoints = victoryPoints;
	}

	public int getTrooperCount() {
		return trooperCount;
	}

	public void setTrooperCount(int trooperCount) {
		this.trooperCount = trooperCount;
	}

	public ArrayList<DevCard> getHand() {
		return hand;
	}

	public void setHand(ArrayList<DevCard> hand) {
		this.hand = hand;
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
}
