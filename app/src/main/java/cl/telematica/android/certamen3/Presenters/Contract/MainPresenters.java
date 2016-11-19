package cl.telematica.android.certamen3.Presenters.Contract;

import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;

import java.util.List;

import cl.telematica.android.certamen3.Models.Feed;

/**
 * Created by gerson on 18-11-16.
 */

public interface MainPresenters {

    List<Feed> getFeeds(String result);

    Activity getActivity();

    SQLiteDatabase getdb();

    void Adapter(Activity ad);




}
