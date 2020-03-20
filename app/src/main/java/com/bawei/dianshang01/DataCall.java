package com.bawei.dianshang01;

/**
 * 反馈接口
 */
public interface DataCall {
    void success(PengPaiListBean pengPaiListBean);
    void fail();
}
