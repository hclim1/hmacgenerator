package com.hchulim.demo;

import com.hchulim.demo.hmac.HMac;
import com.hchulim.demo.hmac.message.DefaultMessageCreator;
import com.hchulim.demo.hmac.utils.MessageValueUtils;
import jdk.nashorn.internal.objects.annotations.Getter;

import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;
import java.util.Date;

public class HMacClient {

	private static String secretKey = "test_secretKey";

	public static void main(String[] args) throws Exception{

		String message = "test message";

		int randomInt = MessageValueUtils.getRandomNumber();
		long timestamp = MessageValueUtils.getCurrentTimeMillis();
		DefaultMessageCreator messageCreator = DefaultMessageCreator
				.builder(message)
				.number(randomInt)
				.timestamp(timestamp)
				.build();

		HMac hMac = new HMac();
		String hashValue = hMac.encode(messageCreator.getMessage(), secretKey);
		System.out.println(hashValue);
		System.out.println(messageCreator.getMessage());



	}
}
