package com.desafio_tunts.utils;

import java.io.BufferedReader;

public class Util {

	public static String JsonToString(BufferedReader bufferedReader) throws Exception {
		
		String content, jsonToString = "";
		
		while ((content = bufferedReader.readLine()) != null) {
			jsonToString += content;
		}
		
		return jsonToString;
	}
}
