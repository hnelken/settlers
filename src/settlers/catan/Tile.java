package settlers.catan;

public class Tile{
  private Node[] corners;
  private int resourceType;
  private int rollNum;
  
  public Tile(Node[] corners, int resourceType, int rollNum){
    this.corners = corners;
    this.resourceType = resourceType;
    this.rollNum = rollNum;
  }
  
  public Node[] getCorners(){
    return corners;
  }
  
  public int getResourceType(){
    return resourceType;
  }
  
  public int rollNum(){
    return rollNum;
  }
  
}