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
			
		} else if (btn == buildSettlement) {
			
		} else if (btn == buildCity) {
			
		} else if (btn == buildDevCard) {
			gManager.getDeck().draw(gManager.getCurrPlayer());
		} else {// cancel
			dispose();
		}
	}
		
}
