package net.bytebuddy;

import net.bytebuddy.animal.Lion;
import net.bytebuddy.dynamic.DynamicType;
import net.bytebuddy.dynamic.loading.ClassLoadingStrategy;

import java.io.IOException;

public class CreateObject {
    public static void main(String[] args) throws ClassNotFoundException, IOException {
        DynamicType.Unloaded<?> dynamicType = new ByteBuddy()
          .subclass(Object.class)
          .make();
        System.out.println(dynamicType);

        DynamicType.Unloaded<?> dynamicAnimal = new ByteBuddy()
          .subclass(Lion.class)
          .name("example.Type")
          .make();

        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        dynamicAnimal.load(contextClassLoader);
        //contextClassLoader.loadClass("net.bytebuddy.animal.example.Type");
        var unloadSubClass = new ByteBuddy().rebase(Lion.class)
                                            .name("LionRedifine")
                                            .make();

        Class<? extends DynamicType.Loaded> aClass =
          unloadSubClass.load(Lion.class.getClass().getClassLoader(),
                          ClassLoadingStrategy.Default.WRAPPER)
                        .getClass();
        
        //unloadSubClass.saveIn(new File("target"));
    }
}
