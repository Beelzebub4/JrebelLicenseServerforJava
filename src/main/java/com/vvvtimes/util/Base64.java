package com.vvvtimes.util;


class Base64 {

	/**
	 * 解码
	 * 
	 * @param bStr bStr
	 * @return string
	 */
	static byte[] decode(String bStr) {
		return org.apache.commons.codec.binary.Base64.decodeBase64(bStr);
	}

}
