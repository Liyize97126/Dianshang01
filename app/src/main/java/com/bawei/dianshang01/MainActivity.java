package com.bawei.dianshang01;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    //定义
    private EditText wenbenshow;
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            if(msg.obj != null){
                wenbenshow.setText((String) msg.obj);
            }
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        wenbenshow = findViewById(R.id.wenbenshow);
        //android的EditText控件实现只读只需设置三个方法
        //wenbenshow.setCursorVisible(false);//隐藏光标
        //wenbenshow.setFocusable(false);//失去焦点
        //wenbenshow.setFocusableInTouchMode(false);//虚拟键盘隐藏
        //网络请求框架    Volley、OKHttp、Retrofit
        new Thread(new Runnable() {
            @Override
            public void run() {
                String json = NetUtil.getNetUtil().doGet("http://blog.zhaoliang5156.cn/api/pengpainews/pengpai1.json");
                //发送消息
                Message message = Message.obtain();
                message.obj = json;
                handler.sendMessage(message);
            }
        }).start();
    }
}
