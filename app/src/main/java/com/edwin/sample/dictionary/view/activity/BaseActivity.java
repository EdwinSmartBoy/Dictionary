package com.edwin.sample.dictionary.view.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * 创建者      Created by edwin
 * 创建时间    2017/2/28
 * 描述        ${TODO}
 * <p>
 * 更新者      edwin
 * 更新时间    ${TODO}
 * 更新描述    ${TODO}
 */

public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bindView();
        initData();
        initEvent();
    }

    /**
     * 子类必须实现,绑定界面布局
     */
    protected abstract void bindView();

    /**
     * 初始化界面的数据
     */
    private void initData() {

    }

    /**
     * 界面事件的绑定
     */
    private void initEvent() {

    }

}
