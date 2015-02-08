package settlers.catan;

public class Smuggler {

	// fields
	private Tile location;

	// constructor
	public Smuggler(Tile location) {
		this.location = location; // this is a reference to the desert tile
	}

	public Tile getLocation() {
		return location;
	}

	public void setLocation(Tile location) {
		this.location = location;
	}

}
