package com.vvvtimes.JrebelUtil;
import org.apache.commons.codec.binary.Base64;

import java.nio.charset.Charset;

class ByteUtil {

    static String a(final byte[] binaryData) {
        if (binaryData == null) {
            return null;
        }
        return new String(Base64.encodeBase64(binaryData), Charset.forName("UTF-8"));
    }

}
