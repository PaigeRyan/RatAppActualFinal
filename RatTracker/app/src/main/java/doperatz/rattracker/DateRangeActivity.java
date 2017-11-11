package doperatz.rattracker;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import doperatz.rattracker.Model.DateRange;

public class DateRangeActivity extends AppCompatActivity {

    private EditText date1;
    private EditText date2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_range);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        date1 = findViewById(R.id.date1Field);
        date2 = findViewById(R.id.date2Field);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }


    protected void onMapViewPressed(View view) {
        Log.d("Edit", "Cancel");

        String[] date1Params = (date1.getText().toString()).split("/");
        String[] date2Params = (date2.getText().toString()).split("/");

        DateRange firstDate = new DateRange(Integer.parseInt(date1Params[0]), Integer.parseInt(date1Params[1]), Integer.parseInt(date1Params[2]));
        DateRange secondDate = new DateRange(Integer.parseInt(date2Params[0]), Integer.parseInt(date2Params[1]), Integer.parseInt(date2Params[2]));

        if ((secondDate.getYear() - firstDate.getYear()) * 12 + (secondDate.getMonth() - firstDate.getMonth()) <= 12) {
            Intent intent = new Intent(this, RatMapActivity.class);
            intent.putExtra("Date1", firstDate);
            intent.putExtra("Date2", secondDate);
            startActivity(intent);
        } else {
            Toast toast = Toast.makeText(getApplicationContext(), "Limit range to 1 year.", Toast.LENGTH_SHORT);
            toast.show();
        }


    }

    protected void onHistogramPressed(View view) {

        String[] date1Params = (date1.getText().toString()).split("/");
        String[] date2Params = (date2.getText().toString()).split("/");

        DateRange firstDate = new DateRange(Integer.parseInt(date1Params[0]), Integer.parseInt(date1Params[1]), Integer.parseInt(date1Params[2]));
        DateRange secondDate = new DateRange(Integer.parseInt(date2Params[0]), Integer.parseInt(date2Params[1]), Integer.parseInt(date2Params[2]));

        if ((secondDate.getYear() - firstDate.getYear()) * 12 + (secondDate.getMonth() - firstDate.getMonth()) <= 12) {
            Intent intent = new Intent(this, HistogramActivity.class);
            intent.putExtra("Date1", firstDate);
            intent.putExtra("Date2", secondDate);
            startActivity(intent);
        } else {
            Toast toast = Toast.makeText(getApplicationContext(), "Limit range to 1 year.", Toast.LENGTH_SHORT);
            toast.show();
        }

    }

    protected void onDateRangeCancelPressed(View view) {
        Log.d("Edit", "Cancel");
        Intent intent = new Intent(this, StartUpActivity.class);
        startActivity(intent);
    }

}
