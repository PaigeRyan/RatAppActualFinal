package doperatz.rattracker.Model;

import android.content.Context;
import java.util.Date;
import android.content.res.AssetManager;
import android.support.annotation.NonNull;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import doperatz.rattracker.LoginActivity;
import doperatz.rattracker.R;
import doperatz.rattracker.RegistrationActivity;

import static android.R.attr.paddingLeft;
import static android.R.attr.src;

/**
 * Created by agysc on 9/24/2017.
 */

public class Model {
    //Singleton instance
    private static final Model _instance = new Model();
    public static Model getInstance() {
        return _instance;
    }
    private DatabaseReference mDatabase;
    private DatabaseReference rDatabase;


    //list of Users in the system
    private List<User> _users;
    private List<RatReport> _reports;
    private List<RatReport> _recentReports;
    private boolean addedDefaultData;


    //Constructor
    private Model() {
        _users = new ArrayList<User>();
        _reports = new ArrayList<RatReport>();
        _recentReports = new ArrayList<RatReport>();
        mDatabase = FirebaseDatabase.getInstance().getReference().child("ratreportdata");
        rDatabase = FirebaseDatabase.getInstance().getReference("recentreportdata");
        loadDefaultData();
    }

    public DatabaseReference getDatabaseRef() {
        return this.mDatabase;
    }


    public DatabaseReference getRecentRef() { return this.rDatabase; }

    /*
    Hard Coded user with
    username: user
    password: pass
    Meant for easy access to internals of application to test without creating a new user manually.
     */
    private void loadDefaultData() {
        _users.add(new User("user", "pass", false));
        _users.add(new User("MYu", "mindgame", true));
        _users.add(new User("AJensen", "augmentation", true));
        _users.add(new User("GFreeman", "blackmesa", false));
        _users.add(new User("ARyan", "wouldyoukindly", false));

    }

    /**
     * Loads all rat data from the csv file into the list of rat reports.
     * Called on login.
     * @param context
     */
    /*
    public void loadRatData(Context context) {
        if (addedDefaultData) {
            return;
        }
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(context.getAssets().open("ratData.csv")));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] ReportInfo = line.split(",");
                if (ReportInfo.length == 9) {
                    String id = ratReportData.push().getKey();
                    RatReport newReport = new RatReport(id, ReportInfo[1],
                            ReportInfo[2], ReportInfo[3], ReportInfo[4], ReportInfo[5],
                            ReportInfo[6], ReportInfo[7], ReportInfo[8]);
                    _reports.add(newReport);

                }
            }
            for (int i = _reports.size() - 15; i < _reports.size(); i++) {
                RatReport workingReport = _reports.get(i);
                _recentReports.add(workingReport);
            }

            addedDefaultData = true;

        } catch (IOException ex) {
            ex.printStackTrace();
        }


    }

*/
    /**
     * checks to see if the user exists in the system
     * using a user object
     *
     * @param user the user your looking for
     * @return if the user exists in the system
     */
    public boolean isUser(User user) {
        if (_users.contains(user)) {
            return true;
        } else  {
            return false;
        }
    }

    /**
     * Adds a user
     *
     * @param user to be added
     */
    public void addUser(User user) {
        _users.add(user);
    }

    /**
     * Initialize the link between the app and the database and set up
     * the value event listeners to detect changes of information.
     */
    public void loadInitialReports() {
        mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                _reports.clear();
                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    RatReport newReport = postSnapshot.getValue(RatReport.class);
                    _reports.add(newReport);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {}
        });

        rDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                _recentReports.clear();
                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    RatReport newReport = postSnapshot.getValue(RatReport.class);
                    _recentReports.add(newReport);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    /**
     * get the rat reports
     * @return a list of the rat reports in the app
     */
    public List<RatReport> getRatReports() { return _reports; }

    /**
     * get the most recent rat reports
     * @return a list of the 15 most recent rat reports
     */
    public List<RatReport> getRecentRatReports() { return _recentReports; }

    /**
     * Adds a new rat report to the list of reports
     * @param report
     */
    public void addReport(RatReport report) {
        // Create child in appropriate folder
        mDatabase.child(report.getUniqueKey()).setValue(report);
        rDatabase.child(report.getUniqueKey()).setValue(report);
    }

    /**
     * Adds a user using user properties
     *
     * @param name the user's name
     * @param password the user's password
     */
    public void addUser(String name, String password, boolean isAdmin) {
        _users.add(new User(name, password, isAdmin));
    }

    /**
     * Given a user attempting to login, checks against original user's password
     * for match to allow logging in.
     * @param checkedUser
     * @return whether or not passwords match and user can log in
     */
    public boolean checkPassword(User checkedUser) {
        for (User runningUser : _users) {
            if (checkedUser.equals(runningUser)) {
                return checkedUser.get_password().equals(runningUser.get_password());
            }
        }
        return false;
    }

}
