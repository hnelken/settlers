package settlers.catan;

import java.util.*;

public class Node extends Clickable {

	// fields
	public GameManager manager;
	public enum NodeStatus {EMPTY, SETTLEMENT, CITY}
	public NodeStatus status;
	private ArrayList<Tile> surrounding;
	private Player owner;
	private boolean available;
	private ArrayList<Edge> edges;
	private int xcord, ycord;

	// constructor
	public Node(int xcord, int ycord) {
		owner = null;
		status = NodeStatus.EMPTY;
		edges = new ArrayList<Edge>(3);
		surrounding = new ArrayList<Tile>();
		this.xcord = xcord;
		this.ycord = ycord;
	}

	// methods
	
	private void settle(Player settler) {
		if(null == owner) {
			owner = settler;
			status = NodeStatus.SETTLEMENT;
		}
	}

	private void upgrade() {
		status = NodeStatus.CITY;
	}

	public void addEdge(Edge edge) {
		edges.add(edge);
	}
	
	public void addTile(Tile tile) {
		surrounding.add(tile);
	}
	
	public ArrayList<Tile> getTiles() {
		return surrounding;
	}
	/**
	 * Decides if this node is available for settlement by a given player
	 */
	public void availabilityCheck(Player currPlayer) {
		for (int edge = 0; edge < edges.size(); edge++) {
			Edge e = edges.get(edge);
			if (currPlayer.equals(getOwner())) {
				if (e.getNodes()[0].equals(this)) {
					checkSurroundingNodes(e.getNodes()[1], currPlayer);
				} else {
					checkSurroundingNodes(e.getNodes()[0], currPlayer);
				}
			}
		}
	}

	private void checkSurroundingNodes(Node neighbor, Player currPlayer) {
		if (neighbor.status == NodeStatus.EMPTY) {
			for (int edge = 0; edge < neighbor.edges.size(); edge++) {
				Edge e = neighbor.edges.get(edge);
				if (isSettledByPlayer(neighbor, e, currPlayer)) {
					available = true;
				}
			}
		}
	}

	private boolean isSettledByPlayer(Node neighbor, Edge edge, Player currPlayer) {
		if (edge.getOwner().equals(currPlayer)) {
			Node[] nodes = edge.getNodes();
			if (nodes[0].equals(neighbor)) {
				if (nodes[1].owner.equals(currPlayer)) {
					return true;
				}
			} else {
				if (nodes[0].owner.equals(currPlayer)) {
					return true;
				}
			}
		}
		return false;
	}

	public boolean isAvailable() {
		return available;
	}

	public NodeStatus getStatus() {
		return status;
	}

	public Player getOwner() {
		return owner;
	}
	
	public ArrayList<Edge> getEdges() {
		return edges;
	}
	
	public int getXcord() {
		return xcord;
	}
	
	public int getYcord() {
		return ycord;
	}
	
	public int getRadius() {
		return 40;
	}
	
	public void doOnClick() {
		if (status == NodeStatus.EMPTY){
			settle(manager.getCurrPlayer());
			owner.modifyResource(Resource.ADOBE, -1);
			owner.modifyResource(Resource.BANTHA, -1);
			owner.modifyResource(Resource.BLUEMILK, -1);
			owner.modifyResource(Resource.MOISTURE, -1);
		} else {
			upgrade();
			owner.modifyResource(Resource.DURASTEEL, -3);
			owner.modifyResource(Resource.MOISTURE, -2);
		}
	}
}
