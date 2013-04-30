package com.jpii.KingOil.gui;
import javax.swing.*;
import com.jpii.KingOil.data.Constants;
import com.jpii.gamekit.gui.BaseWindow;

import java.awt.*;
import java.awt.event.*;

@SuppressWarnings("serial")
public class Menu extends BaseWindow {
	public Menu() {
		super();
		
		getContentPane().setLayout(null);
		
		JLabel lblVersion = new JLabel(Constants.KING_OIL_VERSION_TITLE);
		JLabel lblNavalBattle = new JLabel("NavalBattle");
		JButton btnSingleplayer = new JButton("Singleplayer");
		JButton btnHelp = new JButton("Help");
		JButton btnQuit = new JButton("Quit");
		JButton btnCredits = new JButton("Credits");
		
		lblNavalBattle.setBounds(10, 13, 466, 51);
		lblVersion.setBounds(10, 276, 238, 14);
		btnSingleplayer.setBounds(194, 74, 100, 30);
		btnHelp.setBounds(194, 141, 100, 30);
		btnQuit.setBounds(194, 209, 100, 30);
		btnCredits.setBounds(375, 267, 100, 30);
		
		lblNavalBattle.setForeground(Color.blue);
		//lblNavalBattle.setFont(Helper.GUI_MENU_TITLE_FONT);
		setFont(new Font("RingBearer", Font.BOLD, 35));
		lblNavalBattle.setHorizontalAlignment(SwingConstants.CENTER);
		
		getContentPane().add(lblVersion);
		getContentPane().add(lblNavalBattle);
		getContentPane().add(btnSingleplayer);
		getContentPane().add(btnHelp);
		getContentPane().add(btnQuit);
		getContentPane().add(btnCredits);
		
		btnSingleplayer.setFocusable(false);
		btnHelp.setFocusable(false);
		btnQuit.setFocusable(false);
		btnCredits.setFocusable(false);
		
		btnSingleplayer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				nextWindow("Game");
			}
		});		
		btnHelp.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				nextWindow("HelpWindow");
			}
		});
		btnQuit.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				WindowCloser.close();
			}
		});
		btnCredits.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				nextWindow("CreditsWindow");
			}
		});
	}
}
