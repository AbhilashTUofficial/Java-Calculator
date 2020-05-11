package com.example.calculator_app;

import androidx.appcompat.app.AppCompatActivity;
import java.lang.Integer;
import java.lang.String;
import android.view.View;
import android.widget.Button;
import android.os.Bundle;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    int firstNumber;
    int secondNumber;
    String screenContent="";
    int secondNumberIndex;
    boolean isOperation=false;
    char theOperation;

    public void getnumber(int number){

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculator_layout);
        final TextView calculator_Screen = findViewById(R.id.calculator_Screen);
        final Button num0 = findViewById(R.id.number0);
        final Button num1 = findViewById(R.id.number1);
        final Button num2 = findViewById(R.id.number2);
        final Button num3 = findViewById(R.id.number3);
        final Button num4 = findViewById(R.id.number4);
        final Button num5 = findViewById(R.id.number5);
        final Button num6 = findViewById(R.id.number6);
        final Button num7 = findViewById(R.id.number7);
        final Button num8 = findViewById(R.id.number8);
        final Button num9 = findViewById(R.id.number9);
        final Button add = findViewById(R.id.addition);
        final Button sub = findViewById(R.id.subtraction);
        final Button mul = findViewById(R.id.multiplication);
        final Button div = findViewById(R.id.division);
        final Button equal = findViewById(R.id.equal);
        final Button dot = findViewById(R.id.dot);
        final View.OnClickListener calculatorListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final int id = v.getId();
                switch (id) {
                    case R.id.number0:

                        calculator_Screen.append("0");
                        break;

                    case R.id.number1:
                        calculator_Screen.append("1");
                        break;

                    case R.id.number2:
                        calculator_Screen.append("2");
                        break;
                    case R.id.number3:
                        calculator_Screen.append("3");
                        break;
                    case R.id.number4:
                        calculator_Screen.append("4");
                        break;
                    case R.id.number5:
                        calculator_Screen.append("5");
                        break;
                    case R.id.number6:
                        calculator_Screen.append("6");
                        break;
                    case R.id.number7:
                        calculator_Screen.append("7");
                        break;
                    case R.id.number8:
                        calculator_Screen.append("8");
                        break;
                    case R.id.number9:
                        calculator_Screen.append("9");
                        break;
                    case R.id.equal:
                        if(isOperation){
                            screenContent=calculator_Screen.getText().toString();
                            secondNumber=Integer.parseInt(screenContent.substring(secondNumberIndex,screenContent.length()));
                            if(theOperation=='+'){
                                firstNumber+=secondNumber;
                                calculator_Screen.setText(String.valueOf(firstNumber));
                            }
                            else if(theOperation=='-'){
                                firstNumber-=secondNumber;
                                calculator_Screen.setText(String.valueOf(firstNumber));
                            }
                            else if(theOperation=='x') {
                                firstNumber *= secondNumber;
                                calculator_Screen.setText(String.valueOf(firstNumber));
                            }
                            else if(theOperation=='/') {
                                firstNumber /= secondNumber;
                                calculator_Screen.setText(String.valueOf(firstNumber));
                            }
                        }

                        break;
                    case R.id.addition:
                        screenContent=calculator_Screen.getText().toString();
                        secondNumberIndex=screenContent.length()+1;
                        firstNumber=Integer.parseInt(calculator_Screen.getText().toString());
                        calculator_Screen.append("+");
                        isOperation=true;
                        theOperation='+';
                        break;
                    case R.id.subtraction:
                        screenContent=calculator_Screen.getText().toString();
                        secondNumberIndex=screenContent.length()+1;
                        firstNumber=Integer.parseInt(calculator_Screen.getText().toString());
                        calculator_Screen.append("-");
                        isOperation=true;
                        theOperation='-';
                        break;
                    case R.id.multiplication:
                        screenContent=calculator_Screen.getText().toString();
                        secondNumberIndex=screenContent.length()+1;
                        firstNumber=Integer.parseInt(calculator_Screen.getText().toString());
                        calculator_Screen.append("x");
                        isOperation=true;
                        theOperation='x';
                        break;
                    case R.id.division:
                        screenContent=calculator_Screen.getText().toString();
                        secondNumberIndex=screenContent.length()+1;
                        firstNumber=Integer.parseInt(calculator_Screen.getText().toString());
                        calculator_Screen.append("/");
                        isOperation=true;
                        theOperation='/';
                        break;
                    case R.id.dot:
                        calculator_Screen.append(".");
                        break;


                }

            }
        };
        num0.setOnClickListener(calculatorListener);
        num1.setOnClickListener(calculatorListener);
        num2.setOnClickListener(calculatorListener);
        num3.setOnClickListener(calculatorListener);
        num4.setOnClickListener(calculatorListener);
        num5.setOnClickListener(calculatorListener);
        num6.setOnClickListener(calculatorListener);
        num7.setOnClickListener(calculatorListener);
        num8.setOnClickListener(calculatorListener);
        num9.setOnClickListener(calculatorListener);
        dot.setOnClickListener(calculatorListener);
        equal.setOnClickListener(calculatorListener);
        add.setOnClickListener(calculatorListener);
        sub.setOnClickListener(calculatorListener);
        mul.setOnClickListener(calculatorListener);
        div.setOnClickListener(calculatorListener);

        final Button delete = findViewById(R.id.del);
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String displayedElements = calculator_Screen.getText().toString();
                int length = displayedElements.length();
                if (length > 0) {
                    displayedElements = displayedElements.substring(0, length - 1);
                    calculator_Screen.setText(displayedElements);

                }
            }
        });
        final Button clearEverything = findViewById(R.id.clearAll);
        clearEverything.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculator_Screen.setText("");
            }
        });
    }

}

