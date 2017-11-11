package doperatz.rattracker.Model;




import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;


public class Model {
    //Singleton instance
    private static final Model _instance = new Model();
    public static Model getInstance() {
        return _instance;
    }
    private final DatabaseReference mDatabase;
    private final DatabaseReference rDatabase;


    //list of Users in the system
    private final List<User> _users;
    private final List<RatReport> _reports;
    private final List<RatReport> _recentReports;

    //Constructor
    private Model() {
        _users = new ArrayList<>();
        _reports = new ArrayList<>();
        _recentReports = new ArrayList<>();
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
    }

    /**
     * checks to see if the user exists in the system
     * using a user object
     *
     * @param user the user your looking for
     * @return if the user exists in the system
     */
    public boolean isUser(User user) {
        return (_users.contains(user));
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
     * @param report report to be added to database
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
     * @param checkedUser user to check password against
     * @return whether or not passwords match and user can log in
     */
    public boolean checkPassword(User checkedUser) {
        if (checkedUser == null) {
            throw new IllegalArgumentException("User cannot be null.");
        }
        for (User runningUser : _users) {
            if (checkedUser.equals(runningUser)) {
                return checkedUser.get_password().equals(runningUser.get_password());
            }
        }
        return false;
    }

}
