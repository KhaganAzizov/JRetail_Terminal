package com.example.jterminal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.Transformation;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.Toast;

import java.text.DateFormatSymbols;
import java.util.ArrayList;
import java.util.EventListener;

public class Product_Accept extends AppCompatActivity {
    boolean toUp = true;
    RadioButton countradiobtn;
    RadioButton weightradiobtn;
    RadioGroup group;
    String[] itemname = {
            "Cola", "Sprte",
            "Fanta"
    };

    String[] itembarcode = {
            "12345678910", "12345678910",
            "12345678910"};
    String[] itemprice = {
            "5.30 \u20BC ", "1100",
            "350"};
    String[] itemcount = {
            "Miqdar:15 eded", "Miqdar:15 k",
            "Miqdar:15 eded"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.product_accept);
        ImageButton btn = findViewById(R.id.mainbtn);
        Button searchbtn = findViewById(R.id.searchbtn);
        EditText barcodetxt = findViewById(R.id.barcodetext);
        countradiobtn = findViewById(R.id.countradiobtn);
        weightradiobtn = findViewById(R.id.weightradiobtn);
        ListAdapter adapter = new ListAdapter(this, itemname, itembarcode, itemcount, itemprice);
        ListView list = findViewById(R.id.test);
        System.out.println("fadfd");
        list.setAdapter(adapter);
        searchbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (barcodetxt.getText().toString().isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Barkod daxil edin", Toast.LENGTH_LONG).show();
                    return;
                }

            }
        });

    }
}