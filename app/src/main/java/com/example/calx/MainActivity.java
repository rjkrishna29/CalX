//package com.example.calx;
//
//import android.content.res.Configuration;
//import android.graphics.Color;
//import android.os.Build;
//import android.os.Bundle;
//import android.view.View;
//import android.view.Window;
//import android.view.WindowInsets;
//import android.view.WindowManager;
//import android.widget.TextView;
//
//import androidx.activity.EdgeToEdge;
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.appcompat.app.AppCompatDelegate;
//import androidx.core.content.ContextCompat;
//import androidx.core.graphics.Insets;
//import androidx.core.view.ViewCompat;
//import androidx.core.view.WindowInsetsCompat;
//
//import com.google.android.material.button.MaterialButton;
//
//import java.text.DecimalFormat;
//import java.util.Stack;
//
////public class MainActivity extends AppCompatActivity {
////    private TextView textView1,textView2;
////    private double input;
////    private double firstOperand;
////    private double secondOperand;
////    private double result = Double.NaN;
////    private boolean lastDot = false;
////    private boolean lastDigit = false;
////    private boolean stateError = false;
////    private boolean lastnumeric = false;
////    private boolean lastOp = false;
////    public  void onDigitClick(View view){
////
////    }
////    public void onOperatorClick(View view){
////
////    }
////    public void onACClick(View view){
////
////    }
////    public  void onBackClick(View view){
////
////    }
////    public void onEqualClick(View view){
////            if(Double.isNaN(result)){
////                    textView2.setText("NaN");
////            } else if (lastnumeric &&) {
////
////            }
////        {
////                textView2.setText(String.format("=%s", result));
////            }
////    }
////    @Override
////    protected void onCreate(Bundle savedInstanceState) {
////        TextView textView1 = findViewById(R.id.textView1);
////        TextView textView2= findViewById(R.id.textView2);
////
////        super.onCreate(savedInstanceState);
////        EdgeToEdge.enable(this);
////        setContentView(R.layout.activity_main);
////        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
////            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
////            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
////            return insets;
////        });
////    }
////}
//
//
//
//
//public class MainActivity extends AppCompatActivity {
//    private TextView textView1, textView2;
//    private boolean setOp = true;
//    int op = 0;
//    private boolean checkPercentage = false;
//    private boolean checkClickEqual=false;
//
//    private boolean checkBack=false;
//    private boolean checkSecondOperand = false;
//    private double op1 = 0.0;
//    private double op2 = 0.0;
//    private double result = 0.0;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//
//        super.onCreate(savedInstanceState);
//        requestWindowFeature(Window.FEATURE_NO_TITLE);
//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
//        setContentView(R.layout.activity_main);
//        textView1 = findViewById(R.id.textView1);
//        textView2 = findViewById(R.id.textView2);
//    }
////    @Override
////    public void onConfigurationChanged(Configuration newConfig) {
////        super.onConfigurationChanged(newConfig);
////        // Hide status bar if orientation changes to landscape
////        //hideStatusBarIfLandscape(newConfig.orientation);
////    }
//
////    private void hideStatusBarIfLandscape(int orientation) {
////        if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
////            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
////                getWindow().setDecorFitsSystemWindows(false);
////                getWindow().getInsetsController().hide(WindowInsets.Type.statusBars());
////            } else {
////                getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
////                        WindowManager.LayoutParams.FLAG_FULLSCREEN);
////                View decorView = getWindow().getDecorView();
////                decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
////            }
////        } else {
////            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
////                getWindow().setDecorFitsSystemWindows(true);
////                getWindow().getInsetsController().show(WindowInsets.Type.statusBars());
////            } else {
////                getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
////                View decorView = getWindow().getDecorView();
////                decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_VISIBLE);
////            }
////        }
////    }
//
//    public void onDigitClick(View view) {
//        if(checkClickEqual && !checkBack)  {
//            textView1.setTextSize(42);
//            textView2.setTextSize(28);
//            // Determine the current theme mode
//            textView1.setTextAppearance(R.style.changeDigit_tv1);
//            textView2.setTextAppearance(R.style.changeDigit_tv2);
////            int nightMode = AppCompatDelegate.getDefaultNightMode();
////
////            // Set text color based on the theme mode
////            if (nightMode == AppCompatDelegate.MODE_NIGHT_YES) {
////                // Dark mode
////                textView2.setTextColor(ContextCompat.getColor(this, R.color.color_custom2));
////                textView1.setTextColor(Color.WHITE);
////            } else {
////                // Light mode
////                textView2.setTextColor(ContextCompat.getColor(this, R.color.color_custom1));
////                textView1.setTextColor(Color.BLACK);
////            }
//            checkClickEqual=false;
//            textView1.setText("");
//            textView2.setText("");
//            checkPercentage=false;
//        }
//
//
//        MaterialButton button = (MaterialButton) view;
//        String btnText = button.getText().toString();
//        String text = textView1.getText().toString();
//        text += btnText;
//        textView1.setText(text);
//        setOp = false;
//        // Calculate the result and update textView2
//        double result = calculate(text);
//        String resultText = Double.toString(result);
//        textView2.setText(resultText);
//    }
//
//    public void onOperatorClick(View view) {
//        String currentText;
//        MaterialButton button = (MaterialButton) view;
//        String btnText = button.getText().toString();
//
//        if(checkClickEqual) {
//            checkClickEqual = false;
//            checkBack = false;
//            textView1.setTextSize(42);
//            textView2.setTextSize(28);
//            textView1.setTextAppearance(R.style.changeDigit_tv1);
//            textView2.setTextAppearance(R.style.changeDigit_tv2);
//
//            // Update currentText from textView2's result
//            currentText = textView2.getText().toString();
//            textView1.setText(currentText + btnText);
//            textView2.setText(""); // Clear textView2 since we're now in the middle of a new operation
//        } else {
//            currentText = textView1.getText().toString();
//            if (currentText.isEmpty() && btnText.equals("−")) {
//                // Handle the case where a negative sign is being added at the beginning
//                currentText = "−";
//            } else if (!currentText.isEmpty()) {
//                // Handle replacing the last operator with the new one
//                char lastChar = currentText.charAt(currentText.length() - 1);
//                if (lastChar == '+' || lastChar == '−' || lastChar == '×' || lastChar == '÷') {
//                    currentText = currentText.substring(0, currentText.length() - 1) + btnText;
//                } else {
//                    currentText += btnText;
//                }
//            }
//            textView1.setText(currentText);
//            textView2.setText(""); // Clear textView2 for new result
//        }
//        setOp = true;
//    }
//    public void onPercentageClick(View view) {
//        String currentText = textView1.getText().toString();
//        if(checkClickEqual) {
//            textView1.setTextSize(42);
//            textView2.setTextSize(28);
//            textView1.setTextAppearance(R.style.changeDigit_tv1);
//            textView2.setTextAppearance(R.style.changeDigit_tv2);
//            // Determine the current theme mode
//            //int nightMode = AppCompatDelegate.getDefaultNightMode();
//
//            // Set text color based on the theme mode
////            if (nightMode == AppCompatDelegate.MODE_NIGHT_YES) {
////                // Dark mode
////                textView2.setTextColor(ContextCompat.getColor(this, R.color.color_custom2));
////                textView1.setTextColor(Color.WHITE);
////            } else {
////                // Light mode
////                textView2.setTextColor(ContextCompat.getColor(this, R.color.color_custom1));
////                textView1.setTextColor(Color.BLACK);
////            }
//            checkClickEqual=false;
//            currentText=textView2.getText().toString();
//            textView1.setText(currentText);
//        }
//        else {
//            currentText = textView1.getText().toString();
//
//        }
//        if (!currentText.isEmpty() && !setOp ) {
//            String text = currentText + "%";
//            textView1.setText(text);
//            checkPercentage=true;
//            // Calculate the result and update textView2
//            double result = calculate(text);
//            String resultText = Double.toString(result);
//            textView2.setText(resultText);
//        }
////        String currentText = textView1.getText().toString();
////        textView1.setText(currentText+"%");
////        if (!currentText.isEmpty() && !setOp) {
////            try {
////                double currentValue = Double.parseDouble(currentText);
////                currentValue = currentValue / 100;
////                textView2.setText(String.valueOf(currentValue));
////            } catch (NumberFormatException e) {
////                textView2.setText("Error");
////            }
////        }
//
//    }
//    public void onEqualClick(View view) {
//
//        String text = textView1.getText().toString();
//        double result = calculate(text);
//        String t = Double.toString(result);
//        textView2.setTextSize(42);
//        textView1.setTextSize(28);
//        textView1.setTextAppearance(R.style.changeDigit_tv2);
//        textView2.setTextAppearance(R.style.changeDigit_tv1);
//        // Determine the current theme mode
////        int nightMode = AppCompatDelegate.getDefaultNightMode();
////
////        // Set text color based on the theme mode
////        if (nightMode == AppCompatDelegate.MODE_NIGHT_YES) {
////            // Dark mode
////            textView2.setTextColor(Color.WHITE);
////            textView1.setTextColor(ContextCompat.getColor(this, R.color.color_custom2));
////        } else {
////            // Light mode
////            textView2.setTextColor(Color.BLACK);
////            textView1.setTextColor(ContextCompat.getColor(this, R.color.color_custom1));
////        }
//        textView2.setText(t);
//        checkClickEqual=true;
//    }
//
//    public void onACClick(View view) {
//        textView1.setText("");
//        textView2.setText("");
//        checkPercentage=false;
//    }
//
//    public void onBackClick(View view) {
//        if(checkClickEqual) {
//            textView1.setTextSize(42);
//            textView2.setTextSize(28);
//            // Determine the current theme mode
//            textView1.setTextAppearance(R.style.changeDigit_tv1);
//            textView2.setTextAppearance(R.style.changeDigit_tv2);
//            }
//        checkBack = true;
//
//        String currentText = textView1.getText().toString();
//        if (currentText.length() > 0) {
//            textView1.setText(currentText.substring(0, currentText.length() - 1));
//            // Calculate the result and update textView2
//            String newText = textView1.getText().toString();
//            if (!newText.isEmpty()) {
//                double result = calculate(newText);
//                String resultText = Double.toString(result);
//                textView2.setText(resultText);
//
//            } else {
//                textView2.setText("");
//            }
//        }
//
//    }
//
//    public static String calculate(String expression) {
//        try {
//            Stack<Double> numbers = new Stack<>();
//            Stack<Character> operators = new Stack<>();
//            boolean isNegative = false; // Flag to track negative numbers
//            for (int i = 0; i < expression.length(); i++) {
//                char ch = expression.charAt(i);
//                if (Character.isDigit(ch) || ch == '.') {
//                    StringBuilder numBuilder = new StringBuilder();
//                    if (isNegative) { // If the number is negative, append the negative sign
//                        numBuilder.append('-');
//                        isNegative = false; // Reset the flag
//                    }
//                    while (i < expression.length() && (Character.isDigit(expression.charAt(i)) || expression.charAt(i) == '.')) {
//                        numBuilder.append(expression.charAt(i));
//                        i++;
//                    }
//                    i--; // Move back one character to account for the extra increment in the loop
//                    double num = Double.parseDouble(numBuilder.toString());
//                    numbers.push(num);
//                } else if (ch == '×' || ch == '÷') {
//                    while (!operators.isEmpty() && (operators.peek() == '×' || operators.peek() == '÷')) {
//                        performOperation(numbers, operators);
//                    }
//                    operators.push(ch);
//                } else if (ch == '+' || ch == '−') {
//                    if (i == 0 || expression.charAt(i - 1) == '(') { // Handle negative numbers
//                        isNegative = true; // Set the flag for negative numbers
//                        continue; // Skip further processing in this iteration
//                    }
//                    while (!operators.isEmpty() && (operators.peek() == '×' || operators.peek() == '÷' || operators.peek() == '+' || operators.peek() == '−')) {
//                        performOperation(numbers, operators);
//                    }
//                    operators.push(ch);
//                } else if (ch == '%') {
//                    if (!numbers.isEmpty()) {
//                        double num = numbers.pop();
//                        num = num / 100;
//                        numbers.push(num);
//                    }
//                } else if (ch == '(') {
//                    operators.push(ch);
//                } else if (ch == ')') {
//                    while (!operators.isEmpty() && operators.peek() != '(') {
//                        performOperation(numbers, operators);
//                    }
//                    if (operators.isEmpty() || operators.peek() != '(') {
//                        throw new IllegalArgumentException("Unmatched closing parenthesis.");
//                    }
//                    operators.pop(); // Remove the '(' from the stack
//                }
//            }
//
//            while (!operators.isEmpty()) {
//                if (operators.peek() == '(') {
//                    operators.pop(); // Ignore unmatched opening parenthesis
//                    continue;
//                }
//                performOperation(numbers, operators);
//            }
//
//            return String.format("%.2f", numbers.pop());
//        } catch (Exception e) {
//            return e.getMessage();
//        }
//    }
//
//    private static void performOperation(Stack<Double> numbers, Stack<Character> operators) {
//        char operator = operators.pop();
//        double num2 = numbers.pop();
//        double num1 = numbers.isEmpty() ? 0 : numbers.pop();
//        double result = 0;
//        if (operator == '+') {
//            result = num1 + num2;
//        } else if (operator == '−') {
//            result = num1 - num2;
//        } else if (operator == '×') {
//            result = num1 * num2;
//        } else if (operator == '÷') {
//            result = num1 / num2;
//        }
//        numbers.push(result);
//    }
//}
//package com.example.calx;
//
//import android.content.res.Configuration;
//import android.graphics.Color;
//import android.os.Build;
//import android.os.Bundle;
//import android.view.View;
//import android.view.Window;
//import android.view.WindowInsets;
//import android.view.WindowManager;
//import android.widget.TextView;
//
//import androidx.activity.EdgeToEdge;
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.appcompat.app.AppCompatDelegate;
//import androidx.core.content.ContextCompat;
//import androidx.core.graphics.Insets;
//import androidx.core.view.ViewCompat;
//import androidx.core.view.WindowInsetsCompat;
//
//import com.google.android.material.button.MaterialButton;
//
//import java.text.DecimalFormat;
//import java.util.Stack;
//
//public class MainActivity extends AppCompatActivity {
//    private TextView textView1, textView2;
//    private boolean setOp = true;
//    int op = 0;
//    private boolean checkPercentage = false;
//    private boolean checkClickEqual = false;
//    private boolean checkBack = false;
//   // private boolean checkSecondOperand = false;
//    //private double op1 = 0.0;
//    //private double op2 = 0.0;
//    //private double result = 0.0;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        //requestWindowFeature(Window.FEATURE_NO_TITLE);
//        //getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
//        setContentView(R.layout.activity_main);
//        textView1 = findViewById(R.id.textView1);
//        textView2 = findViewById(R.id.textView2);
//    }
//
//    public void onDigitClick(View view) {
//        if (checkClickEqual && !checkBack) {
//            textView1.setTextSize(40);
//            textView2.setTextSize(24);
//            textView1.setTextAppearance(R.style.changeDigit_tv1);
//            textView2.setTextAppearance(R.style.changeDigit_tv2);
//            checkClickEqual = false;
//            textView1.setText("");
//            textView2.setText("");
//            checkPercentage = false;
//        }
//
//        MaterialButton button = (MaterialButton) view;
//        String btnText = button.getText().toString();
//        String text = textView1.getText().toString();
//        text += btnText;
//        textView1.setText(text);
//        setOp = false;
//
//        double result = calculate(text);
//        String resultText = Double.isNaN(result) ? "Error" : String.format("%.2f", result);
//        textView2.setText(resultText);
//    }
//
//    public void onOperatorClick(View view) {
//        String currentText;
//        MaterialButton button = (MaterialButton) view;
//        String btnText = button.getText().toString();
//
//        if (checkClickEqual) {
//            checkClickEqual = false;
//            checkBack = false;
//            textView1.setTextSize(40);
//            textView2.setTextSize(24);
//            textView1.setTextAppearance(R.style.changeDigit_tv1);
//            textView2.setTextAppearance(R.style.changeDigit_tv2);
//
//            currentText = textView2.getText().toString();
//            textView1.setText(currentText + btnText);
//            textView2.setText("");
//        } else {
//            currentText = textView1.getText().toString();
//            if (currentText.isEmpty() && btnText.equals("−")) {
//                currentText = "−";
//            } else if (!currentText.isEmpty()) {
//                char lastChar = currentText.charAt(currentText.length() - 1);
//                if (lastChar == '+' || lastChar == '−' || lastChar == '×' || lastChar == '÷') {
//                    currentText = currentText.substring(0, currentText.length() - 1) + btnText;
//                } else {
//                    currentText += btnText;
//                }
//            }
//            textView1.setText(currentText);
//            textView2.setText("");
//        }
//        setOp = true;
//    }
//
//    public void onPercentageClick(View view) {
//        String currentText = textView1.getText().toString();
//        if (checkClickEqual) {
//            textView1.setTextSize(40);
//            textView2.setTextSize(24);
//            textView1.setTextAppearance(R.style.changeDigit_tv1);
//            textView2.setTextAppearance(R.style.changeDigit_tv2);
//            checkClickEqual = false;
//            currentText = textView2.getText().toString();
//            textView1.setText(currentText);
//        }
//        if (!currentText.isEmpty() && !setOp) {
//            String text = currentText + "%";
//            textView1.setText(text);
//            checkPercentage = true;
//
//            double result = calculate(text);
//            String resultText = Double.isNaN(result) ? "Error" : String.format("%.2f", result);
//            textView2.setText(resultText);
//        }
//    }
//
//    public void onEqualClick(View view) {
//        String text = textView1.getText().toString();
//        double result = calculate(text);
//        String resultText = Double.isNaN(result) ? "Error" : String.format("%.2f", result);
//
//        textView2.setTextSize(40);
//        textView1.setTextSize(24);
//        textView1.setTextAppearance(R.style.changeDigit_tv2);
//        textView2.setTextAppearance(R.style.changeDigit_tv1);
//        textView2.setText(resultText);
//        checkClickEqual = true;
//    }
//
//    public void onACClick(View view) {
//        textView1.setText("");
//        textView2.setText("");
//        checkPercentage = false;
//    }
//
//    public void onBackClick(View view) {
//        if (checkClickEqual) {
//            textView1.setTextSize(40);
//            textView2.setTextSize(24);
//            textView1.setTextAppearance(R.style.changeDigit_tv1);
//            textView2.setTextAppearance(R.style.changeDigit_tv2);
//        }
//        checkBack = true;
//
//        String currentText = textView1.getText().toString();
//        if (currentText.length() > 0) {
//            textView1.setText(currentText.substring(0, currentText.length() - 1));
//
//            String newText = textView1.getText().toString();
//            if (!newText.isEmpty()) {
//                double result = calculate(newText);
//                String resultText = Double.isNaN(result) ? "Error" : String.format("%.2f", result);
//                textView2.setText(resultText);
//            } else {
//                textView2.setText("");
//            }
//        }
//    }
//
//    public static double calculate(String expression) {
//        try {
//            Stack<Double> numbers = new Stack<>();
//            Stack<Character> operators = new Stack<>();
//            boolean isNegative = false;
//
//            for (int i = 0; i < expression.length(); i++) {
//                char ch = expression.charAt(i);
//
//                if (Character.isDigit(ch) || ch == '.') {
//                    StringBuilder numBuilder = new StringBuilder();
//                    if (isNegative) {
//                        numBuilder.append('-');
//                        isNegative = false;
//                    }
//                    while (i < expression.length() && (Character.isDigit(expression.charAt(i)) || expression.charAt(i) == '.')) {
//                        numBuilder.append(expression.charAt(i));
//                        i++;
//                    }
//                    i--;
//                    double num = Double.parseDouble(numBuilder.toString());
//                    numbers.push(num);
//                } else if (ch == '×' || ch == '÷') {
//                    while (!operators.isEmpty() && (operators.peek() == '×' || operators.peek() == '÷')) {
//                        performOperation(numbers, operators);
//                    }
//                    operators.push(ch);
//                } else if (ch == '+' || ch == '−') {
//                    if (i == 0 || expression.charAt(i - 1) == '(') {
//                        isNegative = true;
//                        continue;
//                    }
//                    while (!operators.isEmpty() && (operators.peek() == '×' || operators.peek() == '÷' || operators.peek() == '+' || operators.peek() == '−')) {
//                        performOperation(numbers, operators);
//                    }
//                    operators.push(ch);
//                } else if (ch == '%') {
//                    if (!numbers.isEmpty()) {
//                        double num = numbers.pop();
//                        num = num / 100;
//                        numbers.push(num);
//                    }
//                } else if (ch == '(') {
//                    operators.push(ch);
//                } else if (ch == ')') {
//                    while (!operators.isEmpty() && operators.peek() != '(') {
//                        performOperation(numbers, operators);
//                    }
//                    if (operators.isEmpty() || operators.peek() != '(') {
//                        throw new IllegalArgumentException("Unmatched closing parenthesis.");
//                    }
//                    operators.pop();
//                }
//            }
//
//            while (!operators.isEmpty()) {
//                if (operators.peek() == '(') {
//                    operators.pop();
//                    continue;
//                }
//                performOperation(numbers, operators);
//            }
//
//            return numbers.pop();
//        } catch (Exception e) {
//            return Double.NaN;
//        }
//    }
//
//    private static void performOperation(Stack<Double> numbers, Stack<Character> operators) {
//        char operator = operators.pop();
//        double num2 = numbers.pop();
//        double num1 = numbers.isEmpty() ? 0 : numbers.pop();
//        double result = 0;
//        if (operator == '+') {
//            result = num1 + num2;
//        } else if (operator == '−') {
//            result = num1 - num2;
//        } else if (operator == '×') {
//            result = num1 * num2;
//        } else if (operator == '÷') {
//            result = num1 / num2;
//        }
//        numbers.push(result);
//    }
//}

package com.example.calx;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import com.google.android.material.button.MaterialButton;
import java.util.Stack;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private TextView textView1, textView2;
    private boolean setOp = true;
    private boolean checkPercentage = false;
    private boolean checkClickEqual = false;
    private boolean checkBack = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //requestWindowFeature(Window.FEATURE_NO_TITLE);
        //getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        textView1 = findViewById(R.id.textView1);
        textView2 = findViewById(R.id.textView2);
        // to show the menubar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //Not to show the title
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayShowTitleEnabled(false); // Disable default title
        }
        //EdgeToEdge.enable(this);
        // Restore the saved state if available
        if (savedInstanceState != null) {
            textView1.setText(savedInstanceState.getString("textView1"));
            textView2.setText(savedInstanceState.getString("textView2"));
            checkClickEqual = savedInstanceState.getBoolean("checkClickEqual");
            checkPercentage = savedInstanceState.getBoolean("checkPercentage");
            checkBack = savedInstanceState.getBoolean("checkBack");
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu,menu);
        // getMenuInflater().inflate(R.menu.main_menu,menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId()==R.id.menu_share) {
            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setType("text/plain");
            intent.putExtra(Intent.EXTRA_SUBJECT, "Try this calculator app");
            intent.putExtra(Intent.EXTRA_TEXT, "Apk is here : https://drive.google.com/drive/folders/1McJEran4lGcDDscFf9cDDxU6Rz9s4163?usp=drive_link ");
            startActivity(Intent.createChooser(intent, "Share Via"));
            return true;
        } else if (item.getItemId() == R.id.menu_settings) {
            Intent settingIntent = new Intent(this, SettingsActivity.class);
            startActivity(settingIntent);
        } else if(item.getItemId()==R.id.menu_more){
            Intent moreIntent = new Intent(this, MoreActivity.class);
            startActivity(moreIntent);
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("textView1", textView1.getText().toString());
        outState.putString("textView2", textView2.getText().toString());
        outState.putBoolean("checkClickEqual", checkClickEqual);
        outState.putBoolean("checkPercentage", checkPercentage);
        outState.putBoolean("checkBack", checkBack);
    }


    public void onDigitClick(View view) {
        if (checkClickEqual && !checkBack) {
            textView1.setTextSize(42);
            textView2.setTextSize(28);
            textView1.setTextAppearance(R.style.changeDigit_tv1);
            textView2.setTextAppearance(R.style.changeDigit_tv2);
            checkClickEqual = false;
            textView1.setText("");
            textView2.setText("");
            checkPercentage = false;
        }
        MaterialButton button = (MaterialButton) view;
        String btnText = button.getText().toString();
        String text = textView1.getText().toString();
        text += btnText;
        textView1.setText(text);
        setOp = false;
        // Calculate the result and update textView2
        double result = calculate(text);
        String resultText = Double.toString(result);
        textView2.setText(resultText);
    }


    public void onOperatorClick(View view) {
        String currentText;
        MaterialButton button = (MaterialButton) view;
        String btnText = button.getText().toString();
        if (checkClickEqual) {
            checkClickEqual = false;
            checkBack = false;
            textView1.setTextSize(42);
            textView2.setTextSize(28);
            textView1.setTextAppearance(R.style.changeDigit_tv1);
            textView2.setTextAppearance(R.style.changeDigit_tv2);
            // Update currentText from textView2's result
            currentText = textView2.getText().toString();
            textView1.setText(currentText + btnText);
            textView2.setText(""); // Clear textView2 since we're now in the middle of a new operation
        } else {
            currentText = textView1.getText().toString();
            if (currentText.isEmpty() && btnText.equals("−")) {
                // Handle the case where a negative sign is being added at the beginning
                currentText = "−";
            } else if (!currentText.isEmpty()) {
                // Handle replacing the last operator with the new one
                char lastChar = currentText.charAt(currentText.length() - 1);
                if (lastChar == '+' || lastChar == '−' || lastChar == '×' || lastChar == '÷') {
                    currentText = currentText.substring(0, currentText.length() - 1) + btnText;
                } else {
                    currentText += btnText;
                }
            }
            textView1.setText(currentText);
            textView2.setText(""); // Clear textView2 for new result
        }
        setOp = true;
    }


    public void onPercentageClick(View view) {
        String currentText = textView1.getText().toString();
        if (checkClickEqual) {
            textView1.setTextSize(42);
            textView2.setTextSize(28);
            textView1.setTextAppearance(R.style.changeDigit_tv1);
            textView2.setTextAppearance(R.style.changeDigit_tv2);
            checkClickEqual = false;
            currentText = textView2.getText().toString();
            textView1.setText(currentText);
        }
        if (!currentText.isEmpty() && !setOp) {
            String text = currentText + "%";
            textView1.setText(text);
            checkPercentage = true;
            // Calculate the result and update textView2
            double result = calculate(text);
            String resultText = Double.toString(result);
            textView2.setText(resultText);
        }
    }


    public void onEqualClick(View view) {
        String text = textView1.getText().toString();
        double result = calculate(text);
        String t = Double.toString(result);
        textView2.setTextSize(42);
        textView1.setTextSize(28);
        textView1.setTextAppearance(R.style.changeDigit_tv2);
        textView2.setTextAppearance(R.style.changeDigit_tv1);
        textView2.setText(t);
        checkClickEqual = true;
    }


    public void onACClick(View view) {
        textView1.setText("");
        textView2.setText("");
        checkPercentage = false;
    }
    public void onCopyClick(View view) {
        String copy1 = textView1.getText().toString();
        String copy2 = textView2.getText().toString();
        String copy3;
        if (!copy1.isEmpty() && !copy2.equals("NaN")) {
            copy3 = copy1 + " = " + copy2;

            // Get the clipboard system service
            ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
            if (clipboard != null) {
                // Create a clip data object to store the copied text
                ClipData clip = ClipData.newPlainText("Calculator Result", copy3);
                // Set the clip data to clipboard
                clipboard.setPrimaryClip(clip);
                // Notify the user that the text has been copied
                Toast.makeText(this, "Result copied to clipboard", Toast.LENGTH_SHORT).show();
            }
        }
        else {
            Toast.makeText(this, "Result is undefined", Toast.LENGTH_SHORT).show();
        }
    }
    public void onBackClick(View view) {
        if (checkClickEqual) {
            textView1.setTextSize(42);
            textView2.setTextSize(28);
            textView1.setTextAppearance(R.style.changeDigit_tv1);
            textView2.setTextAppearance(R.style.changeDigit_tv2);
        }
        checkBack = true;
        String currentText = textView1.getText().toString();
        if (currentText.length() > 0) {
            textView1.setText(currentText.substring(0, currentText.length() - 1));
            // Calculate the result and update textView2
            String newText = textView1.getText().toString();
            if (!newText.isEmpty()) {
                double result = calculate(newText);
                String resultText = Double.toString(result);
                textView2.setText(resultText);
            } else {
                textView2.setText("");
            }
        }
    }

    public static double calculate(String expression) {
        try {
            Stack<Double> numbers = new Stack<>();
            Stack<Character> operators = new Stack<>();
            boolean isNegative = false; // Flag to track negative numbers
            for (int i = 0; i < expression.length(); i++) {
                char ch = expression.charAt(i);
                if (Character.isDigit(ch) || ch == '.') {
                    StringBuilder numBuilder = new StringBuilder();
                    if (isNegative) { // If the number is negative, append the negative sign
                        numBuilder.append('-');
                        isNegative = false; // Reset the flag
                    }
                    while (i < expression.length() && (Character.isDigit(expression.charAt(i)) || expression.charAt(i) == '.')) {
                        numBuilder.append(expression.charAt(i));
                        i++;
                    }
                    i--; // Move back one character to account for the extra increment in the loop
                    double num = Double.parseDouble(numBuilder.toString());
                    numbers.push(num);
                } else if (ch == '×' || ch == '÷') {
                    while (!operators.isEmpty() && (operators.peek() == '×' || operators.peek() == '÷')) {
                        performOperation(numbers, operators);
                    }
                    operators.push(ch);
                } else if (ch == '+' || ch == '−'|| ch == '-') {
                    if (i == 0 || expression.charAt(i - 1) == '(') { // Handle negative numbers
                        isNegative = true; // Set the flag for negative numbers
                        continue; // Skip further processing in this iteration
                    }
                    while (!operators.isEmpty() && (operators.peek() == '×' || operators.peek() == '÷' || operators.peek() == '+' || operators.peek() == '−' || operators.peek() == '-')) {
                        performOperation(numbers, operators);
                    }
                    operators.push(ch);
                } else if (ch == '%') {
                    if (!numbers.isEmpty()) {
                        double num = numbers.pop();
                        num = num / 100;
                        numbers.push(num);
                    }
                } else if (ch == '(') {
                    operators.push(ch);
                } else if (ch == ')') {
                    while (!operators.isEmpty() && operators.peek() != '(') {
                        performOperation(numbers, operators);
                    }
                    if (operators.isEmpty() || operators.peek() != '(') {
                        throw new IllegalArgumentException("Invalid expression: mismatched parentheses");
                    }
                    operators.pop();
                }
            }
            while (!operators.isEmpty()) {
                performOperation(numbers, operators);
            }
            return numbers.pop();
        } catch (Exception e) {
            e.printStackTrace();
            return Double.NaN; // Return 0.0 in case of any exception
        }
    }

    private static void performOperation(Stack<Double> numbers, Stack<Character> operators) {
        if (numbers.size() < 2) {
            throw new IllegalArgumentException("Invalid expression");
        }
        double b = numbers.pop();
        double a = numbers.pop();
        char op = operators.pop();
        double result;
        switch (op) {
            case '×':
                result = a * b;
                break;
            case '÷':
                if (b == 0) {
                    throw new ArithmeticException("Division by zero");
                }
                result = a / b;
                break;
            case '+':
                result = a + b;
                break;
            case '−':
            case '-':
                result = a - b;
                break;
            default:
                throw new IllegalArgumentException("Invalid operator: " + op);
        }
        numbers.push(result);
    }
}
