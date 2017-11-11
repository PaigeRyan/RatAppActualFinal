package doperatz.rattracker;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import doperatz.rattracker.Model.DateRange;
import doperatz.rattracker.Model.Model;
import doperatz.rattracker.Model.RatReport;

public class RatMapActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private Model model;
    DateRange date1;
    DateRange date2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rat_map);
        Bundle bundle = getIntent().getExtras();
        date1 = bundle.getParcelable("Date1");
        date2 = bundle.getParcelable("Date2");
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        model = Model.getInstance();
    }



    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;


        for (RatReport report : model.getRatReports()) {
            if (report.getCreatedDate() != "Created Date") {
                String[] rDate = report.getCreatedDate().split("/");

                //Conditional checks for appropriate date format before populating map.
                if (rDate.length == 3) {
                    if (rDate[2].length() == 2) {
                        rDate[2] = "20".concat(rDate[2]);
                    }
                    rDate[2] = rDate[2].substring(0, 4);
                    DateRange reportDate = new DateRange(Integer.parseInt(rDate[0]), Integer.parseInt(rDate[1]), Integer.parseInt(rDate[2]));
                    if (date1.compare(reportDate) <= 0 && date2.compare(reportDate) >= 0) {
                        String reportInfo = String.format("%s, %s", report.getUniqueKey(), report.getBorough());
                        LatLng reportPos = new LatLng(Double.parseDouble(report.getLatitude()), Double.parseDouble(report.getLongitude()));
                        mMap.addMarker(new MarkerOptions().position(reportPos).title(reportInfo));
                    }
                }
            }
        }
        mMap.moveCamera(CameraUpdateFactory.newLatLng(new LatLng(40, -75)));
    }
}
