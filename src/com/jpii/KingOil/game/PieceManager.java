package com.jpii.KingOil.game;

import java.awt.*;
import java.util.*;

public class PieceManager {
	
	private ArrayList<Plot> plots;
	
	public PieceManager(int x,int y,double scale){
		plots = new ArrayList<Plot>();
		initializePlots();
		updatePlots(scale);
	}
	
	private void initializePlots(){
		int[] x = {174, 244, 193, 60, 60, 55, 65, 67, 63, 69, 86, 105, 129};
		int[] y = {84, 174, 336, 321, 307, 285, 253, 236, 192, 140, 102, 83, 80};
		plots.add(new Plot(x,y));
		int[] x1 ={174, 245, 335, 344, 328, 338, 299, 275, 246};
		int[] y1 ={84, 172, 171, 147, 87, 41, 47, 50, 74, 0};
		plots.add(new Plot(x1,y1));
		/*plots.add(new Plot());
		plots.add(new Plot());
		plots.add(new Plot());
		plots.add(new Plot());
		plots.add(new Plot());
		plots.add(new Plot());
		plots.add(new Plot());
		plots.add(new Plot());
		plots.add(new Plot());
		plots.add(new Plot());
		plots.add(new Plot());
		plots.add(new Plot());
		plots.add(new Plot());
		plots.add(new Plot());
		plots.add(new Plot());
		plots.add(new Plot());*/
	}
	
	public void updatePlots(double scale){
		for(int index = 0; index<plots.size();index++){
			plots.get(index).updatePlot(scale);
		}
	}
	
	public void drawPlots(Graphics g){
		for(int index = 0; index<plots.size();index++){
			plots.get(index).drawPlot(g);
		}
	}
}
