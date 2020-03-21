package com.bawei.dianshang01.util;

import com.bawei.dianshang01.bean.Result;

/**
 * 反馈接口
 */
public interface DataCall<T> {
    void success(Result<T> result);
    void fail();
}
