package com;

import com.mysql.jdbc.TimeUtil;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class BlockingQueueAutoTest {
    public static void main(String[] args) throws InterruptedException {
        SourceQueue sourceQueue = new SourceQueue(new ArrayBlockingQueue<>(10));
        new Thread(()->{
            System.out.println(Thread.currentThread().getName()+"生产者启动");
            try {
                sourceQueue.producer();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"生产者").start();

        new Thread(()->{
            System.out.println(Thread.currentThread().getName() + "消费者启动");
            try {
                sourceQueue.consumer();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"消费者").start();

        TimeUnit.SECONDS.sleep(5);

        System.out.println(Thread.currentThread().getName() + "BOSS停止");

        sourceQueue.stop();

    }
}

class SourceQueue{

    private volatile boolean flag = true;
    private volatile AtomicInteger atomicInteger = new AtomicInteger();

    BlockingQueue<String> blockingQueue;

    public SourceQueue(BlockingQueue<String> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    public void producer() throws InterruptedException {
        String data;
        boolean offer;
        while (flag){
            data = atomicInteger.incrementAndGet()+"";
            offer = blockingQueue.offer(data,2L, TimeUnit.SECONDS);
            if (offer){
                System.out.println(Thread.currentThread().getName() + "插入队列成功，data:" + data + "成功");
            }else {
                System.out.println(Thread.currentThread().getName() + "插入队列失败，data:" + data + "失败");
            }
        }
        System.out.println(Thread.currentThread().getName() + "停止生产活动" + "flag=" + flag + "停止活动");
    }

    public void consumer() throws InterruptedException {
        String result;
        while (flag){
            result = blockingQueue.poll(2L, TimeUnit.SECONDS);
            if (result == null || result.equalsIgnoreCase("")){
                flag = false;
                System.out.println(Thread.currentThread().getName() + "超过2s没有收到，消费退出");
                return;
            }
            System.out.println(Thread.currentThread().getName() + "消费队列，result=" + result);
        }
    }

    public void stop(){
        this.flag = false;
    }
}