package com.bawei.dianshang01;

import android.os.Bundle;
import android.os.Handler;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    //定义
    private EditText wenbenshow;
    private Handler handler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        wenbenshow = findViewById(R.id.wenbenshow);
        //android的EditText控件实现只读只需设置三个方法
        //wenbenshow.setCursorVisible(false);//隐藏光标
        //wenbenshow.setFocusable(false);//失去焦点
        //wenbenshow.setFocusableInTouchMode(false);//虚拟键盘隐藏
        handler = new Handler();
        //网络请求框架    Volley、OKHttp、Retrofit
        new Thread(new Runnable() {
            @Override
            public void run() {
                //发送请求
                final PengPaiListBean instance = NewsModel.getInstance();
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        //设置文本
                        wenbenshow.setText(instance.code + "\n" + instance.listdata.get(1).content);
                    }
                });
            }
        }).start();
    }
}
