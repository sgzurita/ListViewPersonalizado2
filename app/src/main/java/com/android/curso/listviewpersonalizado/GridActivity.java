package com.android.curso.listviewpersonalizado;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class GridActivity extends AppCompatActivity {

    private GridView gridView;
    private List<String> names;
    private int counter;
    private MyAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid);
        gridView = (GridView) findViewById(R.id.grid);
        names = new ArrayList<>();
        names.add("pepe");
        names.add("juan");
        names.add("eva");
        names.add("manolo");
        names.add("penelope");
        names.add("jimena");
        names.add("roberto");
        names.add("oscar");
      /*  names.add("mario");
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
        names.add("Anabel");*/
        myAdapter = new MyAdapter(this, R.layout.grid_item, names);

        registerForContextMenu(gridView);
        gridView.setAdapter(myAdapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                Toast.makeText(GridActivity.this, names.get(position) + myAdapter.getItemId(position), Toast.LENGTH_LONG).show();
                Toast.makeText(GridActivity.this,""+(position==id), Toast.LENGTH_LONG).show();

            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_action_bar, menu);
        return true;
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.add_item:
                this.names.add("added nº" + (++counter));
                myAdapter.notifyDataSetChanged();//refresca los datos del adapter
                return true;


            default:
                return super.onContextItemSelected(item);
        }


    }


    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();

        AdapterView.AdapterContextMenuInfo info=(AdapterView.AdapterContextMenuInfo)menuInfo;
        menu.setHeaderTitle(this.names.get(info.position));
        inflater.inflate(R.menu.context_menu, menu);



    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info=(AdapterView.AdapterContextMenuInfo)item.getMenuInfo();
        switch (item.getItemId()){
            case R.id.delete_item:
                this.names.remove(info.position);
                myAdapter.notifyDataSetChanged();
                return true;

            default:
                return super.onContextItemSelected(item);

        }


    }
}
