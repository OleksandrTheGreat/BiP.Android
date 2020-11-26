package com.otg.bip.data.repositories.contracts;

import com.otg.bip.data.db.entities.User;

import java.util.List;

public interface IUserRepository {
    User[] getAll();
    void insert(User user);
}
