package net.bytebuddy.enums;

/**
 * Project: galkin-anton
 * <p>
 * Author: Galkin A.B.
 * <p>
 * Date: 16.12.2021
 * <p>
 * Time: 01:02
 * <p>
 * Descriptions
 */

public enum StringValueBinder {
    INSTANCE;

    public void stringMessage(String s) {
        System.out.println(s);
    }
}
