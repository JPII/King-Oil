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

package com.jpii.KingOil;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.UIManager.LookAndFeelInfo;

import com.jpii.KingOil.gui.*;
import com.jpii.KingOil.data.*;

public class KingOil {
	
	private static WindowHandler windowHandler;
	private static DebugWindow debugWindow;
	private static CommandHandler commandHandler;
	private static GameState gameState;

	public static void main(String[] args) {
		setDefaultLookAndFeel();
		debugWindow = new DebugWindow();
		debugWindow.setVisible(true);
		gameState = new GameState();
		commandHandler = new CommandHandler(Commands.COMMANDS);	
		debugWindow.printInfo("King Oil " + Constants.KING_OIL_VERSION + " initialized");
		windowHandler = new WindowHandler();
	}
	
	/**
	 * Returns current instance of GameState.
	 * 
	 * @return gameState
	 */
	public static GameState getGameState() {
		return gameState;
	}
	
	/**
	 * Returns current instance of DebugWindow.
	 * 
	 * @return debugWindow
	 */
	public static DebugWindow getDebugWindow() {
		return debugWindow;
	}
	
	/**
	 * Returns current instance of CommandHandler.
	 * 
	 * @return commandHandler
	 */
	public static CommandHandler getCommandHandler() {
		return commandHandler;
	}
	
	/**
	 * Returns current instance of WindowHandler. Used to switch Windows.
	 * 
	 * @return windowHandler
	 */
	public static WindowHandler getWindowHandler() {
		return windowHandler;
	}
	
	private static void setDefaultLookAndFeel(){
		try {
		    for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
		        if ("Nimbus".equals(info.getName())) {
		            UIManager.setLookAndFeel(info.getClassName());
		            break;
		        }
		    }
		} catch (UnsupportedLookAndFeelException e) {
			getDebugWindow().printError("NimbusLookAndFeel was unable to be loaded, unsuported");	
		} catch (ClassNotFoundException e) {
			getDebugWindow().printError("NimbusLookAndFeel was unable to be loaded, class not found");	
		} catch (InstantiationException e) {
			getDebugWindow().printError("NimbusLookAndFeel was unable to be loaded, instantiation");	
		} catch (IllegalAccessException e) {
			getDebugWindow().printError("NimbusLookAndFeel was unable to be loaded, illegalaccess");	
		}
	}
}