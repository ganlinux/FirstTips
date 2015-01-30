package cn.com.pangutec.ganlinux.firsttips.firsttipsview;

import android.R.integer;
import android.graphics.Color;

/**tips属性
 * @author ganlinux
 *
 */
public class TipsAttr {
	
	private int cursorWith = 0;//箭头宽度
	private int cursorHeight = 0;//箭头长度
	private int cursorSize = 0;//箭头尺寸
	private int cursorColor = 0;//箭头颜色
	private int cursorStart = GlobalAttr.TIPS_CURSOR_START_CENTER_BOTTOM;//箭头开始于目标的位置
	private int cursorEnd = GlobalAttr.TIPS_CURSOR_END_LEFT_TOP;//箭头结束于tip的位置
	
	private String tipsText = "测试";//tip现实的文字
	private int tipsTextSize = 10;//tip的文字大小
	private int tipsColor = 0;//tip的文字颜色
	private int tipsLocation = GlobalAttr.TIPS_LOCATION_BOTTOM_RIGHT;//tip相对于目标的位置
	
	/**只初始化文字内容，其他属性默认
	 * @param tipsText(tip文字内容)
	 */
	public TipsAttr(String tipsText) {
		this.tipsText = tipsText;
	}
	/**只初始化文字内容和相对位置，其他属性默认
	 * @param tipsText(文字内容)
	 * @param tipsLocation(相对于目标的位置)
	 */
	public TipsAttr(String tipsText,int tipsLocation) {
		this.tipsText = tipsText;
		this.tipsLocation = tipsLocation;
	}
	/**初始化文字内容，文字大小，文字颜色，其他属性默认，常用于在某一位置显示tips
	 * @param tipsText文字内容
	 * @param tipsTextSize文字大小
	 * @param tipsColor文字颜色
	 */
	public TipsAttr(String tipsText,int tipsTextSize,int tipsColor) {
		this.tipsText = tipsText;
		this.tipsTextSize = tipsTextSize;
		this.tipsColor = tipsColor;
	}
	
	/**初始化文字内容，文字大小，文字颜色，相对位置,其他属性默认，
	 * @param tipsText文字内容
	 * @param tipsTextSize文字大小
	 * @param tipsColor文字颜色
	 * @param tipsLocation
	 */
	public TipsAttr(String tipsText,int tipsTextSize,int tipsColor,int tipsLocation) {
		this.tipsText = tipsText;
		this.tipsTextSize = tipsTextSize;
		this.tipsColor = tipsColor;
		this.tipsLocation = tipsLocation;
	}
	
	/**初始化文字内容，箭头宽度，箭头长度，箭头大小，箭头颜色，箭头开始位置，箭头结束位置，相对位置,其他属性默认，
	 * @param tipsText
	 * @param cursorWith
	 * @param cursorHeight
	 * @param cursorSize
	 * @param cursorColor
	 * @param cursorStart
	 * @param cursorEnd
	 * @param tipsLocation
	 */
	
	public TipsAttr(String tipsText,int cursorWith,int cursorHeight,int cursorSize,int cursorColor,int cursorStart,int cursorEnd,int tipsLocation) {
		this.tipsText = tipsText;
		this.cursorWith = cursorWith;
		this.cursorHeight = cursorHeight;
		this.cursorSize = cursorSize;
		this.cursorColor = cursorColor;
		this.cursorStart = cursorStart;
		this.cursorEnd = cursorEnd;
		this.tipsLocation = tipsLocation;
	}
	
	/**初始化文字内容，文字大小，文字颜色，箭头宽度，箭头长度，箭头大小，箭头颜色，箭头开始位置，箭头结束位置，相对位置，
	 * @param tipsText
	 * @param tipsTextSize
	 * @param tipsColor
	 * @param cursorWith
	 * @param cursorHeight
	 * @param cursorSize
	 * @param cursorColor
	 * @param cursorStart
	 * @param cursorEnd
	 * @param tipsLocation
	 */
	public TipsAttr(String tipsText,int tipsTextSize,int tipsColor,int cursorWith,int cursorHeight,int cursorSize,int cursorColor,int cursorStart,int cursorEnd,int tipsLocation) {
		this.tipsText = tipsText;
		this.tipsTextSize = tipsTextSize;
		this.tipsColor = tipsColor;
		this.cursorWith = cursorWith;
		this.cursorHeight = cursorHeight;
		this.cursorSize = cursorSize;
		this.cursorColor = cursorColor;
		this.cursorStart = cursorStart;
		this.cursorEnd = cursorEnd;
		this.tipsLocation = tipsLocation;
	}
	
	public int getCursorWith() {
		return cursorWith;
	}
	public int getCursorHeight() {
		return cursorHeight;
	}
	public int getCursorSize() {
		return cursorSize;
	}
	public int getCursorColor() {
		return cursorColor;
	}
	public int getCursorStart() {
		return cursorStart;
	}
	public int getCursorEnd() {
		return cursorEnd;
	}
	public String getTipsText() {
		return tipsText;
	}
	public int getTipsTextSize() {
		return tipsTextSize;
	}
	public int getTipsColor() {
		return tipsColor;
	}
	public int getTipsLocation() {
		return tipsLocation;
	}
	
}
