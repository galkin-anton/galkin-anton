package net.bytebuddy;

/**
 * galki
 * <p>
 * 15.12.2021
 * <p>
 * galkin-anton
 */
interface Interceptor {
    String doSomethingElse();
}

interface InterceptionAccessor {
    Interceptor getInterceptor();

    void setInterceptor(Interceptor interceptor);
}

interface InstanceCreator {
    Object makeInstance();
}

class UserType {
    public String doSomething() {return null;}
}

public class InterceptEx {
    public static void main(String[] args) {

    }

    class HelloWorldInterceptor implements Interceptor {

        @Override
        public String doSomethingElse() {
            return "Hello World!";
        }
    }
}
