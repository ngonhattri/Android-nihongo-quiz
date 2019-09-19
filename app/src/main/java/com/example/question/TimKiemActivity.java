package com.example.question;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.PopupMenu;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import com.example.dacs.R;

public class TimKiemActivity extends AppCompatActivity {

    ListView lvQuestion;
    QuestionController questionController;
    QuestionAdapter adapter;
    EditText edtSearch;
    ImageButton imgSubject;
    String level;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tim_kiem);
        this.getSupportActionBar().setTitle("Tìm Kiếm");
        addControls();
        addEvents();
    }

    private void addEvents() {
        edtSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                listCursor(questionController.getSearchQuestion(level,edtSearch.getText().toString()));
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        imgSubject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showMenu(v);
            }
        });
    }


    //Hiện thị icon trên popupMenu Field

    public static void setForceShowIcon(PopupMenu popupMenu) {
        try {
            Field[] fields = popupMenu.getClass().getDeclaredFields();
            for (Field field : fields) {
                if ("mPopup".equals(field.getName())) {
                    field.setAccessible(true);
                    Object menuPopupHelper = field.get(popupMenu);
                    Class<?> classPopupHelper = Class.forName(menuPopupHelper
                            .getClass().getName());
                    Method setForceIcons = classPopupHelper.getMethod(
                            "setForceShowIcon", boolean.class);
                    setForceIcons.invoke(menuPopupHelper, true);
                    break;
                }
            }
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }

    public void showMenu(View v){
        PopupMenu popupMenu = new PopupMenu(this,v);
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()){
                    case R.id.quesall:
                        level = "";
                        listCursor(questionController.getSearchQuestionByLevel(level));
                        break;
                    case R.id.n5:
                        level = "5";
                        listCursor(questionController.getSearchQuestionByLevel(level));
                        break;
                    case R.id.n4:
                        level = "4";
                        listCursor(questionController.getSearchQuestionByLevel(level));
                        break;
                    case R.id.n3:
                        level = "3";
                        listCursor(questionController.getSearchQuestionByLevel(level));
                        break;
                    case R.id.n2:
                        level = "2";
                        listCursor(questionController.getSearchQuestionByLevel(level));
                        break;
                    case R.id.n1:
                        level = "1";
                        listCursor(questionController.getSearchQuestionByLevel(level));
                        break;
                }
                return false;
            }
        });
        popupMenu.inflate(R.menu.menu_question);
        setForceShowIcon(popupMenu);
        popupMenu.show();
    }

    public void listCursor(Cursor cursor){
        adapter = new QuestionAdapter(this,cursor,true);
        lvQuestion.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    private void addControls() {
        lvQuestion = findViewById(R.id.lvQuestion);
        edtSearch = findViewById(R.id.edtSearch);
        questionController = new QuestionController(this);
        listCursor(questionController.getSearchQuestion(level,edtSearch.getText().toString()));
        imgSubject = findViewById(R.id.imgSubject);
    }

}
