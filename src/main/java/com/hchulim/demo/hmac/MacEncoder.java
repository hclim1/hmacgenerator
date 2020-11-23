package com.hchulim.demo.hmac;

public interface MacEncoder {

	String encode(String message, String key) throws Exception;

}
