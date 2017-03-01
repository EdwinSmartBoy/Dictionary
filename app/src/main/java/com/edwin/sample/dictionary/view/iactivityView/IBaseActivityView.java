package com.edwin.sample.dictionary.view.iactivityView;

import com.edwin.sample.dictionary.model.bean.Dictionary;

/**
 * 创建者      Created by edwin
 * 创建时间    2017/2/28
 * 描述        实现接口
 * <p>
 * 更新者      edwin
 * 更新时间    ${TODO}
 * 更新描述    ${TODO}
 */
public interface IBaseActivityView {

    /**
     * 显示操作进度
     */
    void showProgress();

    /**
     * 关闭进度
     */
    void closeProgress();

    /**
     * 成功回调
     */
    void excuteSuccessCallBack(Dictionary dictionary);

    /**
     * 失败回调
     */
    void excuteFailedCallBack(Throwable throwable);

}
