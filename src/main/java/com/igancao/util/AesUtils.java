package com.igancao.util;

import java.io.UnsupportedEncodingException;
import java.security.Key;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import org.apache.tomcat.util.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.ObjectMapper;

public class AesUtils {
	private static final String AESTYPE = "AES/ECB/PKCS5Padding";
	private static final String AES_SECRECT_KEY = "UITN25LMUQGANCAO";

	private static Logger logger = LoggerFactory.getLogger(AesUtils.class);

	/**
	 * aes加密
	 *
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public static <T> String AES_Encrypt(Object obj) {
		ObjectMapper mapper = new ObjectMapper();
		String str;
		try {
			mapper.setSerializationInclusion(Include.NON_DEFAULT);
			mapper.setSerializationInclusion(Include.NON_NULL);
			str = mapper.writeValueAsString(obj);
		} catch (Exception e) {
			logger.error("aes encrypt error", e);
			str = "{\"msg\": \"jsonError\",\"data\": \"\",\"status\": -1}";
		}
		return AES_Encrypt(str);
	}

	/**
	 * aes加密
	 *
	 * @param
	 * @return
	 */
	private static String AES_Encrypt(String str) {
		byte[] encrypt = null;
		try {
			encrypt = str.getBytes("utf-8");
			Key key = generateKey(AES_SECRECT_KEY);
			Cipher cipher = Cipher.getInstance(AESTYPE);
			cipher.init(Cipher.ENCRYPT_MODE, key);
			encrypt = cipher.doFinal(encrypt);
		} catch (Exception e) {
			logger.error("aes encrypt error", e);
		}
		return new String(Base64.encodeBase64(encrypt));
	}

	/**
	 * aes解密
	 *
	 * @param encryptData
	 * @return
	 */
	public static String AES_Decrypt(String encryptData) {
		byte[] decrypt = null;
		try {
			Key key = generateKey(AES_SECRECT_KEY);
			Cipher cipher = Cipher.getInstance(AESTYPE);
			cipher.init(Cipher.DECRYPT_MODE, key);
			decrypt = cipher
					.doFinal(Base64.decodeBase64(encryptData.getBytes()));
		} catch (Exception e) {
			logger.error("aes decrypt error", e);
		}
		return new String(decrypt);
	}

	private static Key generateKey(String key) {
		try {
			SecretKeySpec keySpec = new SecretKeySpec(key.getBytes(), "AES");
			return keySpec;
		} catch (Exception e) {
			logger.error("aes generateKey error", e);
		}
		return null;

	}

}
