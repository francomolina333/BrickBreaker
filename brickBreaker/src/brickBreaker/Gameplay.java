package brickBreaker;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.Timer;

import javax.swing.JPanel;

public class Gameplay extends JPanel implements KeyListener, ActionListener{
	
	private boolean play = false;
	private boolean outOfBounds = false;
	private boolean winner = false;
	
	private int bricksLen = 1;
	private int bricksWidth = 1;
	private int totalBricks = bricksWidth * bricksLen;
	
	private Timer time;
	private int delay = 8;
	
	private int playerX = 310;
	
	private int ballPosX = 120;
	private int ballPosY = 350;
	private int ballXdir = -1;
	private int ballYdir = -2;
	
	private LevelGenerator lvl1;
	
	
	// constructor
	// loads Level 1
	public Gameplay() {
		resetGame();
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);

		time = new Timer(delay, this);
		time.start(); 
	}

	
	// prints graphics
	
	public void paint(Graphics g) {
		// background
		g.setColor(Color.black);
		g.fillRect(1, 1, 690, 592);
		
		// borders
		g.setColor(Color.yellow);
		g.fillRect(0, 0, 3, 592);
		g.fillRect(0, 0, 692, 3);
		g.fillRect(691, 0, 3, 592);
		
		// drawing level
		lvl1.draw((Graphics2D)g);
		
		// paddle
		g.setColor(Color.green);
		g.fillRect(playerX, 550, 100, 8);
		
		
		// ball
		g.setColor(Color.pink);
		g.fillOval(ballPosX, ballPosY, 20, 20);
		
		
		// bid red font
		Font F = new Font("", 1, 50);
		
		// small white font
		Font sub = new Font("TYPE_1", 1, 25);
		
		// prints winner screen
		if (winner) {
			
			
			// remove ball from screen
			ballPosX = 1000;
			ballPosY = 1000;
			g.setColor(Color.red);

			g.setFont(F);
			g.drawString("Congratulations,", 150, 175);
			g.drawString("You are a Winner!", 150, 230);
			
			g.setFont(sub);
			g.setColor(Color.white);
			g.drawString("Press Space to Restart", 215, 450);
		}
		
		// prints Game Over
		if (outOfBounds) {

			// remove ball from screen
			ballPosX = 1000;
			ballPosY = 1000;
			
			g.setColor(Color.red);
			g.setFont(F);
			g.drawString("GAME OVER", 200, 275);
			
			g.setColor(Color.white);
			g.setFont(sub);
			g.drawString("Press Space to Restart", 215, 450);
		}
		
		
		//releases graphics
		g.dispose();
		
		
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		time.start(); 
		if(play) {
			if(new Rectangle(ballPosX, ballPosY, 20 ,20).intersects(new Rectangle(playerX, 550, 100 ,8))) {
				ballYdir = -ballYdir;
			}
			
			A: for(int i =0; i < lvl1.bricks.length; i++) {
				for(int j = 0; j < lvl1.bricks[0].length; j++) {
					if (lvl1.bricks[i][j] > 0) {
						int brickX = j* lvl1.brickWidth + 80;
						int brickY = i* lvl1.brickHeight + 50;
						int brickWidth = lvl1.brickWidth;
						int brickHeight = lvl1.brickHeight;
						
						Rectangle rect = new Rectangle(brickX, brickY, brickWidth, brickHeight);
						Rectangle ballRect = new Rectangle(ballPosX, ballPosY, 20, 20);
						Rectangle brickRect = rect;
						
						if(ballRect.intersects(brickRect)) {
							lvl1.setBrickValue(0, i, j);
							totalBricks--;
							
							
							if(ballPosX + 19 <= brickRect.x || ballPosX + 1 >= brickRect.x + brickRect.width) {
								ballXdir = -ballXdir;
							} else {
								ballYdir = -ballYdir;
							}
							
							
							
							break A;
						}
					}
					
				}
			}
			
			ballPosX += ballXdir;
			ballPosY += ballYdir;
			
			//Left boundary
			if (ballPosX < 0) {
				ballXdir = -ballXdir;
			}
			//Top boundary
			if (ballPosY < 0) {
				ballYdir = -ballYdir;
			}
			//Right boundary
			if (ballPosX > 670) {
				ballXdir = -ballXdir;
			}
			//Lower boundary
			if (ballPosY > 750) {
				play = false;
				outOfBounds = true;
			}
		}
		
		
		repaint();
		
		if (totalBricks == 0){
			play = false;
			winner = true;
		
		}
		
       // time.start();
		
	}

	@Override
	public void keyTyped(KeyEvent e) {}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			if(playerX >= 600) {
				playerX = 600;
			} else {
				moveRight();
			}
		}
		if(e.getKeyCode() == KeyEvent.VK_LEFT) {
			if(playerX <= 10) {
				playerX = 10;
			} else {
				moveLeft();
			}
		}
		if ((e.getKeyCode() == KeyEvent.VK_SPACE) && (!play)) {
			resetGame();
		}
	}
	
	public void moveRight () {
		play = true;
		playerX += 10;
	}
	public void moveLeft () {
		play = true;
		playerX -= 10;
	}
	
	public void resetGame () {
		play = false;
		lvl1 = new LevelGenerator(bricksWidth, bricksLen);
		totalBricks = bricksWidth * bricksLen;
		playerX = 310;
		
		ballPosX = 120;
		ballPosY = 350;
		ballXdir = -1;
		ballYdir = -2;
		
		winner = false;
		outOfBounds = false;
	}


	@Override
	public void keyReleased(KeyEvent e) {}
	

}
