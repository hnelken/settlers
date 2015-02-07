package settlers.catan;

public class Node {
	private Player owner;
	private boolean available;
	private enum NodeStatus {
		EMPTY, SETTLEMENT, CITY;
	}
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
}
