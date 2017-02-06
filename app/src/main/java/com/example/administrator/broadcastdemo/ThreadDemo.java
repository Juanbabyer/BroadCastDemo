package com.example.administrator.broadcastdemo;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class ThreadDemo extends AppCompatActivity {
    Button bt_image;
    ImageView iv_image;
    // 创建handler，重写方法
    Handler handler=new Handler(){
        // 处理消息的方法，消息中装载了子线程中的数据
        @Override
        public void handleMessage(Message msg) {
    //        Toast.makeText(ThreadDemo.this, "接收子线程数据："+msg.arg1, Toast.LENGTH_SHORT).show();
            switch (msg.what){
                case 1:
                    iv_image.setImageResource(R.drawable.pager_guide1);
                    break;
                case 2:
                    iv_image.setImageResource(R.drawable.pager_guide2);
                    break;
                case 3:
                    iv_image.setImageResource(R.drawable.pager_guide3);
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thread_demo);
        bt_image= (Button) findViewById(R.id.bt_image);
        iv_image= (ImageView) findViewById(R.id.iv_image);
    }
    public void onClick(View view){
        // UI线程（主线程） 不适合执行耗时操作 如果有耗时操作可能会产生ANR
        // 模拟执行下载操作  把线程放入子线程中
        Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    // 在UI线程中，让图片显示到 iv_image上
                    // 让线程休眠5秒
                    Thread.sleep(5000);
                    // 方法1： runOnUiThread
//            runOnUiThread(new Runnable() { // 直接调用方法，系统会自动的去UI线程中运行
//                @Override
//                public void run() {
//                    iv_image.setImageResource(R.drawable.pager_guide1);
//                }
//            });
                    // 方法2： post
//                    iv_image.post(new Runnable() {
//                        @Override
//                        public void run() {
//                            iv_image.setImageResource(R.drawable.pager_guide1);
//                        }
//                    });
                    // 方法3：handler机制，用来处理子线程中的数据，把子线程的数据放到主线程中
                    // 创建message
                    Message message=handler.obtainMessage();  //  第一张图片
                    message.what=1;
                    message.arg1=1; // 放了一个数据1
                    handler.sendMessage(message); // 发送消息
                    Thread.sleep(5000);
                    Message message1=handler.obtainMessage();  //  第二张图片
                    message.what=2;
                    message1.arg1=2;
                    handler.sendMessage(message1);
                    Thread.sleep(5000);
                    Message message2=handler.obtainMessage();  //  第三张图片
                    message2.arg1=3;
                    message2.what=3;
                    handler.sendMessage(message2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        // 开启子线程
        thread.start();
    }
}
