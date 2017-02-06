package com.example.administrator.broadcastdemo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by Administrator on 2017/1/4.
 */

public class PartyReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "上级发布消息", Toast.LENGTH_SHORT).show();
        // 阻拦  拦截
        abortBroadcast();
    }
}
