package com.jpii.KingOil.game;

import com.jpii.KingOil.KingOil;
import com.jpii.KingOil.gui.Window;

import java.awt.*;
import java.awt.image.*;
import java.awt.event.*;
import javax.imageio.ImageIO;

@SuppressWarnings("serial")
public class Game extends Window {
	public Game() {
		super(780,750);
		init();
		setDefaults();
	}
	
	BufferedImage gameboard;
	Image buffer;
	Graphics g;
	int boardx,boardy;
	
	boolean pressed = false;
	
	private void init(){
		try{
			gameboard = ImageIO.read(Game.class.getResource("/com/jpii/KingOil/res/GameBoard.png"));
		}catch(Exception e) {e.printStackTrace();}
		
		MouseListener mouse = new MouseAdapter() {public void mousePressed(MouseEvent e){mousePressed2(e);}
		public void mouseReleased(MouseEvent e){mouseReleased2(e);}};
		this.addMouseListener(mouse);
		MouseMotionListener mouse1 = new MouseAdapter() {public void mouseDragged(MouseEvent md){mouseDrag(md);}
		public void mouseMoved(MouseEvent md){mouseM(md);}};
		this.addMouseMotionListener(mouse1);
		
		initializePoints();
		
		BufferedImage img = new BufferedImage(width+16, height+38, BufferedImage.TYPE_INT_ARGB);
		buffer = img;
		g = buffer.getGraphics();
	}
	
	public void paint(Graphics paint){
		g.setColor(Color.black);
		g.fillRect(0,0,780,750);
		
		
		
		g.drawImage(gameboard, 0+boardx,0+boardy,this);
		paint.drawImage(buffer,0,8,this);
	}
	
	/////  Mouse Events  ///////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	private void mousePressed2(MouseEvent e) {
		if (e.getClickCount() == 2)
			centerScreen(e.getX(),e.getY());
    }

	private void mouseDrag(MouseEvent e) {
    }

    private void mouseM(MouseEvent e) {
    	
    }

    private void mouseReleased2(MouseEvent e) {
	}
    
	/////  Other methods  ///////////////////////////////////////////////////////////////////////////////////////////////////////////

    private void initializePoints(){
    	
    }
    
    private void centerScreen(int x, int y){
    	boardx-=(x-width/2);
    	boardy-=((y-height/2)-8);
    	repaint();
    }
}
