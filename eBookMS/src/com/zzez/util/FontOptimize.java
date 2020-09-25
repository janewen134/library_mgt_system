package com.zzez.util;

import java.awt.Font;

import javax.swing.UIManager;

/**
 * @optimize font
 * @author Jing Wen
 *
 *         2019.6.5.
 */
public class FontOptimize {

	public static void font() {
		Font font = new Font("Dialog", Font.PLAIN, 12);
		java.util.Enumeration keys = UIManager.getDefaults().keys();
		while (keys.hasMoreElements()) {
			Object key = keys.nextElement();
			Object value = UIManager.get(key);
			if (value instanceof javax.swing.plaf.FontUIResource) {
				UIManager.put(key, font);
			}
		}
	}

}
