package com.example.dacs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.Toast;

import com.example.model.Dethi;
import com.example.model.DethiAdapter;
import com.example.slide.ScreenSlideActivity;

import java.util.ArrayList;

public class N1Activity extends AppCompatActivity {
    TabHost tabHost;
    ListView lvExam,lvExamVua,lvExamKho;
    DethiAdapter dethiAdapter,dethivuaAdapter,dethikhoAdapter;
    ArrayList<Dethi> arr_exam=new ArrayList<Dethi>();
    ArrayList<Dethi> arr_examVua=new ArrayList<Dethi>();
    ArrayList<Dethi> arr_examKho=new ArrayList<Dethi>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_n5);
        this.getSupportActionBar().setTitle("Danh sách đề thi N1");
        addControls();
        addEvents();

    }



    private void addEvents() {
        tabHost.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            @Override
            public void onTabChanged(String tabId) {
                if (tabId.equals("t1"))
                {
                    Toast.makeText(N1Activity.this,"Bạn Chọn Bộ Đề Hán Tự",Toast.LENGTH_LONG).show();
                }
                else if(tabId.equals("t2"))
                {
                    Toast.makeText(N1Activity.this,"Bạn Chọn Bộ Đề Từ Vựng",Toast.LENGTH_LONG).show();
                }
                else if(tabId.equals("t3"))
                {
                    Toast.makeText(N1Activity.this,"Bạn Chọn Bộ Đề Ngữ Pháp",Toast.LENGTH_LONG).show();
                }
            }
        });
    }


    private void addControls() {
        tabHost=findViewById(R.id.tabhost);
        tabHost.setup();

        TabHost.TabSpec tab1=tabHost.newTabSpec("t1");
        tab1.setContent(R.id.tabDe);
        tab1.setIndicator("Hán Tự");
        tabHost.addTab(tab1);


        TabHost.TabSpec tab2=tabHost.newTabSpec("t2");
        tab2.setContent(R.id.tabVua);
        tab2.setIndicator("Từ Vựng");
        tabHost.addTab(tab2);

        TabHost.TabSpec tab3=tabHost.newTabSpec("t3");
        tab3.setContent(R.id.tabKho);
        tab3.setIndicator("Ngữ Pháp");
        tabHost.addTab(tab3);

        lvExam=findViewById(R.id.lvExam);
        arr_exam.add(new Dethi("Bài 1"));


        lvExamVua=findViewById(R.id.lvExamVua);
        arr_examVua.add(new Dethi("Bài 1"));



        lvExamKho=findViewById(R.id.lvExamKho);
        arr_examKho.add(new Dethi("Bài 1"));



        dethiAdapter= new DethiAdapter(N1Activity.this,arr_exam);
        lvExam.setAdapter(dethiAdapter);
        lvExam.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(N1Activity.this, ScreenSlideActivity.class);
                intent.putExtra("num_exam",position+1);
                intent.putExtra("level",1);
                intent.putExtra("type","kanji");
                intent.putExtra("test","yes");
                startActivity(intent);
            }
        });
        dethivuaAdapter= new DethiAdapter(N1Activity.this,arr_examVua);
        lvExamVua.setAdapter(dethivuaAdapter);
        lvExamVua.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(N1Activity.this, ScreenSlideActivity.class);
                intent.putExtra("num_exam",position+1);
                intent.putExtra("level",1);
                intent.putExtra("type","goi");
                intent.putExtra("test","yes");
                startActivity(intent);
            }
        });
        dethikhoAdapter= new DethiAdapter(N1Activity.this,arr_examKho);
        lvExamKho.setAdapter(dethikhoAdapter);
        lvExamKho.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(N1Activity.this, ScreenSlideActivity.class);
                intent.putExtra("num_exam",position+1);
                intent.putExtra("level",1);
                intent.putExtra("type","bunpou");
                intent.putExtra("test","yes");
                startActivity(intent);
            }
        });

    }
}
