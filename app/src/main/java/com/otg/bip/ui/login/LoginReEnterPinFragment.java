package com.otg.bip.ui.login;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.otg.bip.R;
import com.otg.bip.mvp.login.LoginPresenter;

public class LoginReEnterPinFragment extends Fragment {

    private final LoginPresenter _presenter;
    private final String _pin;

    public LoginReEnterPinFragment(LoginPresenter presenter, String  pin) {
        _presenter = presenter;
        _pin = pin;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_login_re_enter_pin, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        attachEventListeners();
    }

    private void attachEventListeners() {

        EditText pinEditText = getView().findViewById(R.id.pinEditText);

        pinEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {
                _presenter.onPinReEnter(s.toString(), _pin);
            }
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
        });
    }
}