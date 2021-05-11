package com.ipts.o1generic;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigLib {
	
	public static String dirPath=System.getProperty("user.dir");
	public static String osName=System.getProperty("os.name");
	
	public static String getValue(String key)
	{
		String value=null;
		
		try
		{
			FileInputStream fis=new FileInputStream(new File(dirPath + "\\config.properties"));
			Properties prop=new Properties();
			prop.load(fis);
			value=prop.getProperty(key);
			
			
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
		return value;
	}

	
	public static String set_update_Value(String key,String value)
	{
		
		try
		{
			FileInputStream fis=new FileInputStream(new File(dirPath + "\\config.properties"));
			Properties prop=new Properties();
			prop.load(fis);
			fis.close();
			
			FileOutputStream fos=new FileOutputStream(new File(dirPath + "\\config.properties"));
			prop.setProperty(key, value);
			prop.store(fos, key);
			fos.close();
			
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
		return value;
	}
}
