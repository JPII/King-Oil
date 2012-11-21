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
	public double displayx,displayy,step;
	public double factor,originalFactor;
	boolean pressed = false;
	boolean first = true;
	
	private void init(){
		step = 50;
		factor = 1.0;
		displayx=width/2;
		displayy=height/2;
		originalFactor = factor;
		
		try{
			gameboard = ImageIO.read(Game.class.getResource("/com/jpii/KingOil/res/GameBoard.png"));
		}catch(Exception e) {e.printStackTrace();}
		
		MouseListener mouse = new MouseAdapter() {public void mousePressed(MouseEvent e){mousePressed2(e);}
		public void mouseReleased(MouseEvent e){mouseReleased2(e);}};
		this.addMouseListener(mouse);
		MouseMotionListener mouse1 = new MouseAdapter() {public void mouseDragged(MouseEvent md){mouseDrag(md);}
		public void mouseMoved(MouseEvent md){mouseM(md);}};
		this.addMouseMotionListener(mouse1);
		
		BufferedImage img = new BufferedImage(width+16, height+38, BufferedImage.TYPE_INT_ARGB);
		buffer = img;
		g = buffer.getGraphics();
		
		KingOil.getDebugWindow().println("Game initilized");
	}
	
	public void paint(Graphics paint){
		g.setColor(randomColor());
		g.fillRect(0,0,780,750);
		
		KingOil.getDebugWindow().println("display: "+(displayx - width/2/factor));
		g.drawImage(gameboard, 0, 0, 780, 750,(int)(displayx - width/2/factor),(int)(displayy - height/2/factor),(int)((displayx-width/2/factor)+(width/factor)),(int)((displayy-height/2/factor)+(height/factor)),null);
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
    
    private Color randomColor(){
    	return new Color((int)(Math.random()*100),(int)(Math.random()*100),(int)(Math.random()*100));
    }
    
    private void centerScreen(int x, int y){
    	KingOil.getDebugWindow().println("Mouse "+x+" "+y);
    	displayx= (x-(displayx-(width/2)))/factor;
    	//displayy= (displayy-y);
    }
    
    public void reset(){
    	displayx = width/2;
    	displayy = height/2;
    	factor = originalFactor;
    }
}
