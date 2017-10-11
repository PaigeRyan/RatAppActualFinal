package doperatz.rattracker;

import android.app.Activity;
import android.os.Bundle;
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



        uniqueKeyView.setText("" + thisReport.getUniqueKey());
        createdDateView.setText("" + thisReport.getCreatedDate());
        locationTypeView.setText("" + thisReport.getLocationType());
        incidentZipView.setText("" + thisReport.getIncidentZip());
        incidentAddressView.setText("" + thisReport.getIncidentAddress());
        cityView.setText("" + thisReport.getCity());
        boroughView.setText("" + thisReport.getBorough());
        latitudeView.setText("" + thisReport.getLatitude());
        longitudeView.setText("" + thisReport.getLongitude());
    }


}