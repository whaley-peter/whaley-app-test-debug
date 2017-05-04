package util;

import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import mine.LoginPage;
import mine.SettingPage;
import page.HomePage;
import page.LivePage;
import page.MinePage;
import page.StartPage;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeSuite;


public class TestSuit {
  
	static AppiumDriver driver;
	public HomePage homepage;
	public Action au;
	public DesiredCapabilities capabilities;
	public LivePage livepage;
	public MinePage minepage;
	public LoginPage loginpage;
	public SettingPage settingpage;
	public StartPage startpage;
	
  @BeforeSuite
  public void beforeSuite() throws MalformedURLException, InterruptedException {
	  
	  TestDataProvider tdp = new TestDataProvider(System.getProperty("user.dir")+"/src/main/resources/globalsetting.csv");
//	  File classpathRoot = new File(System.getProperty("user.dir"));
//	  File appDir = new File(classpathRoot, "apps");
//	  File app = new File(appDir, "app-debug_v2.7_03090816.apk");
      


	  
	  capabilities = new DesiredCapabilities();
	  String t = "t3";

	  capabilities.setCapability("platformName", tdp.getTestData("platformName", t));
	  capabilities.setCapability("deviceName", tdp.getTestData("deviceName", t));
	  capabilities.setCapability("ignoreUnimportantViews", tdp.getTestData("ignoreUnimportantViews",t));
	  capabilities.setCapability("newCommandTimeout","1000");
	  capabilities.setCapability("sessionOverride", true);
//	  capabilities.setCapability("app", app.getAbsolutePath());
//	  capabilities.setCapability("noRest", "true");
	  capabilities.setCapability("appPackage", tdp.getTestData("appPackage",t));
	  capabilities.setCapability("appActivity", tdp.getTestData("appActivity", t));
//	  capabilities.setCapability("appWaitPackage", tdp.getTestData("appPackage",t));
//	  capabilities.setCapability("appWaitActivity", tdp.getTestData("appActivity",t));
//	  capabilities.setCapability("appWaitActivity", "com.whaley.vr.module.launcher.activitys.MainActivity");
//	  capabilities.setCapability("appWaitActivity",tdp.getTestData("appActivity",t));
	  
	  driver = new AndroidDriver(new URL("http://"+tdp.getTestData("server",t)+"/wd/hub"),capabilities);
//	  driver.removeApp("unlock_apk-debug.apk");
//	  driver.removeApp("settings_apk-debug.apk");
	  driver.manage().timeouts().implicitlyWait(1000, TimeUnit.MILLISECONDS);
	 
	  au = new Action(driver);
	  homepage = new HomePage(driver);
	  livepage = new LivePage(driver);
	  minepage = new MinePage(driver);
	  loginpage = new LoginPage(driver);
	  settingpage = new SettingPage(driver);
	  startpage = new StartPage(driver);
  }

}
