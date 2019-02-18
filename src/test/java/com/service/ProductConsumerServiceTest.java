package com.service;

import org.junit.Test;

public class ProductConsumerServiceTest {

	@Test
	public void test() {
		ProducerConsumerService pc = new ProducerConsumerService();
		pc.main(null);
		//fail("Not yet implemented");
	}
	
/*	@Test
	public void test2() {
        BlockingQueue<Message> queue = new ArrayBlockingQueue<>(10);
		Producer producer = new Producer(queue);
		producer.run();
	}
*/
}
