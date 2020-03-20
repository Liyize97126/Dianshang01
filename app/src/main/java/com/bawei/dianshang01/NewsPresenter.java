package com.bawei.dianshang01;

import android.os.Handler;

public class NewsPresenter {
    private Handler handler;
    private DataCall dataCall;
    //构造
    public NewsPresenter(DataCall dataCall) {
        this.dataCall = dataCall;
    }
    //请求
    public void request(){
        handler = new Handler();
        //网络请求框架    Volley、OKHttp、Retrofit
        new Thread(new Runnable() {
            @Override
            public void run() {
                //发送请求
                final PengPaiListBean instance = NewsModel.getInstance();
                if(instance != null){
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            dataCall.success(instance);
                        }
                    });
                } else {
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            dataCall.fail();
                        }
                    });
                }
            }
        }).start();
    }
    //释放
    public void destory(){
        this.dataCall = null;
    }
}
