package Generic;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.apache.commons.io.FileUtils;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FWutils implements IAutoconstant
{
	
	public void title_verify(WebDriver driver,String expected_title)
	{
		WebDriverWait wait=new WebDriverWait(driver,Expl_time);
		wait.until(ExpectedConditions.titleContains(expected_title));
		String Actual_title =driver.getTitle();
		if(Actual_title.equalsIgnoreCase(expected_title))
		{
			System.out.println("required title displayed ");
		}
		else
		{
			System.out.println("title is not as expected");
		}
	}
	
	public String read_excel_data(String path,String sheet_name,int cell, int row) throws EncryptedDocumentException, IOException
	{
	
	String data="";
	FileInputStream file =new FileInputStream(path);
	Workbook workbook=WorkbookFactory.create(file);
	data=workbook.getSheet(sheet_name).getRow(row).getCell(cell).toString();
	return data;
	}
	public int read_excel_data(String path,String sheet_name) 
	{
		int data=0;
		FileInputStream file;
		try {
			file = new FileInputStream(path);
			Workbook workbook=WorkbookFactory.create(file);
			data=workbook.getSheet(sheet_name).getLastRowNum();
		} 
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;
	}
	
	public void write_data_xl(String path,String sheet_name,int row,int cell,String data )
	{
		
		try {
			FileInputStream file =new FileInputStream(path);
			Workbook workbook=WorkbookFactory.create(file);
			workbook.getSheet(sheet_name).getRow(row).getCell(cell).setCellValue(data);
			workbook.write(new FileOutputStream(path));
		} 
		catch (Exception e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		}
	
public void getScreenshot(WebDriver driver,String path)
{
	
	try {
		TakesScreenshot t=(TakesScreenshot)driver;
		File src =t.getScreenshotAs(OutputType.FILE);
		File dest=new File(path);
		FileUtils.copyFile(src, dest);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
}

	
	
	
	
	
	
	
	
	
}
