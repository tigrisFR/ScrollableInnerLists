package fr.nabonne.tigris.scrollableinnerliststrial;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by tigris on 7/18/17.
 */

public class TransactionAdapter extends RecyclerView.Adapter {
    private final List<ModelContract.Transaction> data;

    public static class TxViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.description)
        public TextView descriptionView;
        @BindView(R.id.dollarAmount)
        public TextView dollarAmountView;
        @BindView(R.id.date)
        public TextView dateView;


        public TxViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    public TransactionAdapter(List<ModelContract.Transaction> data){
        this.data = data;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LinearLayout v = (LinearLayout) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.transaction_item, parent, false);

        return new TxViewHolder(v);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        TxViewHolder txHolder = (TxViewHolder) holder;
        ModelContract.Transaction txData = data.get(position);

        txHolder.descriptionView.setText(txData.description);
        txHolder.dateView.setText(txData.date);
        txHolder.dollarAmountView.setText(txData.dollarAmount);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
