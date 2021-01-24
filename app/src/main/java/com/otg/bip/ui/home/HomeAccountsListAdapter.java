package com.otg.bip.ui.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.otg.bip.R;
import com.otg.bip.data.db.models.AccountModel;
import com.otg.bip.infrastructure.Tools;

public class HomeAccountsListAdapter extends ArrayAdapter<AccountModel> {

    private final Context _context;
    private final int _resource;

    public HomeAccountsListAdapter(@NonNull Context context, int resource, @NonNull AccountModel[] objects) {
        super(context, resource, objects);

        _context = context;
        _resource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        AccountModel model = getItem(position);

        String name = model.account.name;
        double balance = model.account.balance;
        String currency = model.currency.id;

        LayoutInflater inflater = LayoutInflater.from(_context);
        convertView = inflater.inflate(_resource, parent, false);

        TextView nameTextView = convertView.findViewById(R.id.home_account_name);
        TextView balanceTextView = convertView.findViewById(R.id.home_account_balance);
        TextView currencyTextView = convertView.findViewById(R.id.home_account_currency);

        nameTextView.setText(name);
        balanceTextView.setText(Tools.Currency.format(balance));
        currencyTextView.setText(currency);

        return convertView;
    }
}
