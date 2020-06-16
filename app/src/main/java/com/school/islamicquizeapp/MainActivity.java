package com.school.islamicquizeapp;

import androidx.annotation.AnimatorRes;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.transition.Explode;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;
import com.school.islamicquizeapp.Question;
import com.school.islamicquizeapp.R;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    ArrayList<Question> questionsList = new ArrayList<Question>() ;
    Button nextBtn;
    TextView questionStatementTv , yourScoreTv , totalScoreTv;
    Button option1 , option2 , option3 , option4 , dialogBtnOk ;
    ProgressBar progressBar;
    LinearLayout scoreLayout ;

    int i = 1 , progress = 0 , rightOptionCounter = 0 , totalScore = 0;
    int listSize ;
    String selectedOptionCharacter = "" ;
    boolean check1 = true , check2 = false, check3 = false, check4 = false;


    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        questionsList.add(new Question("2 + 2 = ?"  , "4" , "3" , "2" ,"5" , "A"));
        questionsList.add(new Question("2 + 3 = ?"  , "2" , "5" , "4" ,"3" , "B"));
        questionsList.add(new Question("1 + 2 = ? "  , "2" , "4" , "3" ,"5" , "C"));
        questionsList.add(new Question("1 + 1 = ? "  , "5" , "4" , "3" ,"2" , "D"));
        questionsList.add(new Question("1 + 3 = ? "  , "4" , "5" , "3" ,"2" , "A"));
        questionsList.add(new Question("3 + 2 = ? "  , "4" , "5" , "3" ,"2" , "B"));
        questionsList.add(new Question("1 + 7 = ? "  , "4" , "3" , "8" ,"2" , "C"));
        questionsList.add(new Question("1 + 8 = ? "  , "4" , "5" , "2" ,"9" , "D"));


        listSize = questionsList.size();
        //Finding Views of controls\
//        dialogBtnOk = findViewById(R.id.dialogButtonOK);
        progressBar = findViewById(R.id.progressBar);
        nextBtn  = findViewById(R.id.nextBtnId);
        questionStatementTv = findViewById(R.id.questionStatementId);
        yourScoreTv = findViewById(R.id.yourScoreTvId);
        totalScoreTv = findViewById(R.id.totalScoreTvId);
//        optionsRadioGroup = findViewById(R.id.optionsRadioGroupId);
        option1 = findViewById(R.id.optionOneId);
        option1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                option1.setBackground(getResources().getDrawable(R.drawable.button_active_bg));
                option2.setBackground(getResources().getDrawable(R.drawable.button_in_active_bg));
                option3.setBackground(getResources().getDrawable(R.drawable.button_in_active_bg));
                option4.setBackground(getResources().getDrawable(R.drawable.button_in_active_bg));
                option3.setTextColor(getResources().getColor(R.color.black));
                option2.setTextColor(getResources().getColor(R.color.black));
                option1.setTextColor(getResources().getColor(R.color.offWhite));
                option4.setTextColor(getResources().getColor(R.color.black));

                check1 = true ;
                check2  = false ;
                check3 = false ;
                check4 = false ;

            }
        });
        option2 = findViewById(R.id.optionTwoId);
        option2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                option1.setBackground(getResources().getDrawable(R.drawable.button_in_active_bg));
                option2.setBackground(getResources().getDrawable(R.drawable.button_active_bg));
                option3.setBackground(getResources().getDrawable(R.drawable.button_in_active_bg));
                option4.setBackground(getResources().getDrawable(R.drawable.button_in_active_bg));
                option3.setTextColor(getResources().getColor(R.color.black));
                option2.setTextColor(getResources().getColor(R.color.offWhite));
                option1.setTextColor(getResources().getColor(R.color.black));
                option4.setTextColor(getResources().getColor(R.color.black));

                check1 = false;
                check2  = true ;
                check3 = false ;
                check4 = false ;

            }
        });
        option3 = findViewById(R.id.optionThreeId);
        option3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                option1.setBackground(getResources().getDrawable(R.drawable.button_in_active_bg));
                option2.setBackground(getResources().getDrawable(R.drawable.button_in_active_bg));
                option3.setBackground(getResources().getDrawable(R.drawable.button_active_bg));
                option4.setBackground(getResources().getDrawable(R.drawable.button_in_active_bg));

                option3.setTextColor(getResources().getColor(R.color.offWhite));
                option2.setTextColor(getResources().getColor(R.color.black));
                option1.setTextColor(getResources().getColor(R.color.black));
                option4.setTextColor(getResources().getColor(R.color.black));
                check1 = false ;
                check2  = false ;
                check3 = true ;
                check4 = false ;

            }
        });
        option4 = findViewById(R.id.optionFourId);
        option4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                option1.setBackground(getResources().getDrawable(R.drawable.button_in_active_bg));
                option2.setBackground(getResources().getDrawable(R.drawable.button_in_active_bg));
                option3.setBackground(getResources().getDrawable(R.drawable.button_in_active_bg));
                option4.setBackground(getResources().getDrawable(R.drawable.button_active_bg));

                option3.setTextColor(getResources().getColor(R.color.black));
                option2.setTextColor(getResources().getColor(R.color.black));
                option1.setTextColor(getResources().getColor(R.color.black));
                option4.setTextColor(getResources().getColor(R.color.offWhite));

                check1 = false ;
                check2  = false ;
                check3 = false ;
                check4 = true ;

            }

        });

        progressBar.setMax(listSize);
        totalScoreTv.setText(String.valueOf(listSize));

        questionStatementTv.setText(questionsList.get(0).questionStatement);
        option1.setText(option1.getText() + "  " + questionsList.get(0).optionOne);
        option2.setText(option2.getText() + "  " + questionsList.get(0).optionTwo);
        option3.setText(option3.getText() + "  " + questionsList.get(0).optionThree);
        option4.setText(option4.getText() + "  " + questionsList.get(0).optionFour);



        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    if(i <= listSize){
                        if(i == listSize){
                            i--;
                            questionStatementTv.setText(questionsList.get(i).questionStatement);
                            option1.setText( "A)  " + questionsList.get(i).optionOne);
                            option2.setText("B)  " + questionsList.get(i).optionTwo);
                            option3.setText("C)  " + questionsList.get(i).optionThree);
                            option4.setText("D)  " + questionsList.get(i).optionFour);
                            progressBar.setProgress(progress);
                            progress++;
                            i= i + 2;

                            Toast.makeText(MainActivity.this, "Quiz Completed", Toast.LENGTH_SHORT).show();
                            new AlertDialog.Builder(MainActivity.this)
                                    .setTitle("RESULT")
                                    .setMessage("Your Score : " + String.valueOf(++totalScore))
                                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
//                                            Toast.makeText(MainActivity.this, "OK Clicked", Toast.LENGTH_SHORT).show();
//                                            Intent toVideoTutorial = new Intent(MainActivity.this , VideoTutorial.class);
//                                            startActivity(toVideoTutorial);
//                                            finish();
                                        }
                                    })
                                    .setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
//                                            Toast.makeText(MainActivity.this, "CANCEL Clicked", Toast.LENGTH_SHORT).show();

                                        }
                                    })
                                    .create()
                                    .show();
                        }
                        else{
                            questionStatementTv.setText(questionsList.get(i).questionStatement);
                            option1.setText( "A)  " + questionsList.get(i).optionOne);
                            option2.setText("B)  " + questionsList.get(i).optionTwo);
                            option3.setText("C)  " + questionsList.get(i).optionThree);
                            option4.setText("D)  " + questionsList.get(i).optionFour);


                            progressBar.setProgress(progress);
                            progress++;
                            i++;
                        }


                        if(check1){
                            selectedOptionCharacter = "A";
//                            Toast.makeText(getApplicationContext(), "A", Toast.LENGTH_LONG).show();
                        }else if(check2){
                            selectedOptionCharacter = "B";
//                            Toast.makeText(getApplicationContext(), "B", Toast.LENGTH_LONG).show();
                        }else if(check3){
                            selectedOptionCharacter = "C";
//                            Toast.makeText(getApplicationContext(), "C", Toast.LENGTH_LONG).show();
                        }else if(check4){
                            selectedOptionCharacter = "D";
//                            Toast.makeText(getApplicationContext(), "D", Toast.LENGTH_LONG).show();
                        }else{
//                            Toast.makeText(getqAApplicationContext(), "Running", Toast.LENGTH_LONG).show();
                        }

                        Animation animation = AnimationUtils.loadAnimation(getApplicationContext() , R.anim.blink);
                        nextBtn.startAnimation(animation);
                    }
                    else{
                        Toast.makeText(MainActivity.this, "Quiz Completed !", Toast.LENGTH_SHORT).show();

                    }

                    String rightOption =questionsList.get(rightOptionCounter).rightOption;
                    String statement = questionsList.get(rightOptionCounter).questionStatement;

                    if(rightOption == selectedOptionCharacter){
                        totalScore++;
//                        rightOptionCounter++;
                    }
                    rightOptionCounter++;


                }catch (Exception ex){
//                    Toast.makeText(MainActivity.this, "Exception Occured : " + ex.getMessage(), Toast.LENGTH_SHORT).show();
                    Log.i("Caught : "  , ex.toString() );
                }
                yourScoreTv.setText(String.valueOf(totalScore));

                option1.setBackground(getResources().getDrawable(R.drawable.button_in_active_bg));
                option2.setBackground(getResources().getDrawable(R.drawable.button_in_active_bg));
                option3.setBackground(getResources().getDrawable(R.drawable.button_in_active_bg));
                option4.setBackground(getResources().getDrawable(R.drawable.button_in_active_bg));

                option3.setTextColor(getResources().getColor(R.color.black));
                option2.setTextColor(getResources().getColor(R.color.black));
                option1.setTextColor(getResources().getColor(R.color.black));
                option4.setTextColor(getResources().getColor(R.color.black));

                check1 = false ;
                check4 = false ;

                progressBar.setProgress(progress);
//                progress++;
//                i++;
//                Toast.makeText(MainActivity.this, "i = " + String.valueOf(i), Toast.LENGTH_SHORT).show();
            }
        });

//        dialogBtnOk.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                quizCompletedDialog.dismiss();
//            }
//        });
    }

    public void scoreLayoutClicked(View view) {

    }
}
