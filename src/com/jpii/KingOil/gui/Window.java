package com.jpii.KingOil.gui;

import java.awt.Toolkit;

import javax.swing.*;

import com.jpii.KingOil.*;
import com.jpii.KingOil.data.Constants;

@SuppressWarnings("serial")
public class Window extends JFrame {
	
	/**
	 * Constructor for Window. Superclass for all GUI windows that
	 * handles size, icon, etc. To redefine elements, use custom constructor.
	 * 
	 * Will log opening automatically, but closing (disposing) should be
	 * handled within each subclass.
	 */
	protected int width;
	protected int height;
	protected int xloc;
	protected int yloc;
	
	public Window() {
		width = 492;
		height = 340;
		xloc = 1280/2-width/2;
		yloc = 800/2-height/2;
		setDefaults();
	}
	
	public Window(int x, int y) {
		width = x;
		height = y;
		xloc = Toolkit.getDefaultToolkit().getScreenSize().width /2 - width / 2;
		yloc = Toolkit.getDefaultToolkit().getScreenSize().height /2 -height / 2;		
	}
	
	public Window(int x, int y,int xloc,int yloc) {
		width = x;
		height = y;
		this.xloc = xloc;
		this.yloc = yloc;
	}
	
	private String parseString(){
			return getClass().toString().substring((getClass().toString().lastIndexOf(".")+1));
	}
	
	private void printDebug(String msg){
		if(KingOil.getDebugWindow()!=null){
			KingOil.getDebugWindow().printInfo(msg);
		}
	}
	
	protected void setDefaults(){
		
		this.setIconImage(Constants.getIcon());
		setTitle("King Oil");
		setSize(width, height);
		setLocation(xloc,yloc);
		setResizable(false);
		setFocusable(true);
		addKeyListener(new KeyboardListener(this));
		addWindowListener(new WindowCloser());
		setVisible(false);
	}
	public void setVisible(boolean visible){
		super.setVisible(visible);
		if(isVisible()){
			printDebug("Showing "+parseString());
			setLocation(xloc,yloc);
		}
		if(!isVisible()){
			printDebug("Hiding "+parseString());
		}
	}
	
	public void nextWindow(String next){
		KingOil.getWindowHandler().setNewWindow(next);
	}
	
	public void donewithMe(){
		super.dispose();
	}
	/**
	 * Get method for Window
	 * 
	 * @return Window
	 */
	public JFrame getFrame() {
		return this;
	}
}
