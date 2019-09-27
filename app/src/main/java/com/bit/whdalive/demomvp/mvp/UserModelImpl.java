package com.bit.whdalive.demomvp.mvp;

import com.bit.whdalive.demomvp.bean.User;
import com.bit.whdalive.demomvp.mvp_contracts.LoginContract;

public class UserModelImpl implements LoginContract.IUserModel {

  private LoginContract.IPresenter mIUserLoginPresenter;

  public UserModelImpl(LoginContract.IPresenter userLoginPresenter) {
    this.mIUserLoginPresenter = userLoginPresenter;
  }

  @Override
  public void login(final String username, final String password, final LoginContract.OnLoginListener listener) {
    new Thread() {
      @Override
      public void run() {
        try {
          Thread.sleep(2000);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        if ("1".equals(username) && "1".equals(password)) {
          User user = new User();
          user.setUsername(username);
          user.setPassword(password);
          listener.loginSuccess();
        } else {
          listener.loginFailed();
        }
      }
    }.start();
  }
}
