package com.otg.bip.data.db.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.otg.bip.data.db.entities.User;

import java.util.List;

@Dao
public interface UserDao {

    @Query("select * from " + User.TABLE.NAME)
    User[] getAll();

    @Insert
    void insert(User... users);
}
