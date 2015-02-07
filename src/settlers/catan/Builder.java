package settlers.catan;

import BreezySwing.GBFrame;
import javax.swing.JButton;

public class Builder extends GBFrame {

	// fields
	private static final long serialVersionUID = 1L;
	private JButton buildRoad, buildSettlement, buildCity, buildDevCard;
	
	// constructor
	public Builder() {
		buildRoad = new JButton("Road");
		buildSettlement = new JButton("Settlement");
		buildCity = new JButton("City");
		buildDevCard = new JButton("Development Card");
		new JButton("Cancel");
	}
	
	// methods
	
	public void buttonClicked(JButton btn) {
		
	}
	
}
