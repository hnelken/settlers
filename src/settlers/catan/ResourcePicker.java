package settlers.catan;

import java.awt.*;
import BreezySwing.*;
import javax.swing.*;

public class ResourcePicker extends GBFrame {
	
	// fields
	private static final long serialVersionUID = 1L;
	private Player who;
	private JButton[] buttons = new JButton[5];

	// constructor
	public ResourcePicker(Player who) {
		this.who = who;
		String[] str = {"Adobe", "Bantha", "Blue Milk", "Moisture", "Durasteel"};
		for (int i = 0; i < 5; i++) {
			buttons[i] = new JButton();
			String filename = str[i]+".jpg";
			buttons[i].setIcon(new ImageIcon(filename));
			new JLabel(str[i]);
		}
	}

	// methods

	public void buttonClicked(JButton btn) {
		if (btn == buttons[0]) // adobe
			return;
		else if (btn == buttons[1]) // bantha
			return;
		else if (btn == buttons[2]) // blue milk
			return;
		else if (btn == buttons[3]) // moisture
			return;
		else	// durasteel
			return;
	}

}
