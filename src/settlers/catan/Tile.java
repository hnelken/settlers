package settlers.catan;

public class Tile extends Clickable {
	private Node[] corners; //Order is {N, NE, SE, S, SW, NW}
	private Resource resourceType;
	private int rollNum;
	public GameManager manager;

	public Tile(Node[] corners, Resource resourceType, int rollNum) {
		this.corners = corners;
		this.resourceType = resourceType;
		this.rollNum = rollNum;
	}

	public Node[] getCorners(){
		return corners;
	}

	public Resource getResourceType(){
		return resourceType;
	}

	public int rollNum(){
		return rollNum;
	}
	
	public int getXcord(){
		return corners[0].getXcord();
	}
	
	public int getYcord(){
		return (corners[1].getYcord()+corners[2].getYcord())/2;
	}
	
	public int getRadius(){
		return 60;
	}

}