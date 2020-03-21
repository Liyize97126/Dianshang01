package com.bawei.dianshang01.bean;

import java.io.Serializable;
import java.util.List;

/**
 * 结果集
 */
public class Result<T> implements Serializable {
    public String code;
    public List<T> listdata;
}
