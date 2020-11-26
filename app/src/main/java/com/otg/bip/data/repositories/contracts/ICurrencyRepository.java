package com.otg.bip.data.repositories.contracts;

import com.otg.bip.data.db.entities.Currency;

import java.util.List;

public interface ICurrencyRepository {
    Currency[] getAll();
    void insert(Currency... currencies);
    void update(Currency... currencies);
    void delete(Currency... currencies);
}
