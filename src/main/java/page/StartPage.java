package page;

import io.appium.java_client.AppiumDriver;

public class StartPage extends PageBase{
	AppiumDriver driver;
	/*
	 * by.id
	 */
//	登录按钮--使用父类的属性
//	public String loginButton = "com.snailvr.manager:id/btn_login";
	//注册按钮
	public String register = "com.snailvr.manager:id/btn_register";
	//逛一逛
	public String skippage = "com.snailvr.manager:id/iv_leapfrog";
	
	public StartPage(AppiumDriver driver) {
		
		this.driver = driver;
	}
	
	
	
}
