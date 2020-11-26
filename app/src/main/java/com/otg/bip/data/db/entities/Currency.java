package com.otg.bip.data.db.entities;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = Currency.TABLE.NAME)
public class Currency {

    @PrimaryKey()
    @ColumnInfo(name = TABLE.COLUMNS.ID.NAME)
    @NonNull
    public String id;

    @ColumnInfo(name = TABLE.COLUMNS.NAME.NAME)
    @NonNull
    public String name;

    public Currency(String id, String name) {
        this.id = id;
        this.name = name;
    }

    /* Schema */
    public static final class TABLE {

        public static final String NAME = "currency";

        public static final class COLUMNS {
            public static final class ID {
                public static final String NAME = "rowid";
            }
            public static final class NAME {
                public static final String NAME = "name";
            }
        }
    }
}
