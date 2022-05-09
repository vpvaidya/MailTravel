package util;

import org.apache.commons.lang3.RandomStringUtils;

public class RestUtil {
	
	public static String empName() 
	{
		
		String generatedEmpName= RandomStringUtils.randomAlphabetic(1);
		
		return("John"+generatedEmpName);
	}
	
	public static String empSalary() 
	{
		
		String generatedEmpSal= RandomStringUtils.randomNumeric(5);
		
		return(generatedEmpSal);
	}
	public static String empAge() 
	{
		
		String generatedEmpAge= RandomStringUtils.randomNumeric(2);
		
		return(generatedEmpAge);
	}
	

}
