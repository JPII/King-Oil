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
		int[] y1 ={84, 172, 171, 147, 87, 41, 47, 50, 74};
		plots.add(new Plot(x1,y1));
		int[] x2 = {339, 330, 345, 403, 444, 442, 453, 453, 418, 365};
		int[] y2 = {41, 82, 144, 145, 151, 107, 75, 46, 34, 37};
		plots.add(new Plot(x2,y2));
		int[] x3 = {456, 455, 443, 443, 477, 480, 509, 550, 561, 553, 555, 629};
		int[] y3 = {44, 72, 103, 143, 158, 192, 206, 202, 179, 134, 125, 107};
		plots.add(new Plot(x3,y3));
		int[] x4 = {633, 560, 552, 561, 550, 513, 515, 696};
		int[] y4 = {106, 126, 133, 175, 200, 208, 238, 242};
		plots.add(new Plot(x4,y4));
		int[] x5 = {344, 407, 407, 345, 329, 300, 221, 245, 331};
		int[] y5 = {147, 146, 285, 288, 296, 263, 261, 172, 177};
		plots.add(new Plot(x5,y5));
		int[] x6 = {405, 474, 481, 507, 530, 475, 456, 437, 406};
		int[] y6 = {148, 159, 193, 208, 334, 335, 300, 288, 284};
		plots.add(new Plot(x6,y6));
		int[] x7 = {516, 698, 711, 708, 648, 604, 530};
		int[] y7 = {241, 243, 265, 307, 330, 338, 335};
		plots.add(new Plot(x7,y7));
		int[] x8 = {58, 191, 178, 188, 68};
		int[] y8 = {323, 334, 379, 420, 447};
		plots.add(new Plot(x8,y8));
		int[] x9 = {218, 301, 327, 309, 303, 304, 314, 314, 228, 189, 181};
		int[] y9 = {260, 264, 299, 319, 387, 392, 414, 430, 433, 421, 387};
		plots.add(new Plot(x9,y9));
		int[] x10 = {477, 606, 653, 656, 644, 657, 639, 623, 576, 479};
		int[] y10 = {338, 340, 328, 353, 377, 439, 458, 453, 448, 414};
		plots.add(new Plot(x10,y10));
		int[] x11 = {654, 705, 706, 660, 592, 576, 631, 654};
		int[] y11 = {330, 312, 512, 515, 532, 448, 454, 445};
		plots.add(new Plot(x11,y11));
		int[] x12 = {65, 186, 224, 209, 177, 167, 124, 105, 112};
		int[] y12 = {449, 426, 433, 559, 560, 606, 604, 577, 520};
		plots.add(new Plot(x12,y12));
		int[] x13 = {224, 315, 320, 353, 437, 448, 412, 395, 208};
		int[] y13 = {434, 435, 459, 474, 473, 551, 565, 556, 561};
		plots.add(new Plot(x13,y13));
		int[] x14 = {476, 578, 592, 539, 457, 449, 441, 469};
		int[] y14 = {413, 449, 533, 559, 549, 551, 472, 462};
		plots.add(new Plot(x14,y14));
		int[] x15 = {122, 166, 176, 340, 331, 261, 201, 157};
		int[] y15 = {607, 607, 565, 560, 682, 691, 663, 647};
		plots.add(new Plot(x15,y15));
		int[] x16 = {340, 396, 414, 455, 503, 499, 477, 447, 416, 390, 351, 334};
		int[] y16 = {559, 556, 567, 548, 558, 687, 680, 680, 688, 690, 690, 683};
		plots.add(new Plot(x16,y16));
		int[] x17 = {502, 539, 594, 658, 710, 715, 698, 700, 676, 631, 609, 548, 503};
		int[] y17 = {555, 556, 532, 511, 514, 534, 574, 624, 656, 667, 662, 681, 685};
		plots.add(new Plot(x17,y17));
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
	
	public void addX(int x){
		for(int index = 0; index<plots.size();index++){
			plots.get(index).addX(x);
		}
	}
	
	public void addY(int y){
		for(int index = 0; index<plots.size();index++){
			plots.get(index).addY(y);
		}
	}
	
	public void passMouse(int x, int y){
		for(int index = 0; index<plots.size();index++){
			plots.get(index).passMouse(x,y);
		}
	}
}
