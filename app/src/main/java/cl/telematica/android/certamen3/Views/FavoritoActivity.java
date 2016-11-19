package cl.telematica.android.certamen3.Views;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import cl.telematica.android.certamen3.Models.DataBaseClass;
import cl.telematica.android.certamen3.Presenters.Contract.MainPresenters;
import cl.telematica.android.certamen3.Presenters.MainPresenterImpl;
import cl.telematica.android.certamen3.R;

public class FavoritoActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private MainPresenters mainPresenters;
    private DataBaseClass dbInstance;
    private SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorito);
        dbInstance = new DataBaseClass(this);
        db = dbInstance.getWritableDatabase();
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView1);
        mRecyclerView.setHasFixedSize(true);
        mainPresenters = new MainPresenterImpl(mRecyclerView,this,db);
        mainPresenters.Adapter(this);

    }
}
