package doperatz.rattracker;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import doperatz.rattracker.Model.Model;
import doperatz.rattracker.Model.RatReport;

/**
 * Created by Josh on 10/10/2017.
 */



public class ListViewActivity extends Activity {

    ListView ratListView;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        Model model = Model.getInstance();
        View recyclerView = findViewById(R.id.RatListView);
        final ListAdapter ratListAdapter = new ArrayAdapter<RatReport>(this, android.R.layout.simple_list_item_1, model.getRatReports());
        ratListView = (ListView) findViewById(R.id.RatListView);
        ratListView.setAdapter(ratListAdapter);

        ratListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long longboy) {
                Intent intent = new Intent(ListViewActivity.this, ListDetailViewActivity.class);
                RatReport thisReport = (RatReport)ratListView.getItemAtPosition(i);
                intent.putExtra("Report", thisReport);
                startActivity(intent);
            }
        });
    }



}
