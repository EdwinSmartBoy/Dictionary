package com.edwin.sample.dictionary.view.listener;

import com.edwin.sample.dictionary.model.bean.Dictionary;

/**
 * 创建者      Created by edwin
 * 创建时间    2017/2/28
 * 描述        ${TODO}
 * <p>
 * 更新者      edwin
 * 更新时间    ${TODO}
 * 更新描述    ${TODO}
 */

public interface ICallBackListener {

    /**
     * 成功的回调
     *
     * @param dictionary
     */
    void onSuccess(Dictionary dictionary);

    /**
     * 失败的回调
     *
     * @param throwable
     */
    void onError(Throwable throwable);

    /**
     * 事件结束
     */
    void onAfter();
}
