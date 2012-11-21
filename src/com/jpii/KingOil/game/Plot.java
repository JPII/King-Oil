package com.jpii.KingOil.game;

import java.awt.*;

public class Plot {
	
	Polygon plot;
	Polygon orig;
	
	public Plot(){
		
	}
	
	public Plot(int[] xarray,int[] yarray){
		orig=new Polygon(xarray,yarray,xarray.length);
		plot = orig;
	}
	
	public void drawPlot(Graphics g){
		g.setColor(Color.blue);
		g.drawPolygon(plot);
	}
	
	public void updatePlot(double scale){
		int[] finx = new int[orig.xpoints.length];
		int[] finy = new int[orig.xpoints.length];
		for(int index=0; index<orig.xpoints.length; index++){
			finx[index] = (int) ((orig.xpoints[index]*scale));
			finy[index] = (int) ((orig.ypoints[index]*scale));
		}
		plot = new Polygon(finx,finy,finx.length);
	}
}
