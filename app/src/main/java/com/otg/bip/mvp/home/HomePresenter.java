package com.otg.bip.mvp.home;

import com.otg.bip.data.repositories.contracts.IAccountRepository;
import com.otg.bip.infrastructure.ServiceLocator;

public final class HomePresenter {

    private final IHomeView _view;
    private IAccountRepository _accountRepository = ServiceLocator.getInstance().getAccountRepository();

    public HomePresenter(IHomeView view) {
        this._view = view;
    }

    public void onStart() {
        _view.displayAccounts(_accountRepository.getAllModels());
    }
}
