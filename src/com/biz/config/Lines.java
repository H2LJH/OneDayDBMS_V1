package com.biz.config;

public class Lines 
{
	public static String dLine = "";
	public static String sLine = "";
	
	static
	{
		String line = String.format("%0100d", 0);
		dLine = line.replace("0", "=");
		dLine = line.replace("0", "s");
	}
}
