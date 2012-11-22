package com.jpii.KingOil.game;

import java.awt.*;
import java.util.*;

public class Plot {
	
	Polygon plot;
	Polygon orig;
	boolean inside;
	
	ArrayList<Hole> holes;
	
	public Plot(int[] xarray,int[] yarray){
		orig=new Polygon(xarray,yarray,xarray.length);
		plot = orig;
		inside = false;
		holes = new ArrayList<Hole>();
	}
	
	public Plot(int[] xarray,int[] yarray,int[] capx, int[] capy){
		orig=new Polygon(xarray,yarray,xarray.length);
		plot = orig;
		inside = false;
		holes = new ArrayList<Hole>();
		initilizeHoles(capx, capy);
	}
	
	private void initilizeHoles(int[] capx, int[] capy){
		for(int index = 0; index<capx.length; index++){
			holes.add(new Hole(capx[index],capy[index]));
		}
	}
	
	public void drawPlot(Graphics g){
		g.setColor(Color.blue);
		if(!inside)
			g.drawPolygon(plot);
		else
			g.fillPolygon(plot);
		for (int index = 0; index<holes.size(); index++){
			holes.get(index).drawHole(g);
		}
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
