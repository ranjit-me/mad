//Alaram
//MainActivity.java
package com.example.ja;



import android.content.Intent;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText etHour, etMinute;
    Button btnSetAlarm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etHour = findViewById(R.id.etHour);
        etMinute = findViewById(R.id.etMinute);
        btnSetAlarm = findViewById(R.id.btnSetAlarm);

        btnSetAlarm.setOnClickListener(v -> setAlarm());
    }

    private void setAlarm() {

        String hourStr = etHour.getText().toString().trim();
        String minStr = etMinute.getText().toString().trim();

        // Validation
        if (hourStr.isEmpty() || minStr.isEmpty()) {
            Toast.makeText(this, "Enter time properly", Toast.LENGTH_SHORT).show();
            return;
        }

        int hour = Integer.parseInt(hourStr);
        int minute = Integer.parseInt(minStr);

        if (hour < 0 || hour > 23 || minute < 0 || minute > 59) {
            Toast.makeText(this, "Invalid time", Toast.LENGTH_SHORT).show();
            return;
        }

        try {
            Intent intent = new Intent(AlarmClock.ACTION_SET_ALARM);
            intent.putExtra(AlarmClock.EXTRA_HOUR, hour);
            intent.putExtra(AlarmClock.EXTRA_MINUTES, minute);
            intent.putExtra(AlarmClock.EXTRA_MESSAGE, "Android Alarm");

            startActivity(intent);

        } catch (Exception e) {
            Toast.makeText(this,
                    "Alarm set for " + hour + ":" + minute,
                    Toast.LENGTH_LONG).show();
        }
    }
}

//activity_main.xml 
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:padding="20dp"
    android:gravity="center">

    <TextView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Set Alarm"
        android:textSize="24sp"
        android:textStyle="bold"
        android:gravity="center"
        android:layout_marginBottom="20dp"/>

    <EditText
        android:id="@+id/etHour"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:hint="Enter Hour (0-23)"
        android:inputType="number"
        android:layout_marginBottom="10dp"/>

    <EditText
        android:id="@+id/etMinute"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:hint="Enter Minute (0-59)"
        android:inputType="number"
        android:layout_marginBottom="20dp"/>

    <Button
        android:id="@+id/btnSetAlarm"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Set Alarm"/>

</LinearLayout>
