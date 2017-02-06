package com.example.administrator.broadcastdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Button bt_sendBroadCast,bt_sendOrderedBroadCast;
    Button bt_skip,bt_skip_thread;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bt_sendBroadCast= (Button) findViewById(R.id.bt_sendBroadCast);
        bt_sendOrderedBroadCast= (Button) findViewById(R.id.bt_sendOrderedBroadCast);
        bt_skip= (Button) findViewById(R.id.bt_skip);
        bt_skip_thread= (Button) findViewById(R.id.bt_skip_thread);
    }
    public void onClick(View view){
        int id=view.getId();
        switch (id){
            case R.id.bt_sendBroadCast:
                Random random=new Random();
                boolean action=random.nextBoolean();
                if(action){
                    Intent intent=new Intent();
                    intent.setAction("com.example.administrator.broadcastdemo.meeting");
                    intent.putExtra("number",1334532112);
                    this.sendBroadcast(intent);
                }else {
                    Intent intent=new Intent();
                    intent.setAction(getString(R.string.action_movie));
                    this.sendBroadcast(intent);
                }
                break;
            case R.id.bt_sendOrderedBroadCast:
                Intent intent=new Intent();
                intent.setAction("com.example.administrator.broadcastdemo.center");
                sendOrderedBroadcast(intent,"com.example.red");
                break;
            case R.id.bt_skip:
                Intent intent1=new Intent(this,SqliteDataActivity.class);
                startActivity(intent1);
                break;
            case R.id.bt_skip_thread:
                Intent intent2=new Intent(this,ThreadDemo.class);
                startActivity(intent2);
                break;
            case R.id.bt_am:
                Intent intent3=new Intent(this,CircleActivity.class);
                startActivity(intent3);
                break;
        }
    }
}
