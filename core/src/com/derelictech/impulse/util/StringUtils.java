package com.derelictech.impulse.util;

/**
 * Project: impulse
 * Package: com.derelictech.impulse.util
 * File:    StringUtils.java
 * Author:  voxelv
 * Creation Date: 2017-03-05
 * Description: String Utilities
 */
public class StringUtils {

    public static boolean isValidInteger(String text) {
        /* By NotSideEffect */
        for (int i = 0; i < text.length(); i++) {
            if (!Character.isDigit(text.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}
