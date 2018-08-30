package com.vvvtimes.util;

import org.bouncycastle.asn1.ASN1InputStream;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.pkcs.RSAPrivateKeyStructure;

import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.RSAPrivateKeySpec;


public class RsaSign {

	public static String Sign(String content){
		String key22 = "MIIBOgIBAAJBALecq3BwAI4YJZwhJ+snnDFj3lF3DMqNPorV6y5ZKXCiCMqj8OeOmxk4YZW9aaV9"
				+ "ckl/zlAOI0mpB3pDT+Xlj2sCAwEAAQJAW6/aVD05qbsZHMvZuS2Aa5FpNNj0BDlf38hOtkhDzz/h"
				+ "kYb+EBYLLvldhgsD0OvRNy8yhz7EjaUqLCB0juIN4QIhAOeCQp+NXxfBmfdG/S+XbRUAdv8iHBl+"
				+ "F6O2wr5fA2jzAiEAywlDfGIl6acnakPrmJE0IL8qvuO3FtsHBrpkUuOnXakCIQCqdr+XvADI/UTh"
				+ "TuQepuErFayJMBSAsNe3NFsw0cUxAQIgGA5n7ZPfdBi3BdM4VeJWb87WrLlkVxPqeDSbcGrCyMkC"
				+ "IFSs5JyXvFTreWt7IQjDssrKDRIPmALdNjvfETwlNJyY";
		return RsaSign.Sign(content.getBytes(), key22);
	}

	
	//传入秘钥为ASN格式
    //私钥签名程序，privateKey是私钥base64编码字符串，即私钥文件数据中，中间的主体部分
    private static String Sign(byte[] content, String privateKey) {
	try {
		byte[] keyByte = Base64.decode(privateKey);
		ASN1InputStream in = new ASN1InputStream(keyByte);
		ASN1Primitive obj = in.readObject();
		RSAPrivateKeyStructure pStruct = RSAPrivateKeyStructure.getInstance(obj);
		RSAPrivateKeySpec spec = new RSAPrivateKeySpec(pStruct.getModulus(), pStruct.getPrivateExponent());
		KeyFactory keyFactory = KeyFactory.getInstance("RSA");
		PrivateKey priKey = keyFactory.generatePrivate(spec);
		java.security.Signature signature = java.security.Signature.getInstance("MD5WithRSA");
		signature.initSign(priKey);
		signature.update(content);
		byte[] signed = signature.sign();
		return Hex.bytesToHexString(signed);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
