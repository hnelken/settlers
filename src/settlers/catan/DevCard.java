package settlers.catan;

public class DevCard {
	
	// fields
	private Player owner;
	private boolean playable;
	private String name;
	
	public enum Type {
		TROOPER, VP, SANDSTORM, SANDCRAWLER, BLUEHARVEST
	}
	
	private Type type;
	
	// constructors
	
	public DevCard(Type type) {
		this.owner = null;
		if (type == Type.TROOPER){
			this.setName("Stormtrooper");
		} else if (type == Type.SANDSTORM){
			this.setName("Sandstorm");
		} else if (type == Type.SANDCRAWLER){
			this.setName("Sandcrawler");
		} else if (type == Type.BLUEHARVEST){
			this.setName("Blue Harvest");
		}
		this.setPlayable(false);
	}
	
	public DevCard(String name){
		this.setName(name);
		this.type = Type.VP;
	}
	
	public void play(){
		if (type == Type.TROOPER){
		} else if (type == Type.SANDSTORM){
		} else if (type == Type.SANDCRAWLER){
		} else if (type == Type.BLUEHARVEST){
		} else if (type == Type.VP){
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
	
}
