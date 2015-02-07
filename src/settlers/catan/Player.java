package settlers.catan;

import java.util.*;

public class Player {
	
	private String name;
	
	private int number;
	
	private int moisture;
	
	private int blueMilk;
	
	private int durasteel;
	
	private int adobe;
	
	private int bantha;
	
	private int victoryPoints;
	
	private int trooperCount;
	
	private ArrayList<DevCard> hand;
	
	public Player (String name, int number){
		this.name = name;
		this.number = number;
		this.moisture = 0;
		this.blueMilk = 0;
		this.durasteel = 0;
		this.adobe = 0;
		this.bantha = 0;
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

	public int getMoisture() {
		return moisture;
	}

	public void setMoisture(int moisture) {
		this.moisture = moisture;
	}

	public int getBlueMilk() {
		return blueMilk;
	}

	public void setBlueMilk(int blueMilk) {
		this.blueMilk = blueMilk;
	}

	public int getDurasteel() {
		return durasteel;
	}

	public void setDurasteel(int durasteel) {
		this.durasteel = durasteel;
	}

	public int getAdobe() {
		return adobe;
	}

	public void setAdobe(int adobe) {
		this.adobe = adobe;
	}

	public int getBantha() {
		return bantha;
	}

	public void setBantha(int bantha) {
		this.bantha = bantha;
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
}
