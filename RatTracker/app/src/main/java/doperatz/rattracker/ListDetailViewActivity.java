package doperatz.rattracker;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import doperatz.rattracker.Model.RatReport;

public class ListDetailViewActivity extends Activity {



    /**
     * On Creation of ListDetailView, load text views with information
     * specific to the report in question.
     * @param savedInstanceState bundle that contains details for individual report
     */
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_detail_view);
        Bundle bundle = getIntent().getExtras();
        RatReport thisReport = bundle.getParcelable("Report");

        TextView uniqueKeyView;
        TextView createdDateView;
        TextView locationTypeView;
        TextView incidentZipView;
        TextView incidentAddressView;
        TextView cityView;
        TextView boroughView;
        TextView latitudeView;
        TextView longitudeView;

        uniqueKeyView = findViewById(R.id.uniqueKeyView);
        createdDateView = findViewById(R.id.createdDateView);
        locationTypeView = findViewById(R.id.locationTypeView);
        incidentZipView = findViewById(R.id.incidentZipView);
        incidentAddressView = findViewById(R.id.incidentAddressView);
        cityView = findViewById(R.id.cityView);
        boroughView = findViewById(R.id.boroughView);
        latitudeView = findViewById(R.id.latitudeView);
        longitudeView = findViewById(R.id.longitudeView);



        uniqueKeyView.setText("Unique Key: " + (thisReport != null ? thisReport.getUniqueKey() : null));
        createdDateView.setText("Created Date: " + (thisReport != null ? thisReport.getCreatedDate() : null));
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