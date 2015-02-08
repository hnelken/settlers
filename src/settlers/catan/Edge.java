package settlers.catan;

public class Edge extends Clickable {

	private Player owner;
	private Node[] nodes;
	private boolean road;
	
	public Edge(Node node1, Node node2) {
		this.owner = null;
		this.nodes = new Node[2];
		this.nodes[0] = node1;
		this.nodes[1] = node2;
		this.road = false;
	}

	public Player getOwner() {
		return owner;
	}

	public void setOwner(Player owner) {
		this.owner = owner;
	}

	public Node[] getNodes(){
		return this.nodes;
	}

	public boolean isRoad() {
		return road;
	}

	public void setRoad(boolean road) {
		this.road = road;
	}
	
	public int getXcord(){
		return (nodes[0].getXcord()+nodes[1].getXcord())/2;
	}
	
	public int getYcord(){
		return (nodes[0].getYcord()+nodes[1].getYcord())/2;
	}
	
	public int getRadius(){
		return 40;
	}
	
	public void doOnClick(){
		setRoad(true);
		setOwner(nodes[0].manager.getCurrPlayer());
		owner.modifyResource(Resource.ADOBE, -1);
		owner.modifyResource(Resource.BANTHA, -1);
	}
	
	public boolean canBeRoad(Player player){
		boolean road = false;
		if (getOwner() != null || 
				(getNodes()[0].getOwner() != null && getNodes()[0].getOwner() != nodes[0].manager.getCurrPlayer())||
				(getNodes()[1].getOwner() != null && getNodes()[1].getOwner() != nodes[0].manager.getCurrPlayer())){
			road = getNodes()[0].getOwner() == nodes[0].manager.getCurrPlayer()
					||getNodes()[1].getOwner() == nodes[0].manager.getCurrPlayer();
			for (Node n : getNodes()){
				for (Edge e2: n.getEdges()){
					if (e2.getOwner() == nodes[0].manager.getCurrPlayer())
						road = true;
				}
			}
		}
		return road;
	}

}
