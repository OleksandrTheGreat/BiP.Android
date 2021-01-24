package com.otg.bip.data.db.entities;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = Account.TABLE.NAME)
public class Account {

    @PrimaryKey()
    @ColumnInfo(name = Account.TABLE.COLUMNS.ID.NAME)
    @NonNull
    public String id;

    @ColumnInfo(name = Account.TABLE.COLUMNS.NAME.NAME)
    @NonNull
    public String name;

    @ColumnInfo(name = TABLE.COLUMNS.CURRENCY_ID.NAME)
    @NonNull
    public String currencyId;

    @ColumnInfo(name = TABLE.COLUMNS.BALANCE.NAME)
    @NonNull
    public double balance;

    @ColumnInfo(name = TABLE.COLUMNS.TYPE.NAME)
    @NonNull
    public int type;

    public Account(String id, String name, String currencyId,  double balance, int type) {
        this.id = id;
        this.name = name;
        this.currencyId = currencyId;
        this.balance = balance;
        this.type = type;
    }

    /* Schema */
    public static final class TABLE {

        public static final String NAME = "accounts";

        public static final class COLUMNS {
            public static final class ID {
                public static final String NAME = "rowid";
            }
            public static final class NAME {
                public static final String NAME = "name";
            }
            public static final class CURRENCY_ID {
                public static final String NAME = "currency_id";
            }
            public static final class BALANCE {
                public static final String NAME = "balance";
            }
            public static final class TYPE {
                public static final String NAME = "type";
            }
        }
    }

    public static final class TYPE {
        public static final int ACTIVE = 0;
        public static final int PASSIVE = 1;
        public static final int ACTIVE_PASSIVE = 2;
    }
}
