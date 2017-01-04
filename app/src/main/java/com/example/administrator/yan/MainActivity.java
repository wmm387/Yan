package com.example.administrator.yan;

import android.support.v7.app.AppCompatActivity;

/**
 * 主类
 */
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private TextView textFre;//法语
    private TextView textGer;//德语
    private TextView textSpa;//西班牙语
    private TextView textJpa;//日语
    private TextView textKro;//韩语

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //初始化
        textFre = (TextView)findViewById(R.id.textFre);
        textGer = (TextView)findViewById(R.id.textGer);
        textSpa = (TextView)findViewById(R.id.textSpa);
        textJpa = (TextView)findViewById(R.id.textJpa);
        textKro = (TextView)findViewById(R.id.textKro);

        //添加点击监听事件
        textFre.setOnClickListener(this);
        textGer.setOnClickListener(this);
        textSpa.setOnClickListener(this);
        textJpa.setOnClickListener(this);
        textKro.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            //页面跳转
            case R.id.textFre:
                Intent intent1 = new Intent();
                intent1.setClass(this,FraWordActivity.class);
                startActivity(intent1);
                break;
            case R.id.textGer:
                Intent intent2 = new Intent();
                intent2.setClass(this,GerWordActivity.class);
                startActivity(intent2);
                break;
            case R.id.textSpa:
                Intent intent3 = new Intent();
                intent3.setClass(this,SpaWordActivity.class);
                startActivity(intent3);
                break;
            case R.id.textJpa:
                Intent intent4 = new Intent();
                intent4.setClass(this,JpaWordActivity.class);
                startActivity(intent4);
                break;
            case R.id.textKro:
                Intent intent5 = new Intent();
                intent5.setClass(this,KorWordActivity.class);
                startActivity(intent5);
                break;
        }

    }
}
