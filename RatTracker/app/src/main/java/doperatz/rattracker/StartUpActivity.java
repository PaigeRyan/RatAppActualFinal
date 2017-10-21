package doperatz.rattracker;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.SimpleAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import doperatz.rattracker.R;

public class StartUpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_up);
    }

    protected void onLogoutPressed(View view) {
        Intent intent = new Intent(this, WelcomeActivity.class);
        startActivity(intent);
    }

    protected void onViewReportListPressed(View view) {
        Intent intent = new Intent(this, ListViewActivity.class);
        startActivity(intent);
    }

    protected void onAddReportPressed(View view) {
        Intent intent = new Intent(this, NewReportActivity.class);
        startActivity(intent);
    }

    protected void onRecentListPressed(View view) {
        Intent intent = new Intent(this, RecentListViewActivity.class);
        startActivity(intent);
    }

    protected void onVisualizeDataPressed(View view) {
        Intent intent = new Intent(this, DateRangeActivity.class);
        startActivity(intent);
    }
}
