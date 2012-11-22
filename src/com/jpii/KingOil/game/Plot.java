package com.jpii.KingOil.game;

import java.awt.*;

public class Plot {
	
	Polygon plot;
	Polygon orig;
	boolean inside;
	
	public Plot(int[] xarray,int[] yarray){
		orig=new Polygon(xarray,yarray,xarray.length);
		plot = orig;
		inside = false;
	}
	
	public void drawPlot(Graphics g){
		g.setColor(Color.blue);
		if(!inside)
			g.drawPolygon(plot);
		else
			g.fillPolygon(plot);
	}
	
	public void updatePlot(double scale){
		double imgwidth = 780/2*(scale-(1));
		double imgheight = 750/2*(scale-(1));
		int[] finx = new int[orig.xpoints.length];
		int[] finy = new int[orig.xpoints.length];
		for(int index=0; index<orig.xpoints.length; index++){
			finx[index] = (int) ((orig.xpoints[index]*scale)-imgwidth);
			finy[index] = (int) ((orig.ypoints[index]*scale)-imgheight);
		}
		plot = new Polygon(finx,finy,finx.length);
	}
	
	public void addX(int x){
		for(int index=0; index<orig.xpoints.length; index++){
			orig.xpoints[index] += x; 
			plot.xpoints[index] += x;
		}
	}
	public void addY(int y){
		for(int index=0; index<orig.xpoints.length; index++){
			orig.ypoints[index] += y; 
			plot.ypoints[index] += y;
		}
	}
	
	public void passMouse(int x, int y){
		if(plot.contains(new Point(x,y)))
			inside = true;
		else
			inside = false;
	}
}
