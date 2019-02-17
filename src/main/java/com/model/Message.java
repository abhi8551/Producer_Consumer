package com.model;

import com.fasterxml.jackson.databind.JsonNode;

import play.libs.Json;

public class Message {
	
	private JsonNode node = Json.newObject();
	
	public Message(JsonNode node) {
		this.setNode(node);
	}
	
    private String msg;
    
    public Message(String str){
        this.msg=str;
    }

    public String getMsg() {
        return msg;
    }

	public JsonNode getNode() {
		return node;
	}

	public void setNode(JsonNode node) {
		this.node = node;
	}
}