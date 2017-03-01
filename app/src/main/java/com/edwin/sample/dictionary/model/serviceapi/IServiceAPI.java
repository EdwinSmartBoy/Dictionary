package com.edwin.sample.dictionary.model.serviceapi;

import com.edwin.sample.dictionary.model.bean.Dictionary;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

public interface IServiceAPI {


    /**
     * 获取查询字的解释
     * @param key APPKey
     * @param word 要查询的字或词
     * @return
     */
    @GET("query")
    Call<Dictionary> loadDictionary(@Query("key") String key, @Query("word") String word);

    /**
     * 获取查询字的解释
     * @param key AppKey
     * @param word 要查询的字或词
     * @return
     */
    @GET("query")
    Observable<Dictionary> getDictionaryData(@Query("key") String key, @Query("word") String word);

}
