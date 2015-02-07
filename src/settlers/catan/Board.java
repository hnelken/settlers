package settlers.catan; 

public class Board {
  
  private Tile[] tiles = new Tile[19];
  
  public Board(){
    Node[] nodes = new Node[54];
    for (int i = 0;i < nodes.length;i++){
      nodes[i] = new Node();
    }
    Resource[] resources = getTileTypes();
    int[] nums = getTileNum(resources);
    int[][] vRel = {{4,8,12,7,3},{5,10,15,9,4},{6,12,17,11,5},{6,11,13,10,5},{5,9,12,8,4}};
    int[] tLeft = {0,7,16,28,39};
    int[] num = {3,4,5,4,3};
    int count = 0;
    for (int i = 0; i < num.length; i++){
      for (int j = 0; j < num[i]; j++){
        tiles[count] = new Tile(new Node[] {nodes[tLeft[i]+j],nodes[tLeft[i]+j+vRel[i][0]], nodes[tLeft[i]+j+vRel[i][1]],
          nodes[tLeft[i]+j+vRel[i][2]],nodes[tLeft[i]+j+vRel[i][3]],nodes[tLeft[i]+j+vRel[i][4]]},resources[count],nums[count]);
        count++;
      }
    }
  }
  
  public Tile[] getTiles(){
    return tiles;
  }
  
  private Resource[] getTileTypes(){
    Resource[] tileTypes = new Resource[19];
    int[] numOfTypes = {4,4,3,3,4};
    Resource[] typeList = {Resource.MOISTURE,Resource.BLUEMILK,Resource.DURASTEEL,Resource.ADOBE,Resource.BANTHA};
    int index;
    //This loop sets the type of each tile
    for (int j = 0; j < numOfTypes.length; j++){
      for (int i = 0; i < numOfTypes[j]; i++){
        index = (int)(19*Math.random());
        while (tileTypes[index] != null){
          index = (int)(19*Math.random());
        }
        tileTypes[index] = typeList[j];
      }
    }
    return tileTypes;
  }
  
  private int[] getTileNum(Resource[] tileTypes){
    int index = 0;
    int[] tileNum = new int[19];
    for (int k = 2; k <= 12; k++){
      index = (int)(19*Math.random());
      while (tileNum[index] != 0 || tileTypes[index] == null)
        index = (int)(19*Math.random());
      tileNum[index] = k;
    }
    for (int k = 4; k <= 10; k++){
      index = (int)(19*Math.random());
      while (tileNum[index] != 0 || tileTypes[index] == null)
        index = (int)(19*Math.random());
      tileNum[index] = k;
    }
    return tileNum;
  }
  
}