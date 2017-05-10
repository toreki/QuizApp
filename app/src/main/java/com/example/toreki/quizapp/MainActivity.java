package com.example.toreki.quizapp;

import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    View mainScrollView;
    View howtoLayout;
    View questionLayout;
    View submitLayout;
    View againLayout;
    View solution1;
    View solution2;
    View solution3;
    ImageView solution1image;

    int points = 0;

    int       goodAnswers1 = 2;
    int       goodAnswers2 = 2;
    boolean[] goodAnswers3 = new boolean[]{false, true, true, false};
    boolean correct1 = false;
    boolean correct2 = false;
    boolean correct3 = true;

    boolean SHOW = true;
    boolean HIDE = false;

    /**
     * disable change orientation
     * parse layout elements
     * set howto visible
     * @param savedInstanceState ...
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /**
         * TODO save visible and hidden layouts, and put to intent
         */
        // setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_NOSENSOR);
        setContentView(R.layout.activity_main);

        Log.v("MainActivity", "onCreate");
        mainScrollView = (ScrollView) findViewById(R.id.scrollView);
        howtoLayout = (LinearLayout) findViewById(R.id.howto);
        questionLayout = (LinearLayout) findViewById(R.id.questions);
        submitLayout = (LinearLayout) findViewById(R.id.submit);
        againLayout = (LinearLayout) findViewById(R.id.again);

        solution1 = (TextView) findViewById(R.id.solution_q1);
        solution2 = (TextView) findViewById(R.id.solution_q2);
        solution3 = (TextView) findViewById(R.id.solution_q3);
        solution1image = (ImageView) findViewById(R.id.solution_q1_image);


        toggleSolution(howtoLayout,    SHOW);
        toggleSolution(questionLayout, HIDE);
        toggleSolution(submitLayout,   HIDE);
        toggleSolution(againLayout,    HIDE);

        toggleSolution(solution1,      HIDE);
        toggleSolution(solution2,      HIDE);
        toggleSolution(solution3,      HIDE);
        toggleSolution(solution1image, HIDE);
    }

    /**
     * show or hide view
     * @param view view name to show or hide
     * @param visibility boolean to set state
     */
    public void toggleSolution(View view, boolean visibility) {
        if (visibility) { view.setVisibility(View.VISIBLE); }
        else { view.setVisibility(View.GONE); }
    }

    /**
     * If next button pressed
     * set questions visible
     * @param view caller button
     */
    public void nextButton(View view) {
        Log.v("MainActivity", "nextButton clicked");
        toggleSolution(howtoLayout,      HIDE);
        toggleSolution(questionLayout,   SHOW);
        toggleSolution(submitLayout,     SHOW);
        toggleSolution(againLayout,      HIDE);
    }

    /**
     * If submit button pressed
     * disable buttons
     * set color to answers
     * count points
     * display points
     * set solution text visible
     * @param view caller button
     */
    public void submitAnswers(View view) {
        Log.v("MainActivity", "submitAnswers clicked");

        boolean answerIsSelected;

        // radioButtons question 1
        RadioGroup radioGroup1= (RadioGroup) findViewById(R.id.radiogroup_q1);
        int selectedRadio = radioGroup1.getCheckedRadioButtonId();
        View radioButton = radioGroup1.findViewById(selectedRadio);
        int idx = radioGroup1.indexOfChild(radioButton);
        Log.v("MainActivity","radio checked idx: " +  idx);

        if (idx+1 == goodAnswers1) {
            correct1 = true;
        }
        else {
            correct1 = false;
        }
        Log.v("MainActivity","correct: " + correct1);

        for (int an = 1; an <= 3; an++) {
            String radioName = "radio_q1_a" + an;
            Log.v("MainActivity","button: " + radioName);

            int rId = getResources().getIdentifier(radioName, "id", getPackageName());
            Button button = (RadioButton) findViewById(rId);
            button.setEnabled(false);

            if (correct1) {
                // correct ans
                if (an == idx+1) {
                    Log.v("MainActivity","goodAnsColor");
                    button.setBackgroundColor(ContextCompat.getColor(this, R.color.answerGreen));
                    points +=1;
                }
            }
            else {
                // wrong ans
                if (an == idx+1) {
                    Log.v("MainActivity","badAnsColor");
                    button.setBackgroundColor(ContextCompat.getColor(this, R.color.answerRed));
                }
                if (an == goodAnswers1) {
                    Log.v("MainActivity","goodAnsColor");
                    button.setBackgroundColor(ContextCompat.getColor(this, R.color.answerGreen));
                }
            }
            Log.v("MainActivity","rId: " + an);
        }

        // radioButtons question 2
        RadioGroup radioGroup2 = (RadioGroup) findViewById(R.id.radiogroup_q2);
        int selectedRadio2 = radioGroup2.getCheckedRadioButtonId();
        View radioButton2 = radioGroup2.findViewById(selectedRadio2);
        int idx2 = radioGroup2.indexOfChild(radioButton2);
        Log.v("MainActivity","radio2 checked idx: " +  idx2);

        if (idx2+1 == goodAnswers2) {
            correct2 = true;
        }
        else {
            correct2 = false;
        }
        Log.v("MainActivity","correct: " + correct2);

        for (int an = 1; an <= 3; an++) {
            String radioName = "radio_q2_a" + an;
            Log.v("MainActivity","button: " + radioName);

            int rId = getResources().getIdentifier(radioName, "id", getPackageName());
            Button button = (RadioButton) findViewById(rId);
            button.setEnabled(false);

            if (correct2) {
                // correct ans
                if (an == idx2+1) {
                    Log.v("MainActivity","goodAnsColor");
                    button.setBackgroundColor(ContextCompat.getColor(this, R.color.answerGreen));
                    points +=1;
                }
            }
            else {
                // wrong ans
                if (an == idx2+1) {
                    Log.v("MainActivity","badAnsColor");
                    button.setBackgroundColor(ContextCompat.getColor(this, R.color.answerRed));
                }
                if (an == goodAnswers2) {
                    Log.v("MainActivity","goodAnsColor");
                    button.setBackgroundColor(ContextCompat.getColor(this, R.color.answerGreen));
                }
            }
            Log.v("MainActivity","rId: " + an);
        }

        // checkBoxes question 3
        Log.v("MainActivity","correct3: " + correct3);
        for (int an = 1; an <= 4; an++) {
            String checkboxName = "checkbox_q3_a" + an;
            Log.v("MainActivity","checkbox: " + checkboxName + " " + (an-1));

            int rId = getResources().getIdentifier(checkboxName, "id", getPackageName());
            CheckBox checkBox = (CheckBox) findViewById(rId);

            checkBox.setEnabled(false);

            Log.v("MainActivity","checkbox checked: " + checkBox.isChecked());
            Log.v("MainActivity","goodAnswers3: " + goodAnswers3[an-1]);
            // test correct answer
            answerIsSelected = checkBox.isChecked();
            if (goodAnswers3[an-1]) {
                Log.v("MainActivity","good opt");
                if  (!answerIsSelected) {
                    // good option not checked
                    Log.v("MainActivity","not sel");
                    correct3 = false;
                }
                // good option is allways green
                Log.v("MainActivity","goodAnsColor");
                checkBox.setBackgroundColor(ContextCompat.getColor(this, R.color.answerGreen));
            }
            else
            {
                Log.v("MainActivity","bad opt");
                // wrong option
                if (answerIsSelected) {
                    // wrong answer checked
                    Log.v("MainActivity","badAnsColor");
                    checkBox.setBackgroundColor(ContextCompat.getColor(this, R.color.answerRed));
                    correct3 = false;
                }
            }
            Log.v("MainActivity","correct3: " + correct3);

        }

        if (correct3) {
            points += 1;
        }

        // display result
        TextView text = (TextView) findViewById(R.id.again_text);
        String resString = getString(R.string.result_string, points );
        text.setText(String.valueOf(resString));

        toggleSolution(howtoLayout,    HIDE);
        toggleSolution(questionLayout, SHOW);
        toggleSolution(submitLayout,   HIDE);
        toggleSolution(againLayout,    SHOW);

        toggleSolution(solution1,      SHOW);
        toggleSolution(solution2,      SHOW);
        toggleSolution(solution3,      SHOW);
        toggleSolution(solution1image, SHOW);

        // scroll tot top of scrollView to see answers
        mainScrollView.scrollTo(0, mainScrollView.getTop());
    }

    /**
     * If again button pressed
     * set howto visible
     * clear all answers
     * hide points
     * hide solution text
     * @param view caller button
     */
    public void againButton(View view) {
        Log.v("MainActivity", "againButton clicked");

        // uncheck radioGroups
        for (int qu = 1; qu <= 2; qu++) {
            String radioGroupName = "radiogroup_q" + qu;
            Log.v("MainActivity","radiogroup: " + radioGroupName);

            int rgId = getResources().getIdentifier(radioGroupName, "id", getPackageName());
            RadioGroup radioGroup = (RadioGroup) findViewById(rgId);
            radioGroup.clearCheck();

            // enable radio buttons in all radioGroups
            for (int an = 1; an <= 3; an++) {
                String buttonName = "radio_q" + qu + "_a" + an;
                Log.v("MainActivity","button: " + buttonName);

                int rId = getResources().getIdentifier(buttonName, "id", getPackageName());
                Button button = (Button) findViewById(rId);
                Log.v("MainActivity","defAnsColor");
                button.setBackgroundColor(ContextCompat.getColor(this, R.color.answerWhite));
                button.setEnabled(true);
            }
        }


        // enable checkboxes
        for (int an = 1; an <= 4; an++) {
            String checkboxName = "checkbox_q3_a" + an;
            Log.v("MainActivity","checkbox: " + checkboxName);

            int rId = getResources().getIdentifier(checkboxName, "id", getPackageName());
            CheckBox checkBox = (CheckBox) findViewById(rId);

            checkBox.setEnabled(true);
            checkBox.setChecked(false);
            Log.v("MainActivity","defAnsColor");
            checkBox.setBackgroundColor(ContextCompat.getColor(this, R.color.answerWhite));

        }

        correct1 = false;
        correct2 = false;
        correct3 = true;
        points = 0;

        toggleSolution(howtoLayout,    SHOW);
        toggleSolution(questionLayout, HIDE);
        toggleSolution(submitLayout,   HIDE);
        toggleSolution(againLayout,    HIDE);

        toggleSolution(solution1,      HIDE);
        toggleSolution(solution2,      HIDE);
        toggleSolution(solution3,      HIDE);
        toggleSolution(solution1image, HIDE);
    }

}
