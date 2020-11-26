package com.otg.bip.data.repositories.local;

import com.otg.bip.data.db.AppDatabase;
import com.otg.bip.data.db.entities.Account;
import com.otg.bip.data.db.models.AccountModel;
import com.otg.bip.data.repositories.contracts.IAccountRepository;

public class AccountRepository implements IAccountRepository {

    @Override
    public Account[] getAll() {
        return AppDatabase.getInstance().accountDao().getAll();
    }

    @Override
    public AccountModel[] getAllModels() {
        return AppDatabase.getInstance().accountDao().getAllModels();
    }

    @Override
    public void insert(Account... accounts) {
        AppDatabase.getInstance().accountDao().insert(accounts);
    }

    @Override
    public void update(Account... accounts) {
        AppDatabase.getInstance().accountDao().update(accounts);
    }

    @Override
    public void delete(Account... accounts) {
        AppDatabase.getInstance().accountDao().delete(accounts);
    }
}
