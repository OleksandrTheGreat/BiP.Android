package com.otg.bip.mvp.login;

public interface ILoginView {
    void showLoginFragment();
    void gotoHomePage(String userId);
    void showRegisterUserFragment(String pin);
}
