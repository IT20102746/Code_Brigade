package com.example.item;


import android.os.Bundle;
import android.view.View;

import com.example.item.ItemHelper;

import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

public class View_Additems extends AppCompatActivity {

    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_additems);
        mRecyclerView= (RecyclerView) findViewById(R.id.recyclerView_Item);


        new ItemHelper().readItems(new ItemHelper.DataStatus() {
            @Override
            public void DataIsLoaded(List<ItemModel> items, List<String> keys) {
                findViewById(R.id.Loading).setVisibility(View.GONE);
                new RecyclerView_config2().setConfig(mRecyclerView, com.example.item.View_Additems.this, items,keys);
            }

            @Override
            public void DataIsUpdated() {

            }

            @Override
            public void DataIsDeleted() {

            }
        });
    }
}
