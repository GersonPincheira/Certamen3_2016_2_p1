package cl.telematica.android.certamen3.Presenters;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.List;

import cl.telematica.android.certamen3.Models.Feed;
import cl.telematica.android.certamen3.Models.FeedContract;
import cl.telematica.android.certamen3.Presenters.Contract.MainPresenters;

/**
 * Created by gerson on 18-11-16.
 */

public class MainPresenterImpl implements MainPresenters {

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private Activity activity;
    SQLiteDatabase db;
    private RecyclerView.Adapter adapter;


    public MainPresenterImpl(RecyclerView recyclerView, Activity activity, SQLiteDatabase db){
        this.recyclerView=recyclerView;
        this.activity=activity;
        layoutManager= new LinearLayoutManager(this.activity,LinearLayoutManager.VERTICAL,false);
        this.recyclerView.setLayoutManager(layoutManager);
        this.db=db;
    }

    @Override
    public List<Feed> getFeeds(String result) {
        List<Feed> feeds = new ArrayList<>();
        try {
            JSONObject jsonObject = new JSONObject(result);
            JSONObject responseData = jsonObject.getJSONObject("responseData");
            JSONObject feedObj = responseData.getJSONObject("feed");

            JSONArray entries = feedObj.getJSONArray("entries");
            int size = entries.length();
            for(int i = 0; i < size; i++){
                JSONObject entryObj = entries.getJSONObject(i);
                Feed feed = new Feed();

                feed.setTitle(entryObj.optString("title"));
                feed.setLink(entryObj.optString("link"));
                feed.setAuthor(entryObj.optString("author"));
                feed.setPublishedDate(entryObj.optString("publishedDate"));
                feed.setContent(entryObj.optString("content"));
                feed.setImage(entryObj.optString("image"));
                int ID = entryObj.optString("image").hashCode();
                feed.setID(Integer.toString(ID));


                feeds.add(feed);
            }

            return feeds;
        } catch (JSONException e) {
            e.printStackTrace();
            return feeds;
        }
    }
    public List<Feed> ExtraerDatos(){
        Cursor c = db.rawQuery("SELECT * FROM "+ FeedContract.FeedEntry.TABLE_NAME+";",null);
        List<Feed> feeds = new ArrayList<>();
        if(c.moveToFirst()){
            do{
                Feed feed = new Feed();
                feed.setID(c.getString(0));
                feed.setTitle(c.getString(1));
                feed.setLink(c.getString(2));
                feed.setAuthor(c.getString(3));
                feed.setPublishedDate(c.getString(4));
                feed.setContent(c.getString(5));
                System.out.println(c.getString(2));
                feed.setImage(c.getString(6));

                feeds.add(feed);
            } while (c.moveToNext());
        }
        c.close();
        return  feeds;

    }

    public Activity getActivity(){
        return activity;
    }

    @Override
    public SQLiteDatabase getdb() {
        return db;
    }

    @Override
    public void Adapter(Activity ad) {
        adapter = new DataAdapter(ad,ExtraerDatos(),db);
        recyclerView.setAdapter(adapter);
    }

}
