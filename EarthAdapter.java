package com.example.android.quakereport;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Amr Gamal on 2/22/2018.
 */

public class EarthAdapter extends ArrayAdapter<Earthquakeinfo> {


    public EarthAdapter(@NonNull Context context, ArrayList<Earthquakeinfo> objects) {
        super(context, 0, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Earthquakeinfo earthquakeinfo = getItem(position);
        View v = convertView;
        if (v == null) {
            v = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        TextView Mag = (TextView) v.findViewById(R.id.mag);
        String magFromated = formatMagnitude(earthquakeinfo.getMag());
        Mag.setText(magFromated);
        //Display place as offset and place 3ady
        TextView Place = (TextView) v.findViewById(R.id.place);
        TextView offset = (TextView) v.findViewById(R.id.offset);
        String originalPlace = earthquakeinfo.getPlace();
        if (originalPlace.contains("of")) {
            offset.setText(originalPlace.substring(0, originalPlace.indexOf("of")) + "of");
            Place.setText(originalPlace.substring(originalPlace.indexOf("of") + 2, originalPlace.length()));
        } else {
            offset.setText("Near By ");
            Place.setText(earthquakeinfo.getPlace());
        }
        //Display the Date and time
        Date dateObject = new Date(earthquakeinfo.getTime());

        TextView date = (TextView) v.findViewById(R.id.date);
        String formateedDate = formatDate(dateObject);
        date.setText(formateedDate);

        TextView Time = (TextView) v.findViewById(R.id.time);
        String formattedTime = formatTime(dateObject);
        // Display the time of the current earthquake in that TextView
        Time.setText(formattedTime);

        // Set the proper background color on the magnitude circle.
        // Fetch the background from the TextView, which is a GradientDrawable.
        GradientDrawable magnitudeCircle = (GradientDrawable) Mag.getBackground();

        // Get the appropriate background color based on the current earthquake magnitude
        int magnitudeColor = getMagnitudeColor(earthquakeinfo.getMag());

        // Set the color on the magnitude circle
        magnitudeCircle.setColor(magnitudeColor);

        return v;
    }

    private String formatDate(Date dateObject) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("LLL dd, yyyy");
        return dateFormat.format(dateObject);
    }

    /**
     * Return the formatted date string (i.e. "4:30 PM") from a Date object.
     */
    private String formatTime(Date dateObject) {
        SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm a");
        return timeFormat.format(dateObject);
    }

    private String formatMagnitude(double magnitude) {
        DecimalFormat magnitudeFormat = new DecimalFormat("0.0");
        return magnitudeFormat.format(magnitude);
    }

    private int getMagnitudeColor(double mag) {
        int magnitude1Color;
        int magcolor = (int) Math.floor(mag);
        switch (magcolor) {
            case 0:
            case 1:
                magnitude1Color = R.color.magnitude1;
                break;
            case 2:
                magnitude1Color = R.color.magnitude2;
                break;
            case 3:
                magnitude1Color = R.color.magnitude3;
                break;
            case 4:
                magnitude1Color = R.color.magnitude4;
                break;
            case 5:
                magnitude1Color = R.color.magnitude5;
                break;
            case 6:
                magnitude1Color = R.color.magnitude6;
                break;
            case 7:
                magnitude1Color = R.color.magnitude7;
                break;
            case 8:
                magnitude1Color = R.color.magnitude8;
                break;
            case 9:
                magnitude1Color = R.color.magnitude9;
                break;
            default:
                magnitude1Color = R.color.magnitude10plus;
                break;
        }

        return ContextCompat.getColor(getContext(), magnitude1Color);

    }
}
