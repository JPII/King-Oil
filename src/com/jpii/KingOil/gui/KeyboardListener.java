/*
 * Copyright (C) 2012 JPII and contributors
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */

package com.jpii.KingOil.gui;

import java.awt.event.*;

import com.jpii.KingOil.game.Game;

public class KeyboardListener implements KeyListener {

	Object window;

	public KeyboardListener(Object classname) {
		window = classname;
	}

	@Override
	public void keyPressed(KeyEvent k) {	
		if(k.getKeyCode() == KeyEvent.VK_ESCAPE) {
			WindowCloser.close();
		}
		if(window instanceof DebugWindow) {
			DebugWindow d = (DebugWindow) window;
			if(k.getKeyCode() == KeyEvent.VK_ENTER) {
				d.submitCommandRemote();
			}
		}
		if(window instanceof Game) {
			Game d = (Game) window;
			int key = k.getKeyCode();
			if(key == KeyEvent.VK_HOME) {
				d.reset();
			}
			if (key == KeyEvent.VK_UP) {  
				d.centery+=d.step; 	
				d.addY(-1*d.step);
			}
			if (key == KeyEvent.VK_DOWN) {  
				d.centery-=d.step;
				d.addY(d.step);
			}
			if (key == KeyEvent.VK_LEFT) { 
				d.centerx+=d.step;
				d.addX(-1*d.step);
			}
			if (key == KeyEvent.VK_RIGHT) {
				d.centerx-=d.step;
				d.addX(d.step);
			}
			if (key == KeyEvent.VK_PAGE_DOWN) { 
				if(d.scale-.5>=0.2){
					d.scale-=.2;
					d.scaling();
				}
			}
			if (key == KeyEvent.VK_PAGE_UP) { 
				if(d.scale+.5<=3.0){
					d.scale+=.2;
					d.scaling();
				}
			}
			d.repaint();
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {

	}

	@Override
	public void keyTyped(KeyEvent e) {

	}
}
