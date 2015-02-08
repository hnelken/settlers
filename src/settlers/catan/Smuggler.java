package settlers.catan;

public class Smuggler {

	private Tile location;

	//this is only made when making the board and we encounter the desert.
	public Smuggler(Tile location){
		this.location = location;
	}

	public Tile getLocation() {
		return location;
	}

	public void setLocation(Tile location) {
		this.location = location;
	}

}
