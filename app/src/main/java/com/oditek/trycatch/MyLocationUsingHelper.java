package com.oditek.trycatch;

import android.content.Intent;
import android.location.Address;
import android.location.Location;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat.OnRequestPermissionsResultCallback;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.oditek.trycatch.LocationUtil.LocationHelper;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MyLocationUsingHelper extends AppCompatActivity implements ConnectionCallbacks,
        OnConnectionFailedListener,OnRequestPermissionsResultCallback {


    @BindView(R.id.btnLocation)Button btnProceed;
    @BindView(R.id.tvAddress)TextView tvAddress;



    private Location mLastLocation;

    double latitude;
    double longitude;

    LocationHelper locationHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location_service);

        locationHelper=new LocationHelper(this);
        locationHelper.checkpermission();

        ButterKnife.bind(this);

         btnProceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Intent in = new Intent(MyLocationUsingHelper.this,MainActivityDraw.class);
               startActivity(in);
            }
        });


        // check availability of play services
        if (locationHelper.checkPlayServices()) {

            // Building the GoogleApi client
            locationHelper.buildGoogleApiClient();
        }

    }


    public void getAddress()
    {
        Address locationAddress;

        locationAddress=locationHelper.getAddress(latitude,longitude);

        if(locationAddress!=null)
        {

            String address = locationAddress.getAddressLine(0);
 //           String address1 = locationAddress.getAddressLine(1);
            String city = locationAddress.getLocality();
//            String state = locationAddress.getAdminArea();
//            String country = locationAddress.getCountryName();
//            String postalCode = locationAddress.getPostalCode();


            String currentLocation;

            if(!TextUtils.isEmpty(address))
            {
                currentLocation=address;

//                if (!TextUtils.isEmpty(address1))
//                    currentLocation+="\n"+address1;

                if (!TextUtils.isEmpty(city))
                {
                    currentLocation=city;

//                    if (!TextUtils.isEmpty(postalCode))
//                        currentLocation+=" - "+postalCode;
                }
                else
                {
//                    if (!TextUtils.isEmpty(postalCode))
//                        currentLocation+="\n"+postalCode;
              }

//                if (!TextUtils.isEmpty(state))
//                    currentLocation+="\n"+state;
//
//                if (!TextUtils.isEmpty(country))
//                    currentLocation+="\n"+country;


                tvAddress.setText(currentLocation);
                tvAddress.setVisibility(View.VISIBLE);

            }

        }
        else
            showToast("Something went wrong");
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        locationHelper.onActivityResult(requestCode,resultCode,data);
    }


    @Override
    protected void onResume() {
        super.onResume();
        locationHelper.checkPlayServices();
    }

    /**
     * Google api callback methods
     */
    @Override
    public void onConnectionFailed(ConnectionResult result) {
        Log.i("Connection failed:", " ConnectionResult.getErrorCode() = "
                + result.getErrorCode());
    }

    @Override
    public void onConnected(Bundle arg0) {

        // Once connected with google api, get the location

        mLastLocation=locationHelper.getLocation();

        if (mLastLocation != null) {
            latitude = mLastLocation.getLatitude();
            longitude = mLastLocation.getLongitude();
            getAddress();

        } else {

            showToast("Couldn't get the location. Make sure location is enabled on the device");
        }
    }

    @Override
    public void onConnectionSuspended(int arg0) {
        locationHelper.connectApiClient();
    }


    // Permission check functions
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        // redirects to utils
        locationHelper.onRequestPermissionsResult(requestCode,permissions,grantResults);

    }

    public void showToast(String message)
    {
        Toast.makeText(this,message, Toast.LENGTH_SHORT).show();
    }



}
