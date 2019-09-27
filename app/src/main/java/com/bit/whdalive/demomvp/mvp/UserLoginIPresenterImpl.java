package com.bit.whdalive.demomvp.mvp;

import android.os.Handler;

import com.bit.whdalive.demomvp.mvp_contracts.LoginContract;

public class UserLoginIPresenterImpl implements LoginContract.IPresenter,LoginContract.OnLoginListener {

    private LoginContract.IView mIUserLoginIView;
    private LoginContract.IUserModel mIUserModel;

    private Handler mHandler = new Handler();

    public UserLoginIPresenterImpl(LoginContract.IView IUserLoginIView) {
        mIUserLoginIView = IUserLoginIView;
        mIUserModel = new UserModelImpl(this);
    }

    @Override
    public void doLogin() {
        String username = mIUserLoginIView.getUserName();
        String password = mIUserLoginIView.getPassword();
        mIUserLoginIView.showLoading();
        mIUserModel.login(username,password,this);
    }

    @Override
    public void loginSuccess() {
        mHandler.post(new Runnable() {
            @Override
            public void run() {
                mIUserLoginIView.hideLoading();
                mIUserLoginIView.toMainActivity();
            }
        });
    }

    @Override
    public void loginFailed() {
        mHandler.post(new Runnable() {
            @Override
            public void run() {
                mIUserLoginIView.hideLoading();
                mIUserLoginIView.showFailedError();
            }
        });

    }

    @Override
    public void clear() {
        mIUserLoginIView.clearUserName();
        mIUserLoginIView.clearPassword();
    }
}
