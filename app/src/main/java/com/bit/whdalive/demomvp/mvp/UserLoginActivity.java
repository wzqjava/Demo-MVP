package com.bit.whdalive.demomvp.mvp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.bit.whdalive.demomvp.R;
import com.bit.whdalive.demomvp.mvp_contracts.LoginContract;
/**
 *  https://github.com/android/architecture-samples
 *  参考google sample 编写的mvp
 *  王志强
 *  2019-09-27
 */

public class UserLoginActivity extends AppCompatActivity implements LoginContract.IView {

    private EditText mEdtUsername,mEdtPwd;
    private Button mBtnLogin,mBtnClear;
    private ProgressBar mPbLoading;

    private LoginContract.IPresenter mIUserLoginPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }
    private void initViews(){
        mIUserLoginPresenter = new UserLoginIPresenterImpl(this);
        mEdtUsername = findViewById(R.id.input_account);
        mEdtPwd = findViewById(R.id.input_password);

        mBtnClear = findViewById(R.id.btn_clear);
        mBtnLogin = findViewById(R.id.btn_login);

        mPbLoading = findViewById(R.id.pb_loading);

        mBtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mIUserLoginPresenter.doLogin();
            }
        });

        mBtnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mIUserLoginPresenter.clear();
            }
        });

    }

    @Override
    public String getUserName() {
        return mEdtUsername.getText().toString();
    }

    @Override
    public String getPassword() {
        return mEdtPwd.getText().toString();
    }

    @Override
    public void clearUserName() {
        mEdtUsername.setText("");
    }

    @Override
    public void clearPassword() {
        mEdtPwd.setText("");
    }

    @Override
    public void showLoading() {
        mPbLoading.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        mPbLoading.setVisibility(View.GONE);
}

    @Override
    public void toMainActivity() {
        Toast.makeText(this,"login success, to MainActivity",Toast.LENGTH_SHORT).show();

    }

    @Override
    public void showFailedError() {
        Toast.makeText(this,"Login failed",Toast.LENGTH_SHORT).show();
    }

}
