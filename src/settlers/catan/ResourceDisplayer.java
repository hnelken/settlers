package settlers.catan;

import javax.swing.*;

import BreezySwing.*;

public class ResourceDisplayer extends GBFrame{
	
	
	private static final long serialVersionUID = 6687408458293337712L;
	private Player owner;
	private JButton button;
	
	public ResourceDisplayer(GameManager manager){
		this.owner = manager.getCurrPlayer();
		
		button = addButton("Close", 2, 1, 1, 1);
		
		this.addTextArea(	"Moisture:" + "\t\t" + owner.getResource(0) +"\n" +
							"Blue Milk:" + "\t\t" + owner.getResource(1) + "\n" +
							"Durasteel:" + "\t\t" + owner.getResource(2) +"\n" +
							"Adobe:" + "\t\t" + owner.getResource(3) +"\n" +
							"Banthas:" + "\t\t" + owner.getResource(4) +"\n", 1, 1, 1, 1);
		
	}
	
	public void buttonClicked(JButton btn){
		if (btn == button){
			dispose();
		}
	}
}
