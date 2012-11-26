package com.jpii.KingOil.game;

import java.awt.*;

public class Hole {
	
	double x,y,displayx,displayy;
	double scale;
	
	int level;
	
	public Hole(double a, double b){
		x=a;
		y=b;
		displayx = x;
		displayy = y;
		scale = 1.0;
		level = determineLevel();
	}
	
	private int determineLevel(){
		return (int) ((Math.random()*4)+1); //even chance
	}
	
	public void drawHole(Graphics g){
		int level = this.level;
		switch(level){
		case 1: drawCap(g); break;
		case 2: drawWell(g); break;
		case 3: drawWell(g); break;
		default: g.setColor(Color.orange); g.drawOval((int)(displayx-6*scale),(int)(displayy-6*scale),(int)(12*scale),(int)(12*scale)); break;
		}
			
	}
	
	public void drawCap(Graphics g){
		g.setColor(Color.red); g.fillOval((int)(displayx-6*scale),(int)(displayy-6*scale),(int)(12*scale),(int)(12*scale));
		g.setColor(Color.black); 
		g.drawOval((int)((displayx-6*scale)-(scale)+(1.5*scale)),(int)((displayy-6*scale)+(6*scale)-(1.5*scale)),(int)(3*scale),(int)(3*scale));
		g.drawOval((int)((displayx+6*scale)-(scale)-(1.5*scale)-(1)),(int)((displayy-6*scale)+(6*scale)-(1.5*scale)-(1)),(int)(3*scale),(int)(3*scale));
		g.drawOval((int)((displayx-6*scale)+(6*scale)-(1.5*scale)),(int)((displayy-6*scale)-(scale)+(1.5*scale)),(int)(3*scale),(int)(3*scale));
		g.drawOval((int)((displayx-6*scale)+(6*scale)-(1.5*scale)+(1)),(int)((displayy+6*scale)-(scale)-(1.5*scale)-(1)),(int)(3*scale),(int)(3*scale));
	}
	
	public void drawWell(Graphics g){
		g.setColor(Color.orange); g.drawOval((int)(displayx-6*scale),(int)(displayy-6*scale),(int)(12*scale),(int)(12*scale));
	}
	
	public void updatePlot(double scale,double imgwidth,double imgheight){
		displayx = ((x*scale)-imgwidth);
		displayy = ((y*scale)-imgheight);
		this.scale = scale;
	}
	
	public void passMouse(double x, double y){
		if(Math.sqrt(Math.pow(displayx-x,2)+Math.pow(displayy-y, 2))<=(6*scale)){
			
		}
	}
}
