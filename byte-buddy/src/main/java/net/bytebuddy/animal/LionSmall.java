package net.bytebuddy.animal;

/**
 * galki
 * <p>
 * 15.12.2021
 * <p>
 * galkin-anton
 */
public class LionSmall extends Lion {

    @Override
    public void makeRoar() {
        System.out.println("this is roar from lionSmall");
        super.makeRoar();
    }
}
