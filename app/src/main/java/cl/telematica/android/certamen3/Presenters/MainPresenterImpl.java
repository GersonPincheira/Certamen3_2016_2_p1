package cl.telematica.android.certamen3.Presenters;

import android.app.Activity;
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
import cl.telematica.android.certamen3.Presenters.Contract.MainPresenters;

/**
 * Created by gerson on 18-11-16.
 */

public class MainPresenterImpl implements MainPresenters {

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private Activity activity;
    SQLiteDatabase db;


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


                feeds.add(feed);
            }

            return feeds;
        } catch (JSONException e) {
            e.printStackTrace();
            return feeds;
        }
    }

    public Activity getActivity(){
        return activity;
    }

    @Override
    public SQLiteDatabase getdb() {
        return db;
    }

}
