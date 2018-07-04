package com.example.android.quakereport;

/**
 * Created by Amr Gamal on 2/22/2018.
 */

public class Earthquakeinfo {
    private double Mag;
    private String Place;
    private long Time;
    private String Url;


    public Earthquakeinfo(double mag  ,String place,long time,String url)
    {
        Url=url;
        Mag=mag;
        Place=place;
        Time=time;
    }

    public String getUrl() {
        return Url;
    }

    public double getMag() {
        return Mag;
    }

    public String getPlace() {
        return Place;
    }

    public long getTime() {
        return Time;
    }
}
