package com.example.ccm98.week2lab;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AddCardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_card);

        String question = getIntent().getStringExtra("string1");
        String answer = getIntent().getStringExtra("string2");

        if(question != null && answer != null)
        {
            ((EditText)findViewById(R.id.questionText)).setText(question);
            ((EditText)findViewById(R.id.answerText)).setText(answer);
        }

        findViewById(R.id.cancelButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        findViewById(R.id.saveButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String questionText;
                String answerText;

                questionText = ((EditText) findViewById(R.id.questionText)).getText().toString();
                answerText = ((EditText) findViewById(R.id.answerText)).getText().toString();

                if(!questionText.isEmpty() && !answerText.isEmpty())
                {
                    Intent data = new Intent();
                    data.putExtra("string1", questionText);
                    data.putExtra("string2", answerText);
                    setResult(RESULT_OK, data);
                    finish();
                }
                else
                {
                    Toast.makeText(getApplicationContext(), "Must enter both question and answer.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
