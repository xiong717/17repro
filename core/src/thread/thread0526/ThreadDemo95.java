package thread.thread0526;

import java.io.WriteAbortedException;
import java.util.Date;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ThreadDemo95 {
    public static void main(String[] args) {

        //创建一个读写锁
        ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
        //得到 读锁
        ReentrantReadWriteLock.ReadLock readLock =  readWriteLock.readLock();
        //得到 写锁
        ReentrantReadWriteLock.WriteLock writeLock = readWriteLock.writeLock();
        //创建线程池
        ThreadPoolExecutor executor = new ThreadPoolExecutor(10,10,0, TimeUnit.SECONDS,
                new LinkedBlockingDeque<>(1000));

        //任务一 读锁
        executor.execute(new Runnable() {
            @Override
            public void run() {
                //加锁
                readLock.lock();
                try {
                    System.out.println(Thread.currentThread().getName()+"进入了读锁"+new Date());
                    Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }finally {
                    readLock.unlock();
                }
            }
        });

        executor.execute(new Runnable() {
            @Override
            public void run() {
                //加锁
                readLock.lock();
                try {
                    System.out.println(Thread.currentThread().getName()+"进入了读锁"+new Date());
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    readLock.unlock();
                }
            }
        });

        //任务  写锁
        executor.execute(new Runnable() {
            @Override
            public void run() {
                writeLock.lock();

                System.out.println(Thread.currentThread().getName()+"执行了写锁"+new Date());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    writeLock.unlock();
                }
            }
        });


    }
}
