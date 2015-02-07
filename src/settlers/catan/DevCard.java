package settlers.catan;

public abstract class DevCard {
	
	// fields
	private Player owner;
	private boolean playable;
	
	// constructors
	
	public DevCard() {
		setOwner(null);
	}

	public Player getOwner() {
		return owner;
	}

	public void setOwner(Player owner) {
		this.owner = owner;
	}
	
}
