package settlers.catan;
import java.util.ArrayList;

import BreezySwing.GBFrame;

import javax.swing.JButton;

import settlers.catan.Node.NodeStatus;

public class Builder extends GBFrame {

	// fields
	private static final long serialVersionUID = 1L;
	private JButton buildRoad, buildSettlement, buildCity, buildDevCard;
	private GameManager gManager;
	
	// constructor
	public Builder(GameManager gManager) {
		setSize(300, 400);
		this.gManager = gManager;
		buildRoad = addButton("Road", 1, 1, 200, 50);
		buildSettlement = addButton("Settlement", 2, 1, 200, 50);
		buildCity = addButton("Upgrade to City", 3, 1, 200, 50);
		buildDevCard = addButton("Development Card", 4, 1, 200, 50);
		addButton("Cancel", 5, 1, 200, 50);
		setVisible(true);
	}
	
	// methods
	
	public void buttonClicked(JButton btn) {
		if (btn == buildRoad) {
			if (gManager.getCurrPlayer().getResource(Resource.ADOBE) < 1
					|| gManager.getCurrPlayer().getResource(Resource.BANTHA )<1){
				dispose();
			}
			else{
				gManager.getBoard().clickList = new ArrayList<Clickable>();
				for (int i = 0; i < 72; i++){
					Edge e = gManager.getBoard().getEdges()[i];
					if (e.getOwner() != null || 
					   (e.getNodes()[0].getOwner() != null && e.getNodes()[0].getOwner() != gManager.getCurrPlayer())||
					   (e.getNodes()[1].getOwner() != null && e.getNodes()[1].getOwner() != gManager.getCurrPlayer())){
						boolean road = (e.getNodes()[0].getOwner() == gManager.getCurrPlayer()
								||e.getNodes()[1].getOwner() == gManager.getCurrPlayer());
						for (Node n : e.getNodes()){
							for (Edge e2: n.getEdges()){
								if (e2.getOwner() == gManager.getCurrPlayer())
									road = true;
							}
						}
						if (road){
							gManager.getBoard().clickList.add((Clickable)e);
						}
					}
				}
			}
		} 
		else if (btn == buildSettlement) {
			if (gManager.getCurrPlayer().getResource(Resource.ADOBE) < 1
					|| gManager.getCurrPlayer().getResource(Resource.BANTHA ) < 1 
					|| (gManager.getCurrPlayer().getResource(Resource.MOISTURE) < 1
					|| gManager.getCurrPlayer().getResource(Resource.DURASTEEL) < 1)){
				dispose();
			}
			else{
				gManager.getBoard().clickList = new ArrayList<Clickable>();
				for (Node n : gManager.getBoard().getNodes()){
					n.availabilityCheck(gManager.getCurrPlayer());
					if (n.isAvailable()){
						gManager.getBoard().clickList.add((Clickable)n);
					}
				}
			}
		} 
		else if (btn == buildCity) {
			if (gManager.getCurrPlayer().getResource(Resource.MOISTURE) < 2
					|| gManager.getCurrPlayer().getResource(Resource.DURASTEEL) < 3){
				dispose();
			}
			else{
				gManager.getBoard().clickList = new ArrayList<Clickable>();
				for (Node n : gManager.getBoard().getNodes()){
					if (n.getStatus() == Node.NodeStatus.SETTLEMENT && n.getOwner() == gManager.getCurrPlayer()){
						gManager.getBoard().clickList.add((Clickable)n);
					}
				}
			}
		} 
		else if (btn == buildDevCard) {
			if (gManager.getCurrPlayer().getResource(Resource.BLUEMILK) < 1
					|| (gManager.getCurrPlayer().getResource(Resource.MOISTURE) < 1
					|| gManager.getCurrPlayer().getResource(Resource.DURASTEEL) < 1)){ 
				dispose();
			}
			else{
				gManager.getDeck().draw(gManager.getCurrPlayer());
			}
		} 
		else {// cancel
			dispose();
		}
		dispose();
	}
		
}
