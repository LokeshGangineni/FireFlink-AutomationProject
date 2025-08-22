package ninjaCRM.GenericUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.apache.commons.math3.fraction.ProperBigFractionFormat;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * This class is used to retrive the data from files
 */
public class FileUtility {
	
	/**
	 * This cell return the entire data of complete row
	 * @param sheetName
	 * @param rowNumber
	 * @param columnNumber
	 * @param list
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	
	public List<String> ReadDataFromExcel(String sheetName,int rowNumber,int columnNumber,List<String>list) throws EncryptedDocumentException, IOException
	{
		
		FileInputStream fileInputStream= new FileInputStream(".\\src\\test\\resources\\files\\TestCases.xlsx");
		Workbook workbook = WorkbookFactory.create(fileInputStream);
		Sheet sheet = workbook.getSheet(sheetName);
		Row row = sheet.getRow(rowNumber);
		for(int i=0;i<columnNumber;i++)
		{
			list.add(row.getCell(columnNumber).toString());
		}
		
		return list;
	}
	
	/**
	 * This method is used to read data from 1 cell from excel
	 * @param sheetName
	 * @param rowNumber
	 * @param columnNumber
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	
		public String ReadDataFromExcel( String sheetName,int rowNumber,int columnNumber) throws EncryptedDocumentException, IOException
		{
			FileInputStream fileInputStream= new FileInputStream("C:\\Users\\User\\eclipse-workspace\\Fireflink.NinzaCRM.Automationframework\\src\\test\\resources\\files\\TestData.xlsx");
			Workbook workbook = WorkbookFactory.create(fileInputStream);
			String data= workbook.getSheet(sheetName).getRow(rowNumber).getCell(columnNumber).toString();
			return data;
			
		}
		
		/**
		 * This method id used to retrive the data from properties
		 * @param filePath
		 * @param key
		 * @return
		 * @throws IOException
		 */
		public String readDataFromPropertiesFile(String key) throws IOException
		{
			FileInputStream fis= new FileInputStream("C:\\\\Users\\\\User\\\\eclipse-workspace\\\\Fireflink.NinzaCRM.Automationframework\\\\src\\\\test\\\\resources\\\\files\\\\commondata.properties");
			Properties p= new Properties();
			p.load(fis);
			return p.getProperty(key);
			
		}
		/**
		 * this method is used to read multiple data from excel
		 * @throws IOException
		 */
		public Object[][] readingMultipleDataFromExcel(int rows,int columns,String sheetName) throws IOException
		{
			Object[][] data= new Object[rows][columns];
			FileInputStream fis= new FileInputStream("C:\\Users\\User\\eclipse-workspace\\Fireflink.NinzaCRM.Automationframework\\src\\test\\resources\\files\\TestCases.xlsx");
			Workbook w = WorkbookFactory.create(fis);
			Sheet sh = w.getSheet(sheetName);
			
			for(int i=0;i<rows;i++)
			{
				for(int j=0;j<columns;j++)
				{
					data[i][j]=sh.getRow(i).getCell(j).toString()+"\t";
				}

			}
			return data;
		}
}
