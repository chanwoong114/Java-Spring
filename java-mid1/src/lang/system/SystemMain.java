package lang.system;

import java.util.Arrays;

public class SystemMain {
    public static void main(String[] args) {
        long currentTime = System.currentTimeMillis();
        System.out.println("currentTime = " + currentTime);

        long currentTimeNano = System.nanoTime();
        System.out.println("currentTimeNano = " + currentTimeNano);

        System.out.println("System.getenv() = " + System.getenv());

        System.out.println("System.getProperties() = " + System.getProperties());
        System.out.println("System.getProperty(\"java.version\") = " + System.getProperty("java.version"));

        char[] originalArray = {'h', 'e', 'l', 'l', 'o'};
        char[] copyArray = new char[originalArray.length];
        System.arraycopy(originalArray, 0, copyArray, 0, originalArray.length);

        System.out.println("originalArray = " + originalArray);
        System.out.println("copyArray = " + copyArray);
        System.out.println("Arrays.toString(copyArray) = " + Arrays.toString(copyArray));

        System.exit(0);
    }
}
