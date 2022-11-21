package com.Online_Banking.Banking.GenericLibraries;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class File_Utility {
	/**
	 * This method is used to read from property  file
	 * @author kalam
	 * @param key
	 * @return
	 * @throws IOException
	 */
	
	public String readDataFromPropertyFile(String key) throws IOException {
		Properties p= new Properties();
		FileInputStream fis=new FileInputStream(IPathConstant.FilePath);
				p.load(fis);
				String value=p.getProperty(key);
				return value;
	}
}
