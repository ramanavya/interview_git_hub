package Generic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class BaseTest implements IAutoconstant
{
	public static WebDriver driver;
	static
	{
		System.setProperty(Key_chrome, value_chrome);
	}
	@BeforeClass()
	public void open_browser(String browser_name)
	{
		if(browser_name.equals("chrome"))
		{
			driver=new ChromeDriver();
			
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Wait_time,TimeUnit.SECONDS);
	}
	@BeforeMethod()
	public void Login_to_application()
	{
		driver.get(url);
		
	}
	
	/*@AfterMethod()
	public void close_browser(ITestResult res)
	{
	int status=res.getStatus();
	String methodname=res.getName();
	if(status==1)
	{
		passCount++;
	}
	else
	{
		failCount++;
		String path=screenshot_path+methodname+".png";
		FWUtils.take_screen_shoot(driver,path);
	}
	
	driver.close();
	}*/
	

}
