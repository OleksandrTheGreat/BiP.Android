package com.otg.bip.mvp.home;

import com.otg.bip.data.db.models.AccountModel;

public interface IHomeView {

    void displayAccounts(AccountModel[] accounts);
}
