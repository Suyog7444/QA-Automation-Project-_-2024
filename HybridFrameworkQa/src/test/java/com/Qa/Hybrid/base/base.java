package com.Qa.Hybrid.base;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.Qa.Hybrid.utiles.Utiles;

public class base {
	WebDriver driver;
	public Properties prop;
	public Properties dataprop;

	public base() {
		
		prop = new Properties();
		File propFile = new File(
				System.getProperty("user.dir") + "\\src\\main\\java\\com\\Qa\\Hybrid\\config\\config.properties");
		dataprop = new Properties();
		File dataPropFile = new File(
				System.getProperty("user.dir") + "\\src\\main\\java\\com\\Qa\\Hybrid\\testdata\\testdata.properties");

		try {
			FileInputStream datafis = new FileInputStream(dataPropFile);
			dataprop.load(datafis);

		} catch (Throwable e) {
			e.printStackTrace();

		}

		try {
			FileInputStream fis = new FileInputStream(propFile);
			prop.load(fis);

		} catch (Throwable e) {
			e.printStackTrace();

		}

	}

	public WebDriver OpenApplication(String browserName) {

		if (browserName.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else if (browserName.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Utiles.IMPLICIT_WAIT_TIME));
//		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Utiles.PAGE_WAIT_TIME));
		driver.get(prop.getProperty("url"));
		return driver;
	}
}
