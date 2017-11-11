package doperatz.rattracker;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

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
