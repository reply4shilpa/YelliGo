package yelliGo.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Set;

import org.apache.commons.compress.archivers.dump.InvalidFormatException;
import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.OpenXML4JException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import yelliGo.pages.TestBase;

public class TestUtil extends TestBase {

	public static long PAGELOAD_TIMEOUT=20;
	public static long IMPLICIT_WAIT=20;
	public static String currentDir="\\Users\\Shilpa\\Desktop\\JAVA Work\\oop-demo\\src\\org\\apex\\Employee\\yelligo\\src\\main\\java\\yelliGo\\util\\";
	static Workbook book;
	static Sheet sheet;
	
	public static void takeScreenshotAtEndOfTest() throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
		
	}
	

	public static void switchToFrame() {
		
		Set<String> set = driver.getWindowHandles();

		for (String s1 : set) {
			driver.switchTo().window(s1);

		}
		
		
	
	}
	
	

//C:\\Users\\Shilpa\\Desktop\\JAVA Work\\oop-demo\\src\\org\\apex\\Employee\\yelligo\\src\\main\\java
	
	public static String TESTDATA_SHEET_PATH = TestUtil.currentDir+"registrationtest-data.xlsx";

	public static Object[][] getRegTestData(String sheetName) throws OpenXML4JException{
			
			FileInputStream file = null;
			try{
				file = new FileInputStream(TESTDATA_SHEET_PATH);
			}catch (FileNotFoundException e){
				e.printStackTrace();
			}
			try{
				book = WorkbookFactory.create(file);
			
			}catch(InvalidFormatException e){
				e.printStackTrace();
			}catch(IOException e){
			e.printStackTrace();
			}
			sheet = book.getSheet(sheetName);
			Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
			
			for (int i = 0; i < sheet.getLastRowNum();i++){
				for(int k = 0; k < sheet.getRow(0).getLastCellNum();k++){
					data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
					//System.out.printlt(data[i][k]);
				}
			}
			return data;	
	}





}
