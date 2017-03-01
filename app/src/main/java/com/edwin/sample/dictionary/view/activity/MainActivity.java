package com.edwin.sample.dictionary.view.activity;

import android.app.ProgressDialog;
import android.databinding.DataBindingUtil;
import android.text.TextUtils;
import android.widget.Toast;

import com.edwin.sample.dictionary.R;
import com.edwin.sample.dictionary.databinding.ActivityMainBinding;
import com.edwin.sample.dictionary.model.bean.Dictionary;
import com.edwin.sample.dictionary.view.iactivityView.IBaseActivityView;
import com.edwin.sample.dictionary.view.listener.IMainListener;
import com.edwin.sample.dictionary.viewModel.MainActivityPresenter;

public class MainActivity extends BaseActivity implements IMainListener, IBaseActivityView {

    private ActivityMainBinding mMainBinding;
    private MainActivityPresenter mPresenter;
    private int time = 0;
    private ProgressDialog mProgressDialog;

    @Override
    protected void bindView() {
        mMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mPresenter = new MainActivityPresenter(this);
        mMainBinding.setListener(this);
    }

    @Override
    public void query() {
        String inputWord = mMainBinding.editText.getText().toString().trim();
        if (TextUtils.isEmpty(inputWord)) {
            if (System.currentTimeMillis() - time > 3000) {
                Toast.makeText(this, "要查询的字不能为空哦!~", Toast.LENGTH_SHORT).show();
            }
        } else if (inputWord.length() > 2) {
            if (System.currentTimeMillis() - time > 3000) {
                Toast.makeText(this, "当前只支持查询单个字哦!~", Toast.LENGTH_SHORT).show();
            }
        } else {
            mPresenter.userQuery(inputWord);
        }
    }

    @Override
    public void showProgress() {
        mProgressDialog = ProgressDialog.show(this, "有道字典", "正在查询中,请您稍等...");
    }

    @Override
    public void closeProgress() {
        mProgressDialog.dismiss();
    }

    @Override
    public void excuteSuccessCallBack(Dictionary dictionary) {
        //System.out.println(dictionary.toString());

        mMainBinding.textView.setText(dictionary.result.toString()
        );
    }

    @Override
    public void excuteFailedCallBack(Throwable e) {
        e.printStackTrace();
        if (e != null) {
            System.out.println(e.getMessage());
        }
    }
}
