package com.hchulim.demo.hmac.message;

import com.hchulim.demo.hmac.utils.MessageValueUtils;

public class DefaultMessageCreator implements MessageCreator {

	private int randomNumber;
	private long timestamp;
	private String message;

	private DefaultMessageCreator(Builder builder) {
		this.message = builder.message;
		this.randomNumber = builder.randomNumber;
		this.timestamp = builder.timestamp;
	}

	public static Builder builder(String message){
		return new Builder(message);
	}

	public static class Builder {
		private final String message;
		private int randomNumber;
		private long timestamp;


		public Builder(String message) {
			this.message = message;
		}

		public Builder number(int randomNumber) {
			this.randomNumber = randomNumber;
			return this;
		}

		public Builder timestamp(long timestamp) {
			this.timestamp = timestamp;
			return this;
		}

		public DefaultMessageCreator build() {
			return new DefaultMessageCreator(this);

		}
	}

	@Override
	public String getMessage() {
		return String.format("%s%s%s", randomNumber, message, timestamp);
	}
}
