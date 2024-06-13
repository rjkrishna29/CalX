package com.example.calx;

import android.app.Dialog;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.button.MaterialButton;

public class AreaConActivity extends AppCompatActivity {
    private String input, output;
    private TextView textView1, textView2, popup1,popup2;
    private String[] measures = {"Square kilometre(km²)", "Square metre(m²)", "Square decimetre(dm²)", "Square centimetre(cm²)",
            "Square millimetre(mm²)", "Hectare(ha)", "Acre(ac)",
            "Square inch(in²)", "Square mile(mi²)", "Square foot(ft²)", "Square yard(yd²)"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //EdgeToEdge.enable(this);
        setContentView(R.layout.activity_area_con);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle("Length Converter");
        }
        textView1=findViewById(R.id.textView1);
        textView2=findViewById(R.id.textView2);
        popup1 = findViewById(R.id.popup1);
        popup2 = findViewById(R.id.popup2); // Change to popup2

        // Set default measure
        popup1.setText("Square kilometre(km²)");
        input = "Square kilometre(km²)";

        popup2.setText("Square kilometre(km²)"); // Set default measure for output
        output = "Square kilometre(km²)";

        // Set click listener to open the popup for input unit
        popup1.setOnClickListener(this::onPopUp);
        // Set click listener to open the popup for output unit
        popup2.setOnClickListener(this::onPopUp);

        /*ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });*/
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
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
    private void calculate(double value, String fromUnit, String toUnit) {
        double baseValue = toSquareMeter(value, fromUnit);
        double convertedValue = fromSquareMeter(baseValue, toUnit);
        textView2.setText(String.valueOf(convertedValue));
    }

    private double toSquareMeter(double value, String fromUnit) {
        switch (fromUnit) {
            case "Square kilometre(km²)":
                return value * 1_000_000;
            case "Square metre(m²)":
                return value;
            case "Square decimetre(dm²)":
                return value * 0.01;
            case "Square centimetre(cm²)":
                return value * 0.0001;
            case "Square millimetre(mm²)":
                return value * 0.000001;
            case "Hectare(ha)":
                return value * 10_000;
            case "Acre(ac)":
                return value * 4046.8564224;
            case "Square inch(in²)":
                return value * 0.00064516;
            case "Square mile(mi²)":
                return value * 2_589_988.110336;
            case "Square foot(ft²)":
                return value * 0.09290304;
            case "Square yard(yd²)":
                return value * 0.83612736;
            default:
                throw new IllegalArgumentException("Unknown unit: " + fromUnit);
        }
    }

    private double fromSquareMeter(double value, String toUnit) {
        switch (toUnit) {
            case "Square kilometre(km²)":
                return value / 1_000_000;
            case "Square metre(m²)":
                return value;
            case "Square decimetre(dm²)":
                return value / 0.01;
            case "Square centimetre(cm²)":
                return value / 0.0001;
            case "Square millimetre(mm²)":
                return value / 0.000001;
            case "Hectare(ha)":
                return value / 10_000;
            case "Acre(ac)":
                return value / 4046.8564224;
            case "Square inch(in²)":
                return value / 0.00064516;
            case "Square mile(mi²)":
                return value / 2_589_988.110336;
            case "Square foot(ft²)":
                return value / 0.09290304;
            case "Square yard(yd²)":
                return value / 0.83612736;
            default:
                throw new IllegalArgumentException("Unknown unit: " + toUnit);
        }
    }




}