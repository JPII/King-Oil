package com.jpii.KingOil.game;

import java.awt.*;

public class Hole {
	
	int x,y;
	
	public Hole(int a, int b){
		x=a;
		y=b;
	}
	
	public void drawHole(Graphics g){
		g.setColor(Color.orange);
		g.fillOval(x-6, y-6, 12, 12);
	}
}
