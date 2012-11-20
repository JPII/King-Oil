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
			if(k.getKeyCode() == KeyEvent.VK_HOME) {
				d.reset();
			}
			if(k.getKeyCode() == KeyEvent.VK_F) {
				d.finishPoints();
			}
		}
	}
	
	@Override
	public void keyReleased(KeyEvent e) {
		
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		
	}
}
