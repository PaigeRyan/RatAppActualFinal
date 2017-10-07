package doperatz.rattracker.Model;

/**
 * Created by Josh on 10/7/2017.
 */

public class RatReport {
    private String uniqueKey;
    private String createdDate;
    private String locationType;
    private String incidentZip;
    private String incidentAddress;
    private String city;
    private String borough;
    private String latitude;
    private String longitude;



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
}
