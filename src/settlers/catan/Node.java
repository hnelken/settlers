package settlers.catan;
import java.util.*;

public class Node {
	
	private enum NodeStatus {
		EMPTY, SETTLEMENT, CITY;
	}
	
	private Player owner;
	private boolean available;
	private ArrayList<Edge> edges;
	
	private NodeStatus status;
	
	public Node() {
		owner = null;
		status = NodeStatus.EMPTY;
	}
	
	public void settle(Player settler) {
		if(null == owner) {
			owner = settler;
			status = NodeStatus.SETTLEMENT;
		}
	}
	
	public void upgrade() {
		status = NodeStatus.CITY;
	}
	
	public void addEdge(Edge edge) {
		
	}
	/**
	 * Decides if this node is available for settlement by a given player
	 */
	public void availabilityCheck(Player currPlayer) {
		for (int edge = 0; edge < edges.size(); edge++) {
			Edge e = edges.get(edge);
			if (e.getOwner().equals(currPlayer)) {
				if (e.getNodes()[0].equals(this)) {
					checkSurroundingNodes(e.getNodes()[1], currPlayer);
				}
				else {
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
			}
			else {
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
	
}
