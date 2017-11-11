package doperatz.rattracker.Model;

import android.os.Parcel;
import android.os.Parcelable;

public class RatReport implements Parcelable {
    public String getUniqueKey() {
        return uniqueKey;
    }

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
    private String uniqueKey;
    private String createdDate;
    private String locationType;
    private String incidentZip;
    private String incidentAddress;
    private String city;
    private String borough;
    private String latitude;
    private String longitude;

    public RatReport() {}

    public RatReport(String uniqueKey, String createdDate, String locationType, String incidentZip,
                     String incidentAddress, String city, String borough, String latitude, String longitude) {
        this.uniqueKey = uniqueKey;
        this.createdDate = createdDate;
        this.locationType = locationType;
        this.incidentAddress = incidentAddress;
        this.incidentZip = incidentZip;
        this.city = city;
        this.borough = borough;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    private String[] returnInfo() {
        return new String[] {uniqueKey, createdDate, locationType, incidentZip, incidentAddress, city, borough, latitude, longitude};
    }

    public String toString() {
        return String.format("%s, %s, %s", uniqueKey, incidentAddress, borough);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel out, int flags) {
        for (String item : returnInfo()) {
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
        uniqueKey = in.readString();
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
