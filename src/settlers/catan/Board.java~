package settlers.catan; 

public class Board {
  
  private Tile[] tiles = new Tile[19];
  private Node[] nodes = new Node[53];
  
  public Board(){
    for (int i = 0;i < nodes.length;i++){
      nodes[i] = new Node();
    }
    int[] resources = getTileTypes();
    int[] nums = getTileNum(resources);
    
  }
  
  private int[] getTileTypes(){
    int[] tileTypes = new int[19];
    int[] numOfTypes = {4,4,3,3,4};
    int index;
    //This loop sets the type of each tile
    for (int j = 0; j < numOfTypes.length; j++){
      for (int i = 0; i < numOfTypes[j]; i++){
        index = (int)(19*Math.random());
        while (tileTypes[index] != 0)
          index = (int)(19*Math.random());
        tileTypes[index] = j+1;
      }
    }
    return tileTypes;
  }
  
  private int[] getTileNum(int[] tileTypes){
    int index = 0;
    int[] tileNum = new int[19];
    for (int k = 2; k <= 12; k++){
      index = (int)(19*Math.random());
      while (tileNum[index] != 0 || tileTypes[index] == 0)
        index = (int)(19*Math.random());
      tileNum[index] = k;
    }
    for (int k = 4; k <= 10; k++){
      index = (int)(19*Math.random());
      while (tileNum[index] != 0 || tileTypes[index] == 0)
        index = (int)(19*Math.random());
      tileNum[index] = k;
    }
    return tileNum;
  }
  
}