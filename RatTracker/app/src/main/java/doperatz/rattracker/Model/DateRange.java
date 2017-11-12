package doperatz.rattracker.Model;

import android.os.Parcel;
import android.os.Parcelable;

public class DateRange implements Parcelable {



    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    public int getYear() {
        return year;
    }

    private final int month;
    private final int day;
    private final int year;

    public DateRange(int month, int day, int year) {
        if (month < 1 | month > 12 | day < 0 | day > 31 | year < 1950) {
            throw new IllegalArgumentException();
        }
        this.day = day;
        this.month = month;
        this.year = year;
    }

    /**
     * compares a date object with another
     * @param otherDate, the other date to compare with
     * @return an integer representing the comparison
     */
    public int compare(DateRange otherDate) {
        if (otherDate == null) {
          throw new IllegalArgumentException();
        } else if (year != otherDate.year) {
            return year - otherDate.year;
        } else if (month != otherDate.month) {
            return month - otherDate.month;
        } else {
            return day - otherDate.day;
        }
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel out, int flags) {
        out.writeInt(month);
        out.writeInt(day);
        out.writeInt(year);
    }

    private DateRange(Parcel in) {
        month = in.readInt();
        day = in.readInt();
        year = in.readInt();
    }


    public static final Parcelable.Creator<DateRange> CREATOR
            = new Parcelable.Creator<DateRange>() {
        public DateRange createFromParcel(Parcel in) {
            return new DateRange(in);
        }

        public DateRange[] newArray(int size) {
            return new DateRange[size];
        }
    };
}
