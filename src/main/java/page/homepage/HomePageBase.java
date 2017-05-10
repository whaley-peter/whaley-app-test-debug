package page.homepage;

import io.appium.java_client.AppiumDriver;
import page.PageBase;

//app首页
public class HomePageBase extends PageBase{
	AppiumDriver driver;
	/*
	 * By.Xpath
	 */
	//查找首页推荐元素
    public String RecommendedElement = "//android.support.v7.widget.RecyclerView/android.widget.RelativeLayout[1]";
    public String we = "//android.widget.HorizontalScrollView/android.support.v7.app.ActionBar$Tab[2]/android.widget.TextView[1]";
    
    /*
     * By.id
     */
    //首页icon
    public String homeIcon = "com.snailvr.manager:id/rl_recommend";
    //弹出升级框下的取消按钮
    public String cancleUpdate = "com.snailvr.manager:id/btn_cancel";
    
    public HomePageBase(AppiumDriver driver){
    	this.driver = driver;
    }
    
}
