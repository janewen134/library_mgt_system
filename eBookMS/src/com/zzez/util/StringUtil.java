package com.zzez.util;

/**
 * @string operation
 * @author Jing Wen
 *
 *         2019.6.4.
 */
public class StringUtil {

	public static boolean isEmpty(String str) {

		if (str == null || "".equals(str.trim())) {

			return true;

		} else {

			return false;

		}

	}

	public static boolean isNotEmpty(String str) {

		if (str != null && !"".equals(str.trim())) {
			return true;
		} else {
			return false;
		}

	}

}
