package com.halo.loginui2;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.ContextCompat;
import android.widget.ImageView;

import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.List;


public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {
    private static final String TAG = "MapsActivity";
    private static final float DEFAULT_ZOOM=15f;
private ImageView mGps;
    private GoogleMap mMap;
    LocationManager locationManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);




















        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }

        //check network provider enabled
        if(locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER)){

            locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, new LocationListener() {
                @Override
                public void onLocationChanged(Location location) {
                    double latitude=location.getLatitude();
                    double longitude=location.getLongitude();
                    LatLng latLng=new LatLng(latitude,longitude);
                    //instantiate class geo coder
                    Geocoder geocoder=new Geocoder((getApplicationContext()));
                    try {
                        List<Address> addressList=geocoder.getFromLocation(latitude,longitude,1);
                        String str=addressList.get(0).getLocality()+",";
                        str+=addressList.get(0).getCountryName();
                        mMap.addMarker(new MarkerOptions().position(latLng).title("Me"));
                        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));


                    } catch (IOException e) {
                        e.printStackTrace();
                    }


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
            });


            }




            else if(locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)){
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, new LocationListener() {
                @Override
                public void onLocationChanged(Location location) {




                    double latitude=location.getLatitude();
                    double longitude=location.getLongitude();
                    LatLng latLng=new LatLng(latitude,longitude);
                    //instantiate class geo coder
                    Geocoder geocoder=new Geocoder((getApplicationContext()));
                    try {
                        List<Address> addressList=geocoder.getFromLocation(latitude,longitude,1);
                        String str=addressList.get(0).getLocality()+",";
                        str+=addressList.get(0).getCountryName();

                        mMap.addMarker(new MarkerOptions().position(latLng).title("Me"));
                        mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));

                    } catch (IOException e) {
                        e.printStackTrace();
                    }









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
            });
        }





    }








    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add gym markers all over the globe and Nairobi

        LatLng strathmore = new LatLng(1.3089,36.8121);
        mMap.addMarker(new MarkerOptions().position(strathmore).title("Strathmore Gym"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(strathmore));




        LatLng ponte = new LatLng( 28.0571,26.1906);
        googleMap.addMarker(new MarkerOptions().position(ponte)
                .title("Ponte Gym"));
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(ponte));







        LatLng kampala = new LatLng(0.3476, 32.5825);
        googleMap.addMarker(new MarkerOptions().position(kampala)
                .title("Kampala Gym"));
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(kampala));




















    }
}