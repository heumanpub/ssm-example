package com.heuman.domain;

import com.heuman.common.utils.JsonUtil;

import java.io.Serializable;

/**
 * Created by heuman on 2017/12/20.
 */
public class BaseDomain implements Serializable {

    private static final long serialVersionUID = 1L;

    public String toJson() {
        return JsonUtil.toJson(this);
    }
}
