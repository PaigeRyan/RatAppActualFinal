package doperatz.rattracker.Model;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class DatabaseManager {
    private final DatabaseReference mDatabase;
    private final DatabaseReference rDatabase;

    public DatabaseManager() {
        mDatabase = FirebaseDatabase.getInstance().getReference().child("ratreportdata");
        rDatabase = FirebaseDatabase.getInstance().getReference("recentreportdata");
    }

    public DatabaseReference getDatabaseRef() {
        return this.mDatabase;
    }
    public DatabaseReference getRecentRef() { return this.rDatabase; }
}
