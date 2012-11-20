package com.jpii.KingOil.gui;

import java.util.*;
import javax.swing.*;

import com.jpii.KingOil.game.Game;

public class WindowHandler {
	
	private ArrayList<Window> windows;
	
	public WindowHandler(){
		windows = new ArrayList<Window>();
		initArray();
		windows.get(0).setVisible(true);
	}
	
	private void initArray(){
		windows.add(new Menu());
		windows.add(new Game());
	}
	
	public void setNewWindow(String a){
		for(int index = 0; index<windows.size(); index++){
			JFrame temp = (Window) windows.get(index);
			if(a.toLowerCase().equals( temp.getClass().toString().substring((temp.getClass().toString().lastIndexOf(".")+1)).toLowerCase() )){
				temp.setVisible(true);
			}
			else{
				temp.setVisible(false);
			}
		}
	}
	
	public void add(Window w){
		windows.add(w);
		w.setVisible(true);
	}
}
