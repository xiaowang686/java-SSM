package com;


import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockTest {

    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        Condition producerCondition = lock.newCondition();
        Condition consumerCondition = lock.newCondition();
        Resouce1 resouce1 = new Resouce1(lock,producerCondition,consumerCondition);

        Producer1 producer1 = new Producer1(resouce1);
        producer1.setName("生产者1");
        Producer1 producer2 = new Producer1(resouce1);
        producer2.setName("生产者2");

        Consumer1 consumer1 = new Consumer1(resouce1);
        consumer1.setName("消费者1");
        Consumer1 consumer2 = new Consumer1(resouce1);
        consumer2.setName("消费者2");

        producer1.start();
        producer2.start();

        consumer1.start();
        consumer2.start();
    }

}

class Producer1 extends Thread{

    private Resouce1 resouce1;

    public Producer1(Resouce1 resouce1) {
        this.resouce1 = resouce1;
    }
    @Override
    public void run() {
        while (true) {
            try {
                resouce1.add();
                Thread.sleep(100);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}


class Consumer1 extends Thread{
    private Resouce1 resouce1;

    public Consumer1(Resouce1 resouce1) {
        this.resouce1 = resouce1;
    }

    @Override
    public void run() {
        while (true) {
            try {
                resouce1.remove();
                Thread.sleep(100);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
class Resouce1{
    int sum = 0;
    int size = 10;
    private Lock lock;
    private Condition producerLock;
    private Condition consumerLock;

    public Resouce1(Lock lock, Condition producerLock, Condition consumerLock) {
        this.lock = lock;
        this.producerLock = producerLock;
        this.consumerLock = consumerLock;
    }

    public void add() {
        lock.lock();
        try {
            if (sum<size) {
                sum++;
                System.out.println(Thread.currentThread().getName() + "生产了1个信息,当前队列有" + sum + "个信息");
                consumerLock.signalAll();
            }else {
                try {
                    producerLock.await();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        } finally {
            lock.unlock();
        }
    }

    public void remove(){
        lock.lock();
        try {
            if (sum>0) {
                sum--;
                System.out.println(Thread.currentThread().getName() + "消费了1个信息,当前队列还有" + sum + "个信息");
                producerLock.signalAll();
            }else {
                try {
                    consumerLock.await();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }finally {
            lock.unlock();
        }
    }
}
