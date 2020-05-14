package com.example.recyclerview;

import androidx.recyclerview.widget.RecyclerView;
import java.io.IOException;
import java.util.ArrayList;
import android.os.AsyncTask;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class MainActivity extends AppCompatActivity {
    private RecyclerAdapter adapter;
    private RecyclerView recyclerView;
    public ArrayList<String> list = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new Async().execute();
        recyclerView = (RecyclerView) findViewById(R.id.recycl);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new RecyclerAdapter(this, list);


    }

    public class Async extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String[] arg) {
            try {
                Elements images = Jsoup.connect("https://www.shutterstock.com/search/dawn").get().select("img");
                for (Element img : images) {
                    list.add(img.absUrl("src"));
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(String result) {
            recyclerView.setAdapter(adapter);
        }
    }
}
