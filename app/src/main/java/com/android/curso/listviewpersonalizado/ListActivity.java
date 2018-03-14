package com.android.curso.listviewpersonalizado;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ListActivity extends AppCompatActivity {

    private ListView listView;
    private List<String> names;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        listView = (ListView) findViewById(R.id.listView);
        names = new ArrayList<>();
        names.add("pepe");
        names.add("juan");
        names.add("eva");
        names.add("manolo");
        names.add("penelope");
        names.add("jimena");
        names.add("roberto");
        names.add("oscar");
        names.add("mario");
        names.add("Maria");
        names.add("Teresa");
        names.add("Carmen");
        names.add("Ivan");
        names.add("Gines");
        names.add("Iker");
        names.add("Aaron");
        names.add("Rino");
        names.add("Cristobal");
        names.add("Felicity");
        names.add("Anabel");
        final MyAdapter myAdapter = new MyAdapter(this, R.layout.list_item, names);
        listView.setAdapter(myAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                Toast.makeText(ListActivity.this, names.get(position) + myAdapter.getItemId(position), Toast.LENGTH_LONG).show();
                Toast.makeText(ListActivity.this,""+(position==id), Toast.LENGTH_LONG).show();

            }
        });


    }
}


