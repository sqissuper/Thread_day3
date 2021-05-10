package thread_0509;

/**
 * ClassName:ThreadDemo1
 * Package:thread_0509
 * Description:
 *
 * @Author:HP
 * @date:2021/5/9 10:00
 */
public class ThreadDemo2 {
    public static void main(String[] args) {
        Object lockA = new Object();
        Object lockB = new Object();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lockA) {
                    System.out.println("线程t1A");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("等待B");

                    synchronized (lockB) {
                        System.out.println("线程1得到了锁B");
                    }
                }
            }
        },"t1");

        t1.start();

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lockA) {
                    System.out.println("线程t2A");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("等待B");

                    synchronized (lockA) {
                        System.out.println("线程2得到了锁B");
                    }
                }
            }
        },"t2");

        t2.start();
    }
}
