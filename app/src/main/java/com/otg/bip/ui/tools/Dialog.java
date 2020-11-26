package com.otg.bip.ui.tools;

import android.app.AlertDialog;
import android.content.Context;

import com.otg.bip.R;

public class Dialog {

    public static final class Confirm {

        public static final void Open(Context context, String message, Runnable yesCallback, Runnable noCallback) {

            AlertDialog.Builder builder = new AlertDialog.Builder(context);

            builder.setTitle(R.string.confirm);
            builder.setMessage(message);

            builder.setPositiveButton(R.string.yes, (dialog, which) -> {
                if (yesCallback != null) {
                    yesCallback.run();
                }
                dialog.dismiss();
            });

            builder.setNegativeButton(R.string.no, (dialog, which) -> {
                if (noCallback != null) {
                    noCallback.run();
                }
                dialog.dismiss();
            });

            builder.create().show();
        }
    }
}
