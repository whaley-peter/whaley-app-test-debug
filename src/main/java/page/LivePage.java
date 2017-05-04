package page;

import io.appium.java_client.AppiumDriver;

public class LivePage extends PageBase{
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
	
	
	public LivePage(AppiumDriver driver) {
		this.driver = driver;
	}
}
