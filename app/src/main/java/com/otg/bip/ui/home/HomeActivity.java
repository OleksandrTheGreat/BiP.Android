package com.otg.bip.ui.home;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.otg.bip.R;
import com.otg.bip.data.db.AppDatabase;
import com.otg.bip.data.db.models.AccountModel;
import com.otg.bip.mvp.home.HomePresenter;
import com.otg.bip.mvp.home.IHomeView;
import com.otg.bip.ui.tools.Dialog;

public class HomeActivity extends AppCompatActivity implements IHomeView {

    private HomePresenter _presenter;
    private RecyclerView _accountsView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_activity);

        _presenter = new HomePresenter(this);

        initAccountsView();
    }

    private void initAccountsView() {

        _accountsView = findViewById(R.id.home_accounts_view);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        _accountsView.setLayoutManager(layoutManager);

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(_accountsView.getContext(), layoutManager.getOrientation());
        _accountsView.addItemDecoration(dividerItemDecoration);
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

        HomeAccountsListAdapter adapter = (HomeAccountsListAdapter) _accountsView.getAdapter();

        if (adapter == null) {
            adapter = new HomeAccountsListAdapter();
            _accountsView.setAdapter(adapter);
        }

        adapter.setData(accounts);
        adapter.notifyDataSetChanged();
    }
}