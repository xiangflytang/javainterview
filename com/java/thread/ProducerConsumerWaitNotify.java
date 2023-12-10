package com.java.thread;

import java.util.LinkedList;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;


class Buffer {
    private LinkedList<Integer> buffer;
    private int capacity;

    public Buffer(int capacity) {
        this.buffer = new LinkedList<>();
        this.capacity = capacity;
    }

    public void produce(int item) throws InterruptedException {
        synchronized (this) {
            while (buffer.size() == capacity) {
                System.out.println("Buffer is full. Producer is waiting...");
                wait();  // Wait for the consumer to consume items
            }

            System.out.println("Thread" + Thread.currentThread().getName() + "Producing: " + item);
            buffer.add(item);
            notify();  // Notify the consumer that an item is produced
        }
    }

    public int consume() throws InterruptedException {
        synchronized (this) {
            while (buffer.isEmpty()) {
                System.out.println("Buffer is empty. Consumer is waiting...");
                wait();  // Wait for the producer to produce items
            }

            int item = buffer.remove();
            System.out.println("Threadname " + Thread.currentThread().getName() + "Consuming: " + item);
            notify();  // Notify the producer that an item is consumed
            return item;
        }
    }
}

class Producer implements Runnable {
    private Buffer buffer;

    public Producer(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                buffer.produce(i);
                Thread.sleep(100);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

class ProducerBlockingQueue implements Runnable {
    private BlockingQueue queue;
    public ProducerBlockingQueue(BlockingQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                queue.put(i);
                System.out.print("produce..");
                Thread.sleep(100);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
class Consumer implements Runnable {
    private Buffer buffer;
    public Consumer(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                buffer.consume();
                Thread.sleep(100);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
class ConsumerBlockingQueue implements Runnable {
    private BlockingQueue queue;


    public ConsumerBlockingQueue(BlockingQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                queue.take();
                System.out.print("consume..");
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

public class ProducerConsumerWaitNotify {
    public static void main(String[] args) {
        //test_own_buffer();
        test_blocking_queue();
    }

    static void test_own_buffer() {
        Buffer buffer = new Buffer(10);

        Thread producerThread = new Thread(new Producer(buffer));
        Thread producerThread1 = new Thread(new Producer(buffer));
        Thread consumerThread = new Thread(new Consumer(buffer));
        Thread consumerThread2 = new Thread(new Consumer(buffer));

        producerThread.start();
        producerThread1.start();
        consumerThread.start();
        consumerThread2.start();
    }

    static void test_blocking_queue() {
        BlockingQueue<String> queue = new ArrayBlockingQueue<>(5);
        Thread producerThread= new Thread(new ProducerBlockingQueue(queue));
        Thread producerThread1= new Thread(new ProducerBlockingQueue(queue));
        Thread consumerThread = new Thread(new ConsumerBlockingQueue(queue));
        Thread consumerThread2 = new Thread(new ConsumerBlockingQueue(queue));
        producerThread.start();
        producerThread1.start();
        consumerThread.start();
        consumerThread2.start();

    }
}
