package design.patterns.creational.singleton.threadsafe;

/**
 * This example converts the basic example to be lazily loaded to avoid it being loaded
 * regardless of being used or not. But it is still not thread-safe.
 */
public class DbSingleton {

    // this ensures that the instance will remain a singles through any of the changes inside the JVM (including cache stuff)
    private static volatile DbSingleton instance = null;

    private DbSingleton() {
        // this prevents reflection usage, that is a way of getting around the singleton pattern.
        if (instance != null) {
            throw new RuntimeException("Use getInstance() method");
        }
    }

    public static DbSingleton getInstance() {
        if (instance == null) {
            synchronized (DbSingleton.class) { // synchronizing on class level can be detrimental to performance
                if (instance == null) {
                    instance = new DbSingleton();
                }
            }

        }
        return instance;
    }
}
