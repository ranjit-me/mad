//MainActivity.java
package com.example.smstelephony;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button btnCall, btnSMS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCall = findViewById(R.id.btnCall);
        btnSMS = findViewById(R.id.btnSMS);

        btnCall.setOnClickListener(view -> {
            Intent intent = new Intent(Intent.ACTION_DIAL);
            intent.setData(Uri.parse("tel:9876543210"));
            startActivity(intent);
        });

        btnSMS.setOnClickListener(view -> {
            Intent intent = new Intent(Intent.ACTION_SENDTO);
            intent.setData(Uri.parse("smsto:9876543210"));
            intent.putExtra("sms_body", "Hello from Android App");
            startActivity(intent);
        });
    }
}


//activity_main.xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:gravity="center"
    android:orientation="vertical"
    android:background="#EDE7F6">

    <Button
        android:id="@+id/btnCall"
        android:layout_width="200dp"
        android:layout_height="50dp"
        android:text="Make a Call"
        android:textColor="#FFFFFF"
        android:backgroundTint="#673AB7"
        android:layout_marginBottom="20dp"/>

    <Button
        android:id="@+id/btnSMS"
        android:layout_width="200dp"
        android:layout_height="50dp"
        android:text="Send SMS"
        android:textColor="#FFFFFF"
        android:backgroundTint="#673AB7"/>

</LinearLayout>
