package cn.com.pangutec.ganlinux.firsttips.firsttipsview;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import cn.com.pangutec.ganlinux.firsttips.R;
import android.R.integer;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

/**tip���ؼ���������ʾ��ʾ��Ϣ�������û���һ�����������
 * @author ganlinux
 *
 */
public class TipsImageView extends ImageView{
	private Context mContext;//����������

	private float xIn,yIn,xOut,yOut;//��¼�������� �� ���������ֵ
	private Rect skipreRect = null;//��¼ skip������
	private OnSkipActionListener skipActionListener = null;//skip�Ķ���������
	private OnTipsClickActionListener clickActionListener = null;//������¼�������

	private boolean canShow = false;//�Ƿ���ʾ
	private GlobalAttr globalAttr = null;//ȫ�ֲ���
	private HashMap<View, TipsAttr> viewsTips = new HashMap<View, TipsAttr>();//�ؼ���tips����
	private HashMap<Rect, TipsAttr> areaTips = new HashMap<Rect, TipsAttr>();//�����tips����
	public TipsImageView(Context context) {
		super(context);
		mContext = context;
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param context
	 * @param attrs
	 */
	public TipsImageView(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
		mContext = context;
	}

	/**
	 * @param context
	 * @param attrs
	 * @param defStyleAttr
	 */
	public TipsImageView(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		// TODO Auto-generated constructor stub
		mContext = context;
	}

	/**����ȫ�ֲ���
	 * @param elseAttr
	 */
	public void setGlobalAttr(GlobalAttr globalAttr) {

		this.globalAttr = globalAttr;

	}

	/**
	 * Ӧ��ȫ�ֲ���
	 */
	public void applyGlobalAttr(Paint mBackgroundPaint) {
		if (globalAttr != null) {
			mBackgroundPaint.setColor(globalAttr.getBgColor());
			mBackgroundPaint.setStyle(Paint.Style.FILL);
			mBackgroundPaint.setAlpha(200);
		}else {
			mBackgroundPaint.setColor(Color.BLACK);
			mBackgroundPaint.setStyle(Paint.Style.FILL);
			mBackgroundPaint.setAlpha(200);
		}
	}

	/**Ϊ��ͼ����tips
	 * @param currentView
	 * @param tipsAttr
	 */
	public void addTips2View(View currentView,TipsAttr tipsAttr) {
		viewsTips.put(currentView, tipsAttr);
	}
	/**Ϊ��ͼ��������
	 * @param rect
	 * @param tipsAttr
	 */
	public void addArea2View(Rect rect,TipsAttr tipsAttr) {
		areaTips.put(rect, tipsAttr);
	}
	/**
	 * ��ʾtips
	 */
	public void showTips() {
		canShow = true;
	}
	/**
	 * �ر���ʾtips
	 */
	public void closeTips() {
		this.setVisibility(View.INVISIBLE);
	}

	/* 1.������
	 * 2.���ؼ�tips
	 *   2.1���ؼ�����Բ��
	 *   2.2����ͷָʾ
	 *   2.3дtips����
	 * 3.������tips
	 * 	 3.1дtips����
	 * 4.��skipͼ
	 * @see android.widget.ImageView#onDraw(android.graphics.Canvas)
	 */
	@SuppressLint("NewApi")
	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		if (canShow) {
			if (getDrawable() == null) 
			{
				//ָʾ��ʼ����
				float cursorStartX = 0;
				float cursorStartY = 0;
				//ָʾ��������
				float cursorEndX = 0;
				float cursorEndY = 0;
				//tips����
				float tips_x = 0;
				float tips_y = 0;
				//��ʼ������
				Paint mBackgroundPaint  = new Paint(Paint.ANTI_ALIAS_FLAG);
				Paint mOvalPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
				Paint mSkipPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
				Paint mCursorPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
				//�鿴��û���Զ�������
				boolean hasCustomFont = bAssetsFile(GlobalAttr.CUSTOM_FONT_NAME);

				//�Ȼ�����  �ñ�����������
				applyGlobalAttr(mBackgroundPaint);
				canvas.drawRect(new Rect(0, 0, getWidth(), getHeight()), mBackgroundPaint);
				//�����û�пؼ�tips����
				if (!viewsTips.isEmpty()) {
					//�ؼ�tips�ĵ�����
					Iterator view_iter = viewsTips.entrySet().iterator();
					while (view_iter.hasNext()) {
						Map.Entry entry = (Map.Entry) view_iter.next();
						View currentView = (View)entry.getKey();
						TipsAttr tipsAttr = (TipsAttr) entry.getValue();
						//tips������ȡ
						String tipsString = tipsAttr.getTipsText();
						int tipsTextSize = tipsAttr.getTipsTextSize();
						int tipsColor = tipsAttr.getTipsColor();
						int cursorWith = tipsAttr.getCursorWith();
						int cursorHeight = tipsAttr.getCursorHeight();
						int cursorSize = tipsAttr.getCursorSize();
						int cursorColor = tipsAttr.getCursorColor();
						int cursorStart = tipsAttr.getCursorStart();
						int cursorEnd = tipsAttr.getCursorEnd();
						int cursorLocation = tipsAttr.getTipsLocation();
						//�洢Ŀ��view ����
						int[] location = new int[2];
						currentView.getLocationOnScreen(location);
						location[1]-= getStatusBarHeight();
						//����Բ����
						RectF re3 = new RectF(location[0], location[1], location[0]+currentView.getWidth(), location[1]+currentView.getHeight());  
						mOvalPaint.setAntiAlias(true);  
						mOvalPaint.setColor(Color.WHITE);  
						mOvalPaint.setStyle(Paint.Style.STROKE);//����Ϊ����  
						mOvalPaint.setStrokeWidth(5); 
						canvas.drawOval(re3, mOvalPaint);
						//����ͷָʾ
						mCursorPaint.setColor(cursorColor);
						mCursorPaint.setStrokeWidth(cursorSize);
						mCursorPaint.setAntiAlias(true);//�����
						mCursorPaint.setStyle(Paint.Style.FILL_AND_STROKE);
						mCursorPaint.setStrokeCap(Cap.ROUND);
						switch (cursorStart) {
						case GlobalAttr.TIPS_CURSOR_START_CENTER_BOTTOM:
							cursorStartX =  currentView.getWidth()/2+location[0];
							cursorStartY = currentView.getHeight()+location[1];
							break;
						case GlobalAttr.TIPS_CURSOR_START_CENTER_TOP:
							cursorStartX = currentView.getWidth()/2+location[0];
							cursorStartY = location[1];
							break;
						case GlobalAttr.TIPS_CURSOR_START_RIGHT_TOP:
							cursorStartX = currentView.getWidth()+location[0];
							cursorStartY = location[1];
							break;
						case GlobalAttr.TIPS_CURSOR_START_LEFT_TOP:
							cursorStartX = location[0];
							cursorStartY = location[1];
							break;
						case GlobalAttr.TIPS_CURSOR_START_RIGHT_BOTTOM:
							cursorStartX = currentView.getWidth()+location[0];
							cursorStartY = currentView.getHeight()+location[1];
							break;
						case GlobalAttr.TIPS_CURSOR_START_LEFT_BOTTOM:
							cursorStartX = location[0];
							cursorStartY = currentView.getHeight()+location[1];
							break;
						case GlobalAttr.TIPS_CURSOR_START_LEFT:
							cursorStartX = location[0];
							cursorStartY = currentView.getHeight()/2+location[1];
							break;
						case GlobalAttr.TIPS_CURSOR_START_RIGHT:
							cursorStartX = currentView.getWidth()+location[0];
							cursorStartY = currentView.getHeight()/2+location[1];
							break;
						default:
							break;
						}
						switch (cursorLocation) {
						case GlobalAttr.TIPS_LOCATION_TOP://tip����
							cursorEndX =  cursorStartX;
							cursorEndY = cursorStartY - cursorHeight;
							break;
						case GlobalAttr.TIPS_LOCATION_BOTTOM://tip����
							cursorEndX =  cursorStartX;
							cursorEndY = cursorStartY + cursorHeight;
							break;
						case GlobalAttr.TIPS_LOCATION_LEFT://tip����
							cursorEndX =  cursorStartX - cursorWith;
							cursorEndY = cursorStartY;
							break;
						case GlobalAttr.TIPS_LOCATION_RIGHT:
							cursorEndX =  cursorStartX + cursorWith;
							cursorEndY = cursorStartY;
							break;
						case GlobalAttr.TIPS_LOCATION_TOP_LEFT:
							cursorEndX =  cursorStartX - cursorWith;
							cursorEndY = cursorStartY - cursorHeight;
							break;
						case GlobalAttr.TIPS_LOCATION_TOP_RIGHT:
							cursorEndX =  cursorStartX + cursorWith;
							cursorEndY = cursorStartY - cursorHeight;
							break;
						case GlobalAttr.TIPS_LOCATION_BOTTOM_LEFT:
							cursorEndX =  cursorStartX - cursorWith;
							cursorEndY = cursorStartY + cursorHeight;
							break;
						case GlobalAttr.TIPS_LOCATION_BOTTOM_RIGHT:
							cursorEndX =  cursorStartX + cursorWith;
							cursorEndY = cursorStartY + cursorHeight;
							break;
						default:
							break;
						}
						//����ͷָʾ
						drawAL(canvas,(int)(cursorStartX), (int)cursorStartY, (int)cursorEndX, (int)cursorEndY,mCursorPaint);
						//��tips����
						TextPaint textPaint = new TextPaint(); 
						textPaint.setColor(tipsColor); 
						textPaint.setTextSize(tipsTextSize);  
						textPaint.setAntiAlias(true);  
						StaticLayout layout = new StaticLayout(tipsString, textPaint, 400,  
								Alignment.ALIGN_NORMAL, 0.8F, 0.0F, true);
						float textWidth1 = layout.getWidth();
						float textHeight1 = layout.getHeight();
						//ͨ��ָʾ���������� ����λ��
						switch (cursorEnd) {
						case GlobalAttr.TIPS_CURSOR_END_CENTER_BOTTOM:
							tips_x =  cursorEndX-textWidth1/2;
							tips_y = cursorEndY - textHeight1;
							break;
						case GlobalAttr.TIPS_CURSOR_END_CENTER_TOP:
							tips_x =  cursorEndX-textWidth1/2;
							tips_y = cursorEndY ;
							break;
						case GlobalAttr.TIPS_CURSOR_END_RIGHT_TOP:
							tips_x =  cursorEndX+textWidth1;
							tips_y = cursorEndY ;
							break;
						case GlobalAttr.TIPS_CURSOR_END_LEFT_TOP:
							tips_x =  cursorEndX;
							tips_y = cursorEndY ;
							break;
						case GlobalAttr.TIPS_CURSOR_END_RIGHT_BOTTOM:
							tips_x =  cursorEndX - textWidth1;
							tips_y = cursorEndY - textHeight1;
							break;
						case GlobalAttr.TIPS_CURSOR_END_LEFT_BOTTOM:
							tips_x =  cursorEndX;
							tips_y = cursorEndY - textHeight1;
							break;
						case GlobalAttr.TIPS_CURSOR_END_RIGHT:
							tips_x =  cursorEndX - textWidth1;
							tips_y = cursorEndY - textHeight1/2;
							break;
						case GlobalAttr.TIPS_CURSOR_END_LEFT:
							tips_x =  cursorEndX;
							tips_y = cursorEndY - textHeight1/2;
							break;
						default:
							break;
						}
						//��������
						if (hasCustomFont) {
							Typeface typeFace =Typeface.createFromAsset(mContext.getAssets(),GlobalAttr.CUSTOM_FONT_DIR);
							if (!(typeFace == null)) {
								textPaint.setTypeface(typeFace);
							}
						}
						canvas.save();  
						canvas.translate(tips_x, tips_y);//��20��20��ʼ��  
						layout.draw(canvas);  
						canvas.restore();//������restore

					}
				}

				//�����û������tips����
				if (!areaTips.isEmpty()) {
					Iterator view_iter = areaTips.entrySet().iterator();
					while (view_iter.hasNext()) {
						Map.Entry entry = (Map.Entry) view_iter.next();
						Rect currentRect = (Rect)entry.getKey();
						TipsAttr tipsAttr = (TipsAttr) entry.getValue();

						String tipsString = tipsAttr.getTipsText();
						int tipsTextSize = tipsAttr.getTipsTextSize();
						int tipsColor = tipsAttr.getTipsColor();

						//��tips����
						TextPaint textPaint = new TextPaint(); 
						textPaint.setColor(tipsColor); 
						textPaint.setTextSize(tipsTextSize);  
						textPaint.setAntiAlias(true);  
						StaticLayout layout = new StaticLayout(tipsString, textPaint, 500,  
								Alignment.ALIGN_CENTER, 0.8F, 0.0F, true);
						float textWidth = layout.getWidth();
						float textHeight = layout.getHeight();
						//ͨ��ָʾ���������� ����λ��
						tips_x =  currentRect.left - textWidth/2;
						tips_y = currentRect.top - textHeight/2;
						if (hasCustomFont) {
							Typeface typeFace =Typeface.createFromAsset(mContext.getAssets(),GlobalAttr.CUSTOM_FONT_DIR);
							if (!(typeFace == null)) {
								textPaint.setTypeface(typeFace);
							}
						}
						canvas.save();  
						canvas.translate(tips_x, tips_y);//��20��20��ʼ��  
						layout.draw(canvas);  
						canvas.restore();//������restore

					}
				}


				//�� skip
				Bitmap mBitmap = null;
				try {
					mBitmap = BitmapFactory.decodeStream(mContext.getAssets().open("skip.png"));
					float mX = getWidth() - mBitmap.getWidth();
					float mY = getHeight() - mBitmap.getHeight();
					if (skipreRect == null) {
						skipreRect = new Rect((int)mX, (int)mY, getWidth(), getHeight());
					}
					canvas.drawBitmap(mBitmap, mX, mY, mSkipPaint);
					mBitmap.recycle();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		}
	}
	/**
	 * ����ͷָʾ
	 * @param sx
	 * @param sy
	 * @param ex
	 * @param ey
	 */
	public void drawAL(Canvas canvas,int sx, int sy, int ex, int ey,Paint mCursorPaint)
	{

		double H = 8; // ��ͷ�߶�   
		double L = 3.5; // �ױߵ�һ��   
		int x3 = 0;
		int y3 = 0;
		int x4 = 0;
		int y4 = 0;
		double awrad = Math.atan(L / H); // ��ͷ�Ƕ�   
		double arraow_len = Math.sqrt(L * L + H * H); // ��ͷ�ĳ���   
		double[] arrXY_1 = rotateVec(ex - sx, ey - sy, awrad, true, arraow_len);
		double[] arrXY_2 = rotateVec(ex - sx, ey - sy, -awrad, true, arraow_len);
		double x_3 = ex - arrXY_1[0]; // (x3,y3)�ǵ�һ�˵�   
		double y_3 = ey - arrXY_1[1];
		double x_4 = ex - arrXY_2[0]; // (x4,y4)�ǵڶ��˵�   
		double y_4 = ey - arrXY_2[1];
		Double X3 = new Double(x_3);
		x3 = X3.intValue();
		Double Y3 = new Double(y_3);
		y3 = Y3.intValue();
		Double X4 = new Double(x_4);
		x4 = X4.intValue();
		Double Y4 = new Double(y_4);
		y4 = Y4.intValue();
		// ����   
		canvas.drawLine(sx, sy, ex, ey,mCursorPaint);
		Path triangle = new Path();
		triangle.moveTo(ex, ey);
		triangle.lineTo(x3, y3);  
		triangle.lineTo(x4, y4); 
		triangle.close();
		canvas.drawPath(triangle,mCursorPaint);

	}
	// ���� �Ƕ�
	public double[] rotateVec(int px, int py, double ang, boolean isChLen, double newLen)
	{
		double mathstr[] = new double[2];
		// ʸ����ת��������������ֱ���x������y��������ת�ǡ��Ƿ�ı䳤�ȡ��³���   
		double vx = px * Math.cos(ang) - py * Math.sin(ang);
		double vy = px * Math.sin(ang) + py * Math.cos(ang);
		if (isChLen) {
			double d = Math.sqrt(vx * vx + vy * vy);
			vx = vx / d * newLen;
			vy = vy / d * newLen;
			mathstr[0] = vx;
			mathstr[1] = vy;
		}
		return mathstr;
	}
	/**��assetsd/fonts����û���Զ�������
	 * @param pt
	 * @return
	 */
	private boolean bAssetsFile(String pt){
		AssetManager am = mContext.getAssets();
		try {
			String[] names = am.list("fonts");           
			for(int i=0;i<names.length;i++){
				if(names[i].equals(pt.trim())){
					return true;
				}else{
					//System.out.println(pt+"����������������");
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	// Ϊÿ���ӿ����ü�����
	public void setOnSkipActionListener(OnSkipActionListener skip) {
		this.skipActionListener = skip;
	}
	// ���������ӿ�
	public interface OnSkipActionListener {
		public void skipTrigger();
	}
	// Ϊÿ���ӿ����ü�����
	public void setOnTipsClickActionListener(OnTipsClickActionListener click) {
		this.clickActionListener = click;
	}
	// ���������ӿ�
	public interface OnTipsClickActionListener {
		public void clickTrigger();
	}
	@Override  
	public boolean onTouchEvent(MotionEvent event) {  
		switch (event.getAction()) {
		case MotionEvent.ACTION_DOWN:
			// ��ָ����ʱ��¼��Ҫ����,�������ֵ����Ҫ��ȥ״̬���߶�
			xIn = event.getX();
			yIn = event.getY();
			break;
		case MotionEvent.ACTION_UP:
			xOut = event.getX();
			yOut = event.getY();
			if (xIn == xOut && yIn == yOut) {
				if (!checkIsSkipArea((int)xOut, (int)yOut)) {
					if (clickActionListener!=null) {
						clickActionListener.clickTrigger();
					}

				}
			}else{
				//�϶�
			}
			break;
		default:
			break;
		}
		return true;
	}
	/**����Ƿ���skip����
	 * @param x
	 * @param y
	 * @return
	 */
	public boolean checkIsSkipArea(int x,int y) {
		if (skipreRect.contains(x, y)) {

			if (skipActionListener!=null) {
				skipActionListener.skipTrigger();
			}

			closeTips();
			return true;
		}
		return false;

	}
	/**
	 * ���ڻ�ȡ״̬���ĸ߶ȡ�
	 * 
	 * @return ����״̬���߶ȵ�����ֵ��
	 */
	private int getStatusBarHeight() {
		int statusBarHeight = 0;
		if (statusBarHeight == 0) {
			try {
				Class<?> c = Class.forName("com.android.internal.R$dimen");
				Object o = c.newInstance();
				Field field = c.getField("status_bar_height");
				int x = (Integer) field.get(o);
				statusBarHeight = getResources().getDimensionPixelSize(x);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return statusBarHeight;
	}
}
