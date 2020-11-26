package com.otg.bip.infrastructure;

import com.otg.bip.data.repositories.contracts.IAccountRepository;
import com.otg.bip.data.repositories.contracts.ICurrencyRepository;
import com.otg.bip.data.repositories.contracts.IUserRepository;

public interface IServiceLocator {
    IUserRepository getUserRepositoryInstance();
    ICurrencyRepository getCurrencyRepository();
    IAccountRepository getAccountRepository();
}
