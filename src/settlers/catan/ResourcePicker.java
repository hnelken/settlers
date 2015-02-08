package settlers.catan;

import java.awt.*;
import BreezySwing.*;
import javax.swing.*;

public class ResourcePicker extends GBFrame {
	
	// fields
	private static final long serialVersionUID = 1L;
	private GameManager manager;
	private DevCard.Type type;
	private JButton[] buttons = new JButton[5];

	// constructor
	public ResourcePicker(GameManager manager, DevCard.Type type) {
		this.manager = manager;
		this.type = type;
		setSize(600, 300);
		String[] str = {"Adobe", "Bantha", "Blue Milk", "Moisture", "Durasteel"};
		for (int i = 0; i < 5; i++) {
			buttons[i] = new JButton();
			String filename = str[i]+".jpg";
			buttons[i].setIcon(new ImageIcon(filename));
			new JLabel(str[i]);
		}
		setVisible(true);
	}

	// methods

	public void buttonClicked(JButton btn) {
		// Determine resource type
		Resource res;
		if (btn == buttons[0]) // adobe
			res = Resource.ADOBE;
		else if (btn == buttons[1]) // bantha
			res = Resource.BANTHA;
		else if (btn == buttons[2]) // blue milk
			res = Resource.BLUEMILK;
		else if (btn == buttons[3]) // moisture
			res = Resource.MOISTURE;
		else // durasteel
			res = Resource.DURASTEEL;
		// Report resource chosen to game manager class
		manager.resourceChosen(res, type);
		dispose();
	}

}