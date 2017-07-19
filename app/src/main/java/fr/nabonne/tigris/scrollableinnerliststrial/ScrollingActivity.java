package fr.nabonne.tigris.scrollableinnerliststrial;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ScrollingActivity extends AppCompatActivity {

    @BindView(R.id.pending_tx)
    RecyclerView pendingView;
    @BindView(R.id.posted_tx)
    RecyclerView postedView;

    ModelContract.ModelSource dataSource;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_scrolling);
        ButterKnife.bind(this);

        dataSource = new AModelSource();// TODO: persist model source by inject. from custom app class or dagger component

        //TODO: Move view handling and Adapter out of Activity to a clean Presenter class/package
        pendingView.setLayoutManager(new LinearLayoutManager(this.getApplicationContext()));
        postedView.setLayoutManager(new LinearLayoutManager(this.getApplicationContext()));

        //TODO: model source should implement observable or at least registering a listener for changes
        RecyclerView.Adapter pendingTxAdapter = new TransactionAdapter(dataSource.getPendingTransaction());
        RecyclerView.Adapter postedTxAdapter = new TransactionAdapter(dataSource.getPostedTransaction());

        pendingView.setAdapter(pendingTxAdapter);
        postedView.setAdapter(postedTxAdapter);
    }
}
