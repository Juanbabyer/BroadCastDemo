package com.example.administrator.broadcastdemo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Administrator on 2017/1/5.
 */
// 创建自定义View
public class CircleView extends View {
    // 2、制定一些该View的参数   背景色  前景色  角度
    int backgroundColor;
    int color;
    int angle;
    // 1、实现构造函数
    public CircleView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
    // 3、测量布局，对布局进行一些数值的限定
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        // 取宽高的像素值
        int width=MeasureSpec.getSize(widthMeasureSpec);
        int height=MeasureSpec.getSize(heightMeasureSpec);
        // 判断宽高，使其保持正方形
        if(height>width){
            width=height;
        }else{
            width=height;
        }
        // 把宽高数值重新设置
        setMeasuredDimension(width,height);
    }
    // 4、绘画
    @Override
    protected void onDraw(Canvas canvas) {
        // 设置颜色 角度
        backgroundColor= Color.GREEN;
        color=Color.RED;
        angle=90;
        // 调用画笔，进行绘画
        Paint paint=new Paint();
        // 画背景的圆
        paint.setColor(backgroundColor);
        float cx=getWidth()/2;
        float cy=getHeight()/2;
        canvas.drawCircle(cx,cy,100,paint);
        paint.setColor(color);
        canvas.drawText("哈喽",50,50,paint);
    }
}
