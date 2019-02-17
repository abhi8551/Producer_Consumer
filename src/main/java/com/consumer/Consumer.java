package com.consumer;

import java.util.concurrent.BlockingQueue;

import com.constants.Constants;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.model.Message;

public class Consumer implements Runnable {

	private BlockingQueue<Message> queue;

	//Initializing consumer queue with shared queue 
	public Consumer(BlockingQueue<Message> q) {
		this.queue = q;
	}

	@Override
	public void run() {
		try {
			Message msg;
			// consuming messages until exit message is received
			while ((msg = queue.take()).getMsg() != Constants.EXIT_STRING) {
				Thread.sleep(10);
				JsonNode node = msg.getNode();
				String msgarr = node.get(Constants.MESSAGE_STRING).asText()
						.split(Constants.SPACE_STRING)[Constants.TWO_AS_INT];///
				String sourceThread = node.get(Constants.MESSAGE_STRING).asText()
						.split(Constants.SPACE_STRING)[Constants.FOUR_AS_INT];
				System.out.println(Constants.CONSUMED_STRING + ((ObjectNode) node).put(Constants.MESSAGE_STRING,
						Constants.PRODUCT_CONSUMED_STRING + msgarr + Constants.FROM_STRING + sourceThread
								+ Constants.BY_STRING + Thread.currentThread().getName()));
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}