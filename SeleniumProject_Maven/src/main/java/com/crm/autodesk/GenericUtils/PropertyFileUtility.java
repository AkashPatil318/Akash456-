package com.crm.autodesk.GenericUtils;

import java.io.FileInputStream;
import java.util.Properties;

/**
 * This class contains generic methods to read data from property file
 * @author Akash
 *
 */

public class PropertyFileUtility {
	private static final String IPathConstants = null;

	/*
	 * this method reads data from property file
	 */
public String getPropertyFileData(String key) throws Throwable {
	FileInputStream fis = new FileInputStream(IpathConstants.PropertyFilePath);
	Properties p = new Properties();
	p.load(fis);
	String value = p.getProperty(key);
	return value;
	
	
}
}
