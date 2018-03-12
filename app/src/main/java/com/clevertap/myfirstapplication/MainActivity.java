package com.clevertap.myfirstapplication;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


import com.clevertap.android.sdk.CleverTapAPI;
import com.clevertap.android.sdk.exceptions.CleverTapMetaDataNotFoundException;
import com.clevertap.android.sdk.exceptions.CleverTapPermissionsNotSatisfied;
import com.google.firebase.iid.FirebaseInstanceId;


import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;


/**
 * Created by palashjain on 10/10/17.
 */

public class MainActivity extends AppCompatActivity {

    Button update_user_profile_button,create_event_without_property_novel,
            product_viewed_with_property;
    CleverTapAPI cleverTap;


    String fcmRegId = "";


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();





        try {
            CleverTapAPI.setDebugLevel(3);
            cleverTap = CleverTapAPI.getInstance(getApplicationContext());

        } catch (CleverTapMetaDataNotFoundException e) {
            // thrown if you haven't specified your CleverTap Account ID or Token in your AndroidManifest.xml
        } catch (CleverTapPermissionsNotSatisfied e) {
            // thrown if you haven’t requested the required permissions in your AndroidManifest.xml
        }


//














        fcmRegId = FirebaseInstanceId.getInstance().getToken();
        Log.e("push", FirebaseInstanceId.getInstance().getToken() + " hello");


        clickListeners();

    }

    private void clickListeners() {



        update_user_profile_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HashMap<String, Object> profileUpdate = new HashMap<String, Object>();
                profileUpdate.put("Name", "Jack Montana");                   // String or number
                profileUpdate.put("Email", "jack123456@gmail.com");
                profileUpdate.put("Identity", 91026032);             // Email address of the user
                profileUpdate.put("Phone", "9920879978");                 // Phone (with the country code, starting with +)
                profileUpdate.put("Gender", "M");                           // Can be either M or F
                profileUpdate.put("Employed", "Y");                         // Can be either Y or N
                profileUpdate.put("Education", "Graduate");                 // Can be either Graduate, College or School
                profileUpdate.put("Married", "Y");                          // Can be either Y or N
                profileUpdate.put("DOB", new Date());                       // Date of Birth. Set the Date object to the appropriate value first
                profileUpdate.put("Age", 28);                               // Not required if DOB is set
                profileUpdate.put("Tz", "Asia/Kolkata");

                cleverTap.profile.push(profileUpdate);


            }
        });






        create_event_without_property_novel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // To set a multi-value property
                ArrayList<String> stuff = new ArrayList<String>();
                stuff.add("bag new 99");
                stuff.add("bag new 100");
                cleverTap.profile.addMultiValuesForKey("TestNew", stuff);

            }
        });



        product_viewed_with_property.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ArrayList<String> stuff = new ArrayList<String>();
                stuff.add("bag new 2");
                stuff.add("bag new 1234567");
                cleverTap.profile.addMultiValuesForKey("TestNew", stuff);

            }
        });



    }

    private void init() {

        update_user_profile_button = (Button) findViewById(R.id.update_user_profile_button);
        create_event_without_property_novel = (Button) findViewById(R.id.create_event_without_property_novel);
        product_viewed_with_property = (Button) findViewById(R.id.product_viewed_with_property);


    }









}




