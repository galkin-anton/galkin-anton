package net.bytebuddy;

import net.bytebuddy.agent.ByteBuddyAgent;
import net.bytebuddy.animal.Lion;
import net.bytebuddy.animal.LionSmall;
import net.bytebuddy.dynamic.loading.ClassReloadingStrategy;
import net.bytebuddy.foo.Foo;
import net.bytebuddy.implementation.FixedValue;
import net.bytebuddy.implementation.MethodDelegation;

import java.io.File;
import java.io.IOException;

import static net.bytebuddy.matcher.ElementMatchers.*;

/**
 * Project: galkin-anton
 * <p>
 * Author: Galkin A.B.
 * <p>
 * Date: 16.12.2021
 * <p>
 * Time: 01:09
 * <p>
 * Descriptions
 */

public class Methods {
    public static void main(String[] args)
      throws InstantiationException, IllegalAccessException, IOException, NoSuchMethodException {
        var methods = new Methods();
        methods.toStringMethod();
        methods.changeThreeMethods();
        methods.delegateMethod();
    }

    public void toStringMethod() throws InstantiationException, IllegalAccessException {
        String toString = new ByteBuddy()
          .subclass(Object.class)
          .name("example.Type")
          .method(named("toString"))
          .intercept(FixedValue.value("Hello World!"))
          .make()
          .load(getClass().getClassLoader())
          .getLoaded()
          .newInstance()
          .toString();
        System.out.println(toString);
    }

    public void changeThreeMethods() throws InstantiationException, IllegalAccessException {
        Foo dynamicFoo = new ByteBuddy()
          .subclass(Foo.class)
          .method(isDeclaredBy(Foo.class)).intercept(FixedValue.value("One!"))
          .method(named("foo")).intercept(FixedValue.value("Two!"))
          .method(named("foo").and(takesArguments(1))).intercept(FixedValue.value("Three!"))
          .make()
          .load(getClass().getClassLoader())
          .getLoaded()
          .newInstance();
        dynamicFoo.bar();
        System.out.println(dynamicFoo.foo());
    }

    public void delegateMethod() throws IOException, NoSuchMethodException {
        ByteBuddyAgent.install();
        var lion = new Lion();
        lion.makeRoar();
        
        var makeRoar = new ByteBuddy()
          .redefine(Lion.class)
          .method(named("makeRoar"))
          //intercept(MethodCall.invoke(LionSmall.class.getMethod("makeRoar", Lion.class)).with(lion))
          .intercept(MethodDelegation.to(LionSmall.class))
          .make();

        makeRoar.saveIn(new File("./target"));
        makeRoar.load(getClass().getClassLoader(), ClassReloadingStrategy.fromInstalledAgent());


        lion.makeRoar();
    }
}
