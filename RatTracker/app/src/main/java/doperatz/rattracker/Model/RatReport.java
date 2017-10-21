package doperatz.rattracker.Model;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Josh on 10/7/2017.
 */

public class RatReport implements Parcelable {
    public String getCreatedDate() {
        return createdDate;
    }

    public String getLocationType() {
        return locationType;
    }

    public String getIncidentZip() {
        return incidentZip;
    }

    public String getIncidentAddress() {
        return incidentAddress;
    }

    public String getCity() {
        return city;
    }

    public String getBorough() {
        return borough;
    }

    public String getLatitude() {
        return latitude;
    }

    public String getLongitude() {
        return longitude;
    }
    private static int runningKey = 1;
    private int uniqueKey;
    private String createdDate;
    private String locationType;
    private String incidentZip;
    private String incidentAddress;
    private String city;
    private String borough;
    private String latitude;
    private String longitude;



    public RatReport(String createdDate, String locationType, String incidentZip,
                     String incidentAddress, String city, String borough, String latitude, String longitude) {
        this.uniqueKey = runningKey;
        runningKey++;
        this.createdDate = createdDate;
        this.locationType = locationType;
        this.incidentAddress = incidentAddress;
        this.incidentZip = incidentZip;
        this.city = city;
        this.borough = borough;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public int getUniqueKey() {
        return uniqueKey;
    }

    public String[] getInfo() {
        String[] word = {Integer.toString(uniqueKey), createdDate, locationType, incidentZip, incidentAddress, city, borough, latitude, longitude};
        return word;
    }

    public String toString() {
        return String.format("%s, %s, %s", uniqueKey, incidentAddress, borough);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel out, int flags) {
        for (String item : getInfo()) {
            out.writeString(item);
        }
    }

    public static final Parcelable.Creator<RatReport> CREATOR
            = new Parcelable.Creator<RatReport>() {
        public RatReport createFromParcel(Parcel in) {
            return new RatReport(in);
        }

        public RatReport[] newArray(int size) {
            return new RatReport[size];
        }
    };

    private RatReport(Parcel in) {
        uniqueKey = Integer.parseInt(in.readString());
        createdDate = in.readString();
        locationType = in.readString();
        incidentZip = in.readString();
        incidentAddress = in.readString();
        city = in.readString();
        borough = in.readString();
        latitude = in.readString();
        longitude = in.readString();
    }
}
