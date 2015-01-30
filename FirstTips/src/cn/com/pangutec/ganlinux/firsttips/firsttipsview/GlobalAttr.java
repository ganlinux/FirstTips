package cn.com.pangutec.ganlinux.firsttips.firsttipsview;

import android.R.integer;
import android.graphics.Color;

/**ȫ������
 * @author ganlinux
 *
 */ 
public class GlobalAttr {
	//��ͷָʾ�ӡ�Ŀ��ؼ�����ʼ��λ�ã�Ĭ��ֵΪ0=TIPS_CURSOR_START_CENTER_BOTTOM
	public static final int TIPS_CURSOR_START_CENTER_BOTTOM = 0;//��ʾ��Ŀ��ؼ����·�����λ�ÿ�ʼ
	public static final int TIPS_CURSOR_START_CENTER_TOP = 1;//��ʾ��Ŀ��ؼ����Ϸ�����λ�ÿ�ʼ
	public static final int TIPS_CURSOR_START_RIGHT_TOP = 2;//��ʾ��Ŀ��ؼ����Ϸ��ұ�λ�ÿ�ʼ
	public static final int TIPS_CURSOR_START_LEFT_TOP = 3;//��ʾ��Ŀ��ؼ����Ϸ����λ�ÿ�ʼ
	public static final int TIPS_CURSOR_START_RIGHT_BOTTOM = 4;//��ʾ��Ŀ��ؼ����·��ұ�λ�ÿ�ʼ
	public static final int TIPS_CURSOR_START_LEFT_BOTTOM = 5;//��ʾ��Ŀ��ؼ����·����λ�ÿ�ʼ
	public static final int TIPS_CURSOR_START_LEFT = 6;//��ʾ��Ŀ��ؼ���߾���λ�ÿ�ʼ
	public static final int TIPS_CURSOR_START_RIGHT = 7;//��ʾ��Ŀ��ؼ���߾���λ�ÿ�ʼ
	//��ͷ����λ����tips������λ�ã�Ĭ��ֵΪ0=TIPS_CURSOR_END_LEFT_TOP
	public static final int TIPS_CURSOR_END_CENTER_BOTTOM = 0;//��ʾ��tip�����·�����λ�ý���
	public static final int TIPS_CURSOR_END_CENTER_TOP = 1;//��ʾ��tip�����Ϸ�����λ�ý���
	public static final int TIPS_CURSOR_END_RIGHT_TOP = 2;//��ʾ��tip�����Ϸ��ұ�λ�ý���
	public static final int TIPS_CURSOR_END_LEFT_TOP = 3;//��ʾ��tip�����Ϸ����λ�ý���
	public static final int TIPS_CURSOR_END_RIGHT_BOTTOM = 4;//��ʾ��tip�����·��ұ�λ�ý���
	public static final int TIPS_CURSOR_END_LEFT_BOTTOM = 5;//��ʾ��tip�����·����λ�ý���
	public static final int TIPS_CURSOR_END_LEFT = 6;//��ʾ��tip����߾���λ�ý���
	public static final int TIPS_CURSOR_END_RIGHT = 7;//��ʾ��tip���ұ߾���λ�ý���
	//��ʾtip�����Ŀ��ؼ���λ�ã�Ĭ��0=TIPS_LOCATION_BOTTOM_RIGHT
	public static final int TIPS_LOCATION_TOP = 0;//��ʾtip��Ŀ����Ϸ�
	public static final int TIPS_LOCATION_BOTTOM = 1;//��ʾtip��Ŀ����·�
	public static final int TIPS_LOCATION_LEFT = 2;//��ʾtip��Ŀ�������
	public static final int TIPS_LOCATION_RIGHT = 3;//��ʾtip��Ŀ�������
	public static final int TIPS_LOCATION_TOP_LEFT = 4;//��ʾtip��Ŀ������Ϸ�
	public static final int TIPS_LOCATION_TOP_RIGHT = 5;//��ʾtip��Ŀ������Ϸ�
	public static final int TIPS_LOCATION_BOTTOM_LEFT = 6;//��ʾtip��Ŀ������·�
	public static final int TIPS_LOCATION_BOTTOM_RIGHT = 7;//��ʾtip��Ŀ������·�
	//�Զ����������Ϣ
	public static final String CUSTOM_FONT_NAME="tips_font.ttf";//�Զ�����������
	public static final String CUSTOM_FONT_DIR="fonts/tips_font.ttf";//�Զ�������Ŀ¼
	//������ɫ
	private int bgColor = Color.BLACK;
	
	public GlobalAttr(int bgColor) {
		this.bgColor = bgColor;
	}
	//��ȡ������ɫ
	public int getBgColor() {
		return bgColor;
	}
	//���ñ�����ɫ
	public void setBgColor(int bgColor) {
		this.bgColor = bgColor;
	}
}
