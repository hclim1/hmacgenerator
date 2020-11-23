package com.hchulim.demo.hmac.message;

public class MessageGenerator implements MessageCreator {

	private MessageCreator messageCreator;

	public MessageGenerator(MessageCreator creator){
		this.messageCreator = creator;
	}

	@Override
	public String getMessage() {
		return messageCreator.getMessage();
	}
}
