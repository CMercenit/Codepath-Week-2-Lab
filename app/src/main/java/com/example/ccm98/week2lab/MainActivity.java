package com.example.ccm98.week2lab;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.flashcardQuestion).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                findViewById(R.id.flashcardAnswer).setVisibility(View.VISIBLE);
                findViewById(R.id.flashcardQuestion).setVisibility(View.INVISIBLE);
            }
        });
    }
}
