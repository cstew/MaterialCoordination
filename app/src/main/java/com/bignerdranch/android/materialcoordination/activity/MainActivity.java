package com.bignerdranch.android.materialcoordination.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.bignerdranch.android.materialcoordination.R;
import com.bignerdranch.android.materialcoordination.adapter.SimpleAdapter;
import com.bignerdranch.android.materialcoordination.adapter.SimpleItem;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<SimpleItem> mItems = Arrays.asList(
            new SimpleItem("Normal Use", StandardBehaviorActivity.class),
            new SimpleItem("Shrinking FAB", ShrinkingFabActivity.class),
            new SimpleItem("Custom FAB Toolbar", FabToolbarCustomActivity.class)
    );

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.activity_main_recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new SimpleAdapter(mItems, new SimpleAdapter.OnItemClickListener() {
            @Override
            public void onItemClicked(SimpleItem simpleItem) {
                startActivity(new Intent(MainActivity.this, simpleItem.getClazz()));
            }
        }));
    }

}
