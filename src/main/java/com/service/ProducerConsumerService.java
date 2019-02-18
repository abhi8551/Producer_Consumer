package com.service;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import com.consumer.Consumer;
import com.model.Message;
import com.producer.Producer;

public class ProducerConsumerService {
	
    public static void main(String[] args) {
        execute();
    }

	public static void execute() {
		//Creating BlockingQueue of size 10
        BlockingQueue<Message> queue = new ArrayBlockingQueue<>(10);
        Producer producer = new Producer(queue);
        Consumer consumer = new Consumer(queue);
        //starting producer to produce messages in queue
        Thread t1 = new Thread(producer);
        Thread t2 = new Thread(producer);
        Thread t3 = new Thread(consumer);
        Thread t4 = new Thread(consumer);
        
        t1.start(); //Producer Thread-0
        t2.start(); //Producer Thread-1
        t3.start(); //Consumer Thread-2
        t4.start(); //Consumer Thread-3
        System.out.println("Producer and Consumer has been started");
	}

}