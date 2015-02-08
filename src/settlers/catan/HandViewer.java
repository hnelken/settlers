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
        		
		int i = 0;
		int x = 10;
		int y = 10;
		for (DevCard card : hand){
			buttons[i] = addButton("Play", x , y, 10, 10);
			labels[i] = addLabel(card.getName(), x + 10, y, 300, 30);
			descriptions[i] = addLabel(card.getDescription(), x + 15, y + 15, 300, 10);
			if (card.isPlayable()){
				buttons[i].setEnabled(true);
			} else {
				buttons[i].setEnabled(false);
			}
			x = x + 20;
			y = y + 20;
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
