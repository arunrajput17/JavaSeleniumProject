package S48n49_EncodingDecoding;

import org.apache.commons.codec.binary.Base64;

public class S48_EncodingAndDecodingStrings {

	public static void main(String[] args) {
		
		String str = "admin";
		System.out.println("Actual String : "+str);
		
		//-------------encrypting using Base64 class----------------------
		byte[] encodedString = Base64.encodeBase64(str.getBytes());
		
		System.out.println(encodedString);	// this is printing of bytes
		
		// Printing encoded string 
		System.out.println("Encoded string : "+ new String(encodedString));
		
		
		//--------------Decoding String----------------------------------
		byte[] decodedString = Base64.decodeBase64(encodedString);
		
		//This will print decoded bytes
		System.out.println(decodedString);
		
		// Printing decoded string value
		System.out.println("Decoded value : "+ new String(decodedString));

	}

}
