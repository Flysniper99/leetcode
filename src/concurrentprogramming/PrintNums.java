package concurrentprogramming;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PrintNums {
//    private static final Lock lock = new ReentrantLock();
//    private static final Condition condition1 = lock.newCondition();
//    private static final Condition condition2 = lock.newCondition();
//
//    private static int state = 0;
//
    public static void main(String[] args) {
//        Thread thread1 = new Thread(() -> {
//            for (int i = 0; i <= 50; i++) {
//                try {
//                    lock.lock();
//                    while (state % 2 != 0) {
//                        condition1.await();
//                    }
//                    System.out.println(Thread.currentThread().getName() + " -> " + state++);
//                    condition2.signal();
//                } catch (Exception e) {
//                    throw new RuntimeException(e);
//                } finally {
//                    lock.unlock();
//                }
//            }
//        }, "A");
//
//        Thread thread2 = new Thread(() -> {
//            for (int i = 0; i < 50; i++) {
//                try {
//                    lock.lock();
//                    while (state % 2 == 0) {
//                        condition2.await();
//                    }
//                    System.out.println(Thread.currentThread().getName() + " -> " + state++);
//                    condition1.signal();
//                } catch (Exception e) {
//                    throw new RuntimeException(e);
//                } finally {
//                    lock.unlock();
//                }
//            }
//        }, "B");
//
//        thread1.start();
//        thread2.start();
        PrintNum printNum = new PrintNum();
        new Thread(() -> {
            while (true) {
                printNum.printEven();
            }
//            for (int i = 0; i <= 50; i++)  {
//                System.out.println(Thread.currentThread().getName() + " -> ");

//            }
        }, "A").start();

        new Thread(() -> {
            while (true) {
                printNum.printUneven();
            }
//            for (int i = 0; i < 50; i++) {
//                System.out.println(Thread.currentThread().getName() + " -> ");

//            }
        }, "B").start();
    }
}

class PrintNum {
    public static int state = 0;
    public static final Lock lock = new ReentrantLock();
    public static final Condition conditionA = lock.newCondition();
    public static final Condition conditionB = lock.newCondition();

    public void printEven() {
        try {
            lock.lock();
            while (state % 2 != 0) {
                conditionA.await();
            }
            System.out.println(state);
            state++;
            conditionB.signal();
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }
    }

    public void printUneven() {
        try {
            lock.lock();
            while (state % 2 == 0) {
                conditionB.await();
            }
            System.out.println(state);
            state++;
            conditionA.signal();
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            lock.unlock();
        }
    }
}