package doperatz.rattracker;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.helper.StaticLabelsFormatter;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.util.ArrayList;
import java.util.Date;

import doperatz.rattracker.Model.DateRange;
import doperatz.rattracker.Model.Model;
import doperatz.rattracker.Model.RatReport;

public class HistogramActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_histogram);
        Model model = Model.getInstance();
        Bundle bundle = getIntent().getExtras();
        DateRange date1 = bundle.getParcelable("Date1");
        DateRange date2 = bundle.getParcelable("Date2");
        if (date1 == null || date2 == null) {
            throw new IllegalArgumentException("Cannot accept null date.");
        }
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ArrayList<Date> dateList = new ArrayList<>();
        int months = 1 + ((date2.getYear() - date1.getYear()) * 12) + (date2.getMonth() - date1.getMonth());

        for (RatReport report : model.getRatReports()) {
            if (!report.getCreatedDate().equals("Created Date")) {
                String[] rDate = report.getCreatedDate().split("/");

                //Conditional checks for appropriate date format before populating histogram.
                if (rDate.length == 3) {
                    if (rDate[2].length() == 2) {
                        rDate[2] = "20".concat(rDate[2]);
                    }
                    rDate[2] = rDate[2].substring(0, 4);
                    DateRange reportDate = new DateRange(Integer.parseInt(rDate[0]), Integer.parseInt(rDate[1]), Integer.parseInt(rDate[2]));
                    if (date1.compare(reportDate) <= 0 && date2.compare(reportDate) >= 0) {
                        Date newDate = new Date(reportDate.getYear(), reportDate.getMonth(), reportDate.getDay());
                        dateList.add(newDate);
                    }
                }
            }
        }

        String[] monthNames = {"January", "February", "March", "April", "May", "June",
                               "July", "August", "September", "October", "November", "December"};
        String leftMonth = monthNames[date1.getMonth()];
        String rightMonth = monthNames[date2.getMonth()];
        int[] monthTally = new int[months];
        int x, y;
        for (int i = 0; i < months; i++) {
            monthTally[i] = 0;
        }
        for (Date date : dateList) {
            int month = date.getMonth();
            int year = date.getYear();
            int monthDiff = ((year - date1.getYear()) * 12) + (month - date1.getMonth());
            monthTally[monthDiff]++;
        }

        GraphView graph = findViewById(R.id.graph);
        LineGraphSeries<DataPoint> series = new LineGraphSeries<>();
        for (int i = 0; i < months; i++) {
            x = i;
            y = monthTally[i];
            series.appendData(new DataPoint(x, y), true, months);
        }
        series.setDataPointsRadius(10);
        StaticLabelsFormatter staticLabelsFormatter = new StaticLabelsFormatter(graph);
        staticLabelsFormatter.setHorizontalLabels(new String[] {leftMonth+date1.getYear(), "(Time, in months)", rightMonth+date2.getYear()});
        graph.addSeries(series);
        graph.setTitle("Rat Sightings per month");
        graph.getViewport().setMinX(0);
        graph.getViewport().setMaxX((date2.getYear() - date1.getYear()) * 12 + date2.getMonth() - date1.getMonth());
        graph.getViewport().setXAxisBoundsManual(true);
        graph.getGridLabelRenderer().setHumanRounding(false);
        graph.getGridLabelRenderer().setLabelFormatter(staticLabelsFormatter);


    }



}
