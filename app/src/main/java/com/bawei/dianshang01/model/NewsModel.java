package com.bawei.dianshang01.model;

import android.util.Log;

import com.bawei.dianshang01.bean.NewsBean;
import com.bawei.dianshang01.bean.Result;
import com.bawei.dianshang01.util.NetUtil;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;

/**
 * 请求类
 */
public class NewsModel {
    public static Result<NewsBean> getInstance(int page) {
        String json;
        page = 0;
        if(page == 1){
            json = NetUtil.getNetUtil().doGet("http://blog.zhaoliang5156.cn/api/pengpainews/pengpai1.json");
        } else {
            json = NetUtil.getNetUtil().doGet("http://blog.zhaoliang5156.cn/api/pengpainews/pengpai2.json");
        }
        Log.i("Tag",page + "页");
        //解析
        Gson gson = new Gson();
        //泛型类处理
        Type type = new TypeToken<Result<NewsBean>>() {}.getType();
        Result<NewsBean> result = gson.fromJson(json, type);
        return result;
    }
}
