package page.minepage;

import io.appium.java_client.AppiumDriver;
import page.PageBase;

public class SettingPage extends PageBase{
	AppiumDriver driver;
	/*
	 * by.id
	 */
	//退出按钮
	public String logout = "com.snailvr.manager:id/btn_logout";
	//设置界面标题栏
	public String seetingTitle = "com.snailvr.manager:id/tv_title";
	
	public SettingPage(AppiumDriver driver){
		this.driver = driver;
	}
}
