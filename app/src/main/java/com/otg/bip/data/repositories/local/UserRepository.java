package com.otg.bip.data.repositories.local;

import com.otg.bip.data.db.AppDatabase;
import com.otg.bip.data.db.entities.User;
import com.otg.bip.data.repositories.contracts.IUserRepository;

public final class UserRepository implements IUserRepository {

    @Override
    public User[] getAll() {
        return AppDatabase.getInstance().userDao().getAll();
    }

    @Override
    public void insert(User user) {
        AppDatabase.getInstance().userDao().insert(user);
    }
}
