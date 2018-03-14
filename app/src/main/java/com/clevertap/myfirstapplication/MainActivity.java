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

        fcmRegId = FirebaseInstanceId.getInstance().getToken();
        Log.e("push", FirebaseInstanceId.getInstance().getToken() + " hello");

        clickListeners();

    }

    private void clickListeners() {

        create_event_without_property_novel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    CleverTapAPI.setDebugLevel(1277182231);
                    cleverTap = CleverTapAPI.getInstance(getApplicationContext());

                    HashMap<String, Object> profileUpdate = new HashMap<String, Object>();
                    profileUpdate.put("Name", "Jack Montana");                   // String or number
                    profileUpdate.put("Customer Type", "SUBSCRIBER");
                    profileUpdate.put("Email", "deep+c7@makkajai.com");

                    cleverTap.profile.push(profileUpdate);
                    cleverTap.profile.addMultiValueForKey("Apps", "Monster Math 1");

                } catch (CleverTapMetaDataNotFoundException | CleverTapPermissionsNotSatisfied e) {
                    // thrown if you haven't specified your CleverTap Account ID or Token in your AndroidManifest.xml
                }


            }
        });

        product_viewed_with_property.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    CleverTapAPI.setDebugLevel(1277182231);
                    cleverTap = CleverTapAPI.getInstance(getApplicationContext());

                    HashMap<String, Object> profileUpdate = new HashMap<String, Object>();
                    profileUpdate.put("Name", "Jack Montana");                   // String or number
                    profileUpdate.put("Customer Type", "SUBSCRIBER");
                    profileUpdate.put("Email", "deep+c7@makkajai.com");

                    cleverTap.profile.push(profileUpdate);
                    cleverTap.profile.addMultiValueForKey("Apps", "Monster Math 2");
                } catch (CleverTapMetaDataNotFoundException | CleverTapPermissionsNotSatisfied e) {
                    // thrown if you haven't specified your CleverTap Account ID or Token in your AndroidManifest.xml
                }

            }
        });
    }

    private void init() {
        create_event_without_property_novel = (Button) findViewById(R.id.create_event_without_property_novel);
        product_viewed_with_property = (Button) findViewById(R.id.product_viewed_with_property);
    }









}




