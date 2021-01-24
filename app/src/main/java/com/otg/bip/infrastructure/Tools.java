package com.otg.bip.infrastructure;

import java.text.DecimalFormat;

public final class Tools {

    public static final class Currency {

        private static final String _pattern = "#,##0.00";
        private static final DecimalFormat _format = new DecimalFormat(_pattern);

        public static String format(double number) {
            return _format.format(number);
        }
    }
}
