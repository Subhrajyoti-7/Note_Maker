package com.mycode.notemaker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class Edit_screen extends AppCompatActivity {
    EditText title,note;
    ImageView save,menuBar;
    CardView yellow,pink,orange,purple,green,red;
    TextView countWord;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_screen);
        Innitialize();
    }
    private void Innitialize()
    {
        title = findViewById(R.id.title);
        note = findViewById(R.id.note);
        save = findViewById(R.id.save);
        menuBar = findViewById(R.id.menuBar);
        countWord = findViewById(R.id.countWord);
        yellow = findViewById(R.id.yellow);
        pink = findViewById(R.id.pink);
        orange = findViewById(R.id.orange);
        purple =  findViewById(R.id.purple);
        green = findViewById(R.id.green);
        red = findViewById(R.id.red);
    }
}