package com.example.dacs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.question.DBHelper;
import com.example.question.TimKiemActivity;
import com.example.score.ScoreActivity;

import java.io.IOException;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private CardView n5Card, n4Card, n3Card, n2Card, n1Card, score_card;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.getSupportActionBar().setTitle("Ứng dụng luyện thi JLPT");
        addControls();
        addEvents();
        DBHelper db=new DBHelper(this);

       /* try{
            db.deleteDataBase();
            Toast.makeText(this,"delete success!",Toast.LENGTH_LONG).show();
        }catch (SQLException e){
            e.printStackTrace();
            Toast.makeText(this,"Fail...",Toast.LENGTH_LONG).show();
        }*/




        try {
            db.createDataBase();
        } catch (IOException e) {
            e.printStackTrace();
            Toast.makeText(this,"Copy db Thanh Cong...",Toast.LENGTH_LONG).show();
        }
    }

    private void addEvents() {
        n5Card.setOnClickListener(this);
        n4Card.setOnClickListener(this);
        n3Card.setOnClickListener(this);
        n2Card.setOnClickListener(this);
        n1Card.setOnClickListener(this);
        score_card.setOnClickListener(this);
    }

    private void addControls() {
        n5Card = (CardView) findViewById(R.id.n5_card);
        n4Card = (CardView) findViewById(R.id.n4_card);
        n3Card = (CardView) findViewById(R.id.n3_card);
        n2Card = (CardView) findViewById(R.id.n2_card);
        n1Card = (CardView) findViewById(R.id.n1_card);
        score_card = findViewById(R.id.score_card);

    }

    @Override
    public void onClick(View v) {
        Intent i;
         switch (v.getId()){
             case R.id.n5_card : i = new Intent(this,N5.class);startActivity(i); break;
             case R.id.n4_card : i = new Intent(this,N4Activity.class);startActivity(i); break;
             case R.id.n3_card : i = new Intent(this,N3Activity.class);startActivity(i); break;
             case R.id.n2_card : i = new Intent(this,N2Activity.class);startActivity(i); break;
             case R.id.n1_card : i = new Intent(this,N1Activity.class);startActivity(i); break;
             case R.id.score_card:    i = new Intent(this, ScoreActivity.class);startActivity(i); break;

                 //ScoreFragment scoreFragment = new ScoreFragment();
                 //FragmentManager manager= getSupportFragmentManager();
                 //manager.beginTransaction().replace(,scoreFragment,scoreFragment.getTag()).commit();
             //case R.id.score_card : i = new Intent(this, ScoreActivity.class);startActivity(i); break;

             default:break;
         }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menu_timkiem,menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.mnuTimkiem: Intent intent = new Intent(this,TimKiemActivity.class);
                startActivity(intent);
                default:return super.onOptionsItemSelected(item);
        }

    }
}
