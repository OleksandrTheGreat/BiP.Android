package com.otg.bip.infrastructure;

import com.otg.bip.data.repositories.local.AccountRepository;
import com.otg.bip.data.repositories.local.CurrencyRepository;
import com.otg.bip.data.repositories.contracts.IAccountRepository;
import com.otg.bip.data.repositories.contracts.ICurrencyRepository;
import com.otg.bip.data.repositories.contracts.IUserRepository;
import com.otg.bip.data.repositories.local.UserRepository;

public final class ServiceLocator implements IServiceLocator {

    private static IServiceLocator _instance = new ServiceLocator();

    public static IServiceLocator getInstance() {
        return _instance;
    }

    private final IUserRepository _userRepository = new UserRepository();
    public IUserRepository getUserRepositoryInstance() {
        return _userRepository;
    }

    private final ICurrencyRepository _currencyRepository = new CurrencyRepository();
    public ICurrencyRepository getCurrencyRepository() { return  _currencyRepository; }

    private final IAccountRepository _accountRepository = new AccountRepository();
    public IAccountRepository getAccountRepository() {
        return _accountRepository;
    }
}
