package design.patterns.creational.singleton.lazyloaded;

/**
 * This example converts the basic example to be lazily loaded to avoid it being loaded
 * regardless of being used or not. But it is still not thread-safe.
 */
public class DbSingleton {

    private static DbSingleton instance = null;

    private DbSingleton() { }

    /* concurrent threads calling this method at the same time when there is no instance created yet could
     * cause to instances to be created
     */
    public static DbSingleton getInstance() {
        if (instance == null) {
            instance = new DbSingleton();
        }
        return instance;
    }
}
