package settlers.catan;

import BreezySwing.*;
import javax.swing.*;

public class ResourcePicker extends GBFrame {
	
	// fields
	public enum PickerType {
		TWINSUNS, SANDSTORM, TRADINGAWAY, TRADINGFOR;
	}
	
	private static final long serialVersionUID = 1L;
	private GameManager manager;
	private PickerType type;
	private JButton[] buttons = new JButton[5];

	// constructor
	public ResourcePicker(GameManager manager, PickerType type, String message) {
		this.manager = manager;
		this.type = type;
		addLabel(message, 1, 1, 5, 1);
		setSize(1300, 500);
		String[] str = {"Moisture", "Blue Milk", "Durasteel", "Adobe", "Bantha"};
		for (int i = 0; i < 5; i++) {
			buttons[i] = addButton("", 2, i+1, 1, 1);
			buttons[i].setEnabled(true);
			String filename = str[i]+".jpg";
			buttons[i].setIcon(new ImageIcon(filename));
			addLabel(str[i], 3, i+1, 1, 1);
			if (type == PickerType.TRADINGAWAY && manager.getCurrPlayer().getResource(i) < 4){
				buttons[i].setEnabled(false);
			}
		}
		setVisible(true);
	}

	// methods

	public void buttonClicked(JButton btn) {
		// Determine resource type
		Resource res;
		if (btn == buttons[0]) // adobe
			res = Resource.MOISTURE;
		else if (btn == buttons[1]) // bantha
			res = Resource.BLUEMILK;
		else if (btn == buttons[2]) // blue milk
			res = Resource.DURASTEEL;
		else if (btn == buttons[3]) // moisture
			res = Resource.ADOBE;
		else 
			res = Resource.BANTHA;
		// Report resource chosen to game manager class
		manager.resourceChosen(res, type);
		dispose();
	}

}