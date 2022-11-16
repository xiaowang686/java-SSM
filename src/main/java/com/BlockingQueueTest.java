package com;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class BlockingQueueTest {
    /***
     * 使用阻塞队列BlockingQueue阻塞队列解决生产者消费者
     * @param args
     */
    public static void main(String[] args) {
        Resource2 resource2 = new Resource2();

        Producer2 producer1 = new Producer2(resource2);
        producer1.setName("生产者1");
        Producer2 producer2 = new Producer2(resource2);
        producer2.setName("生产者2");
        Producer2 producer3 = new Producer2(resource2);
        producer3.setName("生产者3");

        Consumer2 consumer1 = new Consumer2(resource2);
        consumer1.setName("消费者1");
        Consumer2 consumer2 = new Consumer2(resource2);
        consumer2.setName("消费者2");
        Consumer2 consumer3 = new Consumer2(resource2);
        consumer3.setName("消费者3");

        producer1.start();
        producer2.start();
        producer3.start();
        consumer1.start();
        consumer2.start();
        consumer3.start();
    }

}

class Producer2 extends Thread{

    private Resource2 resource2;

    public Producer2(Resource2 resource2) {
        this.resource2 = resource2;
    }

    @Override
    public void run() {
        while (true) {
            try {
                resource2.add();
                Thread.sleep(100);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}

class Consumer2 extends Thread{

    private Resource2 resource2;

    public Consumer2(Resource2 resource2) {
        this.resource2 = resource2;
    }

    @Override
    public void run() {
        while (true){
            try {
                resource2.remove();
                Thread.sleep(100);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}

class Resource2{

    private BlockingQueue blockingQueue = new LinkedBlockingQueue(10);

    public void add(){
        try {
            blockingQueue.put(2);
            System.out.println(Thread.currentThread().getName()+ "生产了1个消息，当前队列中有：" + blockingQueue.size() + "个消息");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void remove(){
        try {

            blockingQueue.take();
            System.out.println(Thread.currentThread().getName()+ "消费了1个消息，当前队列中有：" + blockingQueue.size() + "个消息");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
