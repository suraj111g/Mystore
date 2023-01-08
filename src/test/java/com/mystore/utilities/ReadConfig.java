package com.mystore.utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
    //create properties variable for read the data from config.prop
	Properties properties;
    //set the path and store in string variable
	String path = "C:\\Users\\Admin\\eclipse-workspace\\Mystore_V1\\Configuration\\Config.properties";
    
	//create method using constructor for fetch the data from config.properties
	public ReadConfig() {

		try {
			properties = new Properties();

			FileInputStream fis = new FileInputStream(path);
			properties.load(fis);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
    //create method for read the url data from config.properties
	//use return type string because value store in config.prop as a string 
	public String GetUrl() {

		String Value = properties.getProperty("BaseUrl");
		if(Value!=null) {
			System.out.println("url is found");
		}
		else {
			System.out.println("Url is not found");
		}
		return Value;
	}
    
	//create method for read the browser data from config.properties
	public String GetBrowser() {

		String Value = properties.getProperty("Browser");
		
		if(Value!=null) {
			System.out.println("Browser is lauch succesfully");
		}
		else {
			System.out.println("Browser not found");
		}
		return Value;
	}
	
}

