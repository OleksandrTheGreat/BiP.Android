package com.otg.bip.data.db.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.otg.bip.data.db.entities.Account;
import com.otg.bip.data.db.models.AccountModel;

import java.util.List;

@Dao
public interface AccountDao {

    @Query("select * from " + Account.TABLE.NAME)
    Account[] getAll();

    @Insert
    void insert(Account... accounts);

    @Update
    void update(Account... accounts);

    @Delete
    void delete(Account... accounts);

    @Query("select * from " + Account.TABLE.NAME)
    AccountModel[] getAllModels();
}
