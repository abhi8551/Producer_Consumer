package com.producer;

import java.util.concurrent.BlockingQueue;

import com.constants.Constants;
import com.model.Message;

import play.libs.Json;

public class Producer implements Runnable {

	//This queue wait for the queue to become non-empty while retrieving and removing, and
	//space to become available in the queue when adding an element.
	private BlockingQueue<Message> queue;

	//Initializing producer queue with shared queue 
	public Producer(BlockingQueue<Message> q) {
		this.queue = q;
	}

	@Override
	public void run() {
		//produce 10 messages for each thread
		for (int i = 0; i < 10; i++) {
			String productProducedMessage = Constants.PRODUCT_CREATED_CONF_KEY + i + Constants.BY_STRING
					+ Thread.currentThread().getName();
			Message jsonDocument = new Message(Json.newObject().put(Constants.MESSAGE_STRING, productProducedMessage));
			try {
				Thread.sleep(i);
				queue.put(jsonDocument);
				System.out.println(Constants.PRODUCED_STRING + jsonDocument.getNode());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		//adding exit message
		//To check thread terminates after check this message
		Message msg = new Message(Constants.EXIT_STRING);
		try {
			queue.put(msg);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}