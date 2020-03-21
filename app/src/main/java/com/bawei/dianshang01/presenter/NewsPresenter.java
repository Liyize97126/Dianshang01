package com.bawei.dianshang01.presenter;

import com.bawei.dianshang01.bean.Result;
import com.bawei.dianshang01.model.NewsModel;
import com.bawei.dianshang01.util.DataCall;

/**
 * 程序逻辑在Presenter里实现
 */
public class NewsPresenter extends BasePresenter {
    public NewsPresenter(DataCall dataCall) {
        super(dataCall);
    }

    @Override
    protected Result getModel(Object... args) {
        return NewsModel.getInstance((Integer) args[0]);
    }
}
