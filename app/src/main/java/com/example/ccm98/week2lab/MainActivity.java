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
                        if(findViewById(R.id.flashcardQuestion).getVisibility() == View.VISIBLE)
                        {
                            findViewById(R.id.flashcardQuestion).setVisibility(View.INVISIBLE);
                            findViewById(R.id.flashcardAnswer).setVisibility(View.VISIBLE);
                        }
                        else
                        {
                            findViewById(R.id.flashcardQuestion).setVisibility(View.VISIBLE);
                            findViewById(R.id.flashcardAnswer).setVisibility(View.INVISIBLE);
                        }
                    }
        });

        findViewById(R.id.flashcardAnswer).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if(findViewById(R.id.flashcardAnswer).getVisibility() == View.VISIBLE)
                {
                    findViewById(R.id.flashcardQuestion).setVisibility(View.INVISIBLE);
                    findViewById(R.id.flashcardAnswer).setVisibility(View.VISIBLE);
                }
                else
                {
                    findViewById(R.id.flashcardQuestion).setVisibility(View.VISIBLE);
                    findViewById(R.id.flashcardAnswer).setVisibility(View.INVISIBLE);
                }
            }
        });
    }
}
