package settlers.catan;

import BreezySwing.*;
import java.awt.*;

public class ResourcePicker extends GBFrame {
	
	// fields
	private static final long serialVersionUID = 1L;
	private Player who;
	private Button[] buttons = new Button[5];

	// constructor
	public ResourcePicker(Player who) {
		this.who = who;
		Image[] images = getImages();
		String[] str = {"Adobe", "Bantha", "Blue Milk", "Moisture", "Durasteel"};
		for (int i = 0; i < 5; i++) {
			buttons[i] = new Button();
			new Label(str[i]);
		}
	}

	// methods
	
	private Image[] getImages() {
		// import images
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Image[] images = new Image[5];
		images[0] = toolkit.getImage("Adobe.jpg");
		images[1] = toolkit.getImage("Bantha.jpg");
		images[2] = toolkit.getImage("Blue Milk.jpg");
		images[3] = toolkit.getImage("Moisture.jpg");
		images[4] = toolkit.getImage("Durasteel.jpg");
		// scale images
		for (int i = 0; i < 5; i++) {
			images[i] = images[i].getScaledInstance(250, 400, Image.SCALE_FAST);
		}
		return images;
	}

	public void buttonClicked(Button btn) {
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
