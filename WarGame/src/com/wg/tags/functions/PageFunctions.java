package com.wg.tags.functions;

public class PageFunctions {

	static public boolean isNullOrEmpty(String value)
	{
		if(value == null || "".equals(value))
			return true;
		else
			return false;
	}
	
	static public boolean ifEmptyTrue(String value)
	{
		if(value == null || value.length()==0)
			return true;
		else
			return Boolean.valueOf(value);
	}
	
	static public String concat(String value1, String value2)
	{
		if(isNullOrEmpty(value1) || isNullOrEmpty(value2))
			return "";
		else
		{
			return value1+value2;
		}
	}
}
