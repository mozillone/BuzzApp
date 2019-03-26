package Utils;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadExcel {
	
	public ReadExcel()throws FileNotFoundException {
		
		
			super();
			// TODO Auto-generated constructor stub
		}

		public static String TESTDATA_SHEET_PATH = "C:\\Users\\4195\\Downloads\\Responsive.xls";
		

		static Workbook book;
		static org.apache.poi.ss.usermodel.Sheet sheet;

		public static Object[][] getTestData(String sheetName) throws org.apache.poi.openxml4j.exceptions.InvalidFormatException, IOException {
			//FileInputStream file = null;
			BufferedInputStream file = null;
			try {
				
				 file = new BufferedInputStream(new FileInputStream(TESTDATA_SHEET_PATH));
				//file = new FileInputStream(TESTDATA_SHEET_PATH);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			try {
				book = WorkbookFactory.create(file);
			} catch (InvalidFormatException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			sheet = book.getSheet(sheetName);
			Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
			// System.out.println(sheet.getLastRowNum() + "--------" +
			// sheet.getRow(0).getLastCellNum());		
			for (int i = 0; i < sheet.getLastRowNum(); i++) {
				for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
					data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
					// System.out.println(data[i][k]);
					
					
				
				}
			}
			return data; 
	    } 
		
	}

