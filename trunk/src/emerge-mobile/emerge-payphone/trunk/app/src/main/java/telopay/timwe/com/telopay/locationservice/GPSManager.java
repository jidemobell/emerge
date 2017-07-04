package telopay.timwe.com.telopay.locationservice;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by timwe.tunji on 10/19/2016.
 */
public class GPSManager implements LocationListener {

    private LocationManager locationManager;
    private Context context;
    private String provider;
    private double latitude;
    private double longitude;

    public GPSManager(Context _context){
        context = _context;
    }

    public void startGPSRequest(){


        try{
            locationManager = DeviceLocationManager.getInstance(context);
            boolean isGpsEnabled = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
            boolean isNetworkEnabled=locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER);

            if(isGpsEnabled==true || isNetworkEnabled==true){
                Log.i("GPS","Location Enabled in GPSManager");
                Criteria criteria = new Criteria();
                provider = locationManager.getBestProvider(criteria, false);
                locationManager.requestLocationUpdates(provider,60000, (float)10.0, this);
                Location location = locationManager.getLastKnownLocation(provider);
                if(location!=null){
                    Log.i("GPS","Location not NULL in GPSManager with provider"+" "+provider);
                    Log.i("GPS","Latitude"+String.valueOf(location.getLatitude()));
                    Log.i("GPS","Longitude"+String.valueOf(location.getLongitude()));

                }
                else{
                    Log.i("GPS","Location values are NULL in GPSManager with provider"+" "+provider);
                    Location loc=getLastBestLocation();
                    if(loc!=null){

                    }
                }
            }
            else{
                Toast.makeText(context,"Please enable your Location Service",Toast.LENGTH_LONG).show();
                Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                context.startActivity(intent);

            }

        }
        catch(IllegalArgumentException ie){
            Toast.makeText(context,"Please enable your Location Service",Toast.LENGTH_LONG).show();
            Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
            context.startActivity(intent);
        }
        catch (SecurityException secException){
            Toast.makeText(context,"Location Service Permission not allowed",Toast.LENGTH_SHORT).show();
        }

    }

    public Location getLastBestLocation() {
        Location locationGPS = null;
        Location locationNet = null;
        try {
            locationGPS = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
            locationNet = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
        }
        catch(SecurityException e){
            Toast.makeText(context,"Location Service Permission not allowed",Toast.LENGTH_SHORT).show();
            return null;
        }

        long GPSLocationTime = 0;
        if (null != locationGPS) {
            GPSLocationTime = locationGPS.getTime();
        }

        long NetLocationTime = 0;

        if (null != locationNet) {
            NetLocationTime = locationNet.getTime();
        }

        if ( 0 < GPSLocationTime - NetLocationTime ) {
            return locationGPS;
        }
        else{
            return locationNet;
        }

    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    @Override
    public void onLocationChanged(Location location) {

         latitude = location.getLatitude();
         longitude = location.getLongitude();

    }

        @Override
        public void onStatusChanged(String provider, int status, Bundle extras) {

        }

        @Override
        public void onProviderEnabled(String provider) {

        }

        @Override
        public void onProviderDisabled(String provider) {

        }
}
