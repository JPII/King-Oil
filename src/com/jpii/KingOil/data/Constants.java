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

import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class Constants{
	
	/*
	 * General
	 */
	public static final String KING_OIL_VERSION = "0.1a";
	public static final String VERSION_CODE = "1";
	public static final String KING_OIL_CODENAME = "CAP";
	public static final String KING_OIL_VERSION_TITLE = "NavalBattle " + KING_OIL_VERSION + " (" + KING_OIL_CODENAME + ")";
	public static final boolean DEBUG_MODE = true;
	
	public static BufferedImage getIcon()
	{
		BufferedImage GUI_WINDOW_ICON = null;
		try{
			GUI_WINDOW_ICON= ImageIO.read(Constants.class.getResource("/com/jpii/KingOil/res/gui_window_icon.png"));
		}
		catch(Exception e){e.printStackTrace();}
		return GUI_WINDOW_ICON;
	}
}