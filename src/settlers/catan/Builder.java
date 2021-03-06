package settlers.catan;

import BreezySwing.GBFrame;
import java.util.ArrayList;
import javax.swing.JButton;

public class Builder extends GBFrame {

	// fields
	private static final long serialVersionUID = 1L;
	private JButton buildRoad, buildSettlement, buildCity, buildDevCard;
	private GameManager gManager;

	// constructor
	public Builder(GameManager gManager) {
		setSize(300, 400);
		this.gManager = gManager;
		buildRoad = addButton("Road", 1, 1, 1, 1);
		buildRoad.setEnabled(gManager.getCurrPlayer().getResource(Resource.ADOBE) >= 1
				&& gManager.getCurrPlayer().getResource(Resource.BANTHA ) >= 1);
		buildSettlement = addButton("Settlement", 2, 1, 1, 1); 
		buildSettlement.setEnabled(gManager.getCurrPlayer().getResource(Resource.ADOBE) >= 1
				&& gManager.getCurrPlayer().getResource(Resource.BANTHA ) >= 1 
				&& gManager.getCurrPlayer().getResource(Resource.MOISTURE) >= 1
				&& gManager.getCurrPlayer().getResource(Resource.BLUEMILK) >= 1);
		buildCity = addButton("Upgrade to City", 3, 1, 1, 1);
		buildCity.setEnabled(gManager.getCurrPlayer().getResource(Resource.MOISTURE) >= 2
				&& gManager.getCurrPlayer().getResource(Resource.DURASTEEL) > 3);
		buildDevCard = addButton("Development Card", 4, 1, 1, 1);
		buildDevCard.setEnabled(gManager.getCurrPlayer().getResource(Resource.BLUEMILK) >= 1
				&& gManager.getCurrPlayer().getResource(Resource.MOISTURE) >= 1
				&& gManager.getCurrPlayer().getResource(Resource.DURASTEEL) >= 1);
		addButton("Cancel", 5, 1, 1, 1);
		setVisible(true);
	}

	public Builder(GameManager gManager,boolean dev){
		// do nothing
	}

	// methods

	public void buttonClicked(JButton btn) {
		if (btn == buildRoad) {
			gManager.getBoard().clickList = new ArrayList<Clickable>();
			for (int i = 0; i < 72; i++){
				Edge e = gManager.getBoard().getEdges()[i];
				if (e.canBeRoad(gManager.getCurrPlayer())){
					gManager.getBoard().clickList.add((Clickable)e);
				}
			}
		}
		else if (btn == buildSettlement) {
			gManager.getBoard().clickList = new ArrayList<Clickable>();
			for (Node n : gManager.getBoard().getNodes()){
				n.availabilityCheck(gManager.getCurrPlayer());
				if (n.isAvailable()){
					gManager.getBoard().clickList.add((Clickable)n);
				}
			}
			dispose();
		}
		else if (btn == buildCity) {
			gManager.getBoard().clickList = new ArrayList<Clickable>();
			for (Node n : gManager.getBoard().getNodes()){
				if (n.getStatus() == Node.NodeStatus.SETTLEMENT && n.getOwner() == gManager.getCurrPlayer()){
					gManager.getBoard().clickList.add((Clickable)n);
				}
			}
		} 
		else if (btn == buildDevCard) {

			gManager.getDeck().draw(gManager.getCurrPlayer());
			gManager.getCurrPlayer().modifyResource(Resource.DURASTEEL, -1);
			gManager.getCurrPlayer().modifyResource(Resource.MOISTURE, -1);
			gManager.getCurrPlayer().modifyResource(Resource.BLUEMILK, -1);
			dispose();
		} 
		else {// cancel
			dispose();
		}
		dispose();
	}		
}
