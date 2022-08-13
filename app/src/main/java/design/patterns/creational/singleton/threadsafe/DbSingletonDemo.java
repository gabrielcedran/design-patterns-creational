package design.patterns.creational.singleton.threadsafe;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class DbSingletonDemo {


    public static void main(String[] args) {

        // singleUsageExample();

        threadSafeIssueReflectionExample();

        // threadSafeIssueMultiThreadExample();

    }

    private static void singleUsageExample() {
        var dbSingleton = DbSingleton.getInstance();
        System.out.println(dbSingleton);
        System.out.println(dbSingleton == DbSingleton.getInstance());
    }

    private static void threadSafeIssueReflectionExample() {
        try {
            DbSingleton.getInstance();

            Constructor<DbSingleton> constructor = DbSingleton.class.getDeclaredConstructor();
            constructor.setAccessible(true);

            DbSingleton instance1 = constructor.newInstance();
            System.out.println(instance1);
            DbSingleton instance2 = constructor.newInstance();
            System.out.println(instance2);
            System.out.println(instance1 == instance2);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static void threadSafeIssueMultiThreadExample() {
        DbSingletonDemo.Semaphore semaphore = new DbSingletonDemo.Semaphore();

        ExecutorService executorService = Executors.newFixedThreadPool(50);

        List<Future<DbSingleton>> tasks = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            tasks.add(executorService.submit(() -> new DbSingletonDemo.CoordinatedGetSingletonInstance(semaphore).getInstance()));
        }

        semaphore.setReady();

        tasks.stream().map(future -> {
            try {
                return future.get().hashCode();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }).distinct().forEach(System.out::println);

        executorService.shutdown();
    }

    private static class CoordinatedGetSingletonInstance {
        private final DbSingletonDemo.Semaphore semaphore;
        public CoordinatedGetSingletonInstance(Semaphore semaphore) {
            this.semaphore = semaphore;
        }
        public DbSingleton getInstance() {

            semaphore.isReady();

            return DbSingleton.getInstance();
        }
    }

    private static class Semaphore {

        private Boolean ready = false;
        public void isReady() {
            try {
                synchronized (this) {
                    if (ready) {
                        return;
                    }
                    this.wait();
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        public void setReady() {
            synchronized (this) {
                ready = true;
                this.notifyAll();
            }
        }
    }
}
