package com.hchulim.demo.hmac;

import com.hchulim.demo.hmac.message.DefaultMessageCreator;
import com.hchulim.demo.hmac.message.MessageCreator;
import com.hchulim.demo.hmac.message.MessageGenerator;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class HMac implements MacEncoder{

	private HMacsAlgorithm hmacAlgorithm;

	public HMac(HMacsAlgorithm hmacAlgorithm){
		this.hmacAlgorithm = hmacAlgorithm;
	}

	public HMac(){
		setDefaultHMacsAlgorithm();
	}

	private void setDefaultHMacsAlgorithm() {
		this.hmacAlgorithm = HMacsAlgorithm.HmacSHA1;
	}

	@Override
	public String encode(String message, String key) throws Exception{
		Mac mac = Mac.getInstance(hmacAlgorithm.name());
		SecretKeySpec secretKey = new SecretKeySpec(key.getBytes(), hmacAlgorithm.name());
		mac.init(secretKey);
		byte[] hashValue = mac.doFinal(message.getBytes());
		return Base64.getEncoder().encodeToString(hashValue);
	}
}
