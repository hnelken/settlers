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
	
	public void checkAvailability(Player currPlayer) {
		
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
