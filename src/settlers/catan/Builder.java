package settlers.catan;
import java.util.ArrayList;

import java.util.ArrayList;

import BreezySwing.GBFrame;

import javax.swing.JButton;

import settlers.catan.Node.NodeStatus;

public class Builder extends GBFrame {

	// fields
	private static final long serialVersionUID = 1L;
	private JButton buildRoad, buildSettlement, buildCity, buildDevCard;
	private GameManager manager;
	
	// constructor
	public Builder(GameManager manager) {
		setSize(300, 400);
		this.manager = manager;
		buildRoad = addButton("Road", 1, 1, 200, 50);
		buildSettlement = addButton("Build Homestead", 2, 1, 200, 50);
		buildCity = addButton("Upgrade to City", 3, 1, 200, 50);
		buildDevCard = addButton("Development Card", 4, 1, 200, 50);
		addButton("Cancel", 5, 1, 200, 50);
		setVisible(true);
	}
	
	// methods
	
	public void buttonClicked(JButton btn) {
		if (btn == buildRoad) {
			if (manager.getCurrPlayer().getResource(Resource.ADOBE) < 1
					|| manager.getCurrPlayer().getResource(Resource.BANTHA )<1){
				dispose();
			} else {
				manager.getBoard().clickList = new ArrayList<Node>();
				for (int i = 0; i < 72; i++) {
					Edge e = manager.getBoard().getEdges()[i];
					if (e.getOwner() != null || 
					   (e.getNodes()[0].getOwner() != null && e.getNodes()[0].getOwner() != manager.getCurrPlayer())||
					   (e.getNodes()[1].getOwner() != null && e.getNodes()[1].getOwner() != manager.getCurrPlayer())){
						boolean road = false;
						for (Node n : e.getNodes()) {
							for (Edge e2: n.getEdges()) {
								if (e2.getOwner() == manager.getCurrPlayer())
			}
			else{
				manager.getBoard().clickList = new ArrayList<Clickable>();
				for (int i = 0; i < 72; i++){
					Edge e = manager.getBoard().getEdges()[i];
					if (e.getOwner() != null || 
					   (e.getNodes()[0].getOwner() != null && e.getNodes()[0].getOwner() != manager.getCurrPlayer())||
					   (e.getNodes()[1].getOwner() != null && e.getNodes()[1].getOwner() != manager.getCurrPlayer())){
						boolean road = (e.getNodes()[0].getOwner() == manager.getCurrPlayer()
								||e.getNodes()[1].getOwner() == manager.getCurrPlayer());
						for (Node n : e.getNodes()){
							for (Edge e2: n.getEdges()){
								if (e2.getOwner() == manager.getCurrPlayer())
									road = true;
							}
						}
						if (road){
							manager.getBoard().clickList.add((Clickable)e);
						}
					}
				}
			}
		} 
		else if (btn == buildSettlement) {
			if (manager.getCurrPlayer().getResource(Resource.ADOBE) < 1
					|| manager.getCurrPlayer().getResource(Resource.BANTHA ) < 1 
					|| (manager.getCurrPlayer().getResource(Resource.MOISTURE) < 1
					|| manager.getCurrPlayer().getResource(Resource.DURASTEEL) < 1)){
				dispose();
			}
			else{
				manager.getBoard().clickList = new ArrayList<Clickable>();
				for (Node n : manager.getBoard().getNodes()){
					n.availabilityCheck(manager.getCurrPlayer());
					if (n.isAvailable()){
						manager.getBoard().clickList.add((Clickable)n);
					}
				}
			}
		} else if (btn == buildDevCard) {
			manager.getDeck().draw(manager.getCurrPlayer());
		} else {// cancel
		} 
		else if (btn == buildCity) {
			if (manager.getCurrPlayer().getResource(Resource.MOISTURE) < 2
					|| manager.getCurrPlayer().getResource(Resource.DURASTEEL) < 3){
				dispose();
			}
			else{
				manager.getBoard().clickList = new ArrayList<Clickable>();
				for (Node n : manager.getBoard().getNodes()){
					if (n.getStatus() == Node.NodeStatus.SETTLEMENT && n.getOwner() == manager.getCurrPlayer()){
						manager.getBoard().clickList.add((Clickable)n);
					}
				}
			}
		} 
		else if (btn == buildDevCard) {
			if (manager.getCurrPlayer().getResource(Resource.BLUEMILK) < 1
					|| (manager.getCurrPlayer().getResource(Resource.MOISTURE) < 1
					|| manager.getCurrPlayer().getResource(Resource.DURASTEEL) < 1)){ 
				dispose();
			}
			else{
				manager.getDeck().draw(manager.getCurrPlayer());
			}
		} 
		else {// cancel
			dispose();
		}
		dispose();
	}
		
}