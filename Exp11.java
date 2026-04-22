//Calculator 
//MainActivity.java
package com.example.ja;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView tvResult;
    private String currentInput = "";
    private double firstNumber = 0;
    private String operator = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvResult = findViewById(R.id.tvResult);
    }

    public void onNumberClick(View view) {
        Button button = (Button) view;
        currentInput += button.getText().toString();
        tvResult.setText(currentInput);
    }

    public void onOperatorClick(View view) {
        Button button = (Button) view;

        if (!currentInput.isEmpty()) {
            firstNumber = Double.parseDouble(currentInput);
            operator = button.getText().toString();
            currentInput = "";
        }
    }

    public void onEqualClick(View view) {
        if (!currentInput.isEmpty()) {
            double secondNumber = Double.parseDouble(currentInput);
            double result = 0;

            switch (operator) {
                case "+":
                    result = firstNumber + secondNumber;
                    break;
                case "-":
                    result = firstNumber - secondNumber;
                    break;
                case "*":
                    result = firstNumber * secondNumber;
                    break;
                case "/":
                    if (secondNumber != 0) {
                        result = firstNumber / secondNumber;
                    } else {
                        tvResult.setText("Error");
                        return;
                    }
                    break;
            }

            tvResult.setText(String.valueOf(result));
            currentInput = String.valueOf(result);
        }
    }

    public void onClearClick(View view) {
        currentInput = "";
        firstNumber = 0;
        operator = "";
        tvResult.setText("0");
    }
}

//activity_main.xml

<?xml version="1.0" encoding="utf-8"?>
<LinearLayout
    xmlns:android="http://schemas.android.com/apk/res/android"
    android:orientation="vertical"
    android:padding="16dp"
    android:layout_width="match_parent"
    android:layout_height="match_parent">

    <!-- Display -->
    <TextView
        android:id="@+id/tvResult"
        android:text="0"
        android:textSize="32sp"
        android:gravity="end"
        android:padding="20dp"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"/>

    <!-- Buttons Layout -->
    <GridLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:columnCount="4">

        <!-- Row 1 -->
        <Button android:text="7" android:onClick="onNumberClick"/>
        <Button android:text="8" android:onClick="onNumberClick"/>
        <Button android:text="9" android:onClick="onNumberClick"/>
        <Button android:text="/" android:onClick="onOperatorClick"/>

        <!-- Row 2 -->
        <Button android:text="4" android:onClick="onNumberClick"/>
        <Button android:text="5" android:onClick="onNumberClick"/>
        <Button android:text="6" android:onClick="onNumberClick"/>
        <Button android:text="*" android:onClick="onOperatorClick"/>

        <!-- Row 3 -->
        <Button android:text="1" android:onClick="onNumberClick"/>
        <Button android:text="2" android:onClick="onNumberClick"/>
        <Button android:text="3" android:onClick="onNumberClick"/>
        <Button android:text="-" android:onClick="onOperatorClick"/>

        <!-- Row 4 -->
        <Button android:text="0" android:onClick="onNumberClick"/>
        <Button android:text="C" android:onClick="onClearClick"/>
        <Button android:text="=" android:onClick="onEqualClick"/>
        <Button android:text="+" android:onClick="onOperatorClick"/>

    </GridLayout>

</LinearLayout>
