package com.example.ccm98.week2lab;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

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
                findViewById(R.id.flashcardQuestion).setVisibility(View.INVISIBLE);
                findViewById(R.id.flashcardAnswer).setVisibility(View.VISIBLE);
            }
        });

        findViewById(R.id.flashcardAnswer).setOnClickListener(new View.OnClickListener()
        {
           @Override
           public void onClick(View v)
           {
               findViewById(R.id.flashcardAnswer).setVisibility(View.INVISIBLE);
               findViewById(R.id.flashcardQuestion).setVisibility(View.VISIBLE);
           }
        });

        findViewById(R.id.plusButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AddCardActivity.class);
                MainActivity.this.startActivityForResult(intent, 1);
            }
        });

        findViewById(R.id.editButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AddCardActivity.class);
                String string1 = ((TextView)findViewById(R.id.flashcardQuestion)).getText().toString();
                String string2 = ((TextView)findViewById(R.id.flashcardAnswer)).getText().toString();
                intent.putExtra("string1", string1);
                intent.putExtra("string2", string2);
                MainActivity.this.startActivityForResult(intent, 2);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        if(resultCode == RESULT_OK)
        {
            //Snackbar.make(parentView, R.string.snackbar_text, Snackbar.LENGTH_SHORT);

            String string1 = data.getExtras().getString("string1");
            String string2 = data.getExtras().getString("string2");

            ((TextView)findViewById(R.id.flashcardQuestion)).setText(string1);
            ((TextView)findViewById(R.id.flashcardAnswer)).setText(string2);
        }
    }
}