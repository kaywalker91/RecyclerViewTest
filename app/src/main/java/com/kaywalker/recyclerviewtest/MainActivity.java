package com.kaywalker.recyclerviewtest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.kaywalker.recyclerviewtest.Adapter.MenuAdapter;

public class MainActivity extends AppCompatActivity implements MenuAdapter.ItemClickListener {

    MenuAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] data = new String[100];
        for (int i=1; i <= 100; i++){
            data[i - 1] = "friend#"+i;
        }

        RecyclerView recyclerView =findViewById(R.id.rview);
        int columns = 4;
        recyclerView.setLayoutManager(new GridLayoutManager(this, columns));
        adapter = new MenuAdapter(this, data);
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);

    }

    public void onItemClick(View view, int position){
        Log.i("TAG","item: " + adapter.getItem(position) + "number: " + position);
    }
}