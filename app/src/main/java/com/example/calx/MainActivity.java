package com.example.calx;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.button.MaterialButton;

import java.text.DecimalFormat;
import java.util.Stack;

//public class MainActivity extends AppCompatActivity {
//    private TextView textView1,textView2;
//    private double input;
//    private double firstOperand;
//    private double secondOperand;
//    private double result = Double.NaN;
//    private boolean lastDot = false;
//    private boolean lastDigit = false;
//    private boolean stateError = false;
//    private boolean lastnumeric = false;
//    private boolean lastOp = false;
//    public  void onDigitClick(View view){
//
//    }
//    public void onOperatorClick(View view){
//
//    }
//    public void onACClick(View view){
//
//    }
//    public  void onBackClick(View view){
//
//    }
//    public void onEqualClick(View view){
//            if(Double.isNaN(result)){
//                    textView2.setText("NaN");
//            } else if (lastnumeric &&) {
//
//            }
//        {
//                textView2.setText(String.format("=%s", result));
//            }
//    }
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        TextView textView1 = findViewById(R.id.textView1);
//        TextView textView2= findViewById(R.id.textView2);
//
//        super.onCreate(savedInstanceState);
//        EdgeToEdge.enable(this);
//        setContentView(R.layout.activity_main);
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
//            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
//            return insets;
//        });
//    }
//}




public class MainActivity extends AppCompatActivity {
    private TextView textView1, textView2;
    private boolean setOp = true;
    int op = 0;
    private boolean checkPercentage = false;
    private boolean checkClickEqual=false;

    private boolean checkBack=false;
    private boolean checkSecondOperand = false;
    private double op1 = 0.0;
    private double op2 = 0.0;
    private double result = 0.0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView1 = findViewById(R.id.textView1);
        textView2 = findViewById(R.id.textView2);
    }

    public void onDigitClick(View view) {
        if(checkClickEqual && !checkBack)  {
            textView1.setTextSize(42);
            textView2.setTextSize(28);
            // Determine the current theme mode
            textView1.setTextAppearance(R.style.changeDigit_tv1);
            textView2.setTextAppearance(R.style.changeDigit_tv2);
//            int nightMode = AppCompatDelegate.getDefaultNightMode();
//
//            // Set text color based on the theme mode
//            if (nightMode == AppCompatDelegate.MODE_NIGHT_YES) {
//                // Dark mode
//                textView2.setTextColor(ContextCompat.getColor(this, R.color.color_custom2));
//                textView1.setTextColor(Color.WHITE);
//            } else {
//                // Light mode
//                textView2.setTextColor(ContextCompat.getColor(this, R.color.color_custom1));
//                textView1.setTextColor(Color.BLACK);
//            }
            checkClickEqual=false;
            textView1.setText("");
            textView2.setText("");
            checkPercentage=false;
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

        if(checkClickEqual) {
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
        if(checkClickEqual) {
            textView1.setTextSize(42);
            textView2.setTextSize(28);
            textView1.setTextAppearance(R.style.changeDigit_tv1);
            textView2.setTextAppearance(R.style.changeDigit_tv2);
            // Determine the current theme mode
            //int nightMode = AppCompatDelegate.getDefaultNightMode();

            // Set text color based on the theme mode
//            if (nightMode == AppCompatDelegate.MODE_NIGHT_YES) {
//                // Dark mode
//                textView2.setTextColor(ContextCompat.getColor(this, R.color.color_custom2));
//                textView1.setTextColor(Color.WHITE);
//            } else {
//                // Light mode
//                textView2.setTextColor(ContextCompat.getColor(this, R.color.color_custom1));
//                textView1.setTextColor(Color.BLACK);
//            }
            checkClickEqual=false;
            currentText=textView2.getText().toString();
            textView1.setText(currentText);
        }
        else {
            currentText = textView1.getText().toString();

        }
        if (!currentText.isEmpty() && !setOp ) {
            String text = currentText + "%";
            textView1.setText(text);
            checkPercentage=true;
            // Calculate the result and update textView2
            double result = calculate(text);
            String resultText = Double.toString(result);
            textView2.setText(resultText);
        }
//        String currentText = textView1.getText().toString();
//        textView1.setText(currentText+"%");
//        if (!currentText.isEmpty() && !setOp) {
//            try {
//                double currentValue = Double.parseDouble(currentText);
//                currentValue = currentValue / 100;
//                textView2.setText(String.valueOf(currentValue));
//            } catch (NumberFormatException e) {
//                textView2.setText("Error");
//            }
//        }

    }
    public void onEqualClick(View view) {

        String text = textView1.getText().toString();
        double result = calculate(text);
        String t = Double.toString(result);
        textView2.setTextSize(42);
        textView1.setTextSize(28);
        textView1.setTextAppearance(R.style.changeDigit_tv2);
        textView2.setTextAppearance(R.style.changeDigit_tv1);
        // Determine the current theme mode
//        int nightMode = AppCompatDelegate.getDefaultNightMode();
//
//        // Set text color based on the theme mode
//        if (nightMode == AppCompatDelegate.MODE_NIGHT_YES) {
//            // Dark mode
//            textView2.setTextColor(Color.WHITE);
//            textView1.setTextColor(ContextCompat.getColor(this, R.color.color_custom2));
//        } else {
//            // Light mode
//            textView2.setTextColor(Color.BLACK);
//            textView1.setTextColor(ContextCompat.getColor(this, R.color.color_custom1));
//        }
        textView2.setText(t);
        checkClickEqual=true;
    }

    public void onACClick(View view) {
        textView1.setText("");
        textView2.setText("");
        checkPercentage=false;
    }

    public void onBackClick(View view) {
        if(checkClickEqual) {
            textView1.setTextSize(42);
            textView2.setTextSize(28);
            // Determine the current theme mode
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
            } else if (ch == '+' || ch == '−') {
                if (i == 0 || expression.charAt(i - 1) == '(') { // Handle negative numbers
                    isNegative = true; // Set the flag for negative numbers
                    continue; // Skip further processing in this iteration
                }
                while (!operators.isEmpty() && (operators.peek() == '×' || operators.peek() == '÷' || operators.peek() == '+' || operators.peek() == '−')) {
                    performOperation(numbers, operators);
                }
                operators.push(ch);
            } else if (ch == '%') {
                if (i + 1 < expression.length() && Character.isDigit(expression.charAt(i + 1))) {
                    // Check if next character is a number
                    double secondNum = Character.getNumericValue(expression.charAt(i + 1));
                    double firstNum = numbers.pop();
                    double result = firstNum * (secondNum / 100);
                    numbers.push(result);
                    i++; // Skip the second number (already processed)
                } else {
                    double num = numbers.pop();
                    if (!operators.isEmpty() && (operators.peek() == '*' || operators.peek() == '/')) {
                        char op = operators.pop();
                        double prevNum = numbers.pop();
                        double result = (op == '*') ? prevNum * (num / 100) : prevNum / (num / 100);
                        numbers.push(result);
                    } else {
                        num = num / 100;
                        numbers.push(num);
                    }
                }
            }
        }

        while (!operators.isEmpty()) {
            performOperation(numbers, operators);
        }

        return numbers.pop();
    }

    private static void performOperation(Stack<Double> numbers, Stack<Character> operators) {
        char operator = operators.pop();
        double num2 = numbers.pop();
        double num1 = numbers.isEmpty() ? 0 : numbers.pop();
        double result = 0;
        if (operator == '+') {
            result = num1 + num2;
        } else if (operator == '−') {
            result = num1 - num2;
        } else if (operator == '×') {
            result = num1 * num2;
        } else if (operator == '÷') {
            result = num1 / num2;
        }
        numbers.push(result);
    }
}
