package TestCode;

import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import util.Action;
import util.TestDataProvider;
import util.TestSuit;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class LoginTest extends TestSuit{
	//AppiumDriver driver;
	AndroidDriver driver;
	public TestDataProvider tdp;
	public TestDataProvider tdp1;
	@BeforeClass
	public void setUp(){
		tdp = new TestDataProvider(System.getProperty("user.dir")+"\\src\\main\\resources\\gobalsettings.csv");
		tdp1 = new TestDataProvider(System.getProperty("user.dir")+"\\src\\test\\resources\\userInfo.csv");
		
	}
	/*
	@Test(description = "从开机引导页登录")
	public void loginTest() throws InterruptedException{
		String line = "t1";
		if(au.isElementPresented(By.id(startpage.loginButton)) == true){
			au.click(By.id(startpage.startQQ));
			Thread.sleep(4000);
			
			System.out.println(driver.currentActivity());
//			driver.startActivity("com.tencent.mobileqq", "com.tencent.mobileqq.activity.SplashActivity");
			
			au.click(By.id("com.tencent.mobileqq:id/name)"));
			Thread.sleep(4000);
			
			
		}
		
	}
	*/
	
	@Test(description = "从我的界面登录账号")
	public void loginTest1() throws InterruptedException{
		//设置从userInfo中的第几行获取数据
		String line = "t1";
		//如果启动app时，发现处于开机引导页，则跳过
		if(au.isElementPresented(By.id(startpage.loginButton)) == true){
			au.click(By.id(startpage.skippage));
		}
		
		//如果进入首页，有弹出更新框，先点击取消更新
		if(au.isElementPresented(By.id(homepage.cancleUpdate)) == true){
				au.click(By.id(homepage.cancleUpdate));
		};
		
		//点击“我”，切换到“我”的界面
		au.click(By.id(minepage.mineIcon));
		
		//判断用户是否已经登录，如果已经登录，则先退出登录
		if(au.isElementPresented(By.id(minepage.userName)) == true){
			//点击设置图标，并是否跳转到设置界面
			au.click(By.id(minepage.settingIcon));
			Assert.assertEquals(au.isElementPresented(By.id(settingpage.seetingTitle)), true);
			//点击退出登录
			au.click(By.id(settingpage.logout));
			
			//点击确认
//			String a = driver.findElement(By.xpath(loginpage.comfirm1)).getText().toString();
//			Assert.assertEquals(a, "确认");
			
			au.click(By.id(minepage.comfirm));
//			au.click(By.xpath(loginpage.comfirm1));
		}
		//点击登录，并判断是否跳转到登录界面
		au.click(By.id(minepage.loginIcon));
		Assert.assertEquals(au.isElementPresented(By.id(loginpage.loginTitle)),true);
			
		//输入用户名、密码并点击登陆按钮，然后判断是否登录成功
		au.SendKeyEvent(By.id(loginpage.username), tdp1.getTestData("username", line));
		au.SendKeyEvent(By.id(loginpage.password), tdp1.getTestData("password", line));
		au.click(By.id(loginpage.loginButton));
		Assert.assertEquals(au.isElementPresented(By.id(minepage.userName)),true);
		
		System.out.println("登录成功");
	}
	

	@AfterClass
	public void afterClass() {
		au.driverQuit();
	}

}
