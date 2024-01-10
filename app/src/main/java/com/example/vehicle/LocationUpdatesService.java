package com.example.vehicle;

import android.app.IntentService;
import android.content.Intent;
import android.location.Location;
import com.google.android.gms.location.LocationResult;

public class LocationUpdatesService extends IntentService {

    public LocationUpdatesService() {
        super("LocationUpdatesService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        if (LocationResult.hasResult(intent)) {
            LocationResult locationResult = LocationResult.extractResult(intent);
            Location location = locationResult.getLastLocation();

            // Handle the location update, e.g., update UI with speed
            float speed = location.getSpeed(); // Speed in meters per second
            // You can update the UI with the speed information here
        }
    }
}
