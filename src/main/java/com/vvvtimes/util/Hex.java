package com.vvvtimes.util;

class Hex {
	static String bytesToHexString(byte[] src){
	    StringBuilder stringBuilder = new StringBuilder();
	    if (src == null || src.length <= 0) {   
	        return null;   
	    }
		for (byte aSrc : src) {
			int v = aSrc & 0xFF;
			String hv = Integer.toHexString(v);
			if (hv.length() < 2) {
				stringBuilder.append(0);
			}
			stringBuilder.append(hv);
		}
	    return stringBuilder.toString();   
	}   

}
