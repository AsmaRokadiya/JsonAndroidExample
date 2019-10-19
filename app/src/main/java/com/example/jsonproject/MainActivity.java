package com.example.jsonproject;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    Button btnsubmit;
    String responseText;
    StringBuffer response;
    Activity activity;
    URL url;
    ArrayList<country>countries=new ArrayList<country>();
    ProgressDialog progressDialog;
    ListView listView;

    String path="https://api.myjson.com/bins/8rjnw";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnsubmit=(Button) findViewById(R.id.btn);
        listView=(ListView)findViewById(R.id.list1);
        btnsubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 countries.clear();
                 new GetData().execute();
            }
        });

    }
    class GetData extends AsyncTask{

        @Override
        protected void onPreExecute(){
            super.onPreExecute();
        }


            @Override
        protected Object doInBackground(Object[] objects) {
            return getWebservicecalls();
        }

        private Object getWebservicecalls() {
            try {

                url=new URL(path);
                HttpURLConnection connection=(HttpURLConnection)url.openConnection();
                connection.setRequestMethod("GET");
                int responsecode=connection.getResponseCode();
                if (responsecode == HttpURLConnection.HTTP_OK) {
                    BufferedReader in = new
                            BufferedReader(new InputStreamReader(connection.getInputStream()));
                    String output;

                    response = new StringBuffer();

                    while ((output = in.readLine()) != null) {

                        response.append(output);

                    }
                    in.close();


                }
            }
            catch (Exception e){e.printStackTrace();}
            responseText=response.toString();

            try {
                JSONArray jsonArray=new JSONArray(responseText);
                for (int i=0; i<jsonArray.length();i++){

                    JSONObject jsonObject=jsonArray.getJSONObject(i);
                    int id=jsonObject.getInt("id");
                    String country=jsonObject.getString("CountryName");
                    country countryobj=new country(country, id);
                    countries.add(countryobj);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Object o) {
            super.onPostExecute(o);
            CustomCountryList customCountryList=new CustomCountryList(activity,countries);
            listView.setAdapter(customCountryList);
        }


    }
}

