package com.example.calx;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.NavUtils;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.button.MaterialButton;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class LenConActivity extends AppCompatActivity {
    private String input, output;
    private Spinner spinner1, spinner2;
    private TextView textView1, textView2;
    private String[] measures = {"Kilometre(km)", "Metre(m)", "Decimetre(dm)", "Centimetre(cm)",
                                                "Millimetre(mm)","Micrometre(μm)","Nanometre(nm)","Picometre(pm)",//"Light year(ly)","Parsec(pc)","Lunar Distance(LD)","Astronomical unit(AU)",
                                                "Inch(in)","Mile(mi)","Foot(ft)","Yard(yd)","Nautical mile(nmi)"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //EdgeToEdge.enable(this);
        setContentView(R.layout.activity_len_con);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle("Length Converter");
        }

        textView1 = findViewById(R.id.textView1);
        textView2 = findViewById(R.id.textView2);
        spinner1 = findViewById(R.id.spinner1);
        spinner2 = findViewById(R.id.spinner2);

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(LenConActivity.this, R.layout.item_selected, measures);
        arrayAdapter.setDropDownViewResource(R.layout.item_selected);
        spinner1.setAdapter(arrayAdapter);
        spinner2.setAdapter(arrayAdapter);

        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                input = measures[position];
                textView2.setText("");
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Do nothing
            }
        });

        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                output = measures[position];
                textView2.setText("");
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Do nothing
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void onDigitClick2(View view) {
        textView2.setText("");
        MaterialButton digitBtn = (MaterialButton) view;
        String btnText = digitBtn.getText().toString();
        String text = textView1.getText().toString();
        text += btnText;
        textView1.setText(text);
    }
    public void onBackClick(View view) {
        // Get the current text from textView1
        String text = textView1.getText().toString();

        // If the text is not empty, remove the last character
        if (!text.isEmpty()) {
            textView1.setText(text.substring(0, text.length() - 1));
            textView2.setText("");
        }
    }

    public void onACClick(View view) {
        textView1.setText("");
        textView2.setText("");
    }

    public void onEqualClick(View view) {
        String inputValue = textView1.getText().toString();
        if (!inputValue.isEmpty()) {
            try {
                double value = Double.parseDouble(inputValue);
                calculate(value, input, output);
            } catch (NumberFormatException e) {
                textView2.setText("Invalid input");
            }
        }
    }

    // Conversion function
    void calculate(double value, String inputUnit, String outputUnit) {
        // Convert input value to meters first
        double meters = toMeters(value, inputUnit);
        // Convert from meters to the desired output unit
        double result = fromMeters(meters, outputUnit);
        textView2.setText(String.valueOf(result));
    }

    // Convert the value to meters
    private double toMeters(double value, String unit) {
        switch (unit) {
            case "Kilometre(km)":
                return value * 1000;
            case "Metre(m)":
                return value;
            case "Decimetre(dm)":
                return value / 10;
            case "Centimetre(cm)":
                return value / 100;
            case "Millimetre(mm)":
                return value / 1000;
            case "Micrometre(μm)":
                return value / 1e6;
            case "Nanometre(nm)":
                return value / 1e9;
            case "Picometre(pm)":
                return value / 1e12;
            case "Inch(in)":
                return value * 0.0254;
            case "Mile(mi)":
                return value * 1609.34;
            case "Foot(ft)":
                return value * 0.3048;
            case "Yard(yd)":
                return value * 0.9144;
            case "Nautical mile(nmi)":
                return value * 1852;
            default:
                return value;
        }
    }

    // Convert the value from meters to the target unit
    private double fromMeters(double value, String unit) {
        switch (unit) {
            case "Kilometre(km)":
                return value / 1000;
            case "Metre(m)":
                return value;
            case "Decimetre(dm)":
                return value * 10;
            case "Centimetre(cm)":
                return value * 100;
            case "Millimetre(mm)":
                return value * 1000;
            case "Micrometre(μm)":
                return value * 1e6;
            case "Nanometre(nm)":
                return value * 1e9;
            case "Picometre(pm)":
                return value * 1e12;
            case "Inch(in)":
                return value / 0.0254;
            case "Mile(mi)":
                return value / 1609.34;
            case "Foot(ft)":
                return value / 0.3048;
            case "Yard(yd)":
                return value / 0.9144;
            case "Nautical mile(nmi)":
                return value / 1852;
            default:
                return value;
        }
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    }

