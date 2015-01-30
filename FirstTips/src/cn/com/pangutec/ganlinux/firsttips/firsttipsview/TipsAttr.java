package cn.com.pangutec.ganlinux.firsttips.firsttipsview;

import android.R.integer;
import android.graphics.Color;

/**tips����
 * @author ganlinux
 *
 */
public class TipsAttr {
	
	private int cursorWith = 0;//��ͷ���
	private int cursorHeight = 0;//��ͷ����
	private int cursorSize = 0;//��ͷ�ߴ�
	private int cursorColor = 0;//��ͷ��ɫ
	private int cursorStart = GlobalAttr.TIPS_CURSOR_START_CENTER_BOTTOM;//��ͷ��ʼ��Ŀ���λ��
	private int cursorEnd = GlobalAttr.TIPS_CURSOR_END_LEFT_TOP;//��ͷ������tip��λ��
	
	private String tipsText = "����";//tip��ʵ������
	private int tipsTextSize = 10;//tip�����ִ�С
	private int tipsColor = 0;//tip��������ɫ
	private int tipsLocation = GlobalAttr.TIPS_LOCATION_BOTTOM_RIGHT;//tip�����Ŀ���λ��
	
	/**ֻ��ʼ���������ݣ���������Ĭ��
	 * @param tipsText(tip��������)
	 */
	public TipsAttr(String tipsText) {
		this.tipsText = tipsText;
	}
	/**ֻ��ʼ���������ݺ����λ�ã���������Ĭ��
	 * @param tipsText(��������)
	 * @param tipsLocation(�����Ŀ���λ��)
	 */
	public TipsAttr(String tipsText,int tipsLocation) {
		this.tipsText = tipsText;
		this.tipsLocation = tipsLocation;
	}
	/**��ʼ���������ݣ����ִ�С��������ɫ����������Ĭ�ϣ���������ĳһλ����ʾtips
	 * @param tipsText��������
	 * @param tipsTextSize���ִ�С
	 * @param tipsColor������ɫ
	 */
	public TipsAttr(String tipsText,int tipsTextSize,int tipsColor) {
		this.tipsText = tipsText;
		this.tipsTextSize = tipsTextSize;
		this.tipsColor = tipsColor;
	}
	
	/**��ʼ���������ݣ����ִ�С��������ɫ�����λ��,��������Ĭ�ϣ�
	 * @param tipsText��������
	 * @param tipsTextSize���ִ�С
	 * @param tipsColor������ɫ
	 * @param tipsLocation
	 */
	public TipsAttr(String tipsText,int tipsTextSize,int tipsColor,int tipsLocation) {
		this.tipsText = tipsText;
		this.tipsTextSize = tipsTextSize;
		this.tipsColor = tipsColor;
		this.tipsLocation = tipsLocation;
	}
	
	/**��ʼ���������ݣ���ͷ��ȣ���ͷ���ȣ���ͷ��С����ͷ��ɫ����ͷ��ʼλ�ã���ͷ����λ�ã����λ��,��������Ĭ�ϣ�
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
	
	/**��ʼ���������ݣ����ִ�С��������ɫ����ͷ��ȣ���ͷ���ȣ���ͷ��С����ͷ��ɫ����ͷ��ʼλ�ã���ͷ����λ�ã����λ�ã�
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
