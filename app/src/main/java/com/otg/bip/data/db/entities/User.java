package com.otg.bip.data.db.entities;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = User.TABLE.NAME)
public class User {

    @PrimaryKey()
    @ColumnInfo(name = TABLE.COLUMNS.ID.NAME)
    @NonNull
    public String id;

    @ColumnInfo(name = TABLE.COLUMNS.PIN.NAME)
    @NonNull
    public String pin;

    public User(String id, String pin) {
        this.id = id;
        this.pin = pin;
    }

    /* Schema */
    public static final class TABLE {

        public static final String NAME = "user";

        public static final class COLUMNS {
            public static final class ID {
                public static final String NAME = "rowid";
                public static final String NULL_VALUE = "NULL";
            }
            public static final class PIN {
                public static final String NAME = "pin";
                public static final String NULL_VALUE = "NULL";
            }
        }
    }
}
