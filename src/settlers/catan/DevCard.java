package settlers.catan;

import javax.swing.JButton;

public class DevCard {

	// fields
	private Player owner;
	private boolean playable;
	private String name;
	private String description;
	private GameManager manager;

	public enum Type {
		TROOPER, VP, SANDSTORM, SANDCRAWLER, TWINSUNS
	}

	private Type type;

	// constructors

	public DevCard(Type type, GameManager manager) {
		this.owner = null;
		if (type == Type.TROOPER){
			this.setName("Stormtrooper");
			this.setDescription("Move the robber. Steal 1 resource card from the owner of an adjacent settlement or city.");
		}
		else if (type == Type.SANDSTORM){
			this.setName("Sandstorm");
			this.setDescription("When you play this card, all other players must give you all their resource cards of your chosen type.");
		}
		else if (type == Type.SANDCRAWLER){
			this.setName("Sandcrawler");
			this.setDescription("Place two new roads as if you had just built them.");
		}
		else if (type == Type.TWINSUNS){
			this.setName("Twin Suns");
			this.setDescription("When you play this card, you can select 2 resources of your choice from the bank.");
		}
		this.setPlayable(false);
		this.manager = manager;
	}

	public DevCard(String name){
		this.setName(name);
		this.type = Type.VP;
		this.setDescription("1 Victory Point!");
		this.owner = null;
	}


	public void play(){
		switch (type) {
			case TROOPER:
				trooperPlay();
				break;
			case SANDSTORM:
				break;
			case SANDCRAWLER:
				break;
			case TWINSUNS:
				break;
			case VP:
				break;
		}
	}

	private void trooperPlay(){
		owner.addTrooper();
		for (JButton b : manager.getBoard().getButtons()){
			b.setEnabled(false);
		}
	}

	public Player getOwner() {
		return owner;
	}

	public void setOwner(Player owner) {
		this.owner = owner;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public boolean isPlayable() {
		return playable;
	}

	public void setPlayable(boolean playable) {
		this.playable = playable;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
