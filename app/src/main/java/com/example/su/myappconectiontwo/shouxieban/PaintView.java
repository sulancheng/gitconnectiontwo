package com.example.su.myappconectiontwo.shouxieban;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by su
 * on 2017/5/25.
 */
public class PaintView extends View {
    private Paint mPaint;
    private Path mPath;
    private Bitmap mBitmap;
    private Canvas mCanvas;

    //private int screenWidth, screenHeight;
    private float currentX, currentY;
    private Bitmap copybm;
    private Bitmap srcbm;

    public PaintView(Context context) {
        this(context,null);
    }

    public PaintView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public PaintView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }
    private void init() {
        mPaint = new Paint();
        mPaint.setAntiAlias(true); // 去除锯齿
        mPaint.setStrokeWidth(5);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setColor(Color.BLACK);

        mPath = new Path();
        //srcbm = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher);

//      mCanvas.drawColor(Color.WHITE);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int width = measureWidth(widthMeasureSpec);
        int height = measureHeight(heightMeasureSpec);
        // 设置最终的测量结果
        setMeasuredDimension(width, height);
    }
    private int measureHeight(int heightMeasureSpec) {
        int result = 0;
        int mode = MeasureSpec.getMode(heightMeasureSpec);
        int size = MeasureSpec.getSize(heightMeasureSpec);
        switch (mode) {
            case MeasureSpec.UNSPECIFIED:
                //result=dashBoard.getHeight();
                result=size;
                break;
            case MeasureSpec.EXACTLY:
                result=size;
                break;
            case MeasureSpec.AT_MOST:
                result=size;
                //result=Math.min(size, dashBoard.getHeight());
                break;

            default:
                break;
        }

        return result;
    }

    private int measureWidth(int widthMeasureSpec) {
        int mode = MeasureSpec.getMode(widthMeasureSpec);
        // 获取后三十位的值
        int size = MeasureSpec.getSize(widthMeasureSpec);
        int result = 0;
        Log.i("test", "size:" + size);
        switch (mode) {
            case MeasureSpec.UNSPECIFIED:
                result = size;
                //result = dashBoard.getWidth();//获得控件本身的宽
                break;
            case MeasureSpec.EXACTLY://matchparent和一个确切的数
                result = size;
                break;
            case MeasureSpec.AT_MOST://wropparent
                // 当子类的layoutparams传入wrap_content
                result = size;
                //int width = dashBoard.getWidth();
                //result = Math.min(width, size);
                break;

            default:
                break;
        }
        return result;
    }
    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        Log.i("onSizeChanged","我尺寸改变了");
        mBitmap = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
        mCanvas = new Canvas(mBitmap);
//        Matrix matrix=new Matrix();
//        Paint paint=new Paint();
//        mCanvas.drawBitmap(srcbm, matrix, paint);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawBitmap(mBitmap, 0, 0, null);
        canvas.drawPath(mPath, mPaint);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float x = event.getX();
        float y = event.getY();

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                currentX = x;
                currentY = y;
                mPath.moveTo(currentX, currentY);//起始点
                break;
            case MotionEvent.ACTION_MOVE:
                currentX = x;
                currentY = y;
                //如果没有使用moveTo指定起点，起点默认为(0,0)，即(0,0)到(x1,y1)之间绘制贝塞尔曲线，(x1,y1)到(x2,y2)之间绘制贝塞尔曲线。
                mPath.quadTo(currentX, currentY, x, y); // 画线，根据两个控制点绘制贝塞尔曲线。如
                break;
            case MotionEvent.ACTION_UP:
                //mCanvas.drawPath(mPath, mPaint);//要不要无所谓
                break;
        }
        invalidate();
        return true;
    }

    public Bitmap getPaintBitmap() {//提供给外界保存用
        return resizeImage(mBitmap, 320, 480);
    }

    public Path getPath() {//用于判断
//        if (mPaintView.getPath().isEmpty()) {
//            Toast.makeText(mContext, "请写下你的大名", Toast.LENGTH_SHORT).show();
//            return;
//        }
        return mPath;
    }

    // 缩放
    public static Bitmap resizeImage(Bitmap bitmap, int width, int height) {
        int originWidth = bitmap.getWidth();
        int originHeight = bitmap.getHeight();

        float scaleWidth = ((float) width) / originWidth;
        float scaleHeight = ((float) height) / originHeight;

        Matrix matrix = new Matrix();
        matrix.postScale(scaleWidth, scaleHeight);
        Bitmap resizedBitmap = Bitmap.createBitmap(bitmap, 0, 0, originWidth,
                originHeight, matrix, true);
        return resizedBitmap;
    }

    //清除画板
    public void clear() {
        if (mCanvas != null) {
            mPath.reset();
            mCanvas.drawColor(Color.TRANSPARENT, PorterDuff.Mode.CLEAR);
            invalidate();
        }
    }

}
