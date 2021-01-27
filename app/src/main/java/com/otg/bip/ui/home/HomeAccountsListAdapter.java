package com.otg.bip.ui.home;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.otg.bip.R;
import com.otg.bip.data.db.models.AccountModel;
import com.otg.bip.infrastructure.Tools;

public class HomeAccountsListAdapter extends RecyclerView.Adapter<HomeAccountsListAdapter.ViewHolder> {

    private AccountModel[] _data;

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public final TextView nameTextView;
        public final TextView balanceTextView;
        public final TextView currencyTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            nameTextView = itemView.findViewById(R.id.home_account_name);
            balanceTextView = itemView.findViewById(R.id.home_account_balance);
            currencyTextView = itemView.findViewById(R.id.home_account_currency);
        }
    }

    public void setData(AccountModel[] data) {
        _data = data;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_account, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        AccountModel item = _data[position];

        holder.nameTextView.setText(item.account.name);
        holder.balanceTextView.setText(Tools.Currency.format(item.account.balance));
        holder.currencyTextView.setText(item.currency.id);
    }

    @Override
    public int getItemCount() {
        return _data.length;
    }
}
