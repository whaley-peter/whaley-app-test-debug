package util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;


public class Action {
	
	AppiumDriver driver;
	public Action ac;
	public TouchAction au;
	
	public Action(AppiumDriver driver) {
		this.driver = driver;
//		ac = new Action(driver);
		au = new TouchAction(driver);
	}
	
	public void click(By by){
		try{
			driver.findElement(by).click();
		}catch(Exception e){
			try{
				Thread.sleep(2000);
				driver.findElement(by).click();
			}catch(Exception e1){
				e1.printStackTrace();
			}
		}
	}
	public void SendKeyEvent(By by,CharSequence arg0){
		driver.findElement(by).sendKeys(arg0);
	}
	
	public void back(){
		String back = "com.snailvr.manager:id/btn_back";
		ac.isElementPresented(By.id(back));
		ac.click(By.id(back));
	}
	public String getStringOfElement(By by){
		
		driver.findElement(by).toString();
		
		return null;
	}

	public boolean isElementPresented(By by){
		Boolean isDisplayed = false;
		try{
			isDisplayed = driver.findElement(by).isDisplayed();
		}catch(Exception e){
			try{
				Thread.sleep(2000);
				isDisplayed = driver.findElement(by).isDisplayed();
			}catch(Exception e1){
				isDisplayed = false;
			}
		}
		return isDisplayed;
	}
	
	public void waitElement(By by){
		WebDriverWait wait = new WebDriverWait(driver,5);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
	}
	public void driverQuit(){
		driver.quit();
	}
	
}
