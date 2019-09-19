package com.example.slide;


import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dacs.R;
import com.example.question.Question;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class ScreenSlidePageFragment extends Fragment {


    ArrayList<Question>arr_Ques;
    public  static final String ARG_PAGE="page";
    public  static final String ARG_CHECKANSWER="checkAnswer";
    private int mPageNumber; //Vi tri trang hien tai
    public int checkAns; //Bien kiem tra
    TextView txtNum,txtQuestion;
    RadioGroup radioGroup;
    RadioButton radA,radB,radC,radD;


    public ScreenSlidePageFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.fragment_screen_slide_page, container, false);

        txtNum=rootView.findViewById(R.id.txtNumAns);
        txtQuestion=rootView.findViewById(R.id.txtQuestion);
        radA=rootView.findViewById(R.id.radA);
        radB=rootView.findViewById(R.id.radB);
        radC=rootView.findViewById(R.id.radC);
        radD=rootView.findViewById(R.id.radD);
        radioGroup=rootView.findViewById(R.id.radGroup);
        return rootView;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        arr_Ques=new ArrayList<Question>();
        ScreenSlideActivity slideActivity= (ScreenSlideActivity) getActivity();
        arr_Ques=slideActivity.getData();
        mPageNumber=getArguments().getInt(ARG_PAGE);
        checkAns = getArguments().getInt(ARG_CHECKANSWER);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        txtNum.setText("Câu "+(mPageNumber+1));
        txtQuestion.setText(arr_Ques.get(mPageNumber).getQuestion());
        radA.setText(getItem(mPageNumber).getAns_a());
        radB.setText(getItem(mPageNumber).getAns_b());
        radC.setText(getItem(mPageNumber).getAns_c());
        radD.setText(getItem(mPageNumber).getAns_d());

        if(checkAns!=0){
            radA.setClickable(false);
            radB.setClickable(false);
            radC.setClickable(false);
            radD.setClickable(false);
            getCheckAns(getItem(mPageNumber).getResult().toString());
        }


        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
               // Toast.makeText(getActivity(),"This is ans "+checkedId,Toast.LENGTH_SHORT).show();
                getItem(mPageNumber).choiceID = checkedId;
                getItem(mPageNumber).setTraloi(getChoiceFromID(checkedId));
            }
        });
    }

    public Question getItem(int position){
        return arr_Ques.get(position);
    }

    //Lay gia tri (vi tri) radiogroup chuyen thanh dap an A/B/C/D

    private String getChoiceFromID(int ID){
        if (ID==R.id.radA){
            return "A";
        }else if (ID==R.id.radB){
            return "B";
        }else if (ID==R.id.radC){
            return "C";
        }else if (ID==R.id.radD){
            return "D";
        }else return "";
    }

    public static ScreenSlidePageFragment create(int pageNumber,int checkAnswer){
        ScreenSlidePageFragment fragment=new ScreenSlidePageFragment();
        Bundle args=new Bundle();
        args.putInt(ARG_PAGE,pageNumber);
        args.putInt(ARG_CHECKANSWER,checkAnswer);
        fragment.setArguments(args);
        return fragment;
    }

    //Ham kiem tra cau dung, neu cau dung thi doi mau background radioButton tuong ung


    private void getCheckAns(String ans){
        if (ans.equals("A")==true){
            radA.setBackgroundColor(Color.GREEN);
        }else if (ans.equals("B")==true){
            radB.setBackgroundColor(Color.GREEN);
        }else if (ans.equals("C")==true){
            radC.setBackgroundColor(Color.GREEN);
        }else if (ans.equals("D")==true){
            radD.setBackgroundColor(Color.GREEN);
        }
    }


}
