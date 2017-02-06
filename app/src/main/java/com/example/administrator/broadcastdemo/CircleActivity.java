package com.example.administrator.broadcastdemo;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;

public class CircleActivity extends AppCompatActivity {
    ImageView iv_animation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_circle);
        iv_animation= (ImageView) findViewById(R.id.iv_animation);
    }
    public void onClick(View view){
        // 让紫色图片动起来，向右移动30像素
       final float x=iv_animation.getX();// 获取当前x轴坐标
//        float targetX=x + 30; // 获取目标x 轴坐标
//        float targetX1=x+90;
//        float targetX2=x+180;
        final float y=iv_animation.getY();
        // 创建属性动画： 该View必须有成对出现的get/set方法
   //     ObjectAnimator objectAnimator=ObjectAnimator.ofFloat(iv_animation,"x",targetX,targetX1,targetX2);
        ObjectAnimator objectAnimator=ObjectAnimator.ofFloat(iv_animation,"xy",0.0f,5.0f);
        objectAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                // 取出动画中当前的值
                float currentValue= (float) valueAnimator.getAnimatedValue();
                // 设置动画的xy坐标
                iv_animation.setX(x+currentValue*100);
                iv_animation.setY(y+currentValue*50);
            }
        });
        objectAnimator.setDuration(3000);
        objectAnimator.start();
        // 透明度
        AlphaAnimation alphaAnimation=new AlphaAnimation(0.0f,1.0f);
        alphaAnimation.setDuration(300);
        iv_animation.startAnimation(alphaAnimation);
    }
}
