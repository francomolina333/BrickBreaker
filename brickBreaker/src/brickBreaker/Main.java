package brickBreaker;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Main {

	public static void main(String[] args) {
		JFrame obj = new JFrame();
		Gameplay gameplay = new Gameplay();
		obj.setBounds(10, 10, 710, 600);
		obj.setTitle("Brick Breaker");
		obj.setResizable(false);
		obj.setVisible(true);
		obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		obj.add(gameplay);
		
	}

}
