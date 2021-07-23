package com.example.jterminal;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.view.WindowManager;
import android.widget.DatePicker;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class FilterScreen extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {
    int day, month, year;
    EditText firstdate;
    EditText lastdate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        Calendar calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);
        setContentView(R.layout.filter_layout);
        firstdate = findViewById(R.id.firstdate);
        lastdate = findViewById(R.id.lastdate);
        firstdate.setInputType(InputType.TYPE_NULL);
        lastdate.setInputType(InputType.TYPE_NULL);
        firstdate.setTextIsSelectable(true);
        lastdate.setTextIsSelectable(true);
        firstdate.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    DatePickerDialog datePickerDialog = new DatePickerDialog(FilterScreen.this, FilterScreen.this, year, month, day);
                    datePickerDialog.show();
                }
            }
        });

        lastdate.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    getWindow().setSoftInputMode(
                            WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN
                    );
                    DatePickerDialog datePickerDialog = new DatePickerDialog(FilterScreen.this, FilterScreen.this::onDateSet2, year, month, day);
                    datePickerDialog.show();
                }
            }
        });
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        firstdate.setText(year + "/" + month + "/" + dayOfMonth);

    }

    public void onDateSet2(DatePicker view, int year, int month, int dayOfMonth) {
        lastdate.setText(year + "/" + month + "/" + dayOfMonth);

    }

}
