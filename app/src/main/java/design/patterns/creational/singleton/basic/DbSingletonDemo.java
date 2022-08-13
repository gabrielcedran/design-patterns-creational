package design.patterns.creational.singleton.basic;

public class DbSingletonDemo {

    public static void main(String[] args) {
        var dbSingleton = DbSingleton.getInstance();
        System.out.println(dbSingleton);

        // not allowed:
        // new DbSingleton();

        System.out.println(dbSingleton == DbSingleton.getInstance());
    }
}
