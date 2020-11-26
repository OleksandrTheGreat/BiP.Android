package com.otg.bip.data.db.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.otg.bip.data.db.entities.Currency;

import java.util.List;

@Dao
public interface CurrencyDao {

    @Query("select * from " + Currency.TABLE.NAME)
    Currency[] getAll();

    @Insert
    void insert(Currency... currencies);

    @Update
    void update(Currency... currencies);

    @Delete
    void delete(Currency... currencies);
}
