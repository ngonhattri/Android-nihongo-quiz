package com.example.question;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class QuestionController {
    private DBHelper dbHelper;

   public QuestionController(Context context){
        dbHelper=new DBHelper(context);
    }

    //Lay danh sach cau hoi
    public ArrayList<Question>getQuestion(int exam, int level, String type){
        ArrayList<Question> listData= new ArrayList<Question>();
        SQLiteDatabase db= dbHelper.getReadableDatabase();
        Cursor cursor=db.rawQuery("Select * from tracnghiem where num_exam='"+exam+"' and level ='"+level+"' and type ='"+type+"'",null);
        cursor.moveToFirst();
        do {
            Question item;
            item = new Question(cursor.getInt(0),cursor.getString(1),cursor.getString(2),cursor.getString(3),cursor.getString(4),cursor.getString(5),cursor.getString(6),cursor.getString(7),cursor.getInt(8),cursor.getInt(9),cursor.getString(10),"");
            listData.add(item);
        }while (cursor.moveToNext());
        return listData;
    }

    //Lay ds cau hoi theo cau hoi
    public Cursor getSearchQuestion(String level,String key){
        SQLiteDatabase db= dbHelper.getReadableDatabase();
        Cursor cursor=db.rawQuery("Select * from tracnghiem where question Like '%"+key+"%' and level Like '%"+level+"%'",null);
        cursor.moveToFirst();
        if (cursor!=null){
            cursor.moveToFirst();
        }
        return cursor;
    }

    //Lay danh sach cau hoi theo level
    public Cursor getSearchQuestionByLevel(String key){
        SQLiteDatabase db= dbHelper.getReadableDatabase();
        Cursor cursor=db.rawQuery("Select * from tracnghiem where level Like '%"+key+"%'",null);
        cursor.moveToFirst();
        if (cursor!=null){
            cursor.moveToFirst();
        }
        return cursor;
    }
}
