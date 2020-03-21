package com.bawei.dianshang01.activity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import com.bawei.dianshang01.R;
import com.bawei.dianshang01.bean.NewsBean;
import com.bawei.dianshang01.bean.Result;
import com.bawei.dianshang01.presenter.NewsPresenter;
import com.bawei.dianshang01.util.DataCall;

public class MainActivity extends BaseActivity implements DataCall<NewsBean> {
    //定义
    private EditText wenbenshow;
    private NewsPresenter newsPresenter;
    //方法重写
    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }
    //加载视图
    @Override
    protected void initView(Bundle savedInstanceState) {
        wenbenshow = findViewById(R.id.wenbenshow);
        //获取值
        newsPresenter = new NewsPresenter(this);
        newsPresenter.request();
    }
    //成功反馈
    @Override
    public void success(Result<NewsBean> pengPaiListBean) {
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
