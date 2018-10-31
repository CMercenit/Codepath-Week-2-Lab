package com.example.ccm98.week2lab;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class AddCardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_card);

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

                Intent data = new Intent();
                data.putExtra("string1", questionText);
                data.putExtra("string2", answerText);
                setResult(RESULT_OK, data);
                finish();
            }
        });
    }
}
