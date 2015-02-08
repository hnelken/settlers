package settlers.catan;

import BreezySwing.GBFrame;
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
				gManager.getBoard.clickList = new ArrayList<Node>();
				for (int i = 0; i < 72; i++){
					Edge e = gManager.getBoard().getEdges()[i];
					if (e.getOwner() != null || 
					   (e.getNodes()[0].getOwner() != null && e.getNodes()[0].getOwner() != gManager.getCurrPlayer())||
					   (e.getNodes()[1].getOwner() != null && e.getNodes()[1].getOwner() != gManager.getCurrPlayer())){
						boolean road = false;
						for (Node n : e.getNodes()){
							for (Edge e2: n.getEdges()){
								if (e2.getOwner() == gManager.getCurrPlayer())
									road = true;
							}
						}
					}
					
				}
			}
		} else if (btn == buildSettlement) {
			
		} else if (btn == buildCity) {
			
		} else if (btn == buildDevCard) {
			gManager.getDeck().draw(gManager.getCurrPlayer());
		} else {// cancel
			dispose();
		}
	}
		
}
