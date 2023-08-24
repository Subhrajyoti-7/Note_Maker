package com.mycode.notemaker;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity2 extends AppCompatActivity {
    EditText editText1, editText2;
    String title, note;
    Button button;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        editText1 = findViewById(R.id.enterTitle);
        editText2 = findViewById(R.id.enterNote);
        title = editText1.getText().toString();
        note = editText2.getText().toString();
        Notes inputNote = new Notes();
        inputNote.setTitle(title);
        inputNote.setNote(note);
        Intent intent = getIntent();
        String name = intent.getStringExtra("dataBaseName");

        DB_Handler handler = new DB_Handler(this, name, null, 1);

        button = findViewById(R.id.button);
        button.setOnClickListener(v -> {
            handler.addNotes(inputNote);
            handler.close();
            Intent intent1 = new Intent();
            startActivity(intent1);
        });
    }
}