package com.example.android.quakereport;

import android.content.AsyncTaskLoader;
import android.content.Context;
import android.os.AsyncTask;

import java.util.List;

/**
 * Created by amrgamal on 24/06/2018.
 */

public class EarthquakeLoader extends AsyncTaskLoader<List<Earthquakeinfo>> {
    private static final String LOG_TAG = EarthquakeLoader.class.getName();
    private String mUrl;

    public EarthquakeLoader(Context context,String url) {
        super(context);
        mUrl=url;
    }

    @Override
    public List<Earthquakeinfo> loadInBackground() {
        if (mUrl==null)
            return null;
       List <Earthquakeinfo> earthquakeinfo=QueryUtils.fetchEarthquakeData(mUrl);
       return  earthquakeinfo;
    }

    @Override
    protected void onStartLoading() {
        forceLoad();
    }

}

