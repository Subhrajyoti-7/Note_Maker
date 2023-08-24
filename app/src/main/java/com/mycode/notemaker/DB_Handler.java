package com.mycode.notemaker;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

public class DB_Handler extends SQLiteOpenHelper {
    private final String TABLE_NAME = "my_notes";
    public DB_Handler(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String create = "CREATE TABLE " + TABLE_NAME + "(slNo int PRIMARY KEY, title TEXT , note TEXT)";
        db.execSQL(create);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String drop = "DROP TABLE IF EXIST " + db;
        db.execSQL(drop, new String[]{"my_notes"});
    }

    public void addNotes(Notes notes){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("slNo", notes.getSlNo());
        values.put("title", notes.getTitle());
        values.put("note", notes.getNote());
        db.insert("my_notes", null, values);
        db.close();
    }

    public List<Notes> getNotes(){
        List<Notes> allNotes = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        String select = "SELECT * FROM " + TABLE_NAME;
        @SuppressLint("Recycle") Cursor cursor = db.rawQuery(select, null);
        if(cursor != null && cursor.moveToFirst()){
            do{
                Notes notes = new Notes();
                notes.setTitle(cursor.getString(1));
                notes.setNote(cursor.getString(2));
                allNotes.add(notes);
            }while (cursor.moveToNext());
        }
        return allNotes;
    }

    public void deleteNote(int index){
        SQLiteDatabase db = this.getWritableDatabase();
        String delete = "DELETE FROM " + TABLE_NAME + " WHERE slNo = " + index;
        db.execSQL(delete);
    }
}
