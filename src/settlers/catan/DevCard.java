package settlers.catan;

public class DevCard {
	
	// fields
	private Player owner;
	private boolean playable;
	private String name;
	
	public static enum Type {
		TROOPER, VP, SANDSTORM, SANDCRAWLER, BLUEHARVEST
	}
	
	private Type type;
	
	// constructors
	
<<<<<<< HEAD
	public DevCard(Type type) {
		setOwner(null);
		if (type == Type.TROOPER){
			this.name = "Stormtrooper";
		} else if (type == Type.SANDSTORM){
			this.name = "Sandstorm";
		} else if (type == Type.SANDCRAWLER){
			this.name = "Sandcrawler";
		} else if (type == Type.BLUEHARVEST){
			this.name = "Blue Harvest";
		}
	}
	
	public DevCard(String name){
		this.name = name;
		this.type = Type.VP;
	}
	
	public void play(){
		
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
=======
	public abstract Player getOwner() ;

	public abstract void setOwner(Player owner) ;
>>>>>>> 1d349e449fb4860fae0117a8547109e365460918
	
}
