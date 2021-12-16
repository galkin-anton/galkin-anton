package net.bytebuddy.animal;

import net.bytebuddy.implementation.bind.annotation.This;

/**
 * galki
 * <p>
 * 15.12.2021
 * <p>
 * galkin-anton
 */
public class LionSmall {
    public static void makeRoar(@This Lion m) {
        System.out.println("this is roar from lionSmall from class " + m.getClass().getName());
    }
}
