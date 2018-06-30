package com.mantey.quizapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class QuestionsActivity extends AppCompatActivity {
    private CheckBox questionOneCheckBoxOne, questionOneCheckBoxTwo, questionOneCheckBoxThree;
    private RadioButton questionTwoRadioButtonOne, questionTwoRadioButtonTwo, questionTwoRadioButtonThree;
    private RadioButton questionThreeRadioButtonOne, questionThreeRadioButtonTwo, questionThreeRadioButtonThree;
    private CheckBox questionFourCheckBoxOne, questionFourCheckBoxTwo, questionFourCheckBoxThree;
    private RadioButton questionFiveRadioButtonOne, questionFiveRadioButtonTwo, questionFiveRadioButtonThree;
    private RadioButton questionSixRadioButtonOne, questionSixRadioButtonTwo;
    private EditText questionSevenEditText;
    private RadioButton questionEightRadioButtonOne, questionEightRadioButtonTwo, questionEightRadioButtonThree;
    private EditText questionNineEditText;
    private RadioButton questionTenRadioButtonOne, questionTenRadioButtonTwo;
    private int scores = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);

        initQuestionViews();

    }

    /**
     * Initiate all views in the Questions Activity
     * CheckBoxes, RadioButtons and EditTexts
     */
    public void  initQuestionViews() {
        questionOneCheckBoxOne = (CheckBox) findViewById(R.id.question_one_correct_answer_one);
        questionOneCheckBoxTwo = (CheckBox) findViewById(R.id.question_one_wrong_answer);
        questionOneCheckBoxThree = (CheckBox) findViewById(R.id.question_one_correct_answer_two);

        questionTwoRadioButtonOne = (RadioButton) findViewById(R.id.question_two_correct_answer);
        questionTwoRadioButtonTwo = (RadioButton) findViewById(R.id.question_two_wrong_answer_one);
        questionTwoRadioButtonThree = (RadioButton) findViewById(R.id.question_two_wrong_answer_two);

        questionThreeRadioButtonOne = (RadioButton) findViewById(R.id.question_three_wrong_answer_one);
        questionThreeRadioButtonTwo = (RadioButton) findViewById(R.id.question_three_correct_answer);
        questionThreeRadioButtonThree = (RadioButton) findViewById(R.id.question_three_wrong_answer_two);

        questionFourCheckBoxOne = (CheckBox) findViewById(R.id.question_four_correct_answer_one);
        questionFourCheckBoxTwo = (CheckBox) findViewById(R.id.question_four_wrong_answer);
        questionFourCheckBoxThree = (CheckBox) findViewById(R.id.question_four_correct_answer_two);

        questionFiveRadioButtonOne = (RadioButton) findViewById(R.id.question_five_wrong_answer_one);
        questionFiveRadioButtonTwo = (RadioButton) findViewById(R.id.question_five_correct_answer);
        questionFiveRadioButtonThree = (RadioButton) findViewById(R.id.question_five_wrong_answer_two);

        questionSixRadioButtonOne = (RadioButton) findViewById(R.id.question_six_wrong_answer);
        questionSixRadioButtonTwo = (RadioButton) findViewById(R.id.question_six_correct_answer);

        questionSevenEditText = (EditText) findViewById(R.id.question_seven_answer);

        questionEightRadioButtonOne = (RadioButton) findViewById(R.id.question_eight_wrong_answer_one);
        questionEightRadioButtonTwo = (RadioButton) findViewById(R.id.question_eight_correct_answer);
        questionEightRadioButtonThree = (RadioButton) findViewById(R.id.question_eight_wrong_answer_two);

        questionNineEditText = (EditText) findViewById(R.id.question_nine_answer);

        questionTenRadioButtonOne = (RadioButton) findViewById(R.id.question_ten_wrong_answer);
        questionTenRadioButtonTwo = (RadioButton) findViewById(R.id.question_ten_correct_answer);
    }

    public void submitButton(View view) {

        //We check to see if the correct answers are checked (For RadioButtons and CheckBoxes)
        //The resource ID for a view is used to identify the correct answer
        //If the correct answers are checked we increase scores by 1

        //Question One
        if (questionOneCheckBoxOne.isChecked() && questionOneCheckBoxThree.isChecked() && !questionOneCheckBoxTwo.isChecked()) {
            scores = scores + 1;
        }

        //Question Two
        if (questionTwoRadioButtonOne.isChecked()) {
            scores = scores + 1;
        }

        //Question Three
        if (questionThreeRadioButtonTwo.isChecked()) {
            scores = scores + 1;
        }

        //Question Four
        if (questionFourCheckBoxOne.isChecked() && questionFourCheckBoxThree.isChecked() && !questionFourCheckBoxTwo.isChecked()) {
            scores = scores + 1;
        }

        //Question Five
        if (questionFiveRadioButtonTwo.isChecked()) {
            scores = scores + 1;
        }

        //Question Six
        if (questionSixRadioButtonTwo.isChecked()) {
            scores = scores + 1;
        }

        //Question Seven
        String question_seven_answer = questionSevenEditText.getText().toString();
        if (question_seven_answer.equalsIgnoreCase("Saturn")) {
            scores = scores + 1;
        }

        //Question Eight
        if (questionEightRadioButtonTwo.isChecked()) {
            scores = scores + 1;
        }

        //Question Nine
        String question_nine_answer = questionNineEditText.getText().toString();
        if (question_nine_answer.contains("8")) {
            scores = scores + 1;
        }

        //Question Ten
        if (questionTenRadioButtonTwo.isChecked()) {
            scores = scores + 1;
        }

        displayResults();
    }

    /**
     * Displays the result in an alert Dialog.
     * It also gives the user the chance to Play Again or Restart
     */
    public void displayResults() {

        String congrats_message;
        if (scores > 7) {
            congrats_message = "Wow!!! You are a rock...";
        } else {
            congrats_message = "You did better. Try again to become a rock!!!";
        }

        int scores_percent = (scores * 100) / 10;

        String display_message = congrats_message+"\n\nYou scored "+scores_percent+"%. " +
                "You Answered "+scores+" out of 10 questions correct!";

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(display_message)
                .setPositiveButton(R.string.play_again, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                       finish();
                       startActivity(new Intent(QuestionsActivity.this, QuestionsActivity.class));
                    }
                })

                .setNegativeButton(R.string.restart, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        finish();
                        startActivity(new Intent(QuestionsActivity.this, MainActivity.class));
                    }
                });

        builder.create();

        builder.show();

        scores = 0; //We reset the scores after its being displayed
    }
}
