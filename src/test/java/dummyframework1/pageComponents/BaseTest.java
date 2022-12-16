package dummyframework1.pageComponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	
	public static WebDriver driver;
	
	@BeforeMethod
	
	public WebDriver initiatedriver() throws IOException {
		
		Properties Properties= new Properties();
		FileInputStream ip= new FileInputStream(System.getProperty("user.dir")+"/src/main/java/dummyframework1/resources/Globaldata.properties");
		Properties.load(ip);
		String browsername;
		
		if(System.getProperty("browser")!=null) {
			
			browsername=System.getProperty("browser");
						
		}
		else {
			
			browsername=Properties.getProperty("browser");

			
		}
//		browsername=Properties.getProperty("browser");
		
		if(browsername.contains("chrome")) {
			
		WebDriverManager.chromedriver().setup();
		ChromeOptions options= new ChromeOptions();
		
		if(browsername.contains("headless")) {
			options.addArguments("headless");
		   }
		driver=new ChromeDriver(options);
		driver.manage().window().setSize(new Dimension(2048,1080));
		
		}
		
		else if(browsername.equalsIgnoreCase("firefox")) {
			
		WebDriverManager.firefoxdriver().setup();
		driver= new FirefoxDriver();
			
		}
		
		else if(browsername.equalsIgnoreCase("edge")) {
			
			WebDriverManager.edgedriver().setup();
			driver= new EdgeDriver();
			
		}
	  
		return driver;
	}
	
	@AfterMethod
	
	public void closeBrowser() {
		
		driver.close();
		
	}
	
	public static String takeScreenshot(String testCaseName, WebDriver driver) throws IOException {
		   
		   TakesScreenshot ts= (TakesScreenshot)driver;
	   	File source=ts.getScreenshotAs(OutputType.FILE);	  
	   	File destination=new File(System.getProperty("user.dir")+"/reports/" +testCaseName+ ".png");
	   	FileUtils.copyFile(source, destination);
	   	return System.getProperty("user.dir")+"/reports/" +testCaseName+ ".png";
		   
	   }
	
	public List<HashMap<String, String>> dataReaderJSONtoMap(String filepath) throws IOException {
		
		
		//Read JSON to String	
		String JSONContent=FileUtils.readFileToString(new File(filepath),StandardCharsets.UTF_8) ;
		
		//String to HashMap JAckson Databind
		
		ObjectMapper mapper= new ObjectMapper();
		List<HashMap<String, String>> data=mapper.readValue(JSONContent, new TypeReference<List<HashMap<String, String>>>() {});	
		return data;
		}

	
//	public static String takescreenshot(String testCaseName) throws IOException {
//		
//		Screenshot screenshot = new AShot().takeScreenshot(driver);
//		ImageIO.write(screenshot.getImage(), "jpeg", new File(System.getProperty("user.dir")+"/reports/"+testCaseName+".jpeg"));
//        return System.getProperty("user.dir")+"/reports/"+testCaseName+".jpeg";
//		
//	}

	
}

