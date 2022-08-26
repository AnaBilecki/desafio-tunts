package com.desafio_tunts.services;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import com.desafio_tunts.entities.Country;
import com.desafio_tunts.utils.Util;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class CountryService {

	static String webService = "https://restcountries.com/v3.1/all";
	static Integer successCode = 200;
	
	public static List<Country> getAll() throws Exception {
		
		try {
			URL url = new URL(webService);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			
			if (connection.getResponseCode() != successCode) {
				throw new RuntimeException("HTTP error code: " + connection.getResponseCode());
			}
			
			BufferedReader jsonContent = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));
			String content = Util.JsonToString(jsonContent);
			
			connection.disconnect();
			
			Gson gson = new Gson();
			Type countryListType = new TypeToken<ArrayList<Country>>(){}.getType();
			List<Country> country = gson.fromJson(content, countryListType);
			
			return country;
			
		} catch (Exception e) {
			throw new Exception("Error: " + e);
		}
	}
}
