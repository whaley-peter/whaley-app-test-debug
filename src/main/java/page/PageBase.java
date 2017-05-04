package page;

public class PageBase {
	/*
	 * by.id
	 */
	//弹框确认或者取消提示
	//确认
	public String comfirm = "com.snailvr.manager:id/tv_confirm";
	
	//取消
	public String cancle = "com.snailvr.manager:id/tv_cancel";
	//登录按钮
	public String loginButton = "com.snailvr.manager:id/btn_login";
	//qq
	public String startQQ = "com.snailvr.manager:id/start_qq";
	//微信
	public String startWeixin = "com.snailvr.manager:id/start_weixin";
	//微博
	public String startWeibo = "com.snailvr.manager:id/start_weibo";

	
	
	public String comfirm1 = "//android.widget.LinearLayout[2]/android.widget.TextView[2][contains(@text,'确认')]";
	
	public String getElement(String originalStr,String newValue){
		return String.format(originalStr, newValue);
	}
	
}
