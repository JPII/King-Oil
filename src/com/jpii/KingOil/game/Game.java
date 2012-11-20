package com.jpii.KingOil.game;

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
	
	public void init(){
		try{
			gameboard = ImageIO.read(Game.class.getResource("/com/jpii/KingOil/res/GameBoard.png"));
		}catch(Exception e) {e.printStackTrace();}
		
		BufferedImage img = new BufferedImage(width+16, height+38, BufferedImage.TYPE_INT_ARGB);
		buffer = img;
		g = buffer.getGraphics();
	}
	
	public void paint(Graphics paint){
		g.setColor(Color.black);
		g.fillRect(0,0,780,750);
		g.drawImage(gameboard, 0,0,this);
		paint.drawImage(buffer,0,0,this);
	}
	
}
