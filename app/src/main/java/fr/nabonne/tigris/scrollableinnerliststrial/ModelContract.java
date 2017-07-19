package fr.nabonne.tigris.scrollableinnerliststrial;

import java.util.List;

/**
 * Created by tigris on 7/18/17.
 * Blueprint for a Model component. This is what the Presenter expects from the Model
 */

public interface ModelContract {
    class Transaction {
        String dollarAmount;
        String status;
        String date;
        String description;

        final static String STATUS_PENDING = "pend";
        final static String STATUS_POSTED = "post";


        public Transaction(
                String dollarAmount,
                String status,
                String date,
                String description) {
            this.dollarAmount = dollarAmount;
            this.status = status;
            this.date = date;
            this.description = description;
        }
    }

    interface ModelSource {
        List<Transaction> getAllTransaction();
        List<Transaction> getPendingTransaction();
        List<Transaction> getPostedTransaction();
    }
}
