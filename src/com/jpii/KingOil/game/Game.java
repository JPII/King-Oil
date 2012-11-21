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
		super(780,750,( Toolkit.getDefaultToolkit().getScreenSize().width /2 - 780 / 2),8);
		init();
		setDefaults();
	}
	
	BufferedImage gameboard;
	Image buffer;
	Graphics g;
	public double centerx, centery,step,scale,originalFactor;
	
	PieceManager pieces;
	
	private void init(){
		step = 50;
		scale = 1.0;
		centerx = width/2;
		centery = height/2;
		originalFactor = scale;
		
		pieces = new PieceManager(width,height,scale);
		
		BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		buffer = img;
		g = buffer.getGraphics();
		
		try{
			gameboard = ImageIO.read(Game.class.getResource("/com/jpii/KingOil/res/GameBoard.png"));
		}catch(Exception e) {e.printStackTrace();}
		
		MouseListener mouse = new MouseAdapter() {public void mousePressed(MouseEvent e){mousePressed2(e);}
		public void mouseReleased(MouseEvent e){mouseReleased2(e);}};
		this.addMouseListener(mouse);
		MouseMotionListener mouse1 = new MouseAdapter() {public void mouseDragged(MouseEvent md){mouseDrag(md);}
		public void mouseMoved(MouseEvent md){mouseM(md);}};
		this.addMouseMotionListener(mouse1);
		
		KingOil.getDebugWindow().println("Game initilized");
	}
	
	public void paint(Graphics paint){
		g.setColor(Color.black);
		g.fillRect(0,0,780,750);
		drawBoard();
		
		pieces.drawPlots(g);
		
		paint.drawImage(buffer,0,0,this);
		paint.setColor(Color.red);
		paint.fillRect(width/2, height/2, 1, 1);
	}
	
	/////  Mouse Events  ///////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	private void mousePressed2(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();
		if (e.getClickCount() == 2)
			centerScreen(x,y);
		repaint();
    }

	private void mouseDrag(MouseEvent e) {
    }

    private void mouseM(MouseEvent e) {
    	
    }

    private void mouseReleased2(MouseEvent e) {
	}
    
	/////  Other methods  ///////////////////////////////////////////////////////////////////////////////////////////////////////////
    private void drawBoard(){
    	double imgwidth = width/scale;
    	double imgheight = height/scale;
    	g.drawImage(gameboard, 0, 0, width, height,(int)(centerx-imgwidth/2),(int)(centery-imgheight/2),(int)(centerx+imgwidth/2),(int)(centery+imgheight/2), null);
    }
    
    private void centerScreen(int x, int y){
    	centerx += (x-width/2)/scale;
    	centery += (y-height/2)/scale;
    }
    
    public void reset(){
    	centerx = width/2;
    	centery = height/2;
    	scale = originalFactor;
    	pieces = new PieceManager(width,height,scale);
    }
    
    public void scaling(){
    	pieces.updatePlots(scale);
    }
}
