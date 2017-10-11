package doperatz.rattracker.Model;

import android.content.Context;
import android.content.res.AssetManager;
import android.support.annotation.NonNull;
import android.util.Log;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
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


    //list of Users in the system
    private List<User> _users;
    private List<RatReport> _reports;


    //Constructor
    private Model() {
        _users = new ArrayList<User>();
        _reports = new ArrayList<RatReport>();
        loadDefaultData();
    }

    /*
    Hard Coded user with
    username: user
    password: pass
    Just for this milestone
     */
    private void loadDefaultData() {
        _users.add(new User("user", "pass", false));
        _reports.add(new RatReport("31464025","9/4/2015 0:00", "1-2 Family Dwelling", "10310", "758 POST AVENUE", "STATEN ISLAND", "STATEN ISLAND", "40.63123555" ,"-74.1268776"));
        _reports.add(new RatReport("31434342","9/5/2015 0:00", "1-2 Family Dwelling", "10120", "759 POST AVENUE", "STATEN ISLAND", "STATEN ISLAND", "40.63123555" ,"-74.1268776"));
        _reports.add(new RatReport("31464025","9/6/2015 0:00", "1-2 Family Dwelling", "10332", "760 POST AVENUE", "STATEN ISLAND", "STATEN ISLAND", "40.63123555" ,"-74.1268776"));
        _reports.add(new RatReport("31464025","9/7/2015 0:00", "1-2 Family Dwelling", "10340", "761 POST AVENUE", "STATEN ISLAND", "STATEN ISLAND", "40.63123555" ,"-74.1268776"));
        _reports.add(new RatReport("31464025","9/8/2015 0:00", "1-2 Family Dwelling", "12340", "762 POST AVENUE", "STATEN ISLAND", "STATEN ISLAND", "40.63123555" ,"-74.1268776"));
    }

    public void loadRatData(Context context) {

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(context.getAssets().open("ratData.csv")));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] ReportInfo = line.split(",");
                for (String item : ReportInfo) {
                    System.out.print(item);
                }

            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }


    }

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
     * get the rat reports
     * @return a list of the rat reports in the app
     */
    public List<RatReport> getRatReports() { return _reports; }

    public void addReport(RatReport report) {_reports.add(report); }

    /**
     * Adds a user using user properties
     *
     * @param name the user's name
     * @param password the user's password
     */
    public void addUser(String name, String password, boolean isAdmin) {
        _users.add(new User(name, password, isAdmin));
    }


    public boolean checkPassword(User checkedUser) {
        for (User runningUser : _users) {
            if (checkedUser.equals(runningUser)) {
                return checkedUser.get_password().equals(runningUser.get_password());
            }
        }
        return false;
    }

}
