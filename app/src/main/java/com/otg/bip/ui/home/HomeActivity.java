package com.otg.bip.ui.home;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.otg.bip.R;
import com.otg.bip.data.db.AppDatabase;
import com.otg.bip.data.db.models.AccountModel;
import com.otg.bip.infrastructure.Logger;
import com.otg.bip.mvp.home.HomePresenter;
import com.otg.bip.mvp.home.IHomeView;
import com.otg.bip.ui.tools.Dialog;

public class HomeActivity extends AppCompatActivity implements IHomeView {

    private HomePresenter _presenter;
    private ListView _accountsView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_activity);

        _presenter = new HomePresenter(this);
        _accountsView = (ListView)findViewById(R.id.home_accounts_view);
    }

    @Override
    protected void onStart() {
        super.onStart();
        _presenter.onStart();
    }

    @Override
    public void onBackPressed() {
        Dialog.Confirm.Open(
                this,
                getString(R.string.exit_the_app),
                () -> {
                    AppDatabase.disconnect();
                    finishAffinity();
                    System.exit(0);
                },
                null);
    }

    @Override
    public void displayAccounts(AccountModel[] accounts) {
        HomeAccountsListAdapter adapter = new HomeAccountsListAdapter(this, R.layout.home_account, accounts);
        _accountsView.setAdapter(adapter);
    }
}