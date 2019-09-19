package com.example.score;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

import com.example.dacs.R;

public class ScoreAdapter extends CursorAdapter {
    public ScoreAdapter(Context context, Cursor c, boolean autoRequery) {
        super(context, c, autoRequery);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        View view= LayoutInflater.from(context).inflate(R.layout.item_list_score,parent,false);
        return view;
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView txtScore = view.findViewById(R.id.txtScore);
        TextView txtName = view.findViewById(R.id.txtNameStudent);

        txtName.setText(cursor.getString(1));
        txtScore.setText(cursor.getInt(2)+"");
    }
}
