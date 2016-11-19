package cl.telematica.android.certamen3.Views;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import cl.telematica.android.certamen3.Models.DataBaseClass;
import cl.telematica.android.certamen3.Models.FeedContract;
import cl.telematica.android.certamen3.Presenters.Contract.MainPresenters;
import cl.telematica.android.certamen3.Presenters.Contract.MyAsyncTaskExecutor;
import cl.telematica.android.certamen3.Presenters.MainPresenterImpl;
import cl.telematica.android.certamen3.Presenters.MyAsyncTaskExecutorImpl;
import cl.telematica.android.certamen3.R;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private MainPresenters mainPresenters;
    private DataBaseClass   dbInstance;
    private SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dbInstance = new DataBaseClass(this);
        db = dbInstance.getWritableDatabase();
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        mainPresenters = new MainPresenterImpl(mRecyclerView,this,db);
        MyAsyncTaskExecutorImpl.getInstance().executeMyAsynctask(mainPresenters, mRecyclerView);
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            Intent i = new Intent(this, FavoritoActivity.class );
            this.startActivity(i); /**
             * You should manage the action to show the favorite items saved by the user
             */
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
