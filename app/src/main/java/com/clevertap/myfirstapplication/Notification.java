package com.clevertap.myfirstapplication;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.clevertap.android.sdk.CleverTapAPI;

/**
 * Created by palashjain on 30/10/17.
 */

public class Notification extends AppCompatActivity {


    @Override
    protected void onNewIntent(Intent intent) {
        try {
            CleverTapAPI.getInstance(this).event.pushNotificationEvent(intent.getExtras());
        } catch (Throwable t) {
            t.printStackTrace();
        }
        super.onNewIntent(intent);
    }



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_noti);

    }
}

//package com.clevertap.myfirstapplication;
//
//        import android.content.Intent;
//        import android.os.Bundle;
//        import android.support.annotation.Nullable;
//        import android.support.v7.app.AppCompatActivity;
//        import android.util.Log;
//        import android.view.View;
//        import android.widget.Button;
//        import android.widget.Toast;
//
//        import com.android.volley.AuthFailureError;
//        import com.android.volley.Request;
//        import com.android.volley.RequestQueue;
//        import com.android.volley.Response;
//        import com.android.volley.VolleyError;
//        import com.android.volley.toolbox.JsonObjectRequest;
//        import com.android.volley.toolbox.StringRequest;
//        import com.android.volley.toolbox.Volley;
//        import com.appsflyer.AppsFlyerConversionListener;
//        import com.appsflyer.AppsFlyerLib;
//        import com.clevertap.android.sdk.CleverTapAPI;
//        import com.clevertap.android.sdk.exceptions.CleverTapMetaDataNotFoundException;
//        import com.clevertap.android.sdk.exceptions.CleverTapPermissionsNotSatisfied;
//        import com.clevertap.android.sdk.exceptions.InvalidEventNameException;
//        import com.google.firebase.iid.FirebaseInstanceId;
//
//        import org.json.JSONArray;
//        import org.json.JSONException;
//        import org.json.JSONObject;
//
//        import java.util.ArrayList;
//        import java.util.Date;
//        import java.util.HashMap;
//        import java.util.Map;
//
//
///**
// * Created by palashjain on 10/10/17.
// */
//
//public class MainActivity extends AppCompatActivity {
//
//    Button upload_device_token_button,update_user_profile_button,create_event_without_property,create_event_without_property_novel,
//            product_viewed_with_property,user_1,user_2,user_3;
//    CleverTapAPI cleverTap;
//    AppsFlyerLib appsFlyerLib ;
//
//    int i = 150;
//    int k = 1;
//
//    private static final String AF_DEV_KEY = "k7cxex2tpnTwrVwhdpYj2A";
//
//
//    String fcmRegId = "";
//
//
//
////    @Override
////    protected void onNewIntent(Intent intent) {
////        try {
////            CleverTapAPI.getInstance(this).event.pushNotificationEvent(intent.getExtras());
////
////            Log.e("hey",intent.getExtras() + " ");
////        } catch (Throwable t) {
////            t.printStackTrace();
////        }
////        super.onNewIntent(intent);
////    }
//
//
//
//    @Override
//    protected void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        init();
//
//
//
//
//
//        try {
//            CleverTapAPI.setDebugLevel(3);
//            cleverTap = CleverTapAPI.getInstance(getApplicationContext());
//        } catch (CleverTapMetaDataNotFoundException e) {
//            // thrown if you haven't specified your CleverTap Account ID or Token in your AndroidManifest.xml
//        } catch (CleverTapPermissionsNotSatisfied e) {
//            // thrown if you haven’t requested the required permissions in your AndroidManifest.xml
//        }
//
//
//
//
////        // Read key value pairs from an incoming notification
////        try {
////            Bundle extras = getIntent().getExtras();
////            for (String key : extras.keySet()) {
////                Log.i("StarterProject", "key = " + key + "; value = " + extras.get(key).toString());
////
////            }
////        } catch (Exception e) {
////            // Ignore
////        }
//
//
//        String attributionID = cleverTap.getCleverTapAttributionIdentifier();
//        AppsFlyerLib.getInstance().setCustomerUserId(attributionID);
//
//
//
//
//        AppsFlyerConversionListener conversionDataListener = new AppsFlyerConversionListener() {
//
//            @Override
//            public void onInstallConversionDataLoaded(Map<String, String> map) {
//
//            }
//
//            @Override
//            public void onInstallConversionFailure(String s) {
//
//            }
//
//            @Override
//            public void onAppOpenAttribution(Map<String, String> map) {
//
//            }
//
//            @Override
//            public void onAttributionFailure(String s) {
//
//            }
//        };
//
//        AppsFlyerLib.getInstance().init(AF_DEV_KEY, conversionDataListener);
//
//
//
//        AppsFlyerLib.getInstance().startTracking(getApplication(), AF_DEV_KEY);
//
//
//
//
//
//        fcmRegId = FirebaseInstanceId.getInstance().getToken();
//        Log.e("push", FirebaseInstanceId.getInstance().getToken() + " hello");
//
//
//
//
//
//
//
//
//
//
//        clickListeners();
//
//    }
//
//    private void clickListeners() {
//
//        upload_device_token_button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(MainActivity.this, fcmRegId, Toast.LENGTH_SHORT).show();
//                cleverTap.data.pushFcmRegistrationId(fcmRegId, true);
//            }
//        });
//
//
//        update_user_profile_button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//
//
//
////                ArrayList<String> newStuff = new ArrayList<String>();
////                newStuff.add("socks");
////                newStuff.add("scarf");
////                cleverTap.profile.addMultiValuesForKey("mystuff", newStuff);
//
//
//
////                HashMap<String, Object> prodViewedAction = new HashMap<String, Object>();
////                prodViewedAction.put("Product Name", "Skull candy Headphones");
////                prodViewedAction.put("Category", "Headphones");
////                prodViewedAction.put("Price", 59.99);
////                prodViewedAction.put("Date", new java.util.Date());
////
////                cleverTap.event.push("Headphone Viewed", prodViewedAction);
//
//
////
////                        // each of the below mentioned fields are optional
////// if set, these populate demographic information in the Dashboard
////        HashMap<String, Object> profileUpdate = new HashMap<String, Object>();
////        profileUpdate.put("Name", "Palash Jain");                  // String
////        profileUpdate.put("Identity", 61026032);                    // String or number
////        profileUpdate.put("Email", "aditi@clevertap.com");               // Email address of the user
////        profileUpdate.put("Phone", "+919923870479");                 // Phone (with the country code, starting with +)
////        profileUpdate.put("Gender", "M");                           // Can be either M or F
////        profileUpdate.put("Employed", "Y");                         // Can be either Y or N
////        profileUpdate.put("Education", "Graduate");                 // Can be either Graduate, College or School
////        profileUpdate.put("Married", "N");                          // Can be either Y or N
////     //   profileUpdate.put("DOB", new Date());                       // Date of Birth. Set the Date object to the appropriate value first
////        profileUpdate.put("Age", 23);                               // Not required if DOB is set
////        profileUpdate.put("Tz", "Asia/Kolkata");                    //an abbreviation such as "PST", a full name such as "America/Los_Angeles",
////        //or a custom ID such as "GMT-8:00"
////        profileUpdate.put("Photo", "http://clipart-library.com/image_gallery/391479.png");    // URL to the Image
////
////     // optional fields. controls whether the user will be sent email, push etc.
////        profileUpdate.put("MSG-email", true);                      // Disable email notifications
////        profileUpdate.put("MSG-push", true);                        // Enable push notifications
////        profileUpdate.put("MSG-sms", true);                        // Disable SMS notifications
////
////        ArrayList<String> stuff = new ArrayList<String>();
////        stuff.add("bag");
////        stuff.add("shoes");
////        profileUpdate.put("MyStuff", stuff);                        //ArrayList of Strings
////
////        String[] otherStuff = {"Jeans","Perfume"};
////        profileUpdate.put("MyStuff", otherStuff);                   //String Array
////
////        cleverTap.profile.push(profileUpdate);
//
//
//
//
//
//                // each of the below mentioned fields are optional
//// if set, these populate demographic information in the Dashboard
//                HashMap<String, Object> profileUpdate = new HashMap<String, Object>();
//                profileUpdate.put("Name", "Jack Montana");                  // String
//                profileUpdate.put("Identity", 61026032);                    // Email address of the user
//                profileUpdate.put("Phone", "+14155551234");                 // Phone (with the country code, starting with +)
//                profileUpdate.put("Gender", "M");                           // Can be either M or F
//                profileUpdate.put("Employed", "Y");                         // Can be either Y or N
//                profileUpdate.put("Education", "Graduate");                 // Can be either Graduate, College or School
//                profileUpdate.put("Married", "Y");                          // Can be either Y or N
//                profileUpdate.put("DOB", new Date());                       // Date of Birth. Set the Date object to the appropriate value first
//                profileUpdate.put("Age", 28);                               // Not required if DOB is set
//                profileUpdate.put("Tz", "Asia/Kolkata");                    //an abbreviation such as "PST", a full name such as "America/Los_Angeles",
//                //or a custom ID such as "GMT-8:00"
//                profileUpdate.put("Photo", "www.foobar.com/image.jpeg");    // URL to the Image
//
//// optional fields. controls whether the user will be sent email, push etc.
//                profileUpdate.put("MSG-email", false);                      // Disable email notifications
//                profileUpdate.put("MSG-push", true);                        // Enable push notifications
//                profileUpdate.put("MSG-sms", false);                        // Disable SMS notifications
//
//                ArrayList<String> stuff = new ArrayList<String>();
//                stuff.add("bag");
//                stuff.add("shoes");
//                profileUpdate.put("MyStuff", stuff);                        //ArrayList of Strings
//
//                String[] otherStuff = {"Jeans","Perfume"};
//                profileUpdate.put("MyStuff", otherStuff);                   //String Array
//
//                cleverTap.profile.push(profileUpdate);
//
//
//
//
//            }
//        });
//
//
//        create_event_without_property.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//
//
//
//
//
//
//
//
//
//                HashMap<String, Object> prodViewedAction = new HashMap<String, Object>();
//                prodViewedAction.put("Product Name", "Bose Headphones");
//                prodViewedAction.put("Category", "Headphones");
//                prodViewedAction.put("Price", 59.99);
//                prodViewedAction.put("Date", new java.util.Date());
//
//                cleverTap.event.push("Headphone Viewed", prodViewedAction);
//
//
//
//
////                HashMap<String, Object> profileUpdate = new HashMap<String, Object>();
////                profileUpdate.put("Name", "Shalani Sinha");                  // String
////                profileUpdate.put("Identity", 1189549);                    // String or number
////                profileUpdate.put("Email", "shalinisinha40@gmail.com");               // Email address of the user
////                profileUpdate.put("Phone", "+917032407362");                 // Phone (with the country code, starting with +)
////                profileUpdate.put("Gender", "F");                           // Can be either M or F
////                profileUpdate.put("Employed", "Y");                         // Can be either Y or N
////                profileUpdate.put("Education", "Graduate");                 // Can be either Graduate, College or School
////                profileUpdate.put("Married", "N");                          // Can be either Y or N
////                //   profileUpdate.put("DOB", new Date());                       // Date of Birth. Set the Date object to the appropriate value first
////                profileUpdate.put("Age", 23);                               // Not required if DOB is set
////                profileUpdate.put("Tz", "Asia/Kolkata");                    //an abbreviation such as "PST", a full name such as "America/Los_Angeles",
////                //or a custom ID such as "GMT-8:00"
////                profileUpdate.put("Photo", "http://clipart-library.com/image_gallery/391479.png");    // URL to the Image
////
////                // optional fields. controls whether the user will be sent email, push etc.
////                profileUpdate.put("MSG-email", true);                      // Disable email notifications
////                profileUpdate.put("MSG-push", true);                        // Enable push notifications
////                profileUpdate.put("MSG-sms", true);                        // Disable SMS notifications
////
////                ArrayList<String> stuff = new ArrayList<String>();
////                stuff.add("bag");
////                stuff.add("shoes");
////                profileUpdate.put("MyStuff", stuff);                        //ArrayList of Strings
////
////                String[] otherStuff = {"Jeans","Perfume"};
////                profileUpdate.put("MyStuff", otherStuff);                   //String Array
////
////                cleverTap.profile.push(profileUpdate);
//
//
//
////                HashMap<String, Object> chargeDetails = new HashMap<String, Object>();
////                chargeDetails.put("Amount", 300);
////                chargeDetails.put("Payment Mode", "Credit card");
////                chargeDetails.put("Charged ID", 24052013); // important to avoid duplicate transactions due to network failure
////
////                HashMap<String, Object> item1 = new HashMap<String, Object>();
////                item1.put("Product category", "books");
////                item1.put("Book name", "The Millionaire next door");
////                item1.put("Quantity", 1);
////
////                HashMap<String, Object> item2 = new HashMap<String, Object>();
////                item2.put("Product category", "books");
////                item2.put("Book name", "Achieving inner zen");
////                item2.put("Quantity", 1);
////
////                HashMap<String, Object> item3 = new HashMap<String, Object>();
////                item3.put("Product category", "books");
////                item3.put("Book name", "Chuck it, let's do it");
////                item3.put("Quantity", 5);
////
////
////                ArrayList<HashMap<String, Object>> items = new ArrayList<HashMap<String, Object>>();
////                items.add(item1);
////                items.add(item2);
////                items.add(item3);
////
////                try {
////                    cleverTap.event.push(CleverTapAPI.CHARGED_EVENT, chargeDetails, items);
////                } catch (InvalidEventNameException e) {
////                    // You have to specify the first parameter to push()
////                    // as CleverTapAPI.CHARGED_EVENT
////                }
//
//                Toast.makeText(MainActivity.this, "event charged books", Toast.LENGTH_SHORT).show();
//
//            }
//        });
//
//
//
//        create_event_without_property_novel.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//
////                HashMap<String, Object> chargeDetails = new HashMap<String, Object>();
////                chargeDetails.put("Amount", 300);
////                chargeDetails.put("Payment Mode", "Credit card");
////                chargeDetails.put("Charged ID", 24052012); // important to avoid duplicate transactions due to network failure
////
////                HashMap<String, Object> item1 = new HashMap<String, Object>();
////                item1.put("Product category", "books");
////                item1.put("Book name", "The Millionaire next door");
////                item1.put("Quantity", 1);
////
////
////
////
////
////                HashMap<String, Object> item4 = new HashMap<String, Object>();
////                item4.put("Product category", "novel");
////                item4.put("novel name", "Rich dad poor dad");
////                item4.put("Quantity", 5);
////
////                ArrayList<HashMap<String, Object>> items = new ArrayList<HashMap<String, Object>>();
////                items.add(item1);
////                items.add(item4);
////
////                try {
////                    cleverTap.event.push(CleverTapAPI.CHARGED_EVENT, chargeDetails, items);
////                } catch (InvalidEventNameException e) {
////                    // You have to specify the first parameter to push()
////                    // as CleverTapAPI.CHARGED_EVENT
////                }
//
//
//                HashMap<String, Object> prodViewedAction = new HashMap<String, Object>();
//                prodViewedAction.put("Product Name", "Creative Headphones");
//                prodViewedAction.put("Category", "Headphones");
//                prodViewedAction.put("Price", 59.99);
//                prodViewedAction.put("Date", new java.util.Date());
//
//                cleverTap.event.push("Headphone Viewed", prodViewedAction);
//
//                Toast.makeText(MainActivity.this, "event charged novel", Toast.LENGTH_SHORT).show();
//
//            }
//        });
//
//
//
//        product_viewed_with_property.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//
//                HashMap<String, Object> prodViewedAction = new HashMap<String, Object>();
//                prodViewedAction.put("Product Name", "JBL Headphones");
//                prodViewedAction.put("Category", "Headphones");
//                prodViewedAction.put("Price", 59.99);
//                prodViewedAction.put("Date", new java.util.Date());
//
//                cleverTap.event.push("Headphone Viewed", prodViewedAction);
//
//
//
//            }
//        });
//
//
//        user_1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//
//
//
//                // each of the below mentioned fields are optional
//// with the exception of one of Identity, Email, FBID or GPID
////                HashMap<String, Object> profileUpdate = new HashMap<String, Object>();
////                profileUpdate.put("Name", "Jack Montana");    // String
////                profileUpdate.put("Identity", 61026032);      // String or number
////                profileUpdate.put("Email", "jack@gmail.com"); // Email address of the user
////                profileUpdate.put("Phone", "+14155551234");   // Phone (with the country code, starting with +)
////                profileUpdate.put("Gender", "M");             // Can be either M or F
////                profileUpdate.put("Employed", "Y");           // Can be either Y or N
////                profileUpdate.put("Education", "Graduate");   // Can be either Graduate, College or School
////                profileUpdate.put("Married", "Y");            // Date of Birth. Set the Date object to the appropriate value first
////                profileUpdate.put("Age", 28);                 // Not required if DOB is set
////
////// optional fields. controls whether the user will be sent email, push etc.
////                profileUpdate.put("MSG-email", false);        // Disable email notifications
////                profileUpdate.put("MSG-push", true);          // Enable push notifications
////                profileUpdate.put("MSG-sms", false);          // Disable SMS notifications
////
////                ArrayList<String> stuff = new ArrayList<String>();
////                stuff.add("bag");
////                stuff.add("shoes");
////                profileUpdate.put("MyStuff", stuff);                        //ArrayList of Strings
////
////                String[] otherStuff = {"Jeans","Perfume"};
////                profileUpdate.put("MyStuff", otherStuff);                   //String Array
////
////
////                cleverTap.onUserLogin(profileUpdate);
//
//
//                // each of the below mentioned fields are optional
//// if set, these populate demographic information in the Dashboard
//                HashMap<String, Object> profileUpdate = new HashMap<String, Object>();
//                profileUpdate.put("Name", "Palash Jain");                  // String
//                profileUpdate.put("Identity", 61026033);                    // Email address of the user
//                profileUpdate.put("Phone", "+14155551234");                 // Phone (with the country code, starting with +)
//                profileUpdate.put("Gender", "M");                           // Can be either M or F
//                profileUpdate.put("Employed", "Y");                         // Can be either Y or N
//                profileUpdate.put("Education", "Graduate");                 // Can be either Graduate, College or School
//                profileUpdate.put("Married", "Y");                          // Can be either Y or N
//                profileUpdate.put("DOB", new Date());                       // Date of Birth. Set the Date object to the appropriate value first
//                profileUpdate.put("Age", 28);                               // Not required if DOB is set
//                profileUpdate.put("Tz", "Asia/Kolkata");                    //an abbreviation such as "PST", a full name such as "America/Los_Angeles",
//                //or a custom ID such as "GMT-8:00"
//                profileUpdate.put("Photo", "www.foobar.com/image.jpeg");    // URL to the Image
//
//// optional fields. controls whether the user will be sent email, push etc.
//                profileUpdate.put("MSG-email", false);                      // Disable email notifications
//                profileUpdate.put("MSG-push", true);                        // Enable push notifications
//                profileUpdate.put("MSG-sms", false);                        // Disable SMS notifications
//
//                ArrayList<String> stuff = new ArrayList<String>();
//                stuff.add("bag");
//                stuff.add("shoes");
//                profileUpdate.put("MyStuff", stuff);                        //ArrayList of Strings
//
//                String[] otherStuff = {"Jeans","Perfume"};
//                profileUpdate.put("MyStuff", otherStuff);                   //String Array
//
//                cleverTap.profile.push(profileUpdate);
//
//
//
//
//
//                Toast.makeText(MainActivity.this, "profile Updated", Toast.LENGTH_SHORT).show();
//
//
//            }
//        });
//
//
//        user_2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//
//
//
//                volleyApiHit();
//
//
////
////
////                // each of the below mentioned fields are optional
////// with the exception of one of Identity, Email, FBID or GPID
////                HashMap<String, Object> profileUpdate = new HashMap<String, Object>();
////                profileUpdate.put("Name", "John");    // String
////                profileUpdate.put("Identity", 61026033);      // String or number
////                profileUpdate.put("Email", "rachel@gmail.com"); // Email address of the user
////                profileUpdate.put("Phone", "+14155551235");   // Phone (with the country code, starting with +)
////                profileUpdate.put("Gender", "M");             // Can be either M or F
////                profileUpdate.put("Employed", "Y");           // Can be either Y or N
////                profileUpdate.put("Education", "Graduate");   // Can be either Graduate, College or School
////                profileUpdate.put("Married", "Y");            // Date of Birth. Set the Date object to the appropriate value first
////                profileUpdate.put("Age", 28);                 // Not required if DOB is set
////
////// optional fields. controls whether the user will be sent email, push etc.
////                profileUpdate.put("MSG-email", false);        // Disable email notifications
////                profileUpdate.put("MSG-push", true);          // Enable push notifications
////                profileUpdate.put("MSG-sms", false);          // Disable SMS notifications
////
////                ArrayList<String> stuff = new ArrayList<String>();
////                stuff.add("bag");
////                stuff.add("shoes");
////                profileUpdate.put("MyStuff", stuff);                        //ArrayList of Strings
////
////                String[] otherStuff = {"Jeans","Perfume"};
////                profileUpdate.put("MyStuff", otherStuff);                   //String Array
////
////
////                cleverTap.onUserLogin(profileUpdate);
//
//
//
//
//
////                ArrayList<String> mystuff = new ArrayList<String>();
////                mystuff.add("bag4");
////
////                cleverTap.profile.addMultiValuesForKey("mystuff", mystuff);
//
//
//                Toast.makeText(MainActivity.this, "profile Updated", Toast.LENGTH_SHORT).show();
//
//            }
//        });
//
//
//        user_3.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//
//
//                // each of the below mentioned fields are optional
//// with the exception of one of Identity, Email, FBID or GPID
//                HashMap<String, Object> profileUpdate = new HashMap<String, Object>();
//                profileUpdate.put("Name", "Jill");    // String
//                profileUpdate.put("Identity", 61026035);      // String or number
//                profileUpdate.put("Email", "jill@gmail.com"); // Email address of the user
//                profileUpdate.put("Phone", "+14155551234");   // Phone (with the country code, starting with +)
//                profileUpdate.put("Gender", "M");             // Can be either M or F
//                profileUpdate.put("Employed", "Y");           // Can be either Y or N
//                profileUpdate.put("Education", "Graduate");   // Can be either Graduate, College or School
//                profileUpdate.put("Married", "Y");            // Can be either Y or N
//                profileUpdate.put("DOB", new Date());         // Date of Birth. Set the Date object to the appropriate value first
//                profileUpdate.put("Age", 28);                 // Not required if DOB is set
//
//// optional fields. controls whether the user will be sent email, push etc.
//                profileUpdate.put("MSG-email", false);        // Disable email notifications
//                profileUpdate.put("MSG-push", true);          // Enable push notifications
//                profileUpdate.put("MSG-sms", false);          // Disable SMS notifications
//
//                ArrayList<String> stuff = new ArrayList<String>();
//                stuff.add("bag");
//                stuff.add("shoes");
//                profileUpdate.put("MyStuff", stuff);                        //ArrayList of Strings
//
//                String[] otherStuff = {"Jeans","Perfume"};
//                profileUpdate.put("MyStuff", otherStuff);                   //String Array
//
//
//                cleverTap.onUserLogin(profileUpdate);
//
//
//                Toast.makeText(MainActivity.this, "profile Updated", Toast.LENGTH_SHORT).show();
//
//
//            }
//        });
//
//    }
//
//    private void init() {
//
//        upload_device_token_button = (Button) findViewById(R.id.upload_device_token_button);
//        update_user_profile_button = (Button) findViewById(R.id.update_user_profile_button);
//        create_event_without_property = (Button) findViewById(R.id.create_event_without_property);
//        create_event_without_property_novel = (Button) findViewById(R.id.create_event_without_property_novel);
//        product_viewed_with_property = (Button) findViewById(R.id.product_viewed_with_property);
//        user_1 = (Button) findViewById(R.id.user_1);
//        user_2 = (Button) findViewById(R.id.user_2);
//        user_3 = (Button) findViewById(R.id.user_3);
//
//    }
//
//
//
//    public void volleyApiHit(){
//
//
//        JSONObject jsonObject = new JSONObject();
//
//
//
//
//        JSONArray jsonArray = new JSONArray();
//
//
////    JSONObject jsonObject1 = new JSONObject();
//
//        try {
//
//
//            JSONObject jsonObject1 = new JSONObject();
//
//            jsonObject1.put("identity",String.valueOf(k)  + "000"  );
//            jsonObject1.put("type","profile");
////            jsonObject1.put("evtName","Product viewed");
//
//
//            JSONObject jsonObject2 = new JSONObject();
//            jsonObject2.put("Name","Casio" + String.valueOf(k) + "000" + String.valueOf(k) + "000" );
//            jsonObject2.put("userStatus","\"ਸ਼ੇਅਰਚੈਟ ਦੇ ਨਾਲ ਬੱਲੇ ਬੱਲੇ\""+(k));
//            jsonObject2.put("appVersion",100);
//            jsonObject2.put("language","Punjabi");
//            jsonObject2.put("adultContent",0);
//            jsonObject2.put("phoneNo","+919872667487" +  String.valueOf(k) + "000"  + String.valueOf(k) + "000" );
//            jsonObject2.put("verified",0);
//            jsonObject2.put("Created","2017-10-27T08:21:26");
//            jsonObject2.put("Gender","M");
//            jsonObject2.put("feedVersion","1");
//            jsonObject2.put("reportButtonEnabled","1");
//            jsonObject2.put("userIdMod10",1);
//            jsonObject2.put("userName","hello" + String.valueOf(k) + "000"+ String.valueOf(k) + "000");
//            jsonObject2.put("created","2017-10-27T08:21:26");
//            jsonObject2.put("gender","M");
//            jsonObject2.put("privacy_setting",0);
//            jsonObject2.put("pi","15090924866431509092486941");
//            jsonObject2.put("packetId","16663581/15090924866431509092486941");
//
//
//
//
//            jsonObject1.put("profileData",jsonObject2);
//
//
//            jsonArray.put(jsonObject1);
//
//
//            Log.e("size",jsonArray.length() + "");
//
//
//            jsonObject.put("d",jsonArray);
//
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
//
//
//
//
//        Log.e("json", jsonObject + "");
//
//        RequestQueue queue = Volley.newRequestQueue(this);
//        String url = "https://api.clevertap.com/1/upload";
//        JsonObjectRequest postRequest = new JsonObjectRequest(Request.Method.POST, url, jsonObject,
//                new Response.Listener<JSONObject>()
//                {
//                    @Override
//                    public void onResponse(JSONObject response) {
//                        // response
//                        Log.d("Response", response + "");
//
//                        k++;
//
//                        Log.e("value", k + "");
//
//                        if(k <= i){
//
//                            volleyApiHit();
//                        }
//
//                    }
//                },
//                new Response.ErrorListener()
//                {
//                    @Override
//                    public void onErrorResponse(VolleyError error) {
//                        // TODO Auto-generated method stub
//                        Log.d("ERROR","error => ",error);
//
//
//                        k++;
//
//                        if(k <= i){
//
//                            volleyApiHit();
//                        }
//
//                    }
//
//
//                }
//        ) {
//            @Override
//            public Map<String, String> getHeaders() throws AuthFailureError {
//                Map<String, String>  params = new HashMap<String, String>();
//                params.put("Content-Type", "application/json");
//                params.put("X-CleverTap-Account-Id", "TEST-Z46-R55-7W5Z");
//                params.put("X-CleverTap-Passcode", "GAC-IEZ-ISKL");
//
//                return params;
//            }
//        };
//        queue.add(postRequest);
//
//
//    }
//
//
//}
