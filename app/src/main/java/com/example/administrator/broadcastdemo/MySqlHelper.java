package com.example.administrator.broadcastdemo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Administrator on 2017/1/4.
 */
// 数据库的帮助类
public class MySqlHelper extends SQLiteOpenHelper {
    /**
     *
     * @param context  上下文环境
     * @param name    数据库的名字
     * @param factory  游标工厂，不需要，传 null
     * @param version 版本号，如果之前没有版本，则执行onCreate方法，如果当前版本大于之前版本，则执行onUpgrade方法
     */
    public MySqlHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }
    /**
     *
     * @param sqLiteDatabase 数据库
     */
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        // 对数据库执行操作  执行表的创建
        sqLiteDatabase.execSQL("create table student(name varchar,age int,score int)");
    }
    // 升级数据库操作
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
