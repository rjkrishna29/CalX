package com.paniritabrato.calx;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.google.android.material.button.MaterialButton;

public class NumConActivity extends AppCompatActivity {
    private TextView decView, binView, octView, hexView;
    private MaterialButton btnA,btnB,btnC,btnD,btnE,btnF,
                                           btn2,btn3,btn4,btn5,btn6,btn7,
                                            btn8,btn9;
    private LinearLayout l1,l2,l3,l4;
    private boolean hexClick = false;
    private boolean decClick = true;
    private boolean octClick = false;
    private boolean binClick = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_num_con);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle("Number Conversion");
        }

        decView = findViewById(R.id.dec_input);
        binView = findViewById(R.id.bin_input);
        octView = findViewById(R.id.oct_input);
        hexView = findViewById(R.id.hex_input);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);
        btnA = findViewById(R.id.btnA);
        btnB = findViewById(R.id.btnB);
        btnC = findViewById(R.id.btnC);
        btnD = findViewById(R.id.btnD);
        btnE = findViewById(R.id.btnE);
        btnF = findViewById(R.id.btnF);
        l1 = findViewById(R.id.layout1);
        l2 = findViewById(R.id.layout2);
        l3 = findViewById(R.id.layout3);
        l4 = findViewById(R.id.layout4);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Set click listeners for the TextViews
        decView.setOnClickListener(this::onDecClick);
        binView.setOnClickListener(this::onBinClick);
        octView.setOnClickListener(this::onOctClick);
        hexView.setOnClickListener(this::onHexClick);
        hexDisable();
        l1.setBackgroundColor(getResources().getColor(R.color.txtBg));
        decView.setTextColor(getResources().getColor(R.color.btnBackground2));
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            overridePendingTransition(R.anim.stay_still, R.anim.slide_out_right);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    private void resetBackgroundColors() {
        l1.setBackgroundColor(getResources().getColor(android.R.color.transparent));
        l2.setBackgroundColor(getResources().getColor(android.R.color.transparent));
        l3.setBackgroundColor(getResources().getColor(android.R.color.transparent));
        l4.setBackgroundColor(getResources().getColor(android.R.color.transparent));
    }
    public  void octEnable(){
        btn2.setEnabled(true);
        btn2.setTextAppearance(R.style.enableButton);
        btn3.setEnabled(true);
        btn3.setTextAppearance(R.style.enableButton);
        btn4.setEnabled(true);
        btn4.setTextAppearance(R.style.enableButton);
        btn5.setEnabled(true);
        btn5.setTextAppearance(R.style.enableButton);
        btn6.setEnabled(true);
        btn6.setTextAppearance(R.style.enableButton);
        btn7.setEnabled(true);
        btn7.setTextAppearance(R.style.enableButton);
    }
    public  void octDisable(){
        btn2.setEnabled(false);
        btn2.setTextAppearance(R.style.disableButton);
        btn3.setEnabled(false);
        btn3.setTextAppearance(R.style.disableButton);
        btn4.setEnabled(false);
        btn4.setTextAppearance(R.style.disableButton);
        btn5.setEnabled(false);
        btn5.setTextAppearance(R.style.disableButton);
        btn6.setEnabled(false);
        btn6.setTextAppearance(R.style.disableButton);
        btn7.setEnabled(false);
        btn7.setTextAppearance(R.style.disableButton);
    }
    public void decEnable(){
        btn8.setEnabled(true);
        btn9.setEnabled(true);
        btn8.setTextAppearance(R.style.enableButton);
        btn9.setTextAppearance(R.style.enableButton);
    }
    public void decDisable(){
        btn8.setEnabled(false);
        btn9.setEnabled(false);
        btn8.setTextAppearance(R.style.disableButton);
        btn9.setTextAppearance(R.style.disableButton);
     }
    public void hexEnable(){
        btnA.setEnabled(true);
        btnB.setEnabled(true);
        btnC.setEnabled(true);
        btnD.setEnabled(true);
        btnE.setEnabled(true);
        btnF.setEnabled(true);
        btnA.setTextAppearance(R.style.enableButton);
        btnB.setTextAppearance(R.style.enableButton);
        btnC.setTextAppearance(R.style.enableButton);
        btnD.setTextAppearance(R.style.enableButton);
        btnE.setTextAppearance(R.style.enableButton);
        btnF.setTextAppearance(R.style.enableButton);
    }
    public void hexDisable(){
        btnA.setEnabled(false);
        btnB.setEnabled(false);
        btnC.setEnabled(false);
        btnD.setEnabled(false);
        btnE.setEnabled(false);
        btnF.setEnabled(false);
        btnA.setTextAppearance(R.style.disableButton);
        btnB.setTextAppearance(R.style.disableButton);
        btnC.setTextAppearance(R.style.disableButton);
        btnD.setTextAppearance(R.style.disableButton);
        btnE.setTextAppearance(R.style.disableButton);
        btnF.setTextAppearance(R.style.disableButton);
    }
    public void onBackClick(View view) {
        if (decClick) {
            String text = decView.getText().toString();
            if (!text.isEmpty()) {
                text = text.substring(0, text.length() - 1);
                decView.setText(text);
            }
        } else if (binClick) {
            String text = binView.getText().toString();
            if (!text.isEmpty()) {
                text = text.substring(0, text.length() - 1);
                binView.setText(text);
            }
        } else if (octClick) {
            String text = octView.getText().toString();
            if (!text.isEmpty()) {
                text = text.substring(0, text.length() - 1);
                octView.setText(text);
            }
        } else if (hexClick) {
            String text = hexView.getText().toString();
            if (!text.isEmpty()) {
                text = text.substring(0, text.length() - 1);
                hexView.setText(text);
            }
        }
    }

    public void onACClick(View view) {
        clear();
    }
    public void clear(){
        String t = "";
        decView.setText(t);
        binView.setText(t);
        octView.setText(t);
        hexView.setText(t);
    }
    public void onCopyClick(View view){
        String d = decView.getText().toString();
        String b = binView.getText().toString();
        String o = octView.getText().toString();
        String h = hexView.getText().toString();;
        if (!d.isEmpty() && !b.isEmpty() && !o.isEmpty() && !h.isEmpty()){
            String copy = "Decimal"+": "+d+"\n"+"Binary"+": "+b+"\n"+"Octal"+": "+o+"\n"+"Hexadecimal"+": "+h;
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
    public void onDecClick(View view) {
        decClick = true;
        binClick = false;
        octClick = false;
        hexClick = false;
        //clear();
        hexDisable();
        decEnable();
        octEnable();
        resetBackgroundColors();
        l1.setBackgroundColor(getResources().getColor(R.color.txtBg));
        decView.setTextColor(getResources().getColor(R.color.btnBackground2));
        binView.setTextColor(getResources().getColor(R.color.colour_custom3));
        octView.setTextColor(getResources().getColor(R.color.colour_custom3));
        hexView.setTextColor(getResources().getColor(R.color.colour_custom3));
    }

    public void onBinClick(View view) {
        decClick = false;
        binClick = true;
        octClick = false;
        hexClick = false;
        //clear();
        hexDisable();
        decDisable();
        octDisable();
        resetBackgroundColors();
        l2.setBackgroundColor(getResources().getColor(R.color.txtBg));
        binView.setTextColor(getResources().getColor(R.color.btnBackground2));
        decView.setTextColor(getResources().getColor(R.color.colour_custom3));
        octView.setTextColor(getResources().getColor(R.color.colour_custom3));
        hexView.setTextColor(getResources().getColor(R.color.colour_custom3));
        
    }

    public void onOctClick(View view) {
        decClick = false;
        binClick = false;
        octClick = true;
        hexClick = false;
        //clear();
        hexDisable();
        decDisable();
        octEnable();
        resetBackgroundColors();
        l3.setBackgroundColor(getResources().getColor(R.color.txtBg));
        octView.setTextColor(getResources().getColor(R.color.btnBackground2));
        decView.setTextColor(getResources().getColor(R.color.colour_custom3));
        binView.setTextColor(getResources().getColor(R.color.colour_custom3));
        hexView.setTextColor(getResources().getColor(R.color.colour_custom3));
    }

    public void onHexClick(View view) {
        decClick = false;
        binClick = false;
        octClick = false;
        hexClick = true;
        //clear();
        hexEnable();
        decEnable();
        octEnable();
        resetBackgroundColors();
        l4.setBackgroundColor(getResources().getColor(R.color.txtBg));
        hexView.setTextColor(getResources().getColor(R.color.btnBackground2));
        decView.setTextColor(getResources().getColor(R.color.colour_custom3));
        binView.setTextColor(getResources().getColor(R.color.colour_custom3));
        octView.setTextColor(getResources().getColor(R.color.colour_custom3));
    }

    public void onDigit1Click(View view) {
        resetText();
        MaterialButton butDigit = (MaterialButton) view;
        String butText = butDigit.getText().toString();
        if (decClick) {
            String text = decView.getText().toString();
            text += butText;
            decView.setText(text);
        } else if (binClick) {
            String text = binView.getText().toString();
            text += butText;
            binView.setText(text);
        } else if (octClick) {
            String text = octView.getText().toString();
            text += butText;
            octView.setText(text);
        } else if (hexClick) {
            String text = hexView.getText().toString();
            text += butText;
            hexView.setText(text);
        }
    }
    public void onEqualClick(View view) {
        if (binClick) {
            String binaryStr = binView.getText().toString();
            if (!binaryStr.isEmpty()) {
                    double number = binaryToDecimal(binaryStr);
//                 int decimalValue = convertBinToDec(binaryStr);
                   decView.setText(String.valueOf(number));
                   String octalValue = floatToOctal(number);
//                String octalValue = convertBinToOct(binaryStr);
                   octView.setText(octalValue);
                   String hexDecimalValue = floatToHexadecimal(number);
//                String hexDecimalValue = convertBinToHex(binaryStr);
                   hexView.setText(hexDecimalValue);
            }
        }else if (decClick){
                double decValue = Double.parseDouble(decView.getText().toString());
                binView.setText(floatToBinary(decValue));
                octView.setText(floatToOctal(decValue));
                hexView.setText(floatToHexadecimal(decValue));
            }else if (octClick) {
                String octal = octView.getText().toString();
                if(!octal.isEmpty()){
                    double number = octalToDecimal(octal);
                    decView.setText(String.valueOf(number));
                    binView.setText(floatToBinary(number));
                    hexView.setText(floatToHexadecimal(number));
                }
        }
        else if (hexClick) {
            String hexValue = hexView.getText().toString();
           if (!hexValue.isEmpty()){
               double number = hexToDecimal(hexValue);
               decView.setText(String.valueOf(number));
               binView.setText(floatToBinary(number));
               octView.setText(floatToOctal(number));
           }
        }
    }
    public static double hexToDecimal(String hex) {
        // Step 1: Determine the sign
        boolean isNegative = hex.startsWith("-");
        if (isNegative) {
            hex = hex.substring(1);  // Remove the sign for now
        }

        // Split the hexadecimal number into integer and fractional parts
        String[] parts = hex.split("\\.");
        String integerPart = parts[0];
        String fractionalPart = parts.length > 1 ? parts[1] : "";

        // Step 2: Convert the integer part to decimal
        double integerDecimal = 0;
        int length = integerPart.length();
        for (int i = 0; i < length; i++) {
            int digit = Character.digit(integerPart.charAt(i), 16);
            integerDecimal += digit * Math.pow(16, length - 1 - i);
        }

        // Step 3: Convert the fractional part to decimal
        double fractionalDecimal = 0;
        int fracLength = fractionalPart.length();
        for (int i = 0; i < fracLength; i++) {
            int digit = Character.digit(fractionalPart.charAt(i), 16);
            fractionalDecimal += digit * Math.pow(16, -(i + 1));
        }

        // Combine the integer and fractional parts
        double decimalValue = integerDecimal + fractionalDecimal;

        // Apply the sign
        if (isNegative) {
            decimalValue = -decimalValue;
        }

        return decimalValue;
    }

    public static double octalToDecimal(String octal) {
        // Step 1: Determine the sign
        boolean isNegative = octal.startsWith("-");
        if (isNegative) {
            octal = octal.substring(1);  // Remove the sign for now
        }

        // Split the octal number into integer and fractional parts
        String[] parts = octal.split("\\.");
        String integerPart = parts[0];
        String fractionalPart = parts.length > 1 ? parts[1] : "";

        // Step 2: Convert the integer part to decimal
        double integerDecimal = 0;
        int length = integerPart.length();
        for (int i = 0; i < length; i++) {
            int digit = Character.getNumericValue(integerPart.charAt(i));
            integerDecimal += digit * Math.pow(8, length - 1 - i);
        }

        // Step 3: Convert the fractional part to decimal
        double fractionalDecimal = 0;
        int fracLength = fractionalPart.length();
        for (int i = 0; i < fracLength; i++) {
            int digit = Character.getNumericValue(fractionalPart.charAt(i));
            fractionalDecimal += digit * Math.pow(8, -(i + 1));
        }

        // Combine the integer and fractional parts
        double decimalValue = integerDecimal + fractionalDecimal;

        // Apply the sign
        if (isNegative) {
            decimalValue = -decimalValue;
        }

        return decimalValue;
    }
    public static double binaryToDecimal(String binary) {
        // Step 1: Determine the sign
        boolean isNegative = binary.startsWith("-");
        if (isNegative) {
            binary = binary.substring(1);  // Remove the sign for now
        }

        // Split the binary number into integer and fractional parts
        String[] parts = binary.split("\\.");
        String integerPart = parts[0];
        String fractionalPart = parts.length > 1 ? parts[1] : "";

        // Step 2: Convert the integer part to decimal
        double integerDecimal = 0;
        int length = integerPart.length();
        for (int i = 0; i < length; i++) {
            if (integerPart.charAt(i) == '1') {
                integerDecimal += Math.pow(2, length - 1 - i);
            }
        }

        // Step 3: Convert the fractional part to decimal
        double fractionalDecimal = 0;
        int fracLength = fractionalPart.length();
        for (int i = 0; i < fracLength; i++) {
            if (fractionalPart.charAt(i) == '1') {
                fractionalDecimal += Math.pow(2, -(i + 1));
            }
        }

        // Combine the integer and fractional parts
        double decimalValue = integerDecimal + fractionalDecimal;

        // Apply the sign
        if (isNegative) {
            decimalValue = -decimalValue;
        }

        return decimalValue;
    }

    public static String floatToBinary(double number) {
        // Step 1: Determine the sign
        String sign = "";
        if (number < 0) {
            sign = "-";
            number = -number;  // Work with the absolute value
        }

        // Step 2: Convert the integer part to binary
        int integerPart = (int) number;
        String integerBinary = Integer.toBinaryString(integerPart);

        // Step 3: Convert the fractional part to binary
        double fractionalPart = number - integerPart;
        StringBuilder fractionalBinary = new StringBuilder();

        // We limit the length of the fractional part to 8 digits
        int precision = 8;
        while (fractionalPart > 0 && fractionalBinary.length() < precision) {
            fractionalPart *= 2;
            int bit = (int) fractionalPart;
            fractionalBinary.append(bit);
            fractionalPart -= bit;
        }

        // Combine the integer and fractional parts
        String binaryResult = integerBinary;
        if (fractionalBinary.length() > 0) {
            binaryResult += "." + fractionalBinary.toString();
        }

        // Apply the sign and return the result
        return sign + binaryResult;
    }

    public static String floatToOctal(double number) {
        // Step 1: Determine the sign
        String sign = "";
        if (number < 0) {
            sign = "-";
            number = -number;  // Work with the absolute value
        }

        // Step 2: Convert the integer part to octal
        int integerPart = (int) number;
        String integerOctal = Integer.toOctalString(integerPart);

        // Step 3: Convert the fractional part to octal
        double fractionalPart = number - integerPart;
        StringBuilder fractionalOctal = new StringBuilder();

        // We limit the length of the fractional part to 8 digits
        int precision = 8;
        while (fractionalPart > 0 && fractionalOctal.length() < precision) {
            fractionalPart *= 8;
            int digit = (int) fractionalPart;
            fractionalOctal.append(digit);
            fractionalPart -= digit;
        }

        // Combine the integer and fractional parts
        String octalResult = integerOctal;
        if (fractionalOctal.length() > 0) {
            octalResult += "." + fractionalOctal.toString();
        }

        // Apply the sign and return the result
        return sign + octalResult;
    }

    public static String floatToHexadecimal(double number) {
        // Step 1: Determine the sign
        String sign = "";
        if (number < 0) {
            sign = "-";
            number = -number;  // Work with the absolute value
        }

        // Step 2: Convert the integer part to hexadecimal
        int integerPart = (int) number;
        String integerHex = Integer.toHexString(integerPart).toUpperCase();

        // Step 3: Convert the fractional part to hexadecimal
        double fractionalPart = number - integerPart;
        StringBuilder fractionalHex = new StringBuilder();

        // We limit the length of the fractional part to 8 digits
        int precision = 8;
        while (fractionalPart > 0 && fractionalHex.length() < precision) {
            fractionalPart *= 16;
            int digit = (int) fractionalPart;
            fractionalHex.append(Integer.toHexString(digit).toUpperCase());
            fractionalPart -= digit;
        }

        // Combine the integer and fractional parts
        String hexResult = integerHex;
        if (fractionalHex.length() > 0) {
            hexResult += "." + fractionalHex.toString();
        }

        // Apply the sign and return the result
        return sign + hexResult;
    }


    public void onSignClick(View view) {
        resetText();
        // Get the ID of the clicked view
        int viewId = view.getId();

        // Get the input field corresponding to the clicked view
        TextView inputTextView = null;
        if (viewId == R.id.btnSign) {
            // Sign button clicked, determine which input field is active
            if (decClick) {
                inputTextView = findViewById(R.id.dec_input);
            } else if (binClick) {
                inputTextView = findViewById(R.id.bin_input);
            } else if (octClick) {
                inputTextView = findViewById(R.id.oct_input);
            } else if (hexClick) {
                inputTextView = findViewById(R.id.hex_input);
            }
        }

        if (inputTextView != null) {
            // Get the current text from the input field
            String inputText = inputTextView.getText().toString();

            // Check if the text starts with a "-" sign
            boolean isNegative = inputText.startsWith("-");

            // Toggle the sign by removing or adding "-" at the beginning of the text
            if (isNegative) {
                // If negative, remove the "-" sign
                inputText = inputText.substring(1);
            } else {
                // If positive, add a "-" sign at the beginning
                inputText = "-" + inputText;
            }

            // Set the updated text back to the input field
            inputTextView.setText(inputText);
        }
    }

    public  void resetText(){
        if (binClick){
            decView.setText("");
            octView.setText("");
            hexView.setText("");
        } else if (decClick) {
            binView.setText("");
            octView.setText("");
            hexView.setText("");
        } else if (octClick) {
            decView.setText("");
            binView.setText("");
            hexView.setText("");
        } else if (hexClick) {
            decView.setText("");
            octView.setText("");
            binView.setText("");
        }
    }

}
