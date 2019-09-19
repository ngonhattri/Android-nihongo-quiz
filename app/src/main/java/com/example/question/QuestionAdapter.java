package com.example.question;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.dacs.R;

public class QuestionAdapter extends CursorAdapter {
    public QuestionAdapter(Context context, Cursor c, boolean autoRequery) {
        super(context, c, autoRequery);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        View view= LayoutInflater.from(context).inflate(R.layout.item_list_question,parent,false);
        return view;
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView txtQues = view.findViewById(R.id.txtQuestion);

        LinearLayout linQues= view.findViewById(R.id.linQues);
        if (cursor.getPosition()%2==0){
            linQues.setBackgroundColor(Color.parseColor("#EFDDB3"));
        }else linQues.setBackgroundColor(Color.parseColor("#EDF1F2"));

        txtQues.setText(cursor.getString(1));

    }
}
