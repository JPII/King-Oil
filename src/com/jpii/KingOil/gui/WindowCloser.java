package com.jpii.KingOil.gui;

import java.awt.event.*;

import com.jpii.KingOil.*;

public class WindowCloser extends WindowAdapter {
	@Override
	public void windowClosing(WindowEvent we) {
		close();
	}
	
	public static void close(){
		KingOil.getDebugWindow().printInfo("Someone is closing me!");
		System.exit(0);
	}
}
