package com.otg.bip.data.db;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.otg.bip.App;
import com.otg.bip.data.db.dao.AccountDao;
import com.otg.bip.data.db.dao.CurrencyDao;
import com.otg.bip.data.db.entities.Account;
import com.otg.bip.data.db.entities.Currency;
import com.otg.bip.data.db.entities.User;
import com.otg.bip.data.db.dao.UserDao;

import java.util.UUID;
import java.util.concurrent.Executors;

@Database(
        entities = {
                User.class,
                Currency.class,
                Account.class
        },
        version = 1
)
public abstract class AppDatabase extends RoomDatabase {

    public abstract UserDao userDao();
    public abstract CurrencyDao currencyDao();
    public abstract AccountDao accountDao();

    private static final String NAME = "bip";
    private static AppDatabase _instance;

    public static AppDatabase getInstance() {

        if (_instance != null && _instance.isOpen())
            return _instance;

        _instance = Room.databaseBuilder(App.getContext(), AppDatabase.class, AppDatabase.NAME)
                .allowMainThreadQueries()
                .addCallback(new Callback() {
                    @Override
                    public void onCreate(@NonNull SupportSQLiteDatabase db) {
                        super.onCreate(db);

                        Executors.newSingleThreadScheduledExecutor().execute(() -> {

                            getInstance().currencyDao().insert(
                                    new Currency("UAH", "Гривня"),
                                    new Currency("USD", "American dollar"),
                                    new Currency("EUR", "Euro")
                            );

                            getInstance().accountDao().insert(
                                    new Account(UUID.randomUUID().toString(), "Wallet/Гаманець", "UAH", 0),
                                    new Account(UUID.randomUUID().toString(), "Card/Карта", "UAH", 0),
                                    new Account(UUID.randomUUID().toString(), "Reserved/Резерв", "UAH", 0)
                            );
                        });
                    }
                })
                .build();

        return _instance;
    }

    public static void disconnect()
    {
        if (_instance != null && _instance.isOpen())
            _instance.close();
    }
}
