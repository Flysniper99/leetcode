package ConcurrentProgramming;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PrintABC {
    private static final Lock lock = new ReentrantLock();
    private static final Condition conditionA = lock.newCondition();
    private static final Condition conditionB = lock.newCondition();
    private static final Condition conditionC = lock.newCondition();
    private static int state = 0;

    public static void main(String[] args) {
       Thread threadA = new Thread(() -> {
           for (int i = 0; i < 100; i++) {
               try {
                   lock.lock();
                   while (state % 3 != 0) {
                       conditionA.await();
                   }
                   state++;
                   System.out.println(Thread.currentThread().getName() + "-> AAA");
//                   System.out.println("AAA");
                   conditionB.signal();
               } catch (Exception e) {
                   throw new RuntimeException(e);
               } finally {
                   lock.unlock();
               }
           }
       });

       Thread threadB = new Thread(() -> {
           for (int i = 0; i < 100; i++) {
               try {
                   lock.lock();
                   while (state % 3 != 1) {
                       conditionB.await();
                   }
                   state++;
                   System.out.println(Thread.currentThread().getName() + "-> BBB");
//                   System.out.println("BBB");
                   conditionC.signal();
               } catch (Exception e) {
                   throw new RuntimeException(e);
               } finally {
                   lock.unlock();
               }
           }
       });

       Thread threadC = new Thread(() -> {
           for (int i = 0; i < 100; i++) {
               lock.lock();
               try {
                   lock.lock();
                   while (state % 3 != 2) {
                       conditionC.await();
                   }
                   state++;
                   System.out.println(Thread.currentThread().getName() + "-> CCC");
//                   System.out.println("CCC");
                   conditionA.signal();
               } catch (Exception e) {
                   throw new RuntimeException(e);
               } finally {
                   lock.unlock();
               }
           }
       });

       threadA.start();
       threadB.start();
       threadC.start();
    }
}
