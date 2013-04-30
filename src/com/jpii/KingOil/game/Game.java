package com.jpii.KingOil.game;

import com.jpii.KingOil.KingOil;
import com.jpii.gamekit.gui.BaseWindow;

import java.awt.*;
import java.awt.image.*;
import java.awt.event.*;
import javax.imageio.ImageIO;

@SuppressWarnings("serial")
public class Game extends BaseWindow {
	public Game() {
		super(780,750,( Toolkit.getDefaultToolkit().getScreenSize().width /2 - 780 / 2),8);
		init();
		setDefaults();
	}
	
	BufferedImage gameboard;
	Image buffer;
	Graphics g;
	public double centerx, centery,step,scale,originalFactor;
	public int mousex, mousey;
	
	PieceManager pieces;
	
	public Polygon p = new Polygon();
	
	private void init(){
		step = 25;
		scale = 1.0;
		centerx = width/2;
		centery = height/2;
		originalFactor = scale;
		
		pieces = new PieceManager(scale);
		
		BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		buffer = img;
		g = buffer.getGraphics();
		
		try{
			gameboard = ImageIO.read(Game.class.getResource("/com/jpii/KingOil/res/GameBoard.png"));
		}catch(Exception e) {e.printStackTrace();}
		
		MouseListener mouse = new MouseAdapter() {public void mousePressed(MouseEvent e){mousePressed2(e);}
		public void mouseReleased(MouseEvent e){mouseReleased2(e);}};
		this.addMouseListener(mouse);
		MouseMotionListener mouse1 = new MouseAdapter() {public void mouseDragged(MouseEvent md){mouseM(md);}
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
		mousex = e.getX();
		mousey = e.getY();
		if (e.getClickCount() == 2)
			centerScreen(mousex,mousey);
		
		if(e.getButton()==3){
			p.addPoint(mousex, mousey);
		}
		repaint();
    }

    private void mouseM(MouseEvent e) {
    	mousex = e.getX();
		mousey = e.getY();
    	pieces.passMouse(mousex,mousey);
    	repaint();
    }

    private void mouseReleased2(MouseEvent e) {
	}
    
	/////  Other methods  ///////////////////////////////////////////////////////////////////////////////////////////////////////////
    private void drawBoard(){
    	double imgwidth = width/scale;
    	double imgheight = height/scale;
    	g.drawImage(gameboard, 0, 0, width, height,(int)(centerx-imgwidth/2),(int)(centery-imgheight/2),(int)(centerx+imgwidth/2),(int)(centery+imgheight/2), null);
    }
    
    private void centerScreen(double x, double y){
    	double xchange = (x-width/2)/scale;
    	double ychange = (y-height/2)/scale;
    	centerx += xchange;
    	centery += ychange;
    	addX(-1*xchange);
    	addY(-1*ychange);
    }
    public void addX(double x){
    	pieces.addX(x);
    	scaling();
    }
    public void addY(double y){
    	pieces.addY(y);
    	scaling();
    }
    
    public void reset(){
    	addX(centerx-width/2);
    	addY(centery-height/2);
    	centerx = width/2;
    	centery = height/2;
    	scale = originalFactor;
    	scaling();
    }
    
    public void scaling(){
    	pieces.updatePlots(scale);
    }
}
