package com.otg.bip.data.repositories.local;

import com.otg.bip.data.db.AppDatabase;
import com.otg.bip.data.db.entities.Currency;
import com.otg.bip.data.repositories.contracts.ICurrencyRepository;

public class CurrencyRepository implements ICurrencyRepository {

    @Override
    public Currency[] getAll() {
        return AppDatabase.getInstance().currencyDao().getAll();
    }

    @Override
    public void insert(Currency... currencies) {
        AppDatabase.getInstance().currencyDao().insert(currencies);
    }

    @Override
    public void update(Currency... currencies) {
        AppDatabase.getInstance().currencyDao().update(currencies);
    }

    @Override
    public void delete(Currency... currencies) {
        AppDatabase.getInstance().currencyDao().delete(currencies);
    }
}
