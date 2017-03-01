package com.edwin.sample.dictionary.model.biz;

import com.edwin.sample.dictionary.model.serviceapi.HttpDao;
import com.edwin.sample.dictionary.model.serviceapi.IServiceAPI;
import com.edwin.sample.dictionary.view.listener.ICallBackListener;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * 创建者      Created by edwin
 * 创建时间    2017/2/28
 * 描述        业务逻辑执行类
 * <p>
 * 更新者      edwin
 * 更新时间    ${TODO}
 * 更新描述    ${TODO}
 */

public class Business implements IBusiness {

    private static final String TAG = Business.class.getSimpleName();

    @Override
    public void query(String key, String word, ICallBackListener iCallBackListener) {
        IServiceAPI iServiceAPI = HttpDao.I().getIServiceAPI();
        iServiceAPI.getDictionaryData(key, word)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(HttpDao.I().createSubscriber(iCallBackListener));
    }
}
