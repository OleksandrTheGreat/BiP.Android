package com.otg.bip.data.db.models;

import androidx.room.Embedded;
import androidx.room.Relation;

import com.otg.bip.data.db.entities.Account;
import com.otg.bip.data.db.entities.Currency;

public class AccountModel {
    @Embedded public Account account;
    @Relation(parentColumn = Account.TABLE.COLUMNS.CURRENCY_ID.NAME, entityColumn = Currency.TABLE.COLUMNS.ID.NAME)
    public Currency currency;
}
