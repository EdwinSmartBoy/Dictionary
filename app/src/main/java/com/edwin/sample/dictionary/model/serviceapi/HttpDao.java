package com.edwin.sample.dictionary.model.serviceapi;

import android.util.Log;

import com.edwin.sample.dictionary.model.bean.Dictionary;
import com.edwin.sample.dictionary.view.listener.ICallBackListener;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Subscriber;

import static com.edwin.sample.dictionary.model.common.Constants.MAIN_ADDRESS;

/**
 * 创建者      Created by edwin
 * 创建时间    2017/2/28
 * 描述        网络操作的相关类
 * <p>
 * 更新者      edwin
 * 更新时间    ${TODO}
 * 更新描述    ${TODO}
 */

public class HttpDao {

    private static final String TAG = HttpDao.class.getSimpleName();
    private static HttpDao mHttpDao = null;

    public HttpDao() {

    }

    /**
     * 获取单例
     *
     * @return
     */
    public static HttpDao I() {
        if (mHttpDao == null) {
            synchronized (HttpDao.class) {
                if (mHttpDao == null) {
                    mHttpDao = new HttpDao();
                }
            }
        }
        return mHttpDao;
    }

    /**
     * 获取IServiceAPI对象的实例
     *
     * @return IServiceAPI
     */
    public IServiceAPI getIServiceAPI() {
        Retrofit retrofit = new Retrofit
                .Builder()
                .baseUrl(MAIN_ADDRESS)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        return retrofit.create(IServiceAPI.class);
    }

    public Subscriber createSubscriber(final ICallBackListener iCallBackListener) {

        Subscriber<Dictionary> subscriber = new Subscriber<Dictionary>() {
            @Override
            public void onCompleted() {
                Log.d(TAG, "onCompleted");
                iCallBackListener.onAfter();
            }

            @Override
            public void onError(Throwable e) {
                Log.d(TAG, "onError");
                iCallBackListener.onError(e);
            }

            @Override
            public void onNext(Dictionary dictionary) {
                iCallBackListener.onSuccess(dictionary);
            }
        };
        return subscriber;
    }
}

