package com.example.jsonproject;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomCountryList extends BaseAdapter {

    Activity context;
    ArrayList <country>countries;

    public CustomCountryList(Activity context, ArrayList<country> countries) {
        this.context = context;
        this.countries = countries;
    }

    static class ViewHolder{

        TextView textviewId;
        TextView textViewCountry;

    }

    @Override
    public int getCount() {
       if(countries.size()<=0){
           return 1;
       }
       return countries.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View row=convertView;
        LayoutInflater inflater=context.getLayoutInflater();
        ViewHolder vh;

        if (convertView==null){

            vh=new ViewHolder();
            row=inflater.inflate(R.layout.rowi_tem,null,true);
            vh.textviewId=(TextView)row.findViewById(R.id.textviewID1);
            vh.textViewCountry=(TextView)row.findViewById(R.id.textviewID2);

            row.setTag(vh);

        }
        else {
            vh=(ViewHolder)convertView.getTag();

        }
        vh.textViewCountry.setText(countries.get(position).getName());
        vh.textviewId.setText(""+countries.get(position).getId());
        return row;
    }
}
