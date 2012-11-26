package com.jpii.KingOil.game;

import java.awt.*;
import java.util.*;

public class Plot {
	
	ArrayList<Hole> holes;
	double[] origx;
	double[] origy;
	
	Polygon plot;
	
	public Plot(int[] xarray,int[] yarray){
		initilizePlot(xarray,yarray);
		holes = new ArrayList<Hole>();
	}
	
	public Plot(int[] xarray,int[] yarray,int[] capx, int[] capy){
		initilizePlot(xarray,yarray);
		holes = new ArrayList<Hole>();
		initilizeHoles(capx, capy);
	}
	
	private void initilizePlot(int[] xarray,int[] yarray){
		origx = new double[xarray.length];
		origy = new double[yarray.length];
		for(int index=0; index<xarray.length; index++){
			origx[index] = xarray[index];
			origy[index] = yarray[index];
		}
	}
	
	private void initilizeHoles(int[] capx, int[] capy){
		for(int index = 0; index<capx.length; index++){
			holes.add(new Hole(capx[index],capy[index]));
		}
	}
	
	public void drawPlot(Graphics g){
		g.setColor(Color.blue);
		g.drawPolygon(plot);
		for (int index = 0; index<holes.size(); index++){
			holes.get(index).drawHole(g);
		}
	}
	
	public void updatePlot(double scale){
		double imgwidth = 780/2*(scale-(1));
		double imgheight = 750/2*(scale-(1));
		double[] finx = new double[origx.length];
		double[] finy = new double[origy.length];
		for(int index=0; index<origx.length; index++){
			finx[index] = ((origx[index]*scale)-imgwidth);
			finy[index] = ((origy[index]*scale)-imgheight);
		}
		plot = getPolygon(finx,finy);
		for(int index=0; index<holes.size(); index++){
			holes.get(index).updatePlot(scale,imgwidth,imgheight);
		}
	}
	
	private Polygon getPolygon(double[] xs,double[] ys){
		Polygon temp = new Polygon();
		for(int index=0;index<xs.length;index++){
			temp.addPoint((int)(xs[index]),(int)(ys[index]));
		}
		return temp;
	}
	
	public void addX(double x){
		for(int index=0; index<origx.length; index++){
			origx[index] += x; 
		}
		
		for(int index=0; index<holes.size();index++){
			holes.get(index).x+=x;
		}
	}
	public void addY(double y){
		for(int index=0; index<origy.length; index++){
			origy[index] += y; 
		}
		
		for(int index=0; index<holes.size();index++){
			holes.get(index).y+=y;
		}
	}
	
	public void passMouse(double x, double y){
		if(plot.contains(new Point((int)x,(int)y))){
		}
		for(int index=0;index<holes.size();index++){
			holes.get(index).passMouse(x,y);
		}
	}
}
