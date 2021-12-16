package net.bytebuddy.enums;

/**
 * Project: galkin-anton
 * <p>
 * Author: Galkin A.B.
 * <p>
 * Date: 16.12.2021
 * <p>
 * Time: 01:01
 * <p>
 * Descriptions
 */

public enum EnumSingleton {
    INSTANCE;

    public StringValueBinder getStringValueBinder() {
        return StringValueBinder.INSTANCE;
    }
}
