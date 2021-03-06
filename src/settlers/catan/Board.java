package settlers.catan; 

import java.util.ArrayList;
import javax.swing.*;
import BreezySwing.*;

public class Board extends GBFrame {

	// fields
	public ArrayList<Clickable> clickList = new ArrayList<Clickable>();
	public boolean doubleClick = false;
	public Clickable lastClicked = null;
	private static final long serialVersionUID = 1L;
	private GameManager manager;
	private Tile[] tiles;
	private Node[] nodes;
	private Edge[] edges;
	private JButton[] buttons = new JButton[4];

	// constructor
	public Board(GameManager manager) {
		// paint background
		add(new JLabel(new ImageIcon("GAMEBOARDNEW.jpg")));

		addPanel(new GBPanel() {
			private static final long serialVersionUID = 1L;
			public void mouseClicked(int x, int y) {
				Board.this.clickLoc(x,y);
			}
		}, 1, 1, 1, 1);
		this.manager = manager;
		tiles = new Tile[19];
		Resource[] resources = getTileTypes();
		int[] nums = getTileNum(resources);
		nodes = new Node[54];
		int[] numNodes = {3,4,4,5,5,6,6,5,5,4,4,3};
		int[][] coords = {{244,88},{177,128},{177,196},{108,234},{111,302},{46,344},{48,414},{116,447},{117,524},{178,560},{178,627},{246,666}};
		int dist = 138;
		int index = 0;
		for (int i = 0; i < numNodes.length; i++){
			for (int j =0; j < numNodes[i]; j++){
				nodes[index] = new Node(coords[i][0]+dist*j,coords[i][1]);
				nodes[index].manager = manager;
				index++;
			}
		}
		for (int j = 0; j < 19; j++) {
			Node[] tileNodes;
			switch (j) {
			case 0:
				tileNodes = new Node[]{nodes[0],nodes[4],nodes[8],nodes[12],nodes[7],nodes[3]};
				tiles[j] = new Tile(tileNodes, resources[j], nums[j]);
				break;
			case 1:
				tileNodes = new Node[]{nodes[1],nodes[5],nodes[9],nodes[13],nodes[8],nodes[4]};
				tiles[j] = new Tile(tileNodes, resources[j], nums[j]);
				break;
			case 2:
				tileNodes = new Node[]{nodes[2],nodes[6],nodes[10],nodes[14],nodes[9],nodes[5]};
				tiles[j] = new Tile(tileNodes, resources[j], nums[j]);
				break;
			case 3:
				tileNodes = new Node[]{nodes[7],nodes[12],nodes[17],nodes[22],nodes[16],nodes[11]};
				tiles[j] = new Tile(tileNodes, resources[j], nums[j]);
				break;
			case 4:
				tileNodes = new Node[]{nodes[8],nodes[13],nodes[18],nodes[23],nodes[17],nodes[12]};
				tiles[j] = new Tile(tileNodes, resources[j], nums[j]);
				break;
			case 5:
				tileNodes = new Node[]{nodes[9],nodes[14],nodes[19],nodes[24],nodes[18],nodes[13]};
				tiles[j] = new Tile(tileNodes, resources[j], nums[j]);
				break;
			case 6:
				tileNodes = new Node[]{nodes[10],nodes[15],nodes[20],nodes[25],nodes[19],nodes[14]};
				tiles[j] = new Tile(tileNodes, resources[j], nums[j]);
				break;
			case 7:
				tileNodes = new Node[]{nodes[16],nodes[22],nodes[28],nodes[33],nodes[27],nodes[21]};
				tiles[j] = new Tile(tileNodes, resources[j], nums[j]);
				break;
			case 8:
				tileNodes = new Node[]{nodes[17],nodes[23],nodes[29],nodes[34],nodes[28],nodes[22]};
				tiles[j] = new Tile(tileNodes, resources[j], nums[j]);
				break;
			case 9:
				tileNodes = new Node[]{nodes[18],nodes[22],nodes[30],nodes[35],nodes[29],nodes[23]};
				tiles[j] = new Tile(tileNodes, resources[j], nums[j]);
				break;
			case 10:
				tileNodes = new Node[]{nodes[19],nodes[23],nodes[31],nodes[36],nodes[30],nodes[24]};
				tiles[j] = new Tile(tileNodes, resources[j], nums[j]);
				break;
			case 11:
				tileNodes = new Node[]{nodes[20],nodes[24],nodes[32],nodes[37],nodes[31],nodes[25]};
				tiles[j] = new Tile(tileNodes, resources[j], nums[j]);
				break;
			case 12:
				tileNodes = new Node[]{nodes[28],nodes[34],nodes[39],nodes[43],nodes[38],nodes[33]};
				tiles[j] = new Tile(tileNodes, resources[j], nums[j]);
				break;
			case 13:
				tileNodes = new Node[]{nodes[29],nodes[35],nodes[40],nodes[44],nodes[39],nodes[34]};
				tiles[j] = new Tile(tileNodes, resources[j], nums[j]);
				break;
			case 14:
				tileNodes = new Node[]{nodes[30],nodes[36],nodes[41],nodes[45],nodes[40],nodes[35]};
				tiles[j] = new Tile(tileNodes, resources[j], nums[j]);
				break;
			case 15:
				tileNodes = new Node[]{nodes[31],nodes[37],nodes[42],nodes[46],nodes[41],nodes[36]};
				tiles[j] = new Tile(tileNodes, resources[j], nums[j]);
				break;
			case 16:
				tileNodes = new Node[]{nodes[39],nodes[44],nodes[48],nodes[51],nodes[47],nodes[43]};
				tiles[j] = new Tile(tileNodes, resources[j], nums[j]);
				break;
			case 17:
				tileNodes = new Node[]{nodes[40],nodes[45],nodes[49],nodes[52],nodes[48],nodes[44]};
				tiles[j] = new Tile(tileNodes, resources[j], nums[j]);
				break;
			case 18:
				tileNodes = new Node[]{nodes[41],nodes[46],nodes[50],nodes[53],nodes[49],nodes[45]};
				tiles[j] = new Tile(tileNodes, resources[j], nums[j]);
				break;
			}
			tiles[j].manager = manager;
		}

		for (int i = 0; i < tiles.length; i++) {
			for (int j = 0; j < tiles[i].getCorners().length; j++) {
				Node node = tiles[i].getCorners()[j];
				node.addTile(tiles[i]);
			}
		}

		edges = new Edge[72];
		index = 0;
		Edge edg;
		for (int i = 0; i < 3; i++){
			edg = new Edge(nodes[i],nodes[i+3]);
			edges[index] = edg;
			index++;
			nodes[i].addEdge(edg);
			nodes[i+3].addEdge(edg);
			edg = new Edge(nodes[i],nodes[i+4]);
			edges[index] = edg;
			index++;
			nodes[i].addEdge(edg);
			nodes[i+4].addEdge(edg);
		}
		for (int i = 3; i < 7; i++){
			edg = new Edge(nodes[i],nodes[i+4]);
			edges[index] = edg;
			index++;
			nodes[i].addEdge(edg);
			nodes[i+4].addEdge(edg);
		}
		for (int i = 7; i < 11; i++){
			edg = new Edge(nodes[i],nodes[i+4]);
			edges[index] = edg;
			index++;
			nodes[i].addEdge(edg);
			nodes[i+4].addEdge(edg);
			edg = new Edge(nodes[i],nodes[i+5]);
			edges[index] = edg;
			index++;
			nodes[i].addEdge(edg);
			nodes[i+5].addEdge(edg);
		}
		for (int i = 11; i < 16; i++){
			edg = new Edge(nodes[i],nodes[i+5]);
			edges[index] = edg;
			index++;
			nodes[i].addEdge(edg);
			nodes[i+5].addEdge(edg);
		}
		for (int i = 16; i < 21; i++){
			edg = new Edge(nodes[i],nodes[i+5]);
			edges[index] = edg;
			index++;
			nodes[i].addEdge(edg);
			nodes[i+5].addEdge(edg);
			edg = new Edge(nodes[i],nodes[i+6]);
			edges[index] = edg;
			index++;
			nodes[i].addEdge(edg);
			nodes[i+6].addEdge(edg);
		}
		for (int i = 21; i < 27; i++){
			edg = new Edge(nodes[i],nodes[i+6]);
			edges[index] = edg;
			index++;
			nodes[i].addEdge(edg);
			nodes[i+6].addEdge(edg);
		}
		for (int i = 51; i < 54; i++){
			edg = new Edge(nodes[i],nodes[i-3]);
			edges[index] = edg;
			index++;
			nodes[i].addEdge(edg);
			nodes[i-3].addEdge(edg);
			edg = new Edge(nodes[i],nodes[i-4]);
			edges[index] = edg;
			index++;
			nodes[i].addEdge(edg);
			nodes[i-4].addEdge(edg);
		}
		for (int i = 47; i < 51; i++){
			edg = new Edge(nodes[i],nodes[i-4]);
			edges[index] = edg;
			index++;
			nodes[i].addEdge(edg);
			nodes[i-4].addEdge(edg);
		}
		for (int i = 43; i < 47; i++){
			edg = new Edge(nodes[i],nodes[i-4]);
			edges[index] = edg;
			index++;
			nodes[i].addEdge(edg);
			nodes[i-4].addEdge(edg);
			edg = new Edge(nodes[i],nodes[i-5]);
			edges[index] = edg;
			index++;
			nodes[i].addEdge(edg);
			nodes[i-5].addEdge(edg);
		}
		for (int i = 38; i < 43; i++){
			edg = new Edge(nodes[i],nodes[i-5]);
			edges[index] = edg;
			index++;
			nodes[i].addEdge(edg);
			nodes[i-5].addEdge(edg);
		}
		for (int i = 33; i < 38; i++){
			edg = new Edge(nodes[i],nodes[i-5]);
			edges[index] = edg;
			index++;
			nodes[i].addEdge(edg);
			nodes[i-5].addEdge(edg);
			edg = new Edge(nodes[i],nodes[i-6]);
			edges[index] = edg;
			index++;
			nodes[i].addEdge(edg);
			nodes[i-6].addEdge(edg);
		}
		// finish constructing gui
		this.setResizable(false);
		this.setSize(1366, 768);
		this.setVisible(true);
	}

	public Tile[] getTiles(){
		return tiles;
	}

	public Edge[] getEdges(){
		return edges;
	}

	public Node[] getNodes(){
		return nodes;
	}

	private Resource[] getTileTypes(){
		Resource[] tileTypes = new Resource[19];
		int[] numOfTypes = {4,4,3,3,4,1};
		Resource[] typeList = {Resource.MOISTURE,Resource.BLUEMILK,Resource.DURASTEEL,Resource.ADOBE,Resource.BANTHA, Resource.DESERT};
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

	public void clickLoc(int x, int y){
		int tradex = 810;
		int tradey = 320;
		int buildx = 810;
		int buildy = 480;
		int seex = 810;
		int seey = 560;
		int endx = 810;
		int endy = 642;
		int bttnWidth = 291;
		int bttnHeight = 57;
		if (clickList.isEmpty()){
			if (x > tradex && x < tradex+bttnWidth && x > tradey && x < tradey+bttnHeight){
				if (manager.getCurrPlayer().getResource(0) > 4 || manager.getCurrPlayer().getResource(1) > 4 || 
						manager.getCurrPlayer().getResource(2) > 4 || manager.getCurrPlayer().getResource(3) > 4 || 
						manager.getCurrPlayer().getResource(4) > 4){
					new ResourcePicker(manager, ResourcePicker.PickerType.TRADINGAWAY, "Select a resource you would like to trade away.");
					new ResourcePicker(manager, ResourcePicker.PickerType.TRADINGFOR, "Select a resource you would like.");
				}
			}
			else if (x > buildx && x < buildx+bttnWidth && x > buildy && x < tradey+bttnHeight){
				new Builder(manager);
			}
			else if (x > seex && x < seex+bttnWidth && x > seey && x < seey+bttnHeight){
				new HandViewer(manager);
			}
			else if (x > endx && x < endx+bttnWidth && x > endy && x < endy+bttnHeight){
				manager.endTurn();
			}
			else if (x > 794 && x < 1110 && x > 66 && x < 380){
				new ResourceDisplayer(manager);
			}
		}
		else{
			for (Clickable c : clickList){
				if (c.isInRange(x, y)){
					c.doOnClick();
					if (doubleClick){
						doubleClick = false;
						lastClicked = c;
						if (clickList.get(0) instanceof Edge){
							clickList = new ArrayList<Clickable>();
							for (Edge e : getEdges()){
								if (e.canBeRoad(manager.getCurrPlayer())){
									clickList.add(e);
								}
							}
						}
					}
					clickList.remove(c);
					break;
				}
				else{
					lastClicked = c;
					clickList = new ArrayList<Clickable>();
					break;
				}
			}
		}
	}
}
