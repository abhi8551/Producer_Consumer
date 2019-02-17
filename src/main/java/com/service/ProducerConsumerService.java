package com.service;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import com.consumer.Consumer;
import com.model.Message;
import com.producer.Producer;

public class ProducerConsumerService {
	
	public ProducerConsumerService() {
		main(null);
	}

    public static void main(String[] args) {
        //Creating BlockingQueue of size 10
        BlockingQueue<Message> queue = new ArrayBlockingQueue<>(10);
        Producer producer = new Producer(queue);
        Consumer consumer = new Consumer(queue);
        //starting producer to produce messages in queue
        Thread t1 = new Thread(producer);
        Thread t2 = new Thread(producer);
        Thread t3 = new Thread(consumer);
        Thread t4 = new Thread(consumer);
        
        t1.start();
        t2.start(); 
        t3.start(); 
        t4.start(); 
        System.out.println("Producer and Consumer has been started");
    }

}