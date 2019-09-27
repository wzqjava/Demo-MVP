package com.bit.whdalive.demomvp.mvp_contracts;


public interface LoginContract {

  interface IView {
    String getUserName();

    String getPassword();

    void clearUserName();

    void clearPassword();

    void showLoading();

    void hideLoading();

    void toMainActivity();

    void showFailedError();

  }

  interface IPresenter {

    void doLogin();

    void clear();
  }

  interface IUserModel {

    void login(String username, String password, OnLoginListener listener);

  }

  interface OnLoginListener {
    void loginSuccess();

    void loginFailed();
  }
}
