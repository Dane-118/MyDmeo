package com.example.mydmeo.bean;

import android.os.Parcel;
import android.os.Parcelable;


/**
 * @author mac
 */
public class City implements Parcelable {
    /**
     * station_name : 阿龙山
     * station_telecode : ASX
     * station_zmfe : als
     * station_pinyin : alongshan
     * station_telecode_qn : ASX
     * station_zmfe_qn : als
     * station_pinyin_qn : alongshan
     */


    private String station_name;
    public City() {
    }

    protected City(Parcel in) {
        station_name = in.readString();
    }

    public static final Creator<City> CREATOR = new Creator<City>() {
        @Override
        public City createFromParcel(Parcel in) {
            return new City(in);
        }

        @Override
        public City[] newArray(int size) {
            return new City[size];
        }
    };

    public String getStation_name() {
        return station_name;
    }

    public void setStation_name(String station_name) {
        this.station_name = station_name;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(station_name);
    }
}
