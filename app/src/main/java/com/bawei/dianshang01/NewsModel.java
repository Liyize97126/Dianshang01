package com.bawei.dianshang01;

import com.google.gson.Gson;

/**
 * 请求类
 */
public class NewsModel {
    public static PengPaiListBean getInstance() {
        String json = NetUtil.getNetUtil().doGet("http://blog.zhaoliang5156.cn/api/pengpainews/pengpai1.json");
        Gson gson = new Gson();
        PengPaiListBean pengPaiListBean = gson.fromJson(json, PengPaiListBean.class);
        return pengPaiListBean;
    }
}
