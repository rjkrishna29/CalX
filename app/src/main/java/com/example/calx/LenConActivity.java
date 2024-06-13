package com.example.calx;

import android.app.Dialog;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.button.MaterialButton;

public class LenConActivity extends AppCompatActivity {
    private String input, output;
    private TextView textView1, textView2, popup1,popup2;
    private String[] measures = {"Kilometre(km)", "Metre(m)", "Decimetre(dm)", "Centimetre(cm)",
            "Millimetre(mm)", "Micrometre(μm)", "Nanometre(nm)", "Picometre(pm)",
            "Inch(in)", "Mile(mi)", "Foot(ft)", "Yard(yd)", "Nautical mile(nmi)"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_len_con);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle("Length Converter");
        }

        textView1 = findViewById(R.id.textView1);
        textView2 = findViewById(R.id.textView2);
        popup1 = findViewById(R.id.popup1);
        popup2 = findViewById(R.id.popup2); // Change to popup2

        // Set default measure
        popup1.setText("Kilometre(km)");
        input = "Kilometre(km)";

        popup2.setText("Kilometre(km)"); // Set default measure for output
        output = "Kilometre(km)";

        // Set click listener to open the popup for input unit
        popup1.setOnClickListener(this::onPopUp);
        // Set click listener to open the popup for output unit
        popup2.setOnClickListener(this::onPopUp);
    }

    // Method to handle popup for input/output unit selection
    public void onPopUp(View view) {
        textView2.setText("");
        TextView targetTextView = (TextView) view;
        createPopup(targetTextView);
    }

    // Method to create and handle popups
    private void createPopup(TextView targetTextView) {
        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.popup_measures);

        ListView listViewMeasures = dialog.findViewById(R.id.listViewMeasures);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, measures);
        listViewMeasures.setAdapter(adapter);

        listViewMeasures.setOnItemClickListener((parent, view, position, id) -> {
            String selectedMeasure = measures[position];
            targetTextView.setText(selectedMeasure);
            if (targetTextView == popup1) {
                input = selectedMeasure;
            } else {
                output = selectedMeasure;
            }
            dialog.dismiss();
        });

        dialog.show();
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
        String text = textView1.getText().toString();
        if (!text.isEmpty()) {
            textView1.setText(text.substring(0, text.length() - 1));
            textView2.setText("");
        }
    }
   public void onCopyClick(View view){
        String from = textView1.getText().toString();
        String to = textView2.getText().toString();
        if (!from.isEmpty() && !to.isEmpty()){
            String copy = input+": "+from+" = "+output+": "+to;
            // Get the clipboard system service
            ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
            if (clipboard != null) {
                // Create a clip data object to store the copied text
                ClipData clip = ClipData.newPlainText("Calculator Result", copy);
                // Set the clip data to clipboard
                clipboard.setPrimaryClip(clip);
                // Notify the user that the text has been copied
                Toast.makeText(this, "Result copied to clipboard", Toast.LENGTH_SHORT).show();
            }
        }
        else {
            Toast.makeText(this, "To get answer click equal button", Toast.LENGTH_SHORT).show();
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

    void calculate(double value, String inputUnit, String outputUnit) {
        double meters = toMeters(value, inputUnit);
        double result = fromMeters(meters, outputUnit);
        textView2.setText(String.valueOf(result));
    }

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
