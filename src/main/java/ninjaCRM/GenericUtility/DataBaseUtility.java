package ninjaCRM.GenericUtility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBaseUtility {
	
	Connection c;
	Statement s;
	
	
	/**
	 * this method helps in getting connection to db
	 * @return
	 * @throws SQLException
	 */
	public Connection getConnection() throws Exception
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url="jdbc:mysql://localhost:3306/data";
		  c = DriverManager.getConnection(url,"root","root");
		  return c;
	}
	
	/**
	 * This method helps in creation of statements
	 * @return
	 * @throws SQLException
	 */
	public Statement createStatements() throws SQLException
	{
		 return s = c.createStatement();
	}
	/**
	 * This method helps in execution of select  statements
	 * @return
	 * @throws SQLException
	 */
	public ResultSet executeStatements() throws SQLException
	{
		ResultSet set = s.executeQuery("Select * from employee");
	 	  while(set.next())
	 	  {
	 		   set.getInt(1);
	 		   set.getString(2);
	 		   set.getString(3);
	 		   set.getString(4);
	 	  }	
	 	  return set;
	}
	
	/**
	 * used to close connection
	 * @throws SQLException
	 */
	public void closeConnetion() throws SQLException
	{
		c.close();
	}
	
	/**
	 * inserting data into db and returns true or false based on result
	 * @param query
	 * @return
	 * @throws Exception
	 */
	public boolean insertingDataToTable(String query) throws Exception
	{
		
		 	 Statement s = c.createStatement();
		 	 int result=s.executeUpdate(query);
		 	 if(result>0) 
		 	 	return true;
		 	 
		return false;	
		
	}
	
	
	

}
