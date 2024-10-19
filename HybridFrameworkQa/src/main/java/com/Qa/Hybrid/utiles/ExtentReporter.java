package com.Qa.Hybrid.utiles;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReporter {
//	Genreate the ExtendReport in the Browser
	public static ExtentReports generateExtentReport() {

		ExtentReports extentReport = new ExtentReports();

		File extentReportFile = new File(
				System.getProperty("user.dir") + "\\test-output\\ExtentReports\\extentReport.html");
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter(extentReportFile);

		sparkReporter.config().setTheme(Theme.DARK);
		sparkReporter.config().setReportName("Hybrid-Automation-QA Test Automation Results Report");
		sparkReporter.config().setDocumentTitle("Hybrid-Automation-QA Report");
		sparkReporter.config().setTimeStampFormat("dd/MM/yyyy hh:mm:ss");

		extentReport.attachReporter(sparkReporter);
// Taking a common input from the config.file
		Properties configProp = new Properties();
		File configPropFile = new File(
				System.getProperty("user.dir") + "\\src\\main\\java\\com\\Qa\\Hybrid\\config\\config.properties");

		try {
			FileInputStream fisConfigProp = new FileInputStream(configPropFile);
			configProp.load(fisConfigProp);
		} catch (Throwable e) {
			e.printStackTrace();
		}

		extentReport.setSystemInfo("Application URL", configProp.getProperty("url"));
		extentReport.setSystemInfo("Browser Name", configProp.getProperty("browser"));
		extentReport.setSystemInfo("Email", configProp.getProperty("email"));
		extentReport.setSystemInfo("Password", configProp.getProperty("password"));
		extentReport.setSystemInfo("Operating System", System.getProperty("os.name"));
		extentReport.setSystemInfo("Username", System.getProperty("user.name"));
		extentReport.setSystemInfo("Java Version", System.getProperty("java.version"));

		return extentReport;
	}
}
