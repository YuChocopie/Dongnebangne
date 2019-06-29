package com.yojeumgeosdeul.dong;


import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewTreeObserver;

class GraphView extends View {
    private Paint mLinePaint, mTextPaint;
    
    private float mTextGap;
    private double[] mPoints;
    private int[] mPointX;
    private int[] mPointY;
    private int mUnit, mOrigin, mDivide;
    
    public GraphView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setTypes(context, attrs);
    }
    
    //그래프 옵션을 받는다
    private void setTypes(Context context, AttributeSet attrs) {
        TypedArray types = context.obtainStyledAttributes(attrs, R.styleable.GraphView);
        
        //수치 옵션
        Paint paint = new Paint();
        paint.setColor(types.getColor(R.styleable.GraphView_textColor, getResources().getColor(R.color.green)));
        paint.setTextSize(types.getDimension(R.styleable.GraphView_textSize, 10));
        paint.setTextAlign(Paint.Align.CENTER);
        paint.setStrokeWidth(20f);
        mTextPaint = paint;
        
        //막대와 수치와의 거리
        mTextGap = types.getDimension(R.styleable.GraphView_textGap, 0);
        
        //막대 옵션
        paint = new Paint();
        paint.setColor(types.getColor(R.styleable.GraphView_lineColor, Color.BLACK));
        paint.setStrokeWidth(types.getDimension(R.styleable.GraphView_lineThickness, 0));
        mLinePaint = paint;
    }
    
    //그래프 정보를 받는다
    public void setPoints(double[] points, int unit, int origin, int divide) {
        mPoints = points;   //y축 값 배열
        mUnit = unit;       //y축 단위
        mOrigin = origin;   //y축 원점
        mDivide = divide;   //y축 값 갯수
    }
    
    //그래프를 만든다
    public void draw() {
        int height = getHeight();
        double[] points = mPoints;
        
        //x축 막대 사이의 거리
        float gapx = (float) getWidth() / points.length;
        
        //y축 단위 사이의 거리
        float gapy = (float) (height / (mDivide*1.2));
        
        float halfgab = gapx / 2;
        
        int length = points.length;
        mPointX = new int[length];
        mPointY = new int[length];
        
        for (int i = 0; i < length; i++) {
            //막대 좌표를 구한다
            int x = (int) (halfgab + (i * gapx));
            int y = (int) (height - (((points[i] / mUnit*0.8) - mOrigin) * gapy));
    
            mPointX[i] = x;
            mPointY[i] = y;
        }
    }
    
    //그래프를 그린다(onCreate 등에서 호출시)
    public void drawForBeforeDrawView() {
        //뷰의 크기를 계산하여 그래프를 그리기 때문에 뷰가 실제로 만들어진 시점에서 함수를 호출해 준다
        getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                draw();
        
                if (Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN)
                    getViewTreeObserver().removeGlobalOnLayoutListener(this);
                else
                    getViewTreeObserver().removeOnGlobalLayoutListener(this);
            }
        });
    }
    
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        
        if (mPointX != null && mPointY != null) {
            int length = mPointX.length;
    
            int bottom = getHeight();
            for (int i = 0; i < length; i++) {
                int x = mPointX[i];
                int y = mPointY[i];
        
                //믹대 위 수치를 쓴다
                canvas.drawText("" + mPoints[i], x, y - mTextGap, mTextPaint);
        
                //믹대를 그린다
                canvas.drawLine(x, y, x, bottom, mLinePaint);
            }
        }
    }
    
}
        
