package cn.com.pangutec.ganlinux.firsttips.firsttipsview;

import android.R.integer;
import android.graphics.Color;

/**全局属性
 * @author ganlinux
 *
 */ 
public class GlobalAttr {
	//箭头指示从“目标控件”开始的位置，默认值为0=TIPS_CURSOR_START_CENTER_BOTTOM
	public static final int TIPS_CURSOR_START_CENTER_BOTTOM = 0;//表示从目标控件最下方居中位置开始
	public static final int TIPS_CURSOR_START_CENTER_TOP = 1;//表示从目标控件最上方居中位置开始
	public static final int TIPS_CURSOR_START_RIGHT_TOP = 2;//表示从目标控件最上方右边位置开始
	public static final int TIPS_CURSOR_START_LEFT_TOP = 3;//表示从目标控件最上方左边位置开始
	public static final int TIPS_CURSOR_START_RIGHT_BOTTOM = 4;//表示从目标控件最下方右边位置开始
	public static final int TIPS_CURSOR_START_LEFT_BOTTOM = 5;//表示从目标控件最下方左边位置开始
	public static final int TIPS_CURSOR_START_LEFT = 6;//表示从目标控件左边居中位置开始
	public static final int TIPS_CURSOR_START_RIGHT = 7;//表示从目标控件左边居中位置开始
	//箭头结束位置在tips结束的位置，默认值为0=TIPS_CURSOR_END_LEFT_TOP
	public static final int TIPS_CURSOR_END_CENTER_BOTTOM = 0;//表示在tip的最下方居中位置结束
	public static final int TIPS_CURSOR_END_CENTER_TOP = 1;//表示在tip的最上方居中位置结束
	public static final int TIPS_CURSOR_END_RIGHT_TOP = 2;//表示在tip的最上方右边位置结束
	public static final int TIPS_CURSOR_END_LEFT_TOP = 3;//表示在tip的最上方左边位置结束
	public static final int TIPS_CURSOR_END_RIGHT_BOTTOM = 4;//表示在tip的最下方右边位置结束
	public static final int TIPS_CURSOR_END_LEFT_BOTTOM = 5;//表示在tip的最下方左边位置结束
	public static final int TIPS_CURSOR_END_LEFT = 6;//表示在tip的左边居中位置结束
	public static final int TIPS_CURSOR_END_RIGHT = 7;//表示在tip的右边居中位置结束
	//表示tip相对于目标控件的位置，默认0=TIPS_LOCATION_BOTTOM_RIGHT
	public static final int TIPS_LOCATION_TOP = 0;//表示tip在目标的上方
	public static final int TIPS_LOCATION_BOTTOM = 1;//表示tip在目标的下方
	public static final int TIPS_LOCATION_LEFT = 2;//表示tip在目标的左面
	public static final int TIPS_LOCATION_RIGHT = 3;//表示tip在目标的右面
	public static final int TIPS_LOCATION_TOP_LEFT = 4;//表示tip在目标的左上方
	public static final int TIPS_LOCATION_TOP_RIGHT = 5;//表示tip在目标的右上方
	public static final int TIPS_LOCATION_BOTTOM_LEFT = 6;//表示tip在目标的左下方
	public static final int TIPS_LOCATION_BOTTOM_RIGHT = 7;//表示tip在目标的右下方
	//自定义字体的信息
	public static final String CUSTOM_FONT_NAME="tips_font.ttf";//自定义字体名字
	public static final String CUSTOM_FONT_DIR="fonts/tips_font.ttf";//自定义字体目录
	//背景颜色
	private int bgColor = Color.BLACK;
	
	public GlobalAttr(int bgColor) {
		this.bgColor = bgColor;
	}
	//获取背景颜色
	public int getBgColor() {
		return bgColor;
	}
	//设置背景颜色
	public void setBgColor(int bgColor) {
		this.bgColor = bgColor;
	}
}
