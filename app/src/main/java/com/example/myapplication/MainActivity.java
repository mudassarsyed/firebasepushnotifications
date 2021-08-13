package com.example.myapplication;

import com.example.myapplication.R.layout;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import java.util.HashMap;
import android.view.View;
import com.clevertap.android.sdk.CleverTapAPI;
import android.app.NotificationManager;
public class MainActivity extends AppCompatActivity {

    CleverTapAPI cleverTapAPI;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        cleverTapAPI=CleverTapAPI.getDefaultInstance(getApplicationContext());
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    /** Called when the user touches the button */
    public void productViewed(View view)
    {
        //This section will register the product viewed event
        HashMap<String, Object> prodViewedAction = new HashMap<String, Object>();
        prodViewedAction.put("Product ID", "1");
        prodViewedAction.put("Product Image", "https://d35fo82fjcw0y8.cloudfront.net/2018/07/26020307/customer-success-clevertap.jpg");
        prodViewedAction.put("Product Name", "CleverTap");

        // This section will send the push notification
        cleverTapAPI.createNotificationChannel(getApplicationContext(),"1259","Mudassar","This is mudassarrs notification channel",NotificationManager.IMPORTANCE_MAX,true);
        cleverTapAPI.pushEvent("Product viewed", prodViewedAction);

        HashMap<String, Object> emaildetails = new HashMap<String, Object>();
        emaildetails.put("EMAIL ID", "mudassar.sy@gmail.com");
        cleverTapAPI.pushEvent("Push email id", emaildetails);

    }

}
