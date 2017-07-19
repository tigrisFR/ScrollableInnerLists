package fr.nabonne.tigris.scrollableinnerliststrial;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tigris on 7/18/17.
 * An implementation of the ModelSource expected by the Presenter
 * TODO: add tests or business logic to introduce changes to the model and leverage recycling of views by RecyclerView
 */

public class AModelSource implements ModelContract.ModelSource{
    private List<ModelContract.Transaction> data = new ArrayList<>();
    private int firstPostedTxIndex;

    public AModelSource() {
        data.add(new ModelContract.Transaction("5", ModelContract.Transaction.STATUS_PENDING, "5/5/2017", "Automatic"));
        data.add(new ModelContract.Transaction("5", ModelContract.Transaction.STATUS_PENDING, "5/5/2017", "Automatic"));
        data.add(new ModelContract.Transaction("5", ModelContract.Transaction.STATUS_PENDING, "5/5/2017", "Automatic"));
        data.add(new ModelContract.Transaction("5", ModelContract.Transaction.STATUS_PENDING, "5/5/2017", "Automatic"));
        firstPostedTxIndex = 4;
        data.add(new ModelContract.Transaction("23.69", ModelContract.Transaction.STATUS_POSTED, "5/5/2017", "Automatic"));
        data.add(new ModelContract.Transaction("23.69", ModelContract.Transaction.STATUS_POSTED, "5/5/2017", "Automatic"));
        data.add(new ModelContract.Transaction("23.69", ModelContract.Transaction.STATUS_POSTED, "5/5/2017", "Automatic"));
        data.add(new ModelContract.Transaction("23.69", ModelContract.Transaction.STATUS_POSTED, "5/5/2017", "Automatic"));
        data.add(new ModelContract.Transaction("23.69", ModelContract.Transaction.STATUS_POSTED, "5/5/2017", "Automatic"));
        data.add(new ModelContract.Transaction("23.69", ModelContract.Transaction.STATUS_POSTED, "5/5/2017", "Automatic"));
        data.add(new ModelContract.Transaction("23.69", ModelContract.Transaction.STATUS_POSTED, "5/5/2017", "Automatic"));
        data.add(new ModelContract.Transaction("23.69", ModelContract.Transaction.STATUS_POSTED, "5/5/2017", "Automatic"));
        data.add(new ModelContract.Transaction("23.69", ModelContract.Transaction.STATUS_POSTED, "5/5/2017", "Automatic"));
        data.add(new ModelContract.Transaction("23.69", ModelContract.Transaction.STATUS_POSTED, "5/5/2017", "Automatic"));
        data.add(new ModelContract.Transaction("23.69", ModelContract.Transaction.STATUS_POSTED, "5/5/2017", "Automatic"));
    }

    @Override
    public List<ModelContract.Transaction> getAllTransaction() {
        return data;
    }

    @Override
    public List<ModelContract.Transaction> getPendingTransaction() {
        return data.subList(0, firstPostedTxIndex);
    }

    @Override
    public List<ModelContract.Transaction> getPostedTransaction() {
        return data.subList(firstPostedTxIndex, data.size());
    }
}
