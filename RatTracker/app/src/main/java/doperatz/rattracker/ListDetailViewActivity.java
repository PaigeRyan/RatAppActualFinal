package doperatz.rattracker;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import doperatz.rattracker.Model.Model;
import doperatz.rattracker.Model.RatReport;

/**
 * Created by Josh on 10/10/2017.
 */

public class ListDetailViewActivity extends Activity {

    TextView uniqueKeyView;
    TextView createdDateView;
    TextView locationTypeView;
    TextView incidentZipView;
    TextView incidentAddressView;
    TextView cityView;
    TextView boroughView;
    TextView latitudeView;
    TextView longitudeView;

    /**
     * On Creation of ListDetailView, load text views with information
     * specific to the report in question.
     * @param savedInstanceState
     */
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_detail_view);
        Bundle bundle = getIntent().getExtras();
        RatReport thisReport = bundle.getParcelable("Report");

        uniqueKeyView = (TextView) findViewById(R.id.uniqueKeyView);
        createdDateView = (TextView) findViewById(R.id.createdDateView);
        locationTypeView = (TextView) findViewById(R.id.locationTypeView);
        incidentZipView = (TextView) findViewById(R.id.incidentZipView);
        incidentAddressView = (TextView) findViewById(R.id.incidentAddressView);
        cityView = (TextView) findViewById(R.id.cityView);
        boroughView = (TextView) findViewById(R.id.boroughView);
        latitudeView = (TextView) findViewById(R.id.latitudeView);
        longitudeView = (TextView) findViewById(R.id.longitudeView);



        uniqueKeyView.setText("Unique Key: " + thisReport.getUniqueKey());
        createdDateView.setText("Created Date: " + thisReport.getCreatedDate());
        locationTypeView.setText("Location Type: " + thisReport.getLocationType());
        incidentZipView.setText("Incident Zip: " + thisReport.getIncidentZip());
        incidentAddressView.setText("Incident Address: " + thisReport.getIncidentAddress());
        cityView.setText("City: " + thisReport.getCity());
        boroughView.setText("Borough: " + thisReport.getBorough());
        latitudeView.setText("Latitude: " + thisReport.getLatitude());
        longitudeView.setText("Longitude: " + thisReport.getLongitude());
    }

    protected void onBackPressed(View view) {
        Log.d("Edit", "Back");
        Intent intent = new Intent(this, ListViewActivity.class);
        startActivity(intent);
    }


}