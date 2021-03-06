package doperatz.rattracker;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;

import doperatz.rattracker.Model.DatabaseManager;
import doperatz.rattracker.Model.Model;
import doperatz.rattracker.Model.RatReport;

public class NewReportActivity extends AppCompatActivity {
    private EditText date;
    private EditText locationType;
    private EditText incidentAddress;
    private EditText incidentZip;
    private EditText city;
    private EditText borough;
    private EditText longitude;
    private EditText latitude;
    private final Model model = Model.getInstance();
    private DatabaseManager dbManager = new DatabaseManager();
    private final DatabaseReference appRef = dbManager.getDatabaseRef();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_report);

        date = findViewById(R.id.dateField);
        locationType = findViewById(R.id.locationTypeField);
        incidentAddress = findViewById(R.id.incidentAddressField);
        incidentZip = findViewById(R.id.incidentZipField);
        city = findViewById(R.id.cityField);
        borough = findViewById(R.id.boroughField);
        longitude = findViewById(R.id.longitudeField);
        latitude = findViewById(R.id.latitudeField);
    }

    protected void onSubmitReportPressed(View view) {
        Log.d("Edit", "Submit");

        String id = appRef.push().getKey();
        RatReport newReport = new RatReport(id, date.getText().toString(), locationType.getText().toString(),
                incidentZip.getText().toString(), incidentAddress.getText().toString(), city.getText().toString(),
                borough.getText().toString(), latitude.getText().toString(), longitude.getText().toString());
        model.addReport(newReport);
        Intent intent = new Intent(this, StartUpActivity.class);
        startActivity(intent);
    }

    protected void onCancelReportPressed(View view) {
        Log.d("Edit", "Cancel");
        Intent intent = new Intent(this, StartUpActivity.class);
        startActivity(intent);
    }

}
