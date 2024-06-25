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

package com.paniritabrato.calx;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import com.google.android.material.button.MaterialButton;
import java.util.ArrayList;
import java.util.Stack;

public class MainActivity extends AppCompatActivity {
    private EditText textView1;
    // private TextView textView1;
    private TextView textView2;
    private LinearLayout digitLayout;
    private ListView historyView;
    private MaterialButton historyBtn,calcBtn,clrHisBtn;
    private ArrayAdapter<String> historyAdapter;
    private ArrayList<String> historyList;
    private boolean setOp = true;
    private boolean checkPercentage = false;
    private boolean checkClickEqual = false;
    private boolean checkBack = false;
    private boolean historyClick = false;

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        // Save the current state of historyList and other UI states
        outState.putStringArrayList("historyList", new ArrayList<>(historyList));
        outState.putString("textView1", textView1.getText().toString());
        outState.putString("textView2", textView2.getText().toString());
        outState.putBoolean("checkClickEqual", checkClickEqual);
        outState.putBoolean("checkPercentage", checkPercentage);
        outState.putBoolean("checkBack", checkBack);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //requestWindowFeature(Window.FEATURE_NO_TITLE);
        //getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        textView1 = findViewById(R.id.textView1);
        textView2 = findViewById(R.id.textView2);
        historyView =  findViewById(R.id.historyView);
        calcBtn=  findViewById(R.id.btnCalc);
        digitLayout = findViewById(R.id.linearLayout1);
        historyBtn = findViewById(R.id.btnHistory);
        clrHisBtn = findViewById(R.id.btnHisClr);

        // to show the menubar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //Not to show the title
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayShowTitleEnabled(false); // Disable default title
        }
        // Suppress the soft keyboard from appearing
        textView1.setShowSoftInputOnFocus(false);
        // Add listener to handle hiding the keyboard when EditText gains focus
        textView1.setOnFocusChangeListener((v, hasFocus) -> {
            if (hasFocus) {
                hideKeyboard();
            }
        });

        //Listen for touch events to keep the cursor visible
        textView1.setOnTouchListener((v, event) -> {
            textView1.setCursorVisible(true);
            return false; // Allow default behavior (text selection, etc.)
        });
        // Optionally, monitor cursor changes or text changes
        textView1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) { }

            @Override
            public void afterTextChanged(Editable s) {
                // Here you can control cursor position or other behaviors
            }
        });
        textView1.setSelection(0);
        //EdgeToEdge.enable(this);
        // Restore the saved state if available
        if (savedInstanceState != null) {
            textView1.setText(savedInstanceState.getString("textView1"));
            textView2.setText(savedInstanceState.getString("textView2"));
            checkClickEqual = savedInstanceState.getBoolean("checkClickEqual");
            checkPercentage = savedInstanceState.getBoolean("checkPercentage");
            checkBack = savedInstanceState.getBoolean("checkBack");
            historyList = savedInstanceState.getStringArrayList("historyList");
            if (historyList == null) {
                historyList = new ArrayList<>(); // Initialize if null
            }
        } else {
            historyList = new ArrayList<>(); // Initialize if savedInstanceState is null
        }
        // Initialize history adapter with the restored historyList
        historyAdapter = new ArrayAdapter<>(this, R.layout.list_item_history, historyList);
        // Set adapter to ListView
        historyView.setAdapter(historyAdapter);

        historyView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedValue = historyList.get(position);
                int equalIndex = selectedValue.indexOf("=");
                if (equalIndex != -1) {
                    String valueAfterEqual = selectedValue.substring(equalIndex + 1).trim();
                    if (checkClickEqual || textView1.getText().toString().isEmpty() || historyClick) {
                        textView1.setTextSize(40);
                        textView2.setTextSize(24);
                        textView1.setTextAppearance(R.style.changeDigit_tv1);
                        textView2.setTextAppearance(R.style.changeDigit_tv2);
                        // Reset the state
                        checkClickEqual = false;
                        // Clear textView1 and textView2
                        textView1.setText(valueAfterEqual);
                        textView2.setText("");
                        // Set the cursor at the end of the new text
                        textView1.setSelection(textView1.getText().length());
                    } else {
                        int cursorPosition = textView1.getSelectionStart();
                        String currentText = textView1.getText().toString();
                        // Insert valueAfterEqual at the current cursor position
                        String newText = currentText.substring(0, cursorPosition) + valueAfterEqual + currentText.substring(cursorPosition);
                        // Set the new text to textView1
                        textView1.setText(newText);
                        // Move the cursor to the end of the inserted text
                        textView1.setSelection(cursorPosition + valueAfterEqual.length());
                    }
                    // Indicate that a history item was clicked
                    historyClick = true;
                }
                String newText = textView1.getText().toString();
                double result = calculate(newText);
                //String resultText = Double.toString(result);
                String t = formatResult(result); // Format the result to remove trailing zeros
                textView2.setText(t);
            }
        });
    }

    private void hideKeyboard() {
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        if (imm != null && getCurrentFocus() != null) {
            imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
//        MenuItem item = menu.findItem(R.id.menu_settings);
//        SpannableString s = new SpannableString(item.getTitle());
//        s.setSpan(new BackgroundColorSpan(getResources().getColor(R.color.custom_background)), 0, s.length(), 0);
//        item.setTitle(s);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId()==R.id.menu_share) {
            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setType("text/plain");
            intent.putExtra(Intent.EXTRA_SUBJECT, "Try this calculator app");
            intent.putExtra(Intent.EXTRA_TEXT, "Apk is here : \n Drive link : " +
                    "https://drive.google.com/drive/folders/1McJEran4lGcDDscFf9cDDxU6Rz9s4163?usp=drive_link \n " +
                    "Github link : https://github.com/rjkrishna29/CalX_apk");
            startActivity(Intent.createChooser(intent, "Share Via"));
            return true;
        } else if (item.getItemId() == R.id.menu_settings) {
            Intent settingIntent = new Intent(this, SettingsActivity.class);
            startActivity(settingIntent);
            overridePendingTransition(R.anim.slide_in_right, R.anim.stay_still);
        }
        else if(item.getItemId()==R.id.menu_more){
            Intent moreIntent = new Intent(this, MoreActivity.class);
            startActivity(moreIntent);
            overridePendingTransition(R.anim.slide_in_right, R.anim.stay_still);
        }
        return super.onOptionsItemSelected(item);
    }

//    @Override
//    protected void onSaveInstanceState(Bundle outState) {
//        super.onSaveInstanceState(outState);
//        outState.putString("textView1", textView1.getText().toString());
//        outState.putString("textView2", textView2.getText().toString());
//        outState.putBoolean("checkClickEqual", checkClickEqual);
//        outState.putBoolean("checkPercentage", checkPercentage);
//        outState.putBoolean("checkBack", checkBack);
//
//    }

    public void onHistoryClick(View view) {
        if (historyView.getVisibility() == View.GONE) {
            // Animation to slide in from the left
            Animation slideInLeft = AnimationUtils.loadAnimation(this, R.anim.slide_in_left);
            historyView.startAnimation(slideInLeft);
            // When historyView is not visible, show it and hide digitLayout
            historyView.setVisibility(View.VISIBLE);
            digitLayout.setVisibility(View.GONE);
            historyBtn.setVisibility(View.INVISIBLE); // Hide historyBtn
            calcBtn.setVisibility(View.VISIBLE); // Show calcBtn
            clrHisBtn.setVisibility(View.VISIBLE);
        } else {
            // Animation to slide out to the left
            Animation slideOutLeft = AnimationUtils.loadAnimation(this, R.anim.slide_out_left);
            historyView.startAnimation(slideOutLeft);
            // When historyView is visible, hide it and show digitLayout
            historyView.setVisibility(View.GONE);
            digitLayout.setVisibility(View.VISIBLE);
            historyBtn.setVisibility(View.VISIBLE); // Show historyBtn
            calcBtn.setVisibility(View.INVISIBLE); // Hide calcBtn
            clrHisBtn.setVisibility(View.INVISIBLE);
        }
    }

    public void onDigitClick(View view) {
        if (checkClickEqual) {
            textView1.setTextSize(40);
            textView2.setTextSize(24);
            textView1.setTextAppearance(R.style.changeDigit_tv1);
            textView2.setTextAppearance(R.style.changeDigit_tv2);
            checkClickEqual = false;
            textView1.setText("");
            textView2.setText("");
            checkPercentage = false;
        }
        MaterialButton button = (MaterialButton) view;
        String btnText = button.getText().toString();
        // Get current cursor position
        int cursorPosition = textView1.getSelectionStart();
        // Get the current text
        String currentText = textView1.getText().toString();
        // Insert the digit at the cursor position
        String newText = currentText.substring(0, cursorPosition) + btnText + currentText.substring(cursorPosition);
        // Update the text in the EditText
        textView1.setText(newText);
        // Move the cursor to the right of the inserted digit
        textView1.setSelection(cursorPosition + 1);
        setOp = false;
        // Calculate the result and update textView2
        double result = calculate(newText);
        //String resultText = Double.toString(result);
        String t = formatResult(result); // Format the result to remove trailing zeros
        textView2.setText(t);
        historyClick=false;
    }

    public void onOperatorClick(View view) {
        String currentText;
        MaterialButton button = (MaterialButton) view;
        String btnText = button.getText().toString();
        if (checkClickEqual) {
            checkClickEqual = false;
            checkBack = false;
            textView1.setTextSize(40);
            textView2.setTextSize(24);
            textView1.setTextAppearance(R.style.changeDigit_tv1);
            textView2.setTextAppearance(R.style.changeDigit_tv2);
            // Update currentText from textView2's result
            currentText = textView2.getText().toString();
            textView1.setText(currentText + btnText);
            textView2.setText(""); // Clear textView2 since we're now in the middle of a new operation
            textView1.setSelection(textView1.getText().length());
        } else {
            currentText = textView1.getText().toString();
            int cursorPosition = textView1.getSelectionStart();
            int length = textView1.getText().length();
            if (cursorPosition == length) {
                // Cursor is at the end
                if (currentText.isEmpty() && btnText.equals("−")) {
                    // Handle the case where a negative sign is being added at the beginning
                    currentText = "−";
                    textView1.setText(currentText);
                    textView2.setText("");
                    textView1.setSelection(textView1.getText().length());
                } else if (!currentText.isEmpty()) {
                    // Handle replacing the last operator with the new one
                    char lastChar = currentText.charAt(currentText.length() - 1);
                    if (lastChar == '+' || lastChar == '−' || lastChar == '×' || lastChar == '÷') {
                        currentText = currentText.substring(0, currentText.length() - 1) + btnText;
                    } else {
                        currentText += btnText;
                    }
                    textView1.setText(currentText);
                    textView2.setText(""); // Clear textView2 for new result
                    textView1.setSelection(textView1.getText().length());
                }
            } else {
                // Cursor is not at the end
                boolean replaced = false;
                StringBuilder updatedText = new StringBuilder(currentText);
                // Check the character before the cursor
                if (cursorPosition > 0) {
                    char previousChar = updatedText.charAt(cursorPosition - 1);
                    if (previousChar == '+' || previousChar == '−' || previousChar == '×' || previousChar == '÷') {
                        // Replace the operator before the cursor with the new one
                        updatedText.setCharAt(cursorPosition - 1, btnText.charAt(0));
                        replaced = true;
                    }
                }
                // Check the character after the cursor
                if (!replaced && cursorPosition < length) {
                    char nextChar = updatedText.charAt(cursorPosition);
                    if (nextChar == '+' || nextChar == '−' || nextChar == '×' || nextChar == '÷') {
                        // Replace the operator after the cursor with the new one
                        updatedText.setCharAt(cursorPosition, btnText.charAt(0));
                        replaced = true;
                    }
                }
                // If no operator was replaced, insert the new operator at the cursor position
                if (!replaced) {
                    updatedText.insert(cursorPosition, btnText);
                }
                textView1.setText(updatedText.toString());
                textView1.setSelection(cursorPosition + (replaced ? 0 : btnText.length()));
                String newText=textView1.getText().toString();
                double result = calculate(newText);
                String resultText = Double.toString(result);
                textView2.setText(resultText);
            }
        }
        setOp = true;
        historyClick=false;
    }

    public void onPercentageClick(View view) {
        String currentText = textView1.getText().toString();
        // Handle the case if we just completed an operation with "="
        if (checkClickEqual) {
            textView1.setTextSize(40);
            textView2.setTextSize(24);
            textView1.setTextAppearance(R.style.changeDigit_tv1);
            textView2.setTextAppearance(R.style.changeDigit_tv2);
            checkClickEqual = false;
            currentText = textView2.getText().toString();
            textView1.setText(currentText);
            // Set cursor position to the end of textView1
            textView1.setSelection(textView1.getText().length());
        }
        // Ensure there is valid text
        if (!currentText.isEmpty()) {
            // Get current cursor position
            int cursorPosition = textView1.getSelectionStart();
            // Check if the cursor is immediately before an operator
            if (cursorPosition > 0) {
                char prevChar = currentText.charAt(cursorPosition - 1);
                if (isOperator(prevChar)) {
                    // If the character before the cursor is an operator, skip inserting percentage
                    return;
                }
            }
            // Insert the percentage symbol at the cursor position
            String newText = currentText.substring(0, cursorPosition) + "%" + currentText.substring(cursorPosition);
            // Update the text in textView1
            textView1.setText(newText);
            // Move the cursor to the right of the inserted percentage symbol
            textView1.setSelection(cursorPosition + 1);
            // Calculate the result and update textView2
            double result = calculate(newText);
            //String resultText = Double.toString(result);
            String t = formatResult(result); // Format the result to remove trailing zeros
            textView2.setText(t);
        }
        historyClick=false;
    }

    public void onEqualClick(View view) {
        String text = textView1.getText().toString();
        double result = calculate(text);
        String t = formatResult(result); // Format the result to remove trailing zeros
        textView2.setTextSize(40);
        textView1.setTextSize(24);
        textView1.setTextAppearance(R.style.changeDigit_tv2);
        textView2.setTextAppearance(R.style.changeDigit_tv1);
        textView2.setText(t);
        checkClickEqual = true;
        // Set cursor position to the end of textView1
        textView1.setSelection(textView1.getText().length());
        // Check if textView2 contains "NaN"
        if (!textView2.getText().toString().equals("NaN")) {
            // For demonstration, using the input as result
            String s1 = textView1.getText().toString() + "\n=" + textView2.getText().toString();
            // Add result to history list
            addToHistory(s1);
        }
        historyClick=false;
    }

    private String formatResult(double result) {
        // Convert the result to string
        String resultString = Double.toString(result);
        // Check if it contains a decimal point
        if (resultString.contains(".")) {
            // Remove trailing zeros after the decimal point
            resultString = resultString.replaceAll("0*$", "");
            // Remove the decimal point if it's now at the end
            resultString = resultString.replaceAll("\\.$", "");
        }
        return resultString;
    }

    // Add result to history and ensure the list doesn't exceed 10 items
    private void addToHistory(String result) {

        if (historyList.size() >= 10) {
            historyList.remove(0); // Remove the oldest item
        }
        historyList.add(result);
        historyAdapter.notifyDataSetChanged();

    }

    public void onACClick(View view) {
            textView2.setTextSize(40);
            textView1.setTextSize(24);
            textView1.setTextAppearance(R.style.changeDigit_tv2);
            textView2.setTextAppearance(R.style.changeDigit_tv1);
        textView1.setText("");
        textView2.setText("");
        checkPercentage = false;
        // Reset cursor position to the start
        textView1.setSelection(textView1.getText().length());
        historyClick=true;
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
            textView1.setTextSize(40);
            textView2.setTextSize(24);
            textView1.setTextAppearance(R.style.changeDigit_tv1);
            textView2.setTextAppearance(R.style.changeDigit_tv2);
        }
        checkBack = true;
        // Get current cursor position
        int cursorPosition = textView1.getSelectionStart();
        // Get the current text
        String currentText = textView1.getText().toString();
        // Check if there's any text to remove
        if (currentText.length() > 0 && cursorPosition > 0) {
            // Remove the character at the cursor position
            String newText = currentText.substring(0, cursorPosition - 1) + currentText.substring(cursorPosition);
            textView1.setText(newText);
            // Move the cursor to the left of the removed character
            textView1.setSelection(cursorPosition - 1);
            // Update the result in textView2
            if (textView1.getText().toString().isEmpty()){
                textView2.setText("");
           }
            else{
            double result = calculate(newText);
                String t = formatResult(result);
                textView2.setText(t);
            }
        }
    }

    public static double calculate(String expression) {
        try {
            // Preprocess the expression to handle implicit multiplication
            expression = addImplicitMultiplications(expression);
            Stack<Double> numbers = new Stack<>();
            Stack<Character> operators = new Stack<>();
            boolean isNegative = false;
            for (int i = 0; i < expression.length(); i++) {
                char ch = expression.charAt(i);
                if (Character.isDigit(ch) || ch == '.') {
                    StringBuilder numBuilder = new StringBuilder();
                    if (isNegative) {
                        numBuilder.append('-');
                        isNegative = false;
                    }
                    while (i < expression.length() && (Character.isDigit(expression.charAt(i)) || expression.charAt(i) == '.')) {
                        numBuilder.append(expression.charAt(i));
                        i++;
                    }
                    i--; // Adjust for the extra increment
                    numbers.push(Double.parseDouble(numBuilder.toString()));
                } else if (ch == '×' || ch == '÷') {
                    while (!operators.isEmpty() && (operators.peek() == '×' || operators.peek() == '÷')) {
                        performOperation(numbers, operators);
                    }
                    operators.push(ch);
                } else if (ch == '+' || ch == '−' || ch == '-') {
                    if (i == 0 || isOperator(expression.charAt(i - 1)) || expression.charAt(i - 1) == '(') {
                        isNegative = true;
                    } else {
                        while (!operators.isEmpty() && "+−-×÷".indexOf(operators.peek()) != -1) {
                            performOperation(numbers, operators);
                        }
                        operators.push(ch);
                    }
                } else if (ch == '%') {
                    if (!numbers.isEmpty()) {
                        double percentValue = numbers.pop() / 100;
                        if (i + 1 < expression.length() && Character.isDigit(expression.charAt(i + 1))) {
                            i++;
                            StringBuilder nextNumBuilder = new StringBuilder();
                            while (i < expression.length() && (Character.isDigit(expression.charAt(i)) || expression.charAt(i) == '.')) {
                                nextNumBuilder.append(expression.charAt(i));
                                i++;
                            }
                            i--; // Adjust for the extra increment
                            numbers.push(percentValue * Double.parseDouble(nextNumBuilder.toString()));
                        } else {
                            numbers.push(percentValue);
                        }
                    }
                } else if (ch == '(') {
                    operators.push(ch);
                } else if (ch == ')') {
                    while (!operators.isEmpty() && operators.peek() != '(') {
                        performOperation(numbers, operators);
                    }
                    if (!operators.isEmpty() && operators.peek() == '(') {
                        operators.pop(); // Remove the '('
                    } else {
                        throw new IllegalArgumentException("Invalid expression: mismatched parentheses");
                    }
                }
            }

            while (!operators.isEmpty()) {
                performOperation(numbers, operators);
            }

            return numbers.pop();
        } catch (Exception e) {
            e.printStackTrace();
            return Double.NaN;
        }
    }

    private static String addImplicitMultiplications(String expression) {
        StringBuilder result = new StringBuilder();
        char prevChar = ' ';
        for (int i = 0; i < expression.length(); i++) {
            char currChar = expression.charAt(i);
            // Check for a number followed by '('
            if (Character.isDigit(prevChar) && currChar == '(') {
                result.append('×');
            }
            // Check for ')' followed by a number or '('
            else if (prevChar == ')' && (Character.isDigit(currChar) || currChar == '(')) {
                result.append('×');
            }
            result.append(currChar);
            prevChar = currChar;
        }
        return result.toString();
    }

    private static void performOperation(Stack<Double> numbers, Stack<Character> operators) {
        if (numbers.size() < 2) {
            throw new IllegalArgumentException("Invalid expression: insufficient numbers");
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
    private static boolean isOperator(char ch) {
        return ch == '+' || ch == '−' || ch == '-' || ch == '×' || ch == '÷';
    }

    public void onClearHistoryClick(View view) {
        // Clear the historyList
        historyList.clear();
        // Notify the adapter that the data set has changed
        historyAdapter.notifyDataSetChanged();
    }
}


//    public void onOperatorClick(View view) {
//        MaterialButton button = (MaterialButton) view;
//        String btnText = button.getText().toString();
//        // Get current cursor position
//        int cursorPosition = textView1.getSelectionStart();
//        // Get the current text
//        String currentText = textView1.getText().toString();
//        if (checkClickEqual) {
//            checkClickEqual = false;
//            checkBack = false;
//            textView1.setTextSize(42);
//            textView2.setTextSize(28);
//            textView1.setTextAppearance(R.style.changeDigit_tv1);
//            textView2.setTextAppearance(R.style.changeDigit_tv2);
//            currentText = textView2.getText().toString();
//            cursorPosition = currentText.length(); // Place cursor at the end of the result
//            textView1.setText(currentText + btnText);
//            textView2.setText(""); // Clear textView2 for new operation
//            // Set cursor position to the end of textView1
//            textView1.setSelection(textView1.getText().length());
//        } else {
//            if (currentText.isEmpty() && btnText.equals("−")) {
//                // Handle the case where a negative sign is being added at the beginning
//                currentText = "−";
//            } else if (!currentText.isEmpty()) {
//                // Insert the operator at the cursor position
//                String newText = currentText.substring(0, cursorPosition) + btnText + currentText.substring(cursorPosition);
//                textView1.setText(newText);
//
//                // Move the cursor to the right of the inserted operator
//                cursorPosition++;
//                textView1.setSelection(cursorPosition);
//            }
//        }
//        setOp = true;
//        textView2.setText(""); // Clear textView2 for new result
//    }
//public void onOperatorClick(View view) {
//    MaterialButton button = (MaterialButton) view;
//    String btnText = button.getText().toString();
//
//    // Get current cursor position
//    int cursorPosition = textView1.getSelectionStart();
//
//    // Get the current text
//    String currentText = textView1.getText().toString();
//
//    // Check if we're following an equal operation
//    if (checkClickEqual) {
//        checkClickEqual = false;
//        checkBack = false;
//        textView1.setTextSize(42);
//        textView2.setTextSize(28);
//        textView1.setTextAppearance(R.style.changeDigit_tv1);
//        textView2.setTextAppearance(R.style.changeDigit_tv2);
//        currentText = textView2.getText().toString();
//        cursorPosition = currentText.length(); // Place cursor at the end of the result
//        textView1.setText(currentText + btnText);
//        textView2.setText(""); // Clear textView2 for new operation
//        // Set cursor position to the end of textView1
//        textView1.setSelection(textView1.getText().length());
//        setOp = true;
//        return; // Exit method after handling equal operation
//    }
//
//    // Check if current text is empty and button text is "-"
//    if (currentText.isEmpty() && btnText.equals("−")) {
//        currentText = "−";
//    } else if (!currentText.isEmpty()) {
//        // Check if the cursor is not at the beginning and the previous character is an operator
//        if (cursorPosition > 0 && isOperator(currentText.charAt(cursorPosition - 1))) {
//            // Handle replacing the last operator with the new one
//            char lastChar = currentText.charAt(currentText.length() - 1);
//            if (lastChar == '+' || lastChar == '−' || lastChar == '×' || lastChar == '÷') {
//                currentText = currentText.substring(0, currentText.length() - 1) + btnText;
//            } else {
//                currentText += btnText;
//            }
//        } else {
//            // Insert the operator at the cursor position
//            String newText = currentText.substring(0, cursorPosition) + btnText + currentText.substring(cursorPosition);
//            textView1.setText(newText);
//        }
//
//        // Move the cursor to the right of the inserted operator
//        cursorPosition++;
//        textView1.setSelection(cursorPosition);
//    }
//
//    // Set the operator flag
//    setOp = true;
//    // Clear textView2 for new result
//    textView2.setText("");
//}


//    public void onPercentageClick(View view) {
//        String currentText = textView1.getText().toString();
//        if (checkClickEqual) {
//            textView1.setTextSize(42);
//            textView2.setTextSize(28);
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
//            // Calculate the result and update textView2
//            double result = calculate(text);
//            String resultText = Double.toString(result);
//            textView2.setText(resultText);
//        }
//    }



//    public void onBackClick(View view) {
//        if (checkClickEqual) {
//            textView1.setTextSize(42);
//            textView2.setTextSize(28);
//            textView1.setTextAppearance(R.style.changeDigit_tv1);
//            textView2.setTextAppearance(R.style.changeDigit_tv2);
//        }
//        checkBack = true;
//        String currentText = textView1.getText().toString();
//        if (currentText.length() > 0) {
//            textView1.setText(currentText.substring(0, currentText.length() - 1));
//            // Calculate the result and update textView2
//            String newText = textView1.getText().toString();
//            if (!newText.isEmpty()) {
//                double result = calculate(newText);
//                String resultText = Double.toString(result);
//                textView2.setText(resultText);
//            } else {
//                textView2.setText("");
//            }
//        }
//    }

//    public void onPercentageClick(View view) {
//        String currentText = textView1.getText().toString();
//        // Check if we're following an equal operation
//        if (checkClickEqual) {
//            textView1.setTextSize(42);
//            textView2.setTextSize(28);
//            textView1.setTextAppearance(R.style.changeDigit_tv1);
//            textView2.setTextAppearance(R.style.changeDigit_tv2);
//            checkClickEqual = false;
//            currentText = textView2.getText().toString();
//            textView1.setText(currentText);
//            // Set cursor position to the end of textView1
//            textView1.setSelection(textView1.getText().length());
//        }
//
//        // Ensure there is valid text and we are not immediately following an operator
//        if (!currentText.isEmpty() && !setOp) {
//            // Get current cursor position
//            int cursorPosition = textView1.getSelectionStart();
//            // Check if the cursor is before an operator
//            if (cursorPosition > 0 && isOperator(currentText.charAt(cursorPosition - 1))) {
//                // If cursor is before an operator, adjust cursor position
//                //pass
//            }else{
//
//            // Insert the percentage symbol at the cursor position
//            String newText = currentText.substring(0, cursorPosition) + "%" + currentText.substring(cursorPosition);
//
//            // Update the text in the EditText
//            textView1.setText(newText);
//
//            // Move the cursor to the right of the inserted percentage symbol
//            textView1.setSelection(cursorPosition + 1);
//
//            // Calculate the result and update textView2
//            double result = calculate(newText);
//            String resultText = Double.toString(result);
//            textView2.setText(resultText);
//        }}
//
//
//    }


// public void onDigitClick(View view) {
//        if (checkClickEqual && !checkBack) {
//            textView1.setTextSize(42);
//            textView2.setTextSize(28);
//            textView1.setTextAppearance(R.style.changeDigit_tv1);
//            textView2.setTextAppearance(R.style.changeDigit_tv2);
//            checkClickEqual = false;
//            textView1.setText("");
//            textView2.setText("");
//            checkPercentage = false;
//        }
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
