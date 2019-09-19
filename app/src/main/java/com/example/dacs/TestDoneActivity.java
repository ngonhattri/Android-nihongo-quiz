package com.example.dacs;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.question.Question;
import com.example.score.ScoreController;
import com.example.slide.ScreenSlideActivity;

import java.util.ArrayList;

public class TestDoneActivity extends AppCompatActivity {

    ArrayList<Question>arr_QuesBegin=new ArrayList<Question>();
    int numNoAns=0;
    int numTrue=0;
    int numFalse=0;
    int totalScore=0;

    ScoreController scoreController;

    TextView txtTrue,txtFalse,txtNoAns,txtTotalScore;
    Button btnSave,btnAgain,btnExit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_done);
        scoreController = new ScoreController(TestDoneActivity.this);
        this.getSupportActionBar().hide();
        Intent intent=getIntent();
        arr_QuesBegin= (ArrayList<Question>) intent.getExtras().getSerializable("arr_Ques");
        addControls();
        checkResult();
        totalScore=numTrue*10;
        txtNoAns.setText(""+numNoAns);
        txtTrue.setText(""+numTrue);
        txtFalse.setText(""+numFalse);
        txtTotalScore.setText(""+totalScore);

        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder=new AlertDialog.Builder(TestDoneActivity.this);
                builder.setIcon(R.drawable.exit);
                builder.setTitle("Thông Báo");
                builder.setMessage("Bạn có muốn thoát hay không???");
                builder.setPositiveButton("Có", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                });
                builder.setNegativeButton("Không", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });

                builder.show();
            }
        });

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(TestDoneActivity.this);
                LayoutInflater inflater=TestDoneActivity.this.getLayoutInflater();
                View view=inflater.inflate(R.layout.alert_dialog_save_score,null);
                builder.setView(view);

                final EditText edtName=view.findViewById(R.id.edtName);

                TextView txtScore =view.findViewById(R.id.txtScore);
                final int numTotal =numTrue*10;
                txtScore.setText(numTotal+" Điểm");


                builder.setPositiveButton("Lưu", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String name = edtName.getText().toString();


                        scoreController.insertScore(name,numTotal,name);
                        Toast.makeText(TestDoneActivity.this,"Lưu điểm thành công!",Toast.LENGTH_LONG).show();
                        finish();
                        dialog.dismiss();
                    }
                });
                builder.setNegativeButton("Đóng", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                AlertDialog b =builder.create();
                b.show();

            }
        });

        btnAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                refresh();
                finish();
                Intent intent1= new Intent(TestDoneActivity.this, ScreenSlideActivity.class);
                intent1.putExtra("arr_Ques",arr_QuesBegin);
                intent1.putExtra("test","no");
                startActivity(intent1);
            }
        });
    }

    public void refresh(){
        for (int i=0;i<arr_QuesBegin.size();i++)
        {
            arr_QuesBegin.get(i).setTraloi("");
        }
    }


    private void addControls() {
        txtTrue=findViewById(R.id.txtTrue);
        txtFalse=findViewById(R.id.txtWrong);
        txtNoAns=findViewById(R.id.txtNotAnswer);
        btnAgain=findViewById(R.id.btnAgain);
        btnExit=findViewById(R.id.btnExit);
        btnSave=findViewById(R.id.btnSaveScore);
        txtTotalScore=findViewById(R.id.txtTotalPoint);

    }


    //PT check ket qua
    public void checkResult(){
        for (int i=0;i<arr_QuesBegin.size();i++){
           if (arr_QuesBegin.get(i).getTraloi().equals("")==true){
               numNoAns++;
           }else if (arr_QuesBegin.get(i).getResult().equals(arr_QuesBegin.get(i).getTraloi())==true){
               numTrue++;
           }else numFalse++;

        }
    }

}
