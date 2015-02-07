package settlers.catan;

public class DevCard {

	// fields
	private Player owner;
	private boolean playable;
	private String name;
	private String description;

	public enum Type {
		TROOPER, VP, SANDSTORM, SANDCRAWLER, BLUEHARVEST
	}

	private Type type;

	// constructors

	public DevCard(Type type) {
		this.owner = null;
		if (type == Type.TROOPER){
			this.setName("Stormtrooper");
			this.description = "Move the robber. Steal 1 resource card from the owner of an adjacent settlement or city.";
		}
		else if (type == Type.SANDSTORM){
			this.setName("Sandstorm");
			this.description = "When you play this card, you can select two resources of your choice from the bank.";
		}
		else if (type == Type.SANDCRAWLER){
			this.setName("Sandcrawler");
			this.description = "Place two new roads as if you had just built them.";
		}
		else if (type == Type.BLUEHARVEST){
			this.setName("Blue Harvest");
			this.description = "When you play this card, you can select 2 resources of your choice from the bank.";
		}
		this.setPlayable(false);
	}

	public DevCard(String name){
		this.setName(name);
		this.type = Type.VP;
		this.description = "1 Victory Point!";
		this.owner = null;
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
}
