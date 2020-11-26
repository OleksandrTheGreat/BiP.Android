package com.otg.bip.data.repositories.contracts;

import com.otg.bip.data.db.entities.Account;
import com.otg.bip.data.db.models.AccountModel;

import java.util.List;

public interface IAccountRepository {
    Account[] getAll();
    AccountModel[] getAllModels();
    void insert(Account... accounts);
    void update(Account... accounts);
    void delete(Account... accounts);
}
