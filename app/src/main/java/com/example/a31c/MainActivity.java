package com.example.a31c;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    private TextView questionTextView;
    private Button answer1Button, answer2Button, answer3Button, answer4Button, submitButton;

    private ProgressBar progressBar;

    private TextView scoreTextView;

    private String[] questions = {"what is an apple?", "what is array", "what items does under armour sell", "number 4+4 is equal to?"};
    private String[][] answers = {{"fruit", "veggie", "chocolate", "all the above"},
            {"collection of similar items", "variable", "constant", "None of the above"},
            {"caps","foot wear", "gym wear", "All the above"},
            {"44", "8", "2", "6"}};
    private int[] correctAnswers = {0, 0, 3, 1};

    private int currentQuestion = 0;
    private int score = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        questionTextView = findViewById(R.id.question_text_view);
        answer1Button = findViewById(R.id.answer_1_button);
        answer2Button = findViewById(R.id.answer_2_button);
        answer3Button = findViewById(R.id.answer_3_button);
        answer4Button = findViewById(R.id.answer_4_button);
        submitButton = findViewById(R.id.submit_button);
        scoreTextView = findViewById(R.id.score_text_view);
        progressBar = findViewById(R.id.progressBar);

        progressBar.setMax(getResources().getInteger(R.integer.total_questions));

        showQuestion(currentQuestion);

        answer1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkAnswer(0);
            }
        });

    }

    private void showQuestion(int questionIndex) {
        questionTextView.setText(questions[questionIndex]);
        answer1Button.setText(answers[questionIndex][0]);
        answer2Button.setText(answers[questionIndex][1]);
        answer3Button.setText(answers[questionIndex][2]);
        answer4Button.setText(answers[questionIndex][3]);
    }

    private void checkAnswer(int answerIndex) {
        if (answerIndex == correctAnswers[currentQuestion]) {
            score++;
            scoreTextView.setText("Score: " + score);
        }
    }

    private void showScore() {
        String message = "Your score is " + score + " out of " + questions.length;
        Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
        finish();
    }
}
