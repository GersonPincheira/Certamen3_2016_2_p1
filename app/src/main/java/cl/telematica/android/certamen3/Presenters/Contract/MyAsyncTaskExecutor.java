package cl.telematica.android.certamen3.Presenters.Contract;

import android.support.v7.widget.RecyclerView;

/**
 * Created by gerson on 18-11-16.
 */

public interface MyAsyncTaskExecutor {

    void executeMyAsynctask(final MainPresenters mainPresenters, final RecyclerView mRecyclerView);
}
