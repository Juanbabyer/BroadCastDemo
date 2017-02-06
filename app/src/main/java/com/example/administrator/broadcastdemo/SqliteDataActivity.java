package com.example.administrator.broadcastdemo;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SqliteDataActivity extends AppCompatActivity implements View.OnClickListener{
    EditText et_name,et_age,et_score;
    Button bt_insert_student,bt_delete_student,bt_query_student;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlite_data);
        et_name= (EditText) findViewById(R.id.et_name);
        et_age= (EditText) findViewById(R.id.et_age);
        et_score= (EditText) findViewById(R.id.et_score);
        bt_insert_student= (Button) findViewById(R.id.bt_insert_student);
        bt_delete_student= (Button) findViewById(R.id.bt_delete_student);
        bt_query_student= (Button) findViewById(R.id.bt_query_student);
        bt_insert_student.setOnClickListener(this);
        bt_delete_student.setOnClickListener(this);
        bt_query_student.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int id=view.getId();
        // 插入数据  获取达到当前的数据
        String name=et_name.getText().toString();
        String age=et_age.getText().toString();
        String score=et_score.getText().toString();
        // 获取数据库  也在onCreate中建立了数据表student
        MySqlHelper sqlHelper=new MySqlHelper(this,"school.db",null,1);
        SQLiteDatabase database=sqlHelper.getReadableDatabase();// 内存满后，变为只读状态
        switch (id){
            case R.id.bt_insert_student:
                // 向数据库中插入数据
            //    database.execSQL("insert into student(name,age,score) values ('"+name+"',"+age+","+score+")");
                ContentValues contentValues=new ContentValues();
                contentValues.put("name",name);
                contentValues.put("age",age);
                contentValues.put("score",score);
                database.insert("student",null,contentValues);
                break;
            case R.id.bt_delete_student:
                // 拼接SQL语句  从数据库中删除数据
             //   database.execSQL("delete from student where age="+age);
                database.delete("student","age=?",new String[]{age});
                break;
            case R.id.bt_query_student:
                // 查询数据库中的数据  记录到cursor中  第一个参数
                // 查询姓名name和成绩score           第二个参数
                // 查询年龄为5的数据                 第三，四个数据
                Cursor cursor=database.query("student",new String[]{"name","score"},"age=?",new String[]{age},null,null,"score");
                // 从cursor中取出数据  通过Log输出数据
                while (cursor.moveToNext()){// 如果还有数据，移动到下一位，返回true
                    // 分别取出数据
                    String tempName=cursor.getString(cursor.getColumnIndex("name"));
            //        int  tempage=cursor.getInt(cursor.getColumnIndex("age"));
                    int  tempscore=cursor.getInt(cursor.getColumnIndex("score"));
                    Log.i(TAG,"onClick:"+tempName+"---"+tempscore);
                }
                break;
        }
    }
    private static final String TAG = "SqliteDataActivity";
}
