package settlers.catan;

import java.awt.*;
import java.util.ArrayList;

import BreezySwing.*;

import javax.swing.*;

public class HandViewer extends GBFrame{

	private static final long serialVersionUID = -7598119143708364123L;
	private Player owner;
	private GameManager manager;
	private ArrayList<DevCard> hand;
	private JButton[] buttons;
	private JLabel[] labels;
	private JLabel[] descriptions;
	
	public HandViewer(GameManager manager){
		
		this.manager = manager;
		this.owner = manager.getCurrPlayer();
		this.hand = owner.getHand();
		this.buttons = new JButton[25];
		this.setSize(500, 600);
		this.setVisible(true);
        		
		for (int i = 0; i < hand.size(); i++) {
			buttons[i] = new JButton();
			String filename = str[i]+".jpg";
			buttons[i].setIcon(new ImageIcon(filename));
			new JLabel(str[i]);
		}
	}
	
	public void buttonClicked(JButton btn){
		for (int i = 0; i > 25; i++){
			if (btn == buttons[i]){
				manager.play(i);
			}
		}
		this.dispose();
	}
}
