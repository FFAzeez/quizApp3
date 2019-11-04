package com.papey.quizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public Toast toast;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button) findViewById(R.id.btn_id);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String firstPart = radioMethod().toLowerCase();

                String secondPart = checkboxMethod();

                String thirdPart = checkboxMethod2();

                String fourPart = editTextMethod();

                String[] Answer = {firstPart,secondPart,thirdPart,fourPart};

                int result = answerChecker(Answer);

                resultChecker(result);

                EditText editText = findViewById(R.id.input_edit_text);
                editText.setText("");

                CheckBox checkBox = findViewById(R.id.check_a);
                checkBox.setChecked(false);

                checkBox = findViewById(R.id.check_b);
                checkBox.setChecked(false);

                checkBox = findViewById(R.id.check_c);
                checkBox.setChecked(false);

                checkBox = findViewById(R.id.check_d);
                checkBox.setChecked(false);

                CheckBox checkBox1 = findViewById(R.id.check_4a);
                checkBox1.setChecked(false);

                checkBox1 = findViewById(R.id.check_4b);
                checkBox1.setChecked(false);

                checkBox1 = findViewById(R.id.check_4c);
                checkBox1.setChecked(false);

                checkBox1 = findViewById(R.id.check_4d);
                checkBox1.setChecked(false);

                RadioGroup radioGroup = findViewById(R.id.radioGroup);
                radioGroup.clearCheck();
            }

        });
    }
    public void resultChecker(int result) {
        String message = result + " out of 4. ";

        if (result == 0) {
            message += "Poor result.";
        } else if (result == 1) {
            message += "Good result.";
        } else if (result == 2) {
            message += "Very good result.";
        } else if (result == 3) {
            message += "Nice result.";
        }else if (result == 4) {
            message += "Excellency result.";
        }

        Toast.makeText(getApplicationContext(), message,
                Toast.LENGTH_SHORT).show();
    }

    private int answerChecker(String[] answer) {
        int score=0;
        String[] correctAnswers = {"characteristics","true","true","hands"};
        for (int i = 0; i < correctAnswers.length; i++) {
            if (answer[i].equals(correctAnswers[i])) {
                score++;
            }
        }
        return score;
    }
    private String radioMethod(){
        RadioGroup radioGroupQuestion;
        RadioButton radioButtonAns;

        radioGroupQuestion = findViewById(R.id.radioGroup);

        int selectedId = radioGroupQuestion.getCheckedRadioButtonId();
        radioButtonAns = findViewById(selectedId);

        if(radioButtonAns==null){
            return "";
        }
        return (String)radioButtonAns.getText();
    }
    private String checkboxMethod(){
        CheckBox checkbox1 = (CheckBox)findViewById(R.id.check_a);
        boolean hasFirst = checkbox1.isChecked();
        CheckBox checkbox2 = (CheckBox)findViewById(R.id.check_b);
        boolean hasSecond = checkbox2.isChecked();
        CheckBox checkbox3 = (CheckBox)findViewById(R.id.check_c);
        boolean hasThird = checkbox3.isChecked();
        CheckBox checkbox4 = (CheckBox)findViewById(R.id.check_d);
        boolean hasFour = checkbox4.isChecked();
        boolean answerCheck = false;
        if(hasFirst==true && hasSecond==false && hasThird==true&& hasFour==false){
            answerCheck = true;
        }
        String result = Boolean.toString(answerCheck);
        return result;
    }
    private String checkboxMethod2(){
        CheckBox checkbox1a = (CheckBox)findViewById(R.id.check_4a);
        boolean hasFirst = checkbox1a.isChecked();
        CheckBox checkbox2a = (CheckBox)findViewById(R.id.check_4b);
        boolean hasSecond = checkbox2a.isChecked();
        CheckBox checkbox3a = (CheckBox)findViewById(R.id.check_4c);
        boolean hasThird = checkbox3a.isChecked();
        CheckBox checkbox4a = (CheckBox)findViewById(R.id.check_4d);
        boolean hasFour = checkbox4a.isChecked();
        boolean answerCheck = false;
        if(hasFirst==true && hasSecond==false && hasThird==true&& hasFour==false){
            answerCheck = true;
        }
        String result = Boolean.toString(answerCheck);
        return result;
    }
    private String editTextMethod(){
        EditText editText = (EditText) findViewById(R.id.input_edit_text);
        String result = editText.getText().toString().toLowerCase();
        return result;
    }
}
