package com.bawei.dianshang01;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements DataCall {
    //定义
    private EditText wenbenshow;
    private NewsPresenter newsPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        wenbenshow = findViewById(R.id.wenbenshow);
        //获取值
        newsPresenter = new NewsPresenter(this);
        newsPresenter.request();
    }
    //成功反馈
    @Override
    public void success(PengPaiListBean pengPaiListBean) {
        wenbenshow.setText(pengPaiListBean.code + "\n" + pengPaiListBean.listdata.get(1).content);
    }
    //失败反馈
    @Override
    public void fail() {
        Toast.makeText(MainActivity.this,"数据读取失败！",Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        newsPresenter.destory();
    }
}
