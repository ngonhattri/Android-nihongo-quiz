package com.example.model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dacs.R;

import java.util.ArrayList;

public class DethiAdapter extends ArrayAdapter<Dethi> {
    public DethiAdapter(Context context, ArrayList<Dethi> dethis) {
        super(context, 0,dethis);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView==null){
            LayoutInflater inflater=LayoutInflater.from(getContext());
            convertView=inflater.inflate(R.layout.item_exam,parent,false);
        }
        TextView txtName=convertView.findViewById(R.id.txtName);
        ImageView imgIcon=convertView.findViewById(R.id.imgIcon);

        Dethi p=getItem(position);
        if (p!=null){
            txtName.setText(""+p.getName());
            imgIcon.setImageResource(R.drawable.bellcon);
        }
        return convertView;
    }
}
