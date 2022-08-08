package item04;

import java.lang.reflect.Constructor;

public class ReflectionClient {
    public static void main(String[] args) throws Exception {
        Constructor<?> constructor = UtilSample.class.getDeclaredConstructors()[0];
        constructor.setAccessible(true);

        UtilSample instance = (UtilSample) constructor.newInstance();
        instance.print();
    }
}
