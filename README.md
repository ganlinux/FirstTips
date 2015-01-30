# FirstTips
##一个可以让android开发者方便的创建帮助提示界面的sdk
###用法如下：
####1.将库文件FirstTips_1.0_nofont.jar（无字体）或FirstTips_1.0_withfont.jar(有字体)加入你的项目
####2.将TipsImageView加入需要提示的界面配置
        <cn.com.pangutec.ganlinux.firsttips.firsttipsview.TipsImageView
        android:id="@+id/tipsImageView"
        android:layout_width="fill_parent"
        android:layout_height="fill_parent"/>
        最好将界面改为FrameLayout 并将 TipsImageView放于最上层，可以在xml界面中配置或在代码中加入
####3.使用TipsImageView步骤：
        1.创建TipsImageView
		      TipsImageView tipsImageView = (TipsImageView)findViewById(R.id.tipsImageView);

		    2.创建全局属性 ，这里不创建也可以，默认黑色，半透明
		      GlobalAttr elseAttr = new GlobalAttr(Color.BLACK);
		      //设置全局属性
		      tipsImageView.setGlobalAttr(elseAttr);

		    3.为需要的控件生成tip属性
		       TipsAttr backBtnTipsAttr = new TipsAttr("点击这里返回", 50, Color.WHITE, 50, 0, 10, Color.WHITE,          
		       GlobalAttr.TIPS_CURSOR_START_RIGHT, GlobalAttr.TIPS_CURSOR_END_LEFT,GlobalAttr.TIPS_LOCATION_RIGHT);
		    4.提交属性
		       tipsImageView.addTips2View(backButton, backBtnTipsAttr);
		    5.也可为滑动区域生成tip属性
		      TipsAttr slideTipsAttr = new TipsAttr("<---左右滑动--->\n切换类型", 50, Color.WHITE);
		      Rect rect = new Rect(screenWidth/2,screenHeight/2 , 0, 0);
		    6.提交属性
		      tipsImageView.addArea2View(rect,slideTipsAttr);
		   7.监听跳过事件（可选）
		     tipsImageView.setOnSkipActionListener(new OnSkipActionListener() {
			   @Override
			   public void skipTrigger() {
				  // TODO Auto-generated method stub
				  Log.v("tipslog", "skipTrigger");
				  Toast.makeText(MainActivity.this, "捕获了skip事件", Toast.LENGTH_SHORT).show();
			  }
		   });
		8.监听单击事件（可选）
		tipsImageView.setOnTipsClickActionListener(new OnTipsClickActionListener() {

			@Override
			public void clickTrigger() {
				// TODO Auto-generated method stub
				Log.v("tipslog", "clickTrigger");
				Toast.makeText(MainActivity.this, "捕获了点击事件", Toast.LENGTH_SHORT).show();
			}
		});
		9.自此创建完成，以下为显示
		tipsImageView.showTips();
###不懂的可以看demo：
###https://github.com/ganlinux/FirstTipsDemo
##此sdk意在抛砖引玉，如有更好的意见或修改请告知，共同进步
###效果图如下：
![image](https://github.com/ganlinux/FirstTipsDemo/raw/master/FirstTipsDemo/show/demo.jpg)
