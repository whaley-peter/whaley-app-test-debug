package page.minepage;

import io.appium.java_client.AppiumDriver;
import page.PageBase;

//我的界面
public class MinePageBase extends PageBase {
	AppiumDriver driver;
	
	/*
	 * by.id
	 */
	//"我"icon
	public  String mineIcon = "com.snailvr.manager:id/tv_user";
	//登录
	public String loginIcon = "com.snailvr.manager:id/btn_login";
	//注册
	public String registerIcon = "com.snailvr.manager:id/btn_register";
	//设置
	public String settingIcon = "com.snailvr.manager:id/iv_setting";
	//本地管理
	public String localIcon = "com.snailvr.manager:id/layout_local";
	//我的收藏
	public String collectIcon = "com.snailvr.manager:id/layout_collect";
	//我的奖品
	public String giftIcon = "com.snailvr.manager:id/layout_gift";
	//问题反馈
	public String feedbackIcon = "com.snailvr.manager:id/layout_feedback";
	//官方论坛
	public String forumIcon = "com.snailvr.manager:id/layout_forum";
	//使用帮助
	public String helpIcon = "com.snailvr.manager:id/layout_help";
	//登录成功后的用户名
	public String userName = "com.snailvr.manager:id/tv_nick_name";
	
//	publci String userNmae1 = 
	public MinePageBase(AppiumDriver driver){
		this.driver = driver;
	}
}
