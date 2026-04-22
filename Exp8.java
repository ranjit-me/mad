//spinner ,alert,popUp,toast

//MainActivity.java

package com.example.ja;


import android.os.Bundle;
import android.view.View;
import android.widget.*;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Spinner spinner;
    Button btnAlert, btnPopup, btnToast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner = findViewById(R.id.spinner);
        btnAlert = findViewById(R.id.btnAlert);
        btnPopup = findViewById(R.id.btnPopup);
        btnToast = findViewById(R.id.btnToast);

        String[] items = {"Java", "Android", "Python"};

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_item,
                items
        );

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this,
                        "Selected: " + items[position],
                        Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        // Alert Dialog
        btnAlert.setOnClickListener(v -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            builder.setTitle("Alert Dialog")
                    .setMessage("Do you want to continue?")
                    .setPositiveButton("OK", (dialog, which) ->
                            Toast.makeText(MainActivity.this, "OK Clicked", Toast.LENGTH_SHORT).show())
                    .setNegativeButton("Cancel", (dialog, which) ->
                            Toast.makeText(MainActivity.this, "Cancelled", Toast.LENGTH_SHORT).show());

            builder.show();
        });

        // Popup Menu
        btnPopup.setOnClickListener(v -> {
            PopupMenu popupMenu = new PopupMenu(MainActivity.this, btnPopup);
            popupMenu.getMenu().add("Option 1");
            popupMenu.getMenu().add("Option 2");

            popupMenu.setOnMenuItemClickListener(item -> {
                Toast.makeText(MainActivity.this, item.getTitle(), Toast.LENGTH_SHORT).show();
                return true;
            });

            popupMenu.show();
        });

        // Toast Button
        btnToast.setOnClickListener(v -> {
            Toast.makeText(MainActivity.this,
                    "This is a Toast Message",
                    Toast.LENGTH_LONG).show();
        });
    }
}

//activity_main.xml

<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:padding="20dp">

    <Spinner
        android:id="@+id/spinner"
        android:layout_width="match_parent"
        android:layout_height="wrap_content" />

    <Button
        android:id="@+id/btnAlert"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="Show Alert Dialog"
        android:layout_marginTop="15dp"/>

    <Button
        android:id="@+id/btnPopup"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="Show Popup Menu"
        android:layout_marginTop="15dp"/>

    <Button
        android:id="@+id/btnToast"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="Show Toast"
        android:layout_marginTop="15dp"/>

</LinearLayout>
