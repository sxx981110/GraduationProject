package com.sxx.model.pojo;

/**
 * @author: sxx
 * @date: 2020/2/16 14:49
 */
public enum Consts {
    /**
     * 失败
     */
    FAIL(500),
    /**
     * 成功
     */
    SUCCESS(200);

    private Integer code;

    Consts(Integer code) {
        this.code = code;
    }

    Consts() {
    }
}
