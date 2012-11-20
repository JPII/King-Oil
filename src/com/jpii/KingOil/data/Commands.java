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

package com.jpii.KingOil.data;

import java.util.ArrayList;
import com.jpii.KingOil.*;
import com.jpii.KingOil.game.Game;
import com.jpii.KingOil.gui.*;

public class Commands {
	
	/**
	 * Commands loaded on game start
	 */
	@SuppressWarnings("serial")
	public static final ArrayList<Command> COMMANDS = new ArrayList<Command>() {{
	    add(new Command("help", "", "View all commands", new CommandAction() { 
	    	public void onRun(Command c, String[] args) {
	    		KingOil.getDebugWindow().println("----------------- KingOil Debug Help -----------------");
	    		for(Command cmd : KingOil.getCommandHandler().getCommands()) {
	    			KingOil.getDebugWindow().println(cmd.getCommand() + " " + cmd.getArgs() + " - " + cmd.getDescription());
	    		}
	    	}}
	    ));
	    
	    add(new Command("quit", "", "Quit game", new CommandAction() { 
	    	public void onRun(Command c, String[] args) {
	    		WindowCloser.close();
	    	}}
	    ));
	    
	    add(new Command("version", "", "View version info", new CommandAction() { 
	    	public void onRun(Command c, String[] args) {
	    		KingOil.getDebugWindow().println(Constants.KING_OIL_VERSION_TITLE + " (" + Constants.VERSION_CODE + ")");
	    	}}
	    ));
	    
	    add(new Command("echo", "<message>", "Print specified message", new CommandAction() { 
	    	public void onRun(Command c, String[] args) {
	    		if(args[0] == null) {
	    			KingOil.getDebugWindow().printError("Missing or invalid arg: message");
	    		}
	    		
	    		for(String s : args) {
	    			KingOil.getDebugWindow().print(s + " ");
	    		}
	    		
	    		KingOil.getDebugWindow().println("");
	    	}}
	    ));
	    
	    add(new Command("credits", "", "KingOil credits", new CommandAction() { 
	    	public void onRun(Command c, String[] args) {
	    		KingOil.getDebugWindow().println("----------------- KingOil Credits -----------------");
	    		KingOil.getDebugWindow().println("Anthony \"abauer\" Bauer - game design lead");
	    		KingOil.getDebugWindow().println("Thomas \"TexasGamer\" Gaubert - SCM manager; RoketGamer lead");
	    		KingOil.getDebugWindow().println("Max \"maximusvladimir\" Kirkby - TBD");
	    		KingOil.getDebugWindow().println("JR \"DarkWarHero\" Vetus - TBD");
	    		KingOil.getDebugWindow().println("Matt \"Matthis5point0\" Waller - TBD");
	    		KingOil.getDebugWindow().println("Zach \"smeagle42\" Mathewson - TBD");
	    		KingOil.getDebugWindow().println("");
	    		KingOil.getDebugWindow().println("GitHub - source code hosting");
	    		KingOil.getDebugWindow().println("RoketGamer - online social gaming");
	    	}}
	    ));
	    
	    add(new Command("setscore", "<score>", "Set game score", new CommandAction() { 
	    	public void onRun(Command c, String[] args) {
	    		try {
	    			KingOil.getGameState().setScore(Integer.parseInt(args[0]));
		    		KingOil.getDebugWindow().printInfo("Game score set to " + KingOil.getGameState().getScore());
	    		} catch (Exception ex) {
	    			KingOil.getDebugWindow().printError("Missing or invalid arg: score");
	    		}
	    	}}
	    ));
	    
	    add(new Command("addscore", "<score>", "Add to game score", new CommandAction() { 
	    	public void onRun(Command c, String[] args) {
	    		try {
	    			KingOil.getGameState().addScore(Integer.parseInt(args[0]));
		    		KingOil.getDebugWindow().printInfo("Game score set to " + KingOil.getGameState().getScore());
	    		} catch (Exception ex) {
	    			KingOil.getDebugWindow().printError("Missing or invalid arg: score");
	    		}
	    	}}
	    ));
	    
	    add(new Command("removescore", "<score>", "Subtract from game score", new CommandAction() { 
	    	public void onRun(Command c, String[] args) {
	    		try {
	    			KingOil.getGameState().subtractScore(Integer.parseInt(args[0]));
		    		KingOil.getDebugWindow().printInfo("Game score set to " + KingOil.getGameState().getScore());
	    		} catch (Exception ex) {
	    			KingOil.getDebugWindow().printError("Missing or invalid arg: score");
	    		}
	    	}}
	    ));
	    
	    add(new Command("getscore", "", "Get game score", new CommandAction() { 
	    	public void onRun(Command c, String[] args) {
		    	KingOil.getDebugWindow().printInfo("Game score: " + KingOil.getGameState().getScore());
	    	}}
	    ));
	    
	    add(new Command("resetscore", "", "Set game score to 0", new CommandAction() { 
	    	public void onRun(Command c, String[] args) {
	    		KingOil.getGameState().resetScore();
		    	KingOil.getDebugWindow().printInfo("Game score reset");
	    	}}
	    ));
	    
	    add(new Command("clear", "", "Clear debug window", new CommandAction() { 
	    	public void onRun(Command c, String[] args) {
	    		KingOil.getDebugWindow().printNew("");
	    	}}
	    
	    ));
	    
	    add(new Command("cls", "", "Clear debug window", new CommandAction() { 
	    	public void onRun(Command c, String[] args) {
	    		KingOil.getDebugWindow().printNew("");
	    	}}
	    
	    ));
	    
	    add(new Command("openwindow", "<windowid>", "Force a window to appear", new CommandAction() { 
	    	public void onRun(Command c, String[] args) {
	    		args[0] = args[0].toLowerCase();
	    		if(args[0].equals("main") || args[0].equals("menu") || args[0].equals("0") || args[0].equals("mainmenu") || args[0].equals("mainmenuwindow")) {
	    			KingOil.getWindowHandler().add(new Menu());
	    		}
	    		if(args[0].equals("game") || args[0].equals("1") || args[0].equals("gamewindow")) {
	    			KingOil.getWindowHandler().add(new Game());
	    		}
	    	}}
	    ));
	    
	    add(new Command("sysinfo", "", "Get system info", new CommandAction() { 
	    	public void onRun(Command c, String[] args) {
	    		KingOil.getDebugWindow().println("OS: " + System.getProperty("os.name") + " (" + System.getProperty("os.version") + ")");
	    		KingOil.getDebugWindow().println("Java Home: " + System.getProperty("java.home"));
	    		KingOil.getDebugWindow().println("Java Version: " + System.getProperty("java.version"));
	    	}}
	    ));
	}};
}