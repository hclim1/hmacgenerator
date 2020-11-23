package com.hchulim.demo.hmac;

import com.hchulim.demo.hmac.message.DefaultMessageCreator;
import com.hchulim.demo.hmac.utils.MessageValueUtils;
import org.junit.Before;
import org.junit.Test;

import java.util.Random;
import java.util.UUID;

import static org.junit.Assert.*;

public class HMacTest {

	private String secretKey;

	@Before
	public void setSecretKey() {
		this.secretKey = "TEST_SECRET_KEY";
	}


	@Test
	public void create_randomNumber_int() {
		for (int i = 0; i < 1000000; i++) {
			int randomValue = MessageValueUtils.getRandomNumber();
			assertTrue(isValidRandomNumber(randomValue));
		}
	}

	private boolean isValidRandomNumber(int number) {
		return number >= 100000 && number <= 999999;

	}

	@Test
	public void get_hashMessage_string() throws Exception {
		//given
		HMac mac = new HMac();
		int randomInt = MessageValueUtils.getRandomNumber();
		long timestamp = MessageValueUtils.getCurrentTimeMillis();
		DefaultMessageCreator creator = DefaultMessageCreator
				.builder("test")
				.number(randomInt)
				.timestamp(timestamp)
				.build();

		//when
		String hashMessage = mac.encode(creator.getMessage(), "secretKey");

		//then		;
		assertNotNull(hashMessage);
	}

	@Test
	public void compared_hashMessages_notequal() throws Exception {

		//given
		HMac mac = new HMac();
		int randomInt = MessageValueUtils.getRandomNumber();
		long timestamp = MessageValueUtils.getCurrentTimeMillis();
		DefaultMessageCreator creator = DefaultMessageCreator
				.builder("test")
				.number(randomInt)
				.timestamp(timestamp)
				.build();

		int randomInt2 = MessageValueUtils.getRandomNumber();
		long timestamp2 = MessageValueUtils.getCurrentTimeMillis();
		DefaultMessageCreator creator2 = DefaultMessageCreator
				.builder("test")
				.number(randomInt2)
				.timestamp(timestamp2)
				.build();
		//when
		String hashMessage = mac.encode(creator.getMessage(), "secretKey");
		String hashMessage2 = mac.encode(creator2.getMessage(), "secretKey");

		//then
		assertNotNull(hashMessage);
		assertNotEquals(hashMessage, hashMessage2);
	}


	@Test
	public void get_SHA256_hashMessage_string() throws Exception {
		//given
		String message = "test_message1";
		HMac mac = new HMac(HMacsAlgorithm.HmacSHA512);
		int randomInt = MessageValueUtils.getRandomNumber();
		long timestamp = MessageValueUtils.getCurrentTimeMillis();
		DefaultMessageCreator creator = DefaultMessageCreator
				.builder(message)
				.number(randomInt)
				.timestamp(timestamp)
				.build();

		//when
		String hashMessage = mac.encode(creator.getMessage(), "secretKey");

		//then		;
		System.out.println(hashMessage);
		assertNotNull(hashMessage);
	}

}
