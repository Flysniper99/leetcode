package concurrentprogramming;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PrintABC_3 {
    private static final Lock lock = new ReentrantLock();
    private static final Condition condition1 = lock.newCondition();
    private static final Condition condition2 = lock.newCondition();
    private static final Condition condition3 = lock.newCondition();
    private  static  int state = 0;

    public static void main(String[] args) {
        Thread threadA = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    lock.lock();
                    while (state % 3 != 0) {
                        condition1.await();
                    }
                    for (int j = 0; j < 5; j++) {
                        System.out.println(Thread.currentThread().getName() + " -> " + "AA");
                    }
                    state++;
                    condition2.signal();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                } finally {
                    lock.unlock();
                }
            } 
        }, "threadA");

        Thread threadB = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    lock.lock();
                    while (state % 3 != 1) {
                        condition2.await();
                    }
                    for (int j = 0; j < 10; j++) {
                        System.out.println(Thread.currentThread().getName() + " -> " + "BB");
                    }
                    state++;
                    condition3.signal();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                } finally {
                    lock.unlock();
                }
            } 
        },"threadB");

        Thread threadC = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    lock.lock();
                    while (state % 3 != 2) {
                        condition3.await();
                    }
                    for (int j = 0; j < 15; j++) {
                        System.out.println(Thread.currentThread().getName() + " -> " + "CC");
                    }
                    state++;
                    condition1.signal();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                } finally {
                    lock.unlock();
                }
            }
        },"threadC");

        threadA.start();
        threadB.start();
        threadC.start();
    }
}
