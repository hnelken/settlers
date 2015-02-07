package settlers.catan;

public class Tile {
  private Node[] corners; //Order is {NE, NW, W, SW, SE, E}
  private Resource resourceType;
  private int rollNum;
  
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
  
}