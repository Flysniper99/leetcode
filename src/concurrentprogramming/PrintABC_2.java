package concurrentprogramming;

public class PrintABC_2 {

    public static void main(String[] args) {
        Print print = new Print();
        new Thread(() -> {
            for (int i = 0; i < 100; i++) {
//                System.out.print(Thread.currentThread().getName() + "->");
                print.printA();
            }
        }, "A").start();
        
        new Thread(() -> {
            for (int i = 0; i < 100; i++) {
//                System.out.print(Thread.currentThread().getName() + "->");
                print.printB();
            }
        }, "B").start();

        new Thread(() -> {
            for (int i = 0; i < 100; i++) {
//                System.out.print(Thread.currentThread().getName() + "->");
                print.printC();
            }
        }, "C").start();
    }
}

class Print {
    public static int state = 0;
    synchronized void printA() {
        try {
            while (state % 3 != 0) {
                this.wait();
            }
            state++;
            System.out.println("AAA");
            this.notifyAll();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    synchronized void printB() {
        try {
            while (state % 3 != 1) {
                this.wait();
            }
            state++;
            System.out.println("BBB");
            this.notifyAll();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    synchronized void printC() {
        try {
            while (state % 3 != 2) {
                this.wait();
            }
            state++;
            System.out.println("CCC");
            this.notifyAll();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
