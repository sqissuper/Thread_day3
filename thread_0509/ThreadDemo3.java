package thread_0509;

import java.util.concurrent.locks.LockSupport;

/**
 * ClassName:ThreadDemo3
 * Package:thread_0509
 * Description:
 *
 * @Author:HP
 * @date:2021/5/9 20:49
 */
public class ThreadDemo3 {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("线程1，进入线程");

                LockSupport.park();

                System.out.println("线程1执行完成");
            }
        },"t1");

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("线程2，进入线程");

                LockSupport.park();

                System.out.println("线程2执行完成");
            }
        },"t2");

        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("线程3，进入线程");

                LockSupport.park();

                System.out.println("线程3执行完成");
            }
        },"t3");
        t1.start();
        t2.start();
        t3.start();
        Thread.sleep(1000);
        LockSupport.unpark(t1);

        Thread.sleep(1000);
        LockSupport.unpark(t2);

        Thread.sleep(1000);
        LockSupport.unpark(t3);
    }
}
