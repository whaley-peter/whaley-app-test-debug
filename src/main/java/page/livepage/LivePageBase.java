package page.livepage;

import io.appium.java_client.AppiumDriver;
import page.PageBase;

//VR直播页
public class LivePageBase extends PageBase{
	AppiumDriver driver;
	/*
	 * By.Xpath
	 */
	//回顾推荐
	public String ReviewRecommended= "//android.support.v7.widget.RecyclerView/android.widget.LinearLayout[1]/android.widget.TextView";
	/*
	 * By.id
	 */
	//VR直播icon
	public String live = "com.snailvr.manager:id/tv_live";
	
	
	public LivePageBase(AppiumDriver driver) {
		this.driver = driver;
	}
}
