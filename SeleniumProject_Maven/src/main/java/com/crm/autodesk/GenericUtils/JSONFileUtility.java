package com.crm.autodesk.GenericUtils;

import java.io.FileReader;
import java.util.HashMap;

import org.json.simple.parser.JSONParser;

public class JSONFileUtility {
	/**
	 * @author Akash
	 * this method reads the data from json file
	 * @throws Throwable 

	 */

	public String readDataFromJSON(String key) throws Throwable {

		//read the data from json file 
		FileReader file = new FileReader("./commonData.json");

		// convert the json file into java object
		JSONParser jsonobj = new JSONParser();
		Object jobj = jsonobj.parse(file);

		// type cast java ob to hashmap
		HashMap map = (HashMap)jobj;
		String Value = map.get(key).toString();
		// return the value
		return Value;


	}

}
