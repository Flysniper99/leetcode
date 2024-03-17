package concurrentprogramming;

import java.util.concurrent.*;

public class ThreadPool {
    public static void main(String[] args) {
        //三种方法
//        ExecutorService threadPool = Executors.newCachedThreadPool();
//        ExecutorService threadPool = Executors.newFixedThreadPool(10);
//        ExecutorService threadPool = Executors.newSingleThreadExecutor();
        //七个参数
        //最大线程数如何定义
        //1、CPU密集型
        //2、IO密集型 > 程序中非常耗IO资源的线程数
//        System.out.println(Runtime.getRuntime().availableProcessors());
        ExecutorService threadPool = new ThreadPoolExecutor(
                2,
                Runtime.getRuntime().availableProcessors(),
                3,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(3),
                Executors.defaultThreadFactory(),
                //四种拒绝策略
//                new ThreadPoolExecutor.AbortPolicy()
//                new ThreadPoolExecutor.CallerRunsPolicy()
//                new ThreadPoolExecutor.DiscardPolicy()
                new ThreadPoolExecutor.DiscardOldestPolicy()
        );
        try {
            for (int i = 1; i <= 9; i++) {
                threadPool.execute(() -> {
                    System.out.println(Thread.currentThread().getName() + " ok");
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            threadPool.shutdown();
        }
    }
}
