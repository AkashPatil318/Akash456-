package com.crm.autodesk.Organizations.Tests;

import com.crm.autodesk.GenericUtils.JSONFileUtility;

public class DemoFileReader {
	public static void main(String[] args) throws Throwable {
		JSONFileUtility jsonLib = new JSONFileUtility();
		String val = jsonLib.readDataFromJSON("browser");
		System.out.println(val);
	}

}
