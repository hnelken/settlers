package settlers.catan;

import java.awt.*;
import BreezyGUI.*;

public class ResourcePicker extends GBFrame {
	
	// fields
	private static final long serialVersionUID = 1L;
	private Button[] resourceButtons = new Button[5];

	// constructor
	public ResourcePicker() {
		// collect resource images
		Image[] images = getImages();
		
	}

	// methods
	
	private Image[] getImages() {
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Image[] images = new Image[5];
		images[0] = toolkit.getImage("");
		images[0] = toolkit.getImage("");
		images[0] = toolkit.getImage("");
		images[0] = toolkit.getImage("");
		images[0] = toolkit.getImage("");
		return images;
	}

	public void buttonClicked(Button btn) {

	}

}
