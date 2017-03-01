package com.edwin.sample.dictionary.model.biz;

import com.edwin.sample.dictionary.view.listener.ICallBackListener;

/**
 * 创建者      Created by edwin
 * 创建时间    2017/2/28
 * 描述        ${TODO}
 * <p>
 * 更新者      edwin
 * 更新时间    ${TODO}
 * 更新描述    ${TODO}
 */

public interface IBusiness {

    /**
     * 开始执行业务逻辑的接口
     *
     * @param key               AppKey
     * @param word              查询的字
     * @param iCallBackListener 事件执行的回调
     */
    void query(String key, String word, ICallBackListener iCallBackListener);
}
