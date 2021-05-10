package thread_0509;

/**
 * ClassName:TextDemo3
 * Package:thread_0509
 * Description:
 *
 * @Author:HP
 * @date:2021/5/9 18:12
 */
public class TextDemo3 {
    public static void main(String[] args) throws InterruptedException {
        Object lock = new Object();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("线程1，进入线程");

                synchronized (lock) {
                    try {
                        lock.wait(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                System.out.println("线程1执行完成");
            }
        },"t1");
        t1.start();

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("线程2，进入线程");

                synchronized (lock) {
                    try {
                        lock.wait(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                System.out.println("线程2执行完成");
            }
        },"t2");
        t2.start();

        synchronized (lock) {
            lock.notify();
        }
    }
}
