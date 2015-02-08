package settlers.catan;

import BreezySwing.*;
import java.awt.*;
import javax.swing.*;
import java.util.ArrayList;

public class HandViewer extends GBFrame {

	//fields
	
	private static final long serialVersionUID = 1L;
	private GameManager manager;
	private Player owner;
	private ArrayList<JButton> buttons;
	private JLabel[] titles;
	private JTextArea[] descriptions;
	
	// constructors
	
	public HandViewer(GameManager manager){
		// set fields
		this.manager = manager;
		owner = manager.getCurrPlayer();
		ArrayList<DevCard> hand = owner.getHand();
		// initialize GUI element arrays
		buttons = new ArrayList<JButton>(hand.size());
		titles = new JLabel[hand.size()];
		descriptions = new JTextArea[hand.size()];
		// instantiate individual GUI elements
		addLabel("Click a card to play it:", 1, 1, 300, 50);
		for (int i = 0; i < hand.size(); i++) {
			// title label at the top
			titles[i] = addLabel(hand.get(i).getName(), 2, i+1, 300, 50);
			buttons.set(i, addButton("", 3, i+1, 300, 300));
			buttons.get(i).setIcon(hand.get(i).getImage());
			descriptions[i] = addTextArea(hand.get(i).getDescription(), 4, i+1, 300, 100);
			descriptions[i].setEditable(false);  
		}
		setSize(500, 600);
		setVisible(true);
	}
	
	public void buttonClicked(JButton btn){
		int index = buttons.indexOf(btn);
		manager.play(index);
		this.dispose();
	}
}
