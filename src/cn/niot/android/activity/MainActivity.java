package cn.niot.android.activity;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import cn.niot.android.activity.MipcaActivityCapture;
import cn.niot.android.activity.R;
import cn.niot.android.service.ProcessResultReceiver;

@SuppressLint("NewApi")
public class MainActivity extends Activity {
	
	private final static int SCANNIN_GREQUEST_CODE = 1;
	//private String ipString;
	//iBtn为 imagebutton的缩写
	private ImageButton iBtnManulInput = null;
	private ImageButton iBtnScanInput = null;
	private ProcessResultReceiver processResultReceiver = null;

	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		
		//显示action bar上最左侧的回退按钮
		ActionBar actionBar = getActionBar();
	    actionBar.setDisplayHomeAsUpEnabled(true);
	    
	    //为页面上的“手动输入”按钮添加监听器
	    iBtnManulInput = (ImageButton) findViewById(R.id.imageButtonManulInput);
	    iBtnManulInput.setOnClickListener(new iBtnManualInputClickListener() );
	    //为页面上的“手动输入”按钮添加监听器
	    iBtnScanInput = (ImageButton) findViewById(R.id.imageButtonScanInput);
	    iBtnScanInput.setOnClickListener(new iBtnScanInputClickListener() );
	    
	   
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		//为“选项菜单”添加两个子项，一个为“设置”，另一个为“退出”
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return super.onCreateOptionsMenu(menu);
	}
	
	
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {

		//当点击“设置”时，从当前页面跳转到设置页
		if(item.getItemId() == R.id.action_settings){
			Intent intentToSettingActivity= new Intent();
			intentToSettingActivity.setClass(MainActivity.this, SettingActivity.class);
			startActivity(intentToSettingActivity);
			//startActivityForResult(intentToSettingActivity, 1);
		}
		
		//当点击“退出”时，退出app  !!!尚有问题
		if(item.getItemId() == R.id.action_exit){
			System.exit(0);
		}
		// TODO Auto-generated method stub
		return super.onOptionsItemSelected(item);

	}



	//定义内部类，实现“onClickListener”接口，页面上“手动输入”的回调函数为onClick方法
	class iBtnManualInputClickListener implements OnClickListener{

		@SuppressLint("ShowToast")
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			System.out.println("manul input pressed");
			
			Intent intentToManualInputActivity= new Intent();
			//intentToManualInputActivity.putExtra("ipString", ipString);
			intentToManualInputActivity.setClass(MainActivity.this, ManualInputActivity.class);
			startActivity(intentToManualInputActivity);
			
		}
		
	}
	
	class iBtnScanInputClickListener implements OnClickListener{

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			System.out.println("scan input pressed");
			Intent intent = new Intent();
			//intent.putExtra("ipString", ipString);
			intent.setClass(MainActivity.this, MipcaActivityCapture.class);
			//intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			startActivity(intent);
		}
			
	}
		
//	@Override
//    protected void onActivityResult(int requestcode, int resultCode, Intent data) {
//        super.onActivityResult(requestcode, resultCode, data);
//        switch (requestcode) 
//        {
//		case SCANNIN_GREQUEST_CODE://用于判断是哪个activity返回的数据
//			if(resultCode == RESULT_OK)
//			{
//				Bundle bundle = data.getExtras();
//				//显示扫描到的内容，比如一个网址，或者是条码的字符串
//				//mTextView.setText(bundle.getString("result"));
//				//显示二维码的图片
//				//mImageView.setImageBitmap((Bitmap) data.getParcelableExtra("bitmap"));
//				
//			}
//			break;
//		}
//        Bundle bundle = data.getExtras();
//        ipString=bundle.getString("ipString");
//    }	
//	
	
}
