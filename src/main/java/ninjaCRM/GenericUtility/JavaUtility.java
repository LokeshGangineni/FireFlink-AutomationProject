package ninjaCRM.GenericUtility;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class JavaUtility {
	
	
	/**
	 * This is used to retun date 
	 * @return timestamp as String
	 */
	public  String GettingDate()
	{
		Date date=  new Date();
		SimpleDateFormat simpleDateFormat= new SimpleDateFormat("dd-mm-yyyy_hh-mm-ss");
		String TimeStamp= simpleDateFormat.format(date);
		return TimeStamp;	
		
	}
	
	/**
	 * This method will generate random number
	 * @return random number
	 */
	public int gettingRandomNumber()
	{
		Random random= new Random();
		return random.nextInt();
		
	}

}
