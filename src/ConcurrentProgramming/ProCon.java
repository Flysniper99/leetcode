package ConcurrentProgramming;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 1.两个线程，一个线程生产者，一个线程是消费者
 * 2.生产者生产票，超过10张就休息，被消费了就继续生产。
 * 3.消费者消费票，票没了之后就休息，有票了接着消费。
 */
public class ProCon {
    private static final Lock lock = new ReentrantLock();
    private  static final Condition conditionPro = lock.newCondition();
    private  static final Condition conditionCon = lock.newCondition();
    private static int ticketPoll = 0;

    public static void main(String[] args) {
        Thread producer = new Thread(() -> {
            while (true) {
                try {
                    lock.lock();
                    if (ticketPoll >= 10) {
                        conditionPro.await();
                    }
                    if (ticketPoll >= 0 && ticketPoll < 10) {
                        ticketPoll++;
                        System.out.println(Thread.currentThread().getName() + " -> " + "生产票，余票" + ticketPoll );
                    }
                    conditionCon.signal();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                } finally {
                    lock.unlock();
                }

                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }, "producer");

        Thread consumer = new Thread(() -> {
            while (true) {
                try {
                    lock.lock();
                    if (ticketPoll == 0) {
                        conditionCon.await();
                    }
                    if (ticketPoll > 0) {
                        ticketPoll--;
                        System.out.println(Thread.currentThread().getName() + " -> " + "消费票，余票" + ticketPoll);
                    }
                    conditionPro.signal();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                } finally {
                    lock.unlock();
                }

                try {
                    Thread.sleep(1100L);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }, "consumer");

        producer.start();
        consumer.start();
    }
}
