package com.example.score;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.dacs.MainActivity;
import com.example.dacs.R;

public class ScoreActivity extends AppCompatActivity {

    ListView lvScore;
    ScoreController scoreController;
    ScoreAdapter scoreAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getSupportActionBar().hide();
        setContentView(R.layout.activity_score);
        scoreController= new ScoreController(this);
        lvScore= findViewById(R.id.lvScore);
        Cursor cursor=scoreController.getScore();
        scoreAdapter= new ScoreAdapter(this,cursor,true);
        lvScore.setAdapter(scoreAdapter);

    }
}
