package com.otg.bip.ui.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.otg.bip.App;
import com.otg.bip.R;
import com.otg.bip.mvp.login.ILoginView;
import com.otg.bip.mvp.login.LoginPresenter;
import com.otg.bip.ui.home.HomeActivity;

public class LoginActivity extends AppCompatActivity implements ILoginView {

    private LoginPresenter _presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        _presenter = new LoginPresenter(this, getResources().getInteger(R.integer.pin_length));
        _presenter.onInit();
    }

    @Override
    public void showLoginFragment() {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.loginFragment, new LoginEnterPinFragment(_presenter))
                .commit();
    }

    @Override
    public void gotoHomePage(String userId) {
        startActivity(new Intent(App.getContext(), HomeActivity.class));
    }

    @Override
    public void showRegisterUserFragment(int pin) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.loginFragment, new LoginReEnterPinFragment(_presenter, pin))
                .commit();
    }
}