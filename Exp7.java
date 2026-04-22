//MainActivity.java
package com.example.ja;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText etName;
    CheckBox cbJava, cbAndroid;
    RadioGroup rgGender;
    ToggleButton toggleBtn;
    Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.etName);
        cbJava = findViewById(R.id.cbJava);
        cbAndroid = findViewById(R.id.cbAndroid);
        rgGender = findViewById(R.id.rgGender);
        toggleBtn = findViewById(R.id.toggleBtn);
        btnSubmit = findViewById(R.id.btnSubmit);

        btnSubmit.setOnClickListener(view -> {

            String result = "Name: " + etName.getText().toString();

            if (cbJava.isChecked()) result += "\nJava Selected";
            if (cbAndroid.isChecked()) result += "\nAndroid Selected";

            int selectedId = rgGender.getCheckedRadioButtonId();
            if (selectedId != -1) {
                RadioButton rb = findViewById(selectedId);
                result += "\nGender: " + rb.getText();
            }

            result += toggleBtn.isChecked() ? "\nToggle: ON" : "\nToggle: OFF";

            // Send data to SecondActivity
            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
            intent.putExtra("data", result);
            startActivity(intent);
        });
    }
}

//SecondActivity.java
package com.example.ja;


import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        tvResult = findViewById(R.id.tvResult);

        String data = getIntent().getStringExtra("data");
        tvResult.setText(data);
    }
}

//activity_main.xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:orientation="vertical"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:padding="16dp">

    <EditText
        android:id="@+id/etName"
        android:hint="Enter Name"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"/>

    <CheckBox
        android:id="@+id/cbJava"
        android:text="Java"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"/>

    <CheckBox
        android:id="@+id/cbAndroid"
        android:text="Android"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"/>

    <RadioGroup
        android:id="@+id/rgGender"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content">

        <RadioButton
            android:id="@+id/rbMale"
            android:text="Male"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"/>

        <RadioButton
            android:id="@+id/rbFemale"
            android:text="Female"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"/>
    </RadioGroup>

    <ToggleButton
        android:id="@+id/toggleBtn"
        android:textOn="ON"
        android:textOff="OFF"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"/>

    <Button
        android:id="@+id/btnSubmit"
        android:text="Submit"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"/>

</LinearLayout>

  //activity_second.xml
  <?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:gravity="center"
    android:padding="16dp"
    android:orientation="vertical">

    <TextView
        android:id="@+id/tvResult"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:textSize="18sp"
        android:textStyle="bold" />

</LinearLayout>
