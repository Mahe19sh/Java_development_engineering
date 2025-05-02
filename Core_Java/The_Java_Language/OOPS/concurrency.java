package The_Java_Language.OOPS;

import java.util.concurrent.*;

public class concurrency {
    /*
     * Thread: Smallest unit of a program which can run independently within a program.
        - Every Java program has atleastone thread (Main thread)
        - Threads enable multitasking and can implement the concept of concurrency.
        - Threads are managed by JVM.
     * Concurrency : The ability of a program to do multitasking(running multiple tasks in parallel).
        - Concurrency v/s Parallelism: concurrency ensures multiple tasks are being worked on but not necessarily executed at the same time(using time slicing on CPU).
        - parallelism ensures multiple tasks are executed simultaneously on different CPU's or Cores.
     * ThreadPool: A threadpool is a collection of pre-initialized, reusable threads managed by a framework , reducing overhead of thread creation and destruction.
        - In Java threadpool's managed by Executor framework available in java.util.concurrent package.
     * Lifecycle of Thread: Threads are created during pool initialization -> Tasks are submitted to the pool(eg. via execute() or submit()) -> Idle threads from the pool execute the tasks -> Threads return to the pool after task completion, ready for new tasks -> The pool manages thread termination during shutdown.
     * ExecutorService is a Java concurrency framework that provides higher-level API for managing and controlling threads.
     * You can monitor the thread pool status by using ThreadPoolExecutor by having methods to track Active threads, current queue size, total tasks completed.
     * For advanced monitoring of thread pool use ScheduledExecutorService, used for periodic monitoring.
     * Synchronization: A mechanism in Java which ensures thread safety by allowing only one thread can access a shared resource at a time. prevents data inconsistency and race conditions in a multi threaded environment.
     * Types of synchronization: Synchronized method, Synchronized block, Static synchronization(locks whole class instead a specific object).
     * Drawbacks of Synchronization: Performance overhead, deadlocks, complexity.
     * 
     */

    public void scheduledExecutorExample(){
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(3);
        ScheduledExecutorService monitor = Executors.newSingleThreadScheduledExecutor();

        monitor.scheduleAtFixedRate(() -> {
            System.out.println("Active threads: "+executor.getActiveCount());
            System.out.println("Tasks completed: "+executor.getCompletedTaskCount());
        }, 0, 1, TimeUnit.SECONDS);

        executor.execute(() -> {
            for(int i=1;i<=10;i++){
                try{
                    Thread.sleep(2000);
                }
                catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
        });

        executor.shutdown();
        monitor.shutdown();
    }

    public void threadPoolMonitoringExample(){
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(3);

        for(int i=1;i<=5;i++){
            executor.execute(() -> {
                try{
                    Thread.sleep(1000);
                    System.out.println("Task completed by: "+Thread.currentThread().getName());
                }
                catch(InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }

        System.out.println("Active threads: "+executor.getActiveCount());
        System.out.println("Tasks count: "+executor.getTaskCount());
        System.out.println("Tasks completed: "+executor.getCompletedTaskCount());

        executor.shutdown();
    }

    public void executorservice_example(){
        ExecutorService executor = Executors.newFixedThreadPool(2);

        Runnable task1 = () -> System.out.println("Task1 executed with: "+Thread.currentThread().getName());
        Runnable task2 = () -> System.out.println("Task1 executed with: "+Thread.currentThread().getName());

        executor.execute(task1);
        executor.execute(task2);

        executor.shutdown();
    }
    public static void main(String[] args){
        concurrency c1 = new concurrency();
        //c1.threadPoolMonitoringExample();
        c1.scheduledExecutorExample();

    }
}

