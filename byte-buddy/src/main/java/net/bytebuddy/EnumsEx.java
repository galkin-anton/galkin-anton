package net.bytebuddy;

import net.bytebuddy.enums.EnumSingleton;

/**
 * Project: galkin-anton
 * <p>
 * Author: Galkin A.B.
 * <p>
 * Date: 16.12.2021
 * <p>
 * Time: 01:03
 * <p>
 * Descriptions
 */

public class EnumsEx {
    public static void main(String[] args) {
        EnumSingleton.INSTANCE.getStringValueBinder().stringMessage("message");
    }
}
