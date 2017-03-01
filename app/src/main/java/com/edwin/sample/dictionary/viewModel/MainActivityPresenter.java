package com.edwin.sample.dictionary.viewModel;

import com.edwin.sample.dictionary.model.bean.Dictionary;
import com.edwin.sample.dictionary.model.common.Constants;
import com.edwin.sample.dictionary.view.iactivityView.IBaseActivityView;
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

public class MainActivityPresenter implements IBasePresenter {

    private static String TAG = MainActivityPresenter.class.getSimpleName();
    private IBaseActivityView mIBaseActivityView;

    public MainActivityPresenter(IBaseActivityView iBaseActivityView) {
        this.mIBaseActivityView = iBaseActivityView;
    }

    public void userQuery(String word) {
        //显示进度
        mIBaseActivityView.showProgress();
        //开始请求
        mIBusiness.query(Constants.AppKey, word, new ICallBackListener() {
            @Override
            public void onSuccess(Dictionary dictionary) {
                mIBaseActivityView.excuteSuccessCallBack(dictionary);
            }

            @Override
            public void onError(Throwable throwable) {
                mIBaseActivityView.excuteFailedCallBack(throwable);
            }

            @Override
            public void onAfter() {
                mIBaseActivityView.closeProgress();
            }
        });
    }
}
