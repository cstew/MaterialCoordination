package com.bignerdranch.android.materialcoordination.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bignerdranch.android.materialcoordination.R;

import java.util.ArrayList;
import java.util.List;

public class SimpleAdapter extends RecyclerView.Adapter<SimpleAdapter.SimpleHolder> {

    private List<SimpleItem> mItems;
    private OnItemClickListener mOnItemClickListener;

    public interface OnItemClickListener {
        void onItemClicked(SimpleItem simpleItem);
    }

    public SimpleAdapter() {
        mItems = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            mItems.add(new SimpleItem("Item " + i));
        }
    }

    public SimpleAdapter(List<SimpleItem> items, OnItemClickListener onItemClickListener) {
        mItems = items;
        mOnItemClickListener = onItemClickListener;
    }

    @Override
    public SimpleHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        final SimpleHolder viewHolder = new SimpleHolder(inflater.inflate(R.layout.list_item, viewGroup, false));
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mOnItemClickListener == null) {
                    return;
                }

                mOnItemClickListener.onItemClicked(mItems.get(viewHolder.getAdapterPosition()));
            }
        });
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(SimpleHolder viewHolder, int i) {
        SimpleItem item = mItems.get(i);
        viewHolder.getTextView().setText(item.getName());
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    public static class SimpleHolder extends RecyclerView.ViewHolder {

        private TextView mTextView;

        public SimpleHolder(View itemView) {
            super(itemView);
            mTextView = (TextView) itemView.findViewById(android.R.id.text1);
        }

        public TextView getTextView() {
            return mTextView;
        }
    }
}
