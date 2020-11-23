package com.hchulim.demo.hmac.utils;

import java.util.Date;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class MessageValueUtils {

	public static int getRandomNumber() {
		return ThreadLocalRandom.current().nextInt(100000, 1000000);
	}

	public static long getCurrentTimeMillis(){
		return new Date().getTime();
	}
}
