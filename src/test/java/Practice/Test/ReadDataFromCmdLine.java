package Practice.Test;

import org.testng.annotations.Test;

public class  ReadDataFromCmdLine {
		
	@Test	
	public void checking()
	{
		
		
		
		String BROWSER = System.getProperty("browser");
		System.out.println(BROWSER);
		String USERNAME = System.getProperty("username");
		System.out.println(USERNAME);
		String PWD= System.getProperty("password");
		System.out.println(PWD);
		String URL= System.getProperty("url");
		System.out.println(URL);
	}

}
