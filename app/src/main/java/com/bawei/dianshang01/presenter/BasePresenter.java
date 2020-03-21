package com.bawei.dianshang01.presenter;

import android.os.Handler;
import android.os.Message;

import androidx.annotation.NonNull;

import com.bawei.dianshang01.bean.Result;
import com.bawei.dianshang01.util.DataCall;

/**
 * Presenter基类
 */
public abstract class BasePresenter {
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            if(msg.obj != null){
                Result result = (Result) msg.obj;
                dataCall.success(result);
            } else {
                dataCall.fail();
            }
        }
    };
    private DataCall dataCall;
    //构造
    public BasePresenter(DataCall dataCall) {
        this.dataCall = dataCall;
    }
    //请求（含动态参数）
    public void request(final Object...args){
        //网络请求框架    Volley、OKHttp、Retrofit
        new Thread(new Runnable() {
            @Override
            public void run() {
                //发送请求
                Message message = Message.obtain();
                message.obj = getModel(args);
                handler.sendMessage(message);
            }
        }).start();
    }
    //获得的内容
    protected abstract Result getModel(Object...args);

    //释放
    public void destory(){
        this.dataCall = null;
    }
}
