package mine;

import io.appium.java_client.AppiumDriver;
import page.PageBase;

public class LoginPage extends PageBase {
	AppiumDriver driver;
	/*
	 * by.id
	 */
	//登录标题栏
	public String loginTitle = "com.snailvr.manager:id/tv_title";
	//输入用户名框
	public String username = "com.snailvr.manager:id/et_user_name";
	//输入密码框
	public String password = "com.snailvr.manager:id/et_password";
	//短信快捷登陆
	public String loginByMessage = "com.snailvr.manager:id/btn_safe_login";
	//忘记密码
	public String forgetPassword = "com.snailvr.manager:id/btn_forget_pwd";
//	登录按钮--使用父类的属性
//	public String loginButton = "com.snailvr.manager:id/btn_login";
	//注册
	public String register = "com.snailvr.manager:id/btn_right";
	
	
	public LoginPage(AppiumDriver driver) {
		this.driver = driver;
	}
	
}
