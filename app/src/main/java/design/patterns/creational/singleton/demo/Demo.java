package design.patterns.creational.singleton.demo;

public class Demo {

    public static void main(String[] args) {
        Runtime singletonRuntime = Runtime.getRuntime();

        singletonRuntime.gc();

        System.out.println(singletonRuntime); // memory address

        Runtime anotherSingletonRuntime = Runtime.getRuntime();

        System.out.println(anotherSingletonRuntime); // memory address

        if (singletonRuntime == anotherSingletonRuntime) {
            System.out.println("They are the same instance!!");
        }
    }
}
