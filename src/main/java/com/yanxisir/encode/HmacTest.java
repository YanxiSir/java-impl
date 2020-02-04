package com.yanxisir.encode;

import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/**
 * @author: YanxiSir
 * @Date: 2019/10/15
 * @Sign: 心中田间，木行水上
 */
public class HmacTest {

    /**
     * MAC算法可选以下多种算法
     *
     * <pre>
     * HmacMD5
     * HmacSHA1
     * HmacSHA256
     * HmacSHA384
     * HmacSHA512
     * </pre>
     */
    public static final String KEY_MAC = "HmacMD5";

    /**
     * HMAC加密
     *
     * @param data
     * @param key
     * @return
     * @throws Exception
     */
    public static byte[] encryptHMAC(byte[] data, String key) throws Exception {

        SecretKey secretKey = new SecretKeySpec(key.getBytes(), KEY_MAC);
        Mac mac = Mac.getInstance(secretKey.getAlgorithm());
        mac.init(secretKey);

        return mac.doFinal(data);
    }

    /*byte数组转换为HexString*/
    public static String byteArrayToHexString(byte[] b) {
        StringBuffer sb = new StringBuffer(b.length * 2);
        for (int i = 0; i < b.length; i++) {
            int v = b[i] & 0xff;
            if (v < 16) {
                sb.append('0');
            }
            sb.append(Integer.toHexString(v));
        }
        return sb.toString();
    }

    public static void main(String[] args) throws Exception {
        String inputStr = "appKeyf28fdec5formatJSONmethodcheckInV2servicevipapis.activity.ActivityServicetimestamp1571139055version1.0.0{\"activityId\":\"10252\",\"mobile\":\"18311053687\"}";
        byte[] inputData = inputStr.getBytes();
        String key = "36C5C74E0DD22BF638303C840510E550";
        System.out.println(HmacTest.byteArrayToHexString(HmacTest.encryptHMAC(inputData, key)).toUpperCase());
    }
}
