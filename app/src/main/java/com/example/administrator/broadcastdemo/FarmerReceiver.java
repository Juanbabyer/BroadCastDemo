package com.example.administrator.broadcastdemo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by Administrator on 2017/1/4.
 */

public class FarmerReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        String action=intent.getAction();
        if(action.equals("com.example.administrator.broadcastdemo.meeting")){
            int number=intent.getIntExtra("number",0);
            Toast.makeText(context, "接收到一个开会广播,联系方式为："+number, Toast.LENGTH_SHORT).show();
        }else if(action.equals("com.example.administrator.broadcastdemo.movie")){
            Toast.makeText(context, "接收到一个看电影广播", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(context, "接收到上级消息", Toast.LENGTH_SHORT).show();
        }

    }
}
