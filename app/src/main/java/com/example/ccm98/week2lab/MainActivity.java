package com.example.ccm98.week2lab;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity
{
    private FlashcardDatabase flashDatabase;
    private List<Flashcard> myFlashcards;
    private int myCurrentCard = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        flashDatabase = new FlashcardDatabase(getApplicationContext());
        myFlashcards = flashDatabase.getAllCards();

        if (myFlashcards != null && myFlashcards.size() > 0)
        {
            ((TextView) findViewById(R.id.flashcardQuestion)).setText(myFlashcards.get(0).getQuestion());
            ((TextView) findViewById(R.id.flashcardAnswer)).setText(myFlashcards.get(0).getAnswer());
        }
        else
        {
            ((TextView) findViewById(R.id.flashcardQuestion)).setText("Add a question!");
            ((TextView) findViewById(R.id.flashcardAnswer)).setText("Add a question!");
        }

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

        findViewById(R.id.nextButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(myFlashcards.size() > 0)
                {
                    myCurrentCard++;

                    if (myCurrentCard > (myFlashcards.size() - 1)) {
                        myCurrentCard = 0;
                    }

                    ((TextView) findViewById(R.id.flashcardQuestion)).setText(myFlashcards.get(myCurrentCard).getQuestion());
                    ((TextView) findViewById(R.id.flashcardAnswer)).setText(myFlashcards.get(myCurrentCard).getAnswer());

                    if (findViewById(R.id.flashcardAnswer).getVisibility() == View.VISIBLE) {
                        findViewById(R.id.flashcardAnswer).setVisibility(View.INVISIBLE);
                        findViewById(R.id.flashcardQuestion).setVisibility(View.VISIBLE);
                    }
                }
            }
        });

        findViewById(R.id.deleteDataButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flashDatabase.deleteCard(((TextView) findViewById(R.id.flashcardQuestion)).getText().toString());
                //System.out.println(((TextView) findViewById(R.id.flashcardQuestion)).getText().toString());
                myFlashcards = flashDatabase.getAllCards();
                if (myFlashcards == null || myFlashcards.size() == 0)
                {
                    ((TextView) findViewById(R.id.flashcardQuestion)).setText("Add a question!");
                    ((TextView) findViewById(R.id.flashcardAnswer)).setText("Add a question!");
                }
                else
                {
                    if(myCurrentCard > 0)
                    {
                        myCurrentCard--;
                    }
                    ((TextView) findViewById(R.id.flashcardQuestion)).setText(myFlashcards.get(myCurrentCard).getQuestion());
                    ((TextView) findViewById(R.id.flashcardAnswer)).setText(myFlashcards.get(myCurrentCard).getAnswer());

                    if(findViewById(R.id.flashcardAnswer).getVisibility() == View.VISIBLE)
                    {
                        findViewById(R.id.flashcardAnswer).setVisibility(View.INVISIBLE);
                        findViewById(R.id.flashcardQuestion).setVisibility(View.VISIBLE);
                    }
                }
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

            flashDatabase.insertCard(new Flashcard(string1, string2));
            myFlashcards = flashDatabase.getAllCards();
            myCurrentCard++;
        }
    }
}