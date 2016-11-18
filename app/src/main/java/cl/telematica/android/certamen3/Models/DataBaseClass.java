package cl.telematica.android.certamen3.Models;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by gerson on 18-11-16.
 */

public class DataBaseClass extends SQLiteOpenHelper {

    private String sqlString="CREATE TABLE " + FeedContract.FeedEntry.TABLE_NAME +" ("
            + FeedContract.FeedEntry.Title +" TEXT, "
            + FeedContract.FeedEntry.Link +" TEXT, "
            + FeedContract.FeedEntry.Author +" TEXT, "
            + FeedContract.FeedEntry.PublishedDate +" TEXT, "
            + FeedContract.FeedEntry.Content +" TEXT, "
            + FeedContract.FeedEntry.Image +" TEXT)";

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "FeedBD";

    public DataBaseClass(Context cxt){
        super(cxt,DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(sqlString);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+ FeedContract.FeedEntry.TABLE_NAME);
        onCreate(sqLiteDatabase);

    }


}
