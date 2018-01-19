package com.example.android.quizzapp;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    boolean isRightOne = false;
    boolean isRightTwo = false;
    boolean isRightThree = false;
    boolean isRightFour = false;
    boolean isRightFive = false;
    int numberRightAnswers = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        setContentView(R.layout.activity_main);
    }

    //Checks if question one is right and sets the variables
    public boolean questionOneRight(View view) {
        isRightOne = true;
        return isRightOne;
    }

    public boolean questionOneWrong(View view) {
        isRightOne = false;
        return isRightOne;
    }

    //Checks if question two is right and sets the variables
    public void questionTwo() {
        EditText gas_editText = (EditText) (findViewById(R.id.gas_editText));
        String gasName = gas_editText.getText().toString();
        if (gasName.equalsIgnoreCase("Oxygen")) {
            isRightTwo = true;
        }
        return;
    }


    //Checks if question three is right and sets the variables
    public void questionThree() {
        CheckBox front = (CheckBox) (findViewById(R.id.front_checkBox));
        CheckBox back = (CheckBox) (findViewById(R.id.back_checkBox));
        isRightThree = (front.isChecked() && back.isChecked());
        return;
    }

    //Checks if question four is right and sets the variables
    public boolean questionFourWrong(View view) {
        isRightFour = false;
        return isRightFour;
    }

    public boolean questionFourRight(View view) {
        isRightFour = true;
        return isRightFour;
    }

    //Checks if question four is right and sets the variables
    public boolean questionFiveWrong(View view) {
        isRightFive = false;
        return isRightFive;
    }

    public boolean questionFiveRight(View view) {
        isRightFive = true;
        return isRightFive;
    }

    //Evaluation
    public void evaluation(View view) {
        if (isRightOne) numberRightAnswers++;
        if (isRightTwo) numberRightAnswers++;
        if (isRightThree) numberRightAnswers++;
        if (isRightFour) numberRightAnswers++;
        if (isRightFive) numberRightAnswers++;
        displayToast(numberRightAnswers);
    }


    public void displayToast(int numberRightAnswers) {

        if (numberRightAnswers == 5) {
            Toast professionalToast = Toast.makeText(this, "Test Toast 5", Toast.LENGTH_SHORT);
            professionalToast.show();
        } else if (numberRightAnswers > 2 && numberRightAnswers < 5) {
            Toast nearlyToast = Toast.makeText(this, "Test Toast 3 or 4", Toast.LENGTH_SHORT);
            nearlyToast.show();
        } else if (numberRightAnswers > 1 && numberRightAnswers < 3) {
            Toast improvementToast = Toast.makeText(this, "Test Toast 1 or 2", Toast.LENGTH_SHORT);
            improvementToast.setGravity(Gravity.TOP, 0, 0);
            improvementToast.show();
        } else {
            Toast zeroToast = Toast.makeText(this, "Test Toast 0", Toast.LENGTH_SHORT);
            zeroToast.show();
        }
    }

    public void reset(View view) {
        boolean isRightOne = false;
        boolean isRightTwo = false;
        boolean isRightThree = false;
        boolean isRightFour = false;
        boolean isRightFive = false;
        int numberRightAnswers = 0;
        return;
    }
}


// ignore case in answer two
// if (userName.trim().equalsIgnoreCase(resultString.trim())) {
// return true;
//}
// get variable status and thus answer status all the time . on click evaluate
// toast zusammenfassen

//Check for name conventions

//red/ green
//ave status when mode changes
//toast zusammenfassen



