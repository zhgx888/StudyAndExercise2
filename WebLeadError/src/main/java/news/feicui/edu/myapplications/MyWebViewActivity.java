package news.feicui.edu.myapplications;
/***
 * 功能:主要处理 webview在加载网页和加载网页失败时的过程
 * 当 webview在请求网页的这段时间:让它显示一个自定义的页面
 * 当 webview请求失败时:让它显示自定义的网页(本人觉得系统自带的太丑了)
 */
import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.ViewPager.LayoutParams;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;


public class MyWebViewActivity extends Activity{
	private WebView webview;
	private View mErrorView;
	private WebSettings mWebSettings;
	private RelativeLayout loading_over;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_loading);
		webview = (WebView) findViewById(R.id.webview);
		loading_over = (RelativeLayout) findViewById(R.id.loading_over);
		setUpView();

	}
	private void setUpView() {
		//加载需要显示的网页
		webview.loadUrl("http://www.baidu.com/");
		//设置WebView属性，能够执行Javascript脚本
		webview.getSettings().setJavaScriptEnabled(true);
		mWebSettings = webview.getSettings();
		mWebSettings.setJavaScriptEnabled(true);    //允许加载javascript
		mWebSettings.setSupportZoom(true);          //允许缩放
		mWebSettings.setBuiltInZoomControls(true);  //原网页基础上缩放
		mWebSettings.setUseWideViewPort(true);      //任意比例缩放
		webview.setWebViewClient(webClient);  //设置Web视图
	}
	/***
	 * 设置Web视图的方法
	 */
	WebViewClient webClient = new WebViewClient(){//处理网页加载失败时
		public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
			showErrorPage();//显示错误页面
		};
		public void onPageFinished(WebView view, String url) {//处理网页加载成功时
			loading_over.setVisibility(View.GONE);
		}
	};
	/**
	 * 显示自定义错误提示页面，用一个View覆盖在WebView
	 */
	boolean mIsErrorPage;
	protected void showErrorPage() {
		LinearLayout webParentView = (LinearLayout)webview.getParent();
		initErrorPage();//初始化自定义页面
		while (webParentView.getChildCount() > 1) {
			webParentView.removeViewAt(0);
		}
		@SuppressWarnings("deprecation")
		LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LayoutParams.FILL_PARENT,LayoutParams.FILL_PARENT);
		webParentView.addView(mErrorView, 0, lp);
		mIsErrorPage = true;
	}
	/****
	 * 把系统自身请求失败时的网页隐藏
	 */
	protected void hideErrorPage() {
		LinearLayout webParentView = (LinearLayout)webview.getParent();

		mIsErrorPage = false;
		while (webParentView.getChildCount() > 1) {
			webParentView.removeViewAt(0);
		}
	}
	/***
	 * 显示加载失败时自定义的网页
	 */
	protected void initErrorPage() {
		if (mErrorView == null) {
			mErrorView = View.inflate(this, R.layout.activity_url_error, null);
			RelativeLayout button = (RelativeLayout)mErrorView.findViewById(R.id.online_error_btn_retry);
			button.setOnClickListener(new OnClickListener() {
				public void onClick(View v) {
					webview.reload();
				}
			});
			mErrorView.setOnClickListener(null);
		}
	}

	//	@Override
	//设置回退
	//覆盖Activity类的onKeyDown(int keyCoder,KeyEvent event)方法
	//	public boolean onKeyDown(int keyCode, KeyEvent event) {
	//		if ((keyCode == KeyEvent.KEYCODE_BACK) && webview.canGoBack()) {
	//			webview.goBack(); //goBack()表示返回WebView的上一页面
	//			return true;  
	//		}  
	//		return false;  
	//	}  


}
