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
import android.widget.RadioGroup;
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


    //Checks if question three is right and sets the variables
    public boolean questionThree(View view) {
        CheckBox front = (CheckBox) (findViewById(R.id.front_checkBox));
        CheckBox back = (CheckBox) (findViewById(R.id.back_checkBox));
        CheckBox not = (CheckBox) (findViewById(R.id.not_checkBox));
        CheckBox nothing = (CheckBox) (findViewById(R.id.nothing_checkBox));
        isRightThree = (front.isChecked() && back.isChecked() && !not.isChecked() && !nothing.isChecked());
        return isRightThree;
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

    //Checks if question five is right and sets the variables
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
        numberRightAnswers = 0;
        if (isRightOne) numberRightAnswers++;
        EditText gas_editText = (EditText) (findViewById(R.id.gas_editText));
        String gasName = gas_editText.getText().toString();
        if (gasName.equalsIgnoreCase(getString(R.string.answer_two)))
            isRightTwo = true;
        if (isRightTwo) numberRightAnswers++;
        if (isRightThree) numberRightAnswers++;
        if (isRightFour) numberRightAnswers++;
        if (isRightFive) numberRightAnswers++;
        displayToast(numberRightAnswers);
    }


    public void displayToast(int numberRightAnswers) {

        if (numberRightAnswers == 5) {
            Toast professionalToast = Toast.makeText(this, numberRightAnswers + " " + getString(R.string.toast_general) +
                    " " + getString(R.string.toast5), Toast.LENGTH_LONG);
            professionalToast.show();
        } else if (numberRightAnswers > 2 && numberRightAnswers < 5) {
            Toast nearlyToast = Toast.makeText(this, numberRightAnswers + " " + getString(R.string.toast_general)+
                    " " + getString(R.string.toast3_4), Toast.LENGTH_LONG);
            nearlyToast.show();
        } else if (numberRightAnswers > 0 && numberRightAnswers < 3) {
            Toast improvementToast = Toast.makeText(this, numberRightAnswers + " " + getString(R.string.toast_general)+
                    " " + getString(R.string.toast1_2), Toast.LENGTH_LONG);
            improvementToast.show();
        } else {
            Toast zeroToast = Toast.makeText(this, numberRightAnswers + " " + getString(R.string.toast_general)+
                    " " + getString(R.string.toast0), Toast.LENGTH_LONG);
            zeroToast.show();
        }
    }

    public int reset(View view) {
        int numberRightAnswers = 0;
        CheckBox front = (CheckBox) (findViewById(R.id.front_checkBox));
        CheckBox back = (CheckBox) (findViewById(R.id.back_checkBox));
        CheckBox not = (CheckBox) (findViewById(R.id.not_checkBox));
        CheckBox nothing = (CheckBox) (findViewById(R.id.nothing_checkBox));
        if (front.isChecked()) front.toggle();
        if (back.isChecked()) back.toggle();
        if (not.isChecked()) not.toggle();
        if (nothing.isChecked()) nothing.toggle();
        EditText gas_editText = (EditText) (findViewById(R.id.gas_editText));
        gas_editText.setText("");
        isRightOne = false;
        isRightTwo = false;
        isRightThree = false;
        isRightFour = false;
        isRightFive = false;
        RadioGroup groupOne = (RadioGroup) (findViewById(R.id.questionOneGroup));
        groupOne.clearCheck();
        RadioGroup groupFour = (RadioGroup) (findViewById(R.id.questionFourGroup));
        groupFour.clearCheck();
        RadioGroup groupFive = (RadioGroup) (findViewById(R.id.questionFiveGroup));
        groupFive.clearCheck();
        return numberRightAnswers;
    }
}


// toast zusammenfassen


//Check for name conventions

//red/ green
//ave status when mode changes
//toast zusammenfassen



