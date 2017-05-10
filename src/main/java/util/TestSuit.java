package util;

import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import page.StartPage;
import page.homepage.HomePageBase;
import page.livepage.LivePageBase;
import page.minepage.LoginPage;
import page.minepage.MinePageBase;
import page.minepage.SettingPage;

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
	public HomePageBase homepage;
	public Action au;
	public DesiredCapabilities capabilities;
	public LivePageBase livepage;
	public MinePageBase minepage;
	public LoginPage loginpage;
	public SettingPage settingpage;
	public StartPage startpage;
	
  @BeforeSuite
  public void beforeSuite() throws MalformedURLException, InterruptedException {
	  //基本配置文件获取路径
	  TestDataProvider tdp = new TestDataProvider(System.getProperty("user.dir")+"/src/main/resources/globalsetting.csv");
//	  app安装路径
//	  File classpathRoot = new File(System.getProperty("user.dir"));
//	  File appDir = new File(classpathRoot, "apps");
//	  File app = new File(appDir, "app-debug_v2.7_03090816.apk");
	  String t = "t3";
	  
	  //初始化appium
	  capabilities = new DesiredCapabilities();
	  capabilities.setCapability("platformName", tdp.getTestData("platformName", t)); //配置测试机所属平台
	  capabilities.setCapability("deviceName", tdp.getTestData("deviceName", t)); //配置设备名称
	  capabilities.setCapability("ignoreUnimportantViews", tdp.getTestData("ignoreUnimportantViews",t));
	  capabilities.setCapability("newCommandTimeout","100"); //没有新命令，appium100秒退出
	  capabilities.setCapability("sessionOverride", true); //每次启动时覆盖session，否则第二次后运行会报错不能新建session  
	  capabilities.setCapability("unicodeKeyboard", true); //设置键盘  
	  capabilities.setCapability("resetKeyboard", false); //设置默认键盘为appium的键盘 
	  capabilities.setCapability("appPackage", tdp.getTestData("appPackage",t)); //配置app的包名
	  capabilities.setCapability("appActivity", tdp.getTestData("appActivity", t)); //配置app的启动类名
	  
	  driver = new AndroidDriver(new URL("http://"+tdp.getTestData("server",t)+"/wd/hub"),capabilities);//把以上配置传到appium服务端并连接手机
	  driver.manage().timeouts().implicitlyWait(1000, TimeUnit.MILLISECONDS);//隐式等待1s
	 
	  //初始化属性
	  au = new Action(driver);
	  homepage = new HomePageBase(driver);
	  livepage = new LivePageBase(driver);
	  minepage = new MinePageBase(driver);
	  loginpage = new LoginPage(driver);
	  settingpage = new SettingPage(driver);
	  startpage = new StartPage(driver);
	  
  }

}
