package com.bignerdranch.android.materialcoordination.activity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.bignerdranch.android.materialcoordination.R;
import com.bignerdranch.android.materialcoordination.adapter.SimpleAdapter;
import com.bignerdranch.android.materialcoordination.model.SimpleItem;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<SimpleItem> mItems = Arrays.asList(
            new SimpleItem("AppBarLayout", AppBarLayoutActivity.class, false),
            new SimpleItem("Collapsing Toolbar", CollapsingToolbarActivity.class, false),
            new SimpleItem("FAB Shrink Behavior", FabShrinkActivity.class, false),
            new SimpleItem("Bottom Toolbar", BottomToolbarActivity.class, true)
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

                if (simpleItem.isLollipopPlus() && Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
                    Toast.makeText(MainActivity.this, R.string.lollipop_plus_error, Toast.LENGTH_LONG).show();
                    return;
                }

                startActivity(new Intent(MainActivity.this, simpleItem.getClazz()));
            }
        }));
    }

}
