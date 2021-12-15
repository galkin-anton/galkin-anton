package net.bytebuddy;

import net.bytebuddy.agent.ByteBuddyAgent;
import net.bytebuddy.animal.Lion;
import net.bytebuddy.animal.Tiger;
import net.bytebuddy.dynamic.loading.ClassReloadingStrategy;

/**
 * galki
 * <p>
 * 15.12.2021
 * <p>
 * galkin-anton
 * <p style="margin-left: 10pt;">
 *  Переопределяем класс Lion классом Tiger
 * </p>
 */
public class RedefineClass {
    public static void main(String[] args) {
        ByteBuddyAgent.install();

        Lion lion = new Lion();
        lion.makeRoar();

        new ByteBuddy()
          .redefine(Tiger.class)
          .name(Lion.class.getName())
          .make()
          .load(Lion.class.getClassLoader(), ClassReloadingStrategy.fromInstalledAgent());
        
        lion.makeRoar();
    }
}
