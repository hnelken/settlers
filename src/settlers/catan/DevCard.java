package settlers.catan;

public abstract class DevCard {
	
	// fields
	private Player owner;
	private boolean playable;
	
	// constructors
	
	public abstract Player getOwner() ;

	public abstract void setOwner(Player owner) ;
	
}
