package design.patterns.creational.singleton.basic;

/**
 * This is the most basic singleton. Nobody can instantiate a new object using the new keyword but have to use the
 * static getInstance method.
 *
 * This implementation does not follow two basic concepts:
 * 1. Be lazy-loaded
 * 2. Be thread-safe
 */
public class DbSingleton {

    // It is not lazy-loaded not thread-safe
    private static DbSingleton instance = new DbSingleton();

    private DbSingleton() { }

    public static DbSingleton getInstance() {
        return instance;
    }
}
