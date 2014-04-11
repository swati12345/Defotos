package com;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import sun.misc.BASE64Encoder;

public class Encryption
{
	public static void main(String[] args) throws Exception 
	{
		KeyGenerator keygen = KeyGenerator.getInstance("AES");
		keygen.init(128);
		SecretKey secretKey = keygen.generateKey();
		System.out.println(encryption("admin", secretKey));
	}
	
	public static String encryption(String data, SecretKey secretkey) throws Exception 
	{		
		SecretKey secretKey = secretkey;
		Cipher aesCipher = Cipher.getInstance("AES");
		aesCipher.init(Cipher.ENCRYPT_MODE, secretKey);
		
		byte[] byteDataToEncrypt = data.getBytes();
		byte[] byteCipherText = aesCipher.doFinal(byteDataToEncrypt);
		
		data = new BASE64Encoder().encode(byteCipherText);
		return data;
	}
}
