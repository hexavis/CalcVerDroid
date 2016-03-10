package com.jacq100092753.calcverdroid;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class Calculator extends AppCompatActivity {
    //variables
    public static String firstNumStr = "";
    public static String secondNumStr = "";
    public static String operSymbol = "";

    public static TextView main;

    public static Boolean isSecondNum = false;
    public static Boolean isBeginNum = true;
    public static Boolean checkDec = false;
    public static Boolean isNeg = false;
    public static Boolean isCalAgain = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //--------------Calculator Code--------------
        main = (TextView) findViewById(R.id.mainLabel);

        //clear button click
        TextView clearClick = (TextView) findViewById(R.id.clearButt);
        clearClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //reset numbers to 0
                firstNumStr = "";
                secondNumStr = "";
                operSymbol = "";

                //reset bools
                isSecondNum = false;
                isBeginNum = true;
                checkDec = false;
                isNeg = false;
                isCalAgain = false;

                //set label back to 0
                main.setText("0");
            }
        });

        TextView switchClick = (TextView) findViewById(R.id.switchButt);
        switchClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isNeg == true){
                    //remove the - from the number ==== not currently working =====
                    if(isSecondNum == false){
                        firstNumStr = firstNumStr.substring(1);
                        main.setText(firstNumStr);
                        isNeg = false;
                    }
                    else{
                        secondNumStr = secondNumStr.substring(1);
                        main.setText(secondNumStr);
                        isNeg = false;
                    }
                }
                else{
                    //add the - to the number
                    if(isSecondNum == false){
                        firstNumStr = "-" + firstNumStr;
                        main.setText(firstNumStr);
                        isNeg = true;
                    }
                    else{
                        secondNumStr = "-" + secondNumStr;
                        main.setText(secondNumStr);
                        isNeg = true;
                    }
                }
            }
        });

        //number buttons
        TextView zeroClick = (TextView) findViewById(R.id.zeroButt);
        zeroClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                append("0");
            }
        });
        TextView oneClick = (TextView) findViewById(R.id.oneButt);
        oneClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                append("1");
            }
        });
        TextView twoClick = (TextView) findViewById(R.id.twoButt);
        twoClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                append("2");
            }
        });
        TextView threeClick = (TextView) findViewById(R.id.threeButt);
        threeClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                append("3");
            }
        });
        TextView fourClick = (TextView) findViewById(R.id.fourButt);
        fourClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                append("4");
            }
        });
        TextView fiveCick = (TextView) findViewById(R.id.fiveButt);
        fiveCick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                append("5");
            }
        });
        TextView sixClick = (TextView) findViewById(R.id.sixButt);
        sixClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                append("6");
            }
        });
        TextView sevenClick = (TextView) findViewById(R.id.sevenButt);
        sevenClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                append("7");
            }
        });
        TextView eightClick = (TextView) findViewById(R.id.eightButt);
        eightClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                append("8");
            }
        });
        TextView nineclick = (TextView) findViewById(R.id.nineButt);
        nineclick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                append("9");
            }
        });

        //add decimal
        TextView decClick = (TextView) findViewById(R.id.deciButt);
        decClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //check if decimal exists
                if(checkDec == false){
                    append(".");
                    checkDec = true;
                }
                else{

                }
            }
        });

        //Operands
        TextView divideClick = (TextView) findViewById(R.id.divideButt);
        divideClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operSymbol = "/";
                isSecondNum = true;
                isBeginNum = true;
                isCalAgain = true;
                isNeg = false;
            }
        });
        TextView mulClick = (TextView) findViewById(R.id.multiplyButt);
        mulClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operSymbol = "*";
                isSecondNum = true;
                isBeginNum = true;
                isCalAgain = true;
                isNeg = false;
            }
        });
        TextView subclick = (TextView) findViewById(R.id.minusButt);
        subclick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operSymbol = "-";
                isSecondNum = true;
                isBeginNum = true;
                isCalAgain = true;
                isNeg = false;
            }
        });
        TextView addClick = (TextView) findViewById(R.id.addButt);
        addClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operSymbol = "+";
                isSecondNum = true;
                isBeginNum = true;
                isCalAgain = true;
                isNeg = false;
            }
        });

        //equals button
        TextView equalsClick = (TextView) findViewById(R.id.equalsButt);
        equalsClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doMath();
            }
        });

    }

    //--------------------
    //Functions

    //appends the number to make a full inputed number
    public static void append(String appn){
        if(isSecondNum == false){
            if(isBeginNum == true){
                main.setText("");
            }
            firstNumStr += appn;
            main.setText(firstNumStr);
        }
        else{
            if(isBeginNum == true){
                main.setText("");
            }
            secondNumStr += appn;
            main.setText(secondNumStr);
        }
    }

    //This is the function that will actually do the math
    public static void doMath(){
        //convert secondNumStr to float
        if(isSecondNum == true){
            float firstNum = Float.parseFloat(firstNumStr);
            float secondNum = Float.parseFloat(secondNumStr);
            float finalNum = 0;
            //do the math
            if(operSymbol == "+"){
                finalNum = firstNum + secondNum;
            }
            else if(operSymbol == "-"){
                finalNum = firstNum - secondNum;
            }
            else if(operSymbol == "/"){
                finalNum = firstNum / secondNum;
            }
            else if(operSymbol == "*"){
                finalNum = firstNum * secondNum;
            }

            //set label
            main.setText(Float.toString(finalNum));

            //reset bools
            checkDec = false;
            isBeginNum = true;
            isNeg = false;

            if(isCalAgain == false){
                //reset numbers just in case
                firstNumStr = "";
                secondNumStr = "";
                isSecondNum = false;
            }
            else{
                //set first number to be last calc's final number and reset second num
                firstNumStr = Float.toString(finalNum);
                secondNumStr = "";
                isCalAgain = false;

            }
        }

    }//end function equals

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_calculator, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }




}
