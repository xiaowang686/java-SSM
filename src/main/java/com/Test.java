package com;

public class Test {

    public static void main(String[] args) {
        Resource resource = new Resource();

        Producer producer1 = new Producer(resource);
        producer1.setName("生产者1");
        Producer producer2 = new Producer(resource);
        producer2.setName("生产者2");
        Producer producer3 = new Producer(resource);
        producer3.setName("生产者3");

        Consumer consumer1 = new Consumer(resource);
        consumer1.setName("消费者1");
        Consumer consumer2 = new Consumer(resource);
        consumer2.setName("消费者2");
        Consumer consumer3 = new Consumer(resource);
        consumer3.setName("消费者3");

        producer1.start();
        producer2.start();
        producer3.start();
        consumer1.start();
        consumer2.start();
        consumer3.start();
    }

}

class Resource{

    int sum = 0;
    int size = 10;

    public synchronized void remove(){
        if (sum > 0){
            sum--;
            System.out.println(Thread.currentThread().getName() + "消费了一个信息,队列中还剩" + sum + "信息");
            notifyAll();
        }else {
            try {
                wait();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    public synchronized void add(){
        if (sum < size){
            sum++;
            System.out.println(Thread.currentThread().getName() + "生产了一个信息,队列中有" + sum + "信息");
            notifyAll();
        }else {
            try {
                wait();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

}

class Consumer extends Thread{

    private Resource resource;
    public Consumer(Resource resource){
        this.resource = resource;
    }

    @Override
    public void run() {
        while (true){
            try {
                Thread.sleep(1000);
            }catch (Exception e){
                e.printStackTrace();
            }
            resource.remove();
        }
    }
}

class Producer extends Thread{

    private Resource resource;
    public Producer(Resource resource){
        this.resource = resource;
    }

    @Override
    public void run() {
        while (true){
            try {
                Thread.sleep(1000);
            }catch (Exception e){
                e.printStackTrace();
            }
            resource.add();
        }
    }
}


