package com.mycode.notemaker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    FloatingActionButton button;
    String data_base = "note_db";
    int index = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DB_Handler handler = new DB_Handler(this, data_base, null, 1);
        List<Notes> notes = handler.getNotes();
        handler.close();
        ArrayList <Notes> allNotes = new ArrayList<>(notes);

        recyclerView = findViewById(R.id.recyclerView);
        BiswalAdapter BA = new BiswalAdapter(allNotes);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(BA);
        Intent intent = new Intent(this, MainActivity2.class);


        button = findViewById(R.id.floatingActionButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("dataBaseName", data_base);
                startActivity(intent);
            }
        });
    }
}