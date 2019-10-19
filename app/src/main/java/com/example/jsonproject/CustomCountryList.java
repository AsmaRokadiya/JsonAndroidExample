package com.example.jsonproject;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;

public class CustomCountryList extends BaseAdapter {

    Activity context;
    ArrayList <country>countries;

    public CustomCountryList(Activity context, ArrayList<country> countries) {
        this.context = context;
        this.countries = countries;
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return null;
    }
}
