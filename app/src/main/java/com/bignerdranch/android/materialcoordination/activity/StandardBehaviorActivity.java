package com.bignerdranch.android.materialcoordination.activity;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.bignerdranch.android.materialcoordination.R;
import com.bignerdranch.android.materialcoordination.adapter.SimpleAdapter;

public class StandardBehaviorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_standard_behavior);

        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.activity_standard_behavior_recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new SimpleAdapter(this));

        findViewById(R.id.activity_standard_behavior_fab).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View coordinatorLayout = findViewById(R.id.activity_standard_behavior_coordinatorlayout);
                Snackbar.make(coordinatorLayout, R.string.thanks_for_sharing, Snackbar.LENGTH_LONG).show();
            }
        });
    }

}
