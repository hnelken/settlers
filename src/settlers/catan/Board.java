package settlers.catan; 

public class Board {

	private Tile[] tiles;

	public Board() {
		tiles = new Tile[19];
		Resource[] resources = getTileTypes();
		int[] nums = getTileNum(resources);
		for (int j = 0; j < 19; j++) {
			Node[] tileNodes;
			switch (j) {
				case 0:
					tileNodes = new Node[]{new Node(), new Node(), new Node(),
							new Node(), new Node(), new Node()};
					tiles[j] = new Tile(tileNodes, resources[j], nums[j]);
					break;
				case 1:
					tileNodes = new Node[]{new Node(), new Node(), new Node(),
							new Node(), tiles[0].getCorners()[2], tiles[0].getCorners()[1]};
					tiles[j] = new Tile(tileNodes, resources[j], nums[j]);
					break;
				case 2:
					tileNodes = new Node[]{new Node(), new Node(), new Node(),
							new Node(), tiles[1].getCorners()[2], tiles[1].getCorners()[1]};
					tiles[j] = new Tile(tileNodes, resources[j], nums[j]);
					break;
				case 3:
					tileNodes = new Node[]{tiles[0].getCorners()[4], tiles[0].getCorners()[3], new Node(),
							new Node(), new Node(), new Node()};
					tiles[j] = new Tile(tileNodes, resources[j], nums[j]);
					break;
				case 4:
					tileNodes = new Node[]{tiles[0].getCorners()[2], tiles[1].getCorners()[3], new Node(),
							new Node(), tiles[3].getCorners()[2], tiles[3].getCorners()[1]};
					tiles[j] = new Tile(tileNodes, resources[j], nums[j]);
					break;
				case 5:
					tileNodes = new Node[]{tiles[1].getCorners()[2], tiles[2].getCorners()[3], new Node(),
							new Node(), tiles[4].getCorners()[2], tiles[4].getCorners()[1]};
					tiles[j] = new Tile(tileNodes, resources[j], nums[j]);
					break;
				case 6:
					tileNodes = new Node[]{tiles[2].getCorners()[2], new Node(), new Node(),
							new Node(), tiles[5].getCorners()[2], tiles[5].getCorners()[1]};
					tiles[j] = new Tile(tileNodes, resources[j], nums[j]);
					break;
				case 7:
					tileNodes = new Node[]{tiles[3].getCorners()[4], tiles[3].getCorners()[3], new Node(),
							new Node(), new Node(), new Node()};
					tiles[j] = new Tile(tileNodes, resources[j], nums[j]);
					break;
				case 8:
					tileNodes = new Node[]{tiles[3].getCorners()[2], tiles[4].getCorners()[3], new Node(),
							new Node(), tiles[7].getCorners()[2], tiles[7].getCorners()[1]};
					tiles[j] = new Tile(tileNodes, resources[j], nums[j]);
					break;
				case 9:
					tileNodes = new Node[]{tiles[4].getCorners()[2], tiles[5].getCorners()[3], new Node(),
							new Node(), tiles[8].getCorners()[2], tiles[8].getCorners()[1]};
					tiles[j] = new Tile(tileNodes, resources[j], nums[j]);
					break;
				case 10:
					tileNodes = new Node[]{tiles[5].getCorners()[2], tiles[6].getCorners()[3], new Node(),
							new Node(), tiles[9].getCorners()[2], tiles[9].getCorners()[1]};
					tiles[j] = new Tile(tileNodes, resources[j], nums[j]);
					break;
				case 11:
					tileNodes = new Node[]{tiles[6].getCorners()[2], new Node(), new Node(),
							new Node(), tiles[10].getCorners()[2], tiles[10].getCorners()[1]};
					tiles[j] = new Tile(tileNodes, resources[j], nums[j]);
					break;
				case 12:
					tileNodes = new Node[]{tiles[7].getCorners()[2], tiles[8].getCorners()[3], new Node(),
							new Node(), new Node(), tiles[7].getCorners()[3]};
					tiles[j] = new Tile(tileNodes, resources[j], nums[j]);
					break;
				case 13:
					tileNodes = new Node[]{tiles[8].getCorners()[2], tiles[9].getCorners()[3], new Node(),
							new Node(), tiles[12].getCorners()[2], tiles[12].getCorners()[1]};
					tiles[j] = new Tile(tileNodes, resources[j], nums[j]);
					break;
				case 14:
					tileNodes = new Node[]{tiles[9].getCorners()[2], tiles[10].getCorners()[3], new Node(),
							new Node(), tiles[13].getCorners()[2], tiles[13].getCorners()[1]};
					tiles[j] = new Tile(tileNodes, resources[j], nums[j]);
					break;
				case 15:
					tileNodes = new Node[]{tiles[10].getCorners()[2], tiles[11].getCorners()[3], new Node(),
							new Node(), tiles[14].getCorners()[2], tiles[14].getCorners()[1]};
					tiles[j] = new Tile(tileNodes, resources[j], nums[j]);
					break;
				case 16:
					tileNodes = new Node[]{tiles[12].getCorners()[2], tiles[13].getCorners()[3], new Node(),
							new Node(), new Node(), tiles[12].getCorners()[3]};
					tiles[j] = new Tile(tileNodes, resources[j], nums[j]);
					break;
				case 17:
					tileNodes = new Node[]{tiles[13].getCorners()[2], tiles[14].getCorners()[3], new Node(),
							new Node(), tiles[16].getCorners()[2], tiles[16].getCorners()[1]};
					tiles[j] = new Tile(tileNodes, resources[j], nums[j]);
					break;
				case 18:
					tileNodes = new Node[]{tiles[14].getCorners()[2], tiles[15].getCorners()[3], new Node(),
							new Node(), tiles[17].getCorners()[2], tiles[17].getCorners()[1]};
					tiles[j] = new Tile(tileNodes, resources[j], nums[j]);
					break;
			}
		}		
		
		/*
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
		}*/
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