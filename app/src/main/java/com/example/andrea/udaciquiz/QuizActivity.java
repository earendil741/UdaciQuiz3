package com.example.andrea.udaciquiz;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class QuizActivity extends AppCompatActivity {

    int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        TextView text1 = (TextView)findViewById(R.id.name_box);
        text1.setText(getString(R.string.letgo)+" "+MainActivity.nickName);



        Button next =(Button)findViewById(R.id.next);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                RadioButton right1 = (RadioButton)findViewById(R.id.answer_1_3);
                boolean hasRight1 = right1.isChecked();

                RadioButton right2 = (RadioButton)findViewById(R.id.answer_2);
                boolean hasRight2 = right2.isChecked();
                boolean hasEdit = editRight(hasRight2);

                RadioButton right3 = (RadioButton)findViewById(R.id.answer_3_1);
                boolean hasRight3 = right3.isChecked();

                CheckBox right42 = (CheckBox)findViewById(R.id.answer_4_2);
                boolean hasRight42 = right42.isChecked();
                CheckBox right43 = (CheckBox)findViewById(R.id.answer_4_3);
                boolean hasRight43 = right43.isChecked();

                RadioButton right5 = (RadioButton)findViewById(R.id.answer_5_2);
                boolean hasRight5 = right5.isChecked();





                Intent iResult = new Intent(QuizActivity.this,Result.class);
                iResult.putExtra("result",calculateScore(hasRight1, hasRight2, hasEdit, hasRight3,hasRight42,hasRight43,hasRight5));
                startActivity(iResult);
            }
        });


    }


    boolean editRight (boolean hasRight2){

        EditText answerEdit = (EditText)findViewById(R.id.edit_quiz);
        if (hasRight2){
            if (answerEdit.getText().toString().equals("RelativeLayout")){
                return true;
            }else{
                return false;
            }
        }else{
            return false;
        }
    }

    public int calculateScore(boolean hasRight1,boolean hasRight2, boolean hasEdit, boolean hasRight3, boolean hasRight42, boolean hasRight43,boolean hasRight5){

        if (hasRight1){
            score = score + 2;
        }

        if (hasRight2){
            score = score + 1;
        }

        if (hasEdit){
            score = score + 1;
        }

        if (hasRight3){
            score = score + 2;
        }

        if (hasRight42){
            score = score + 1;
        }

        if (hasRight43){
            score = score +1;
        }

        if (hasRight5){
            score = score +2;
        }

        return score;
    }
}
