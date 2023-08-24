package com.mycode.notemaker;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class BiswalAdapter extends RecyclerView.Adapter<BiswalAdapter.ViewHolder> {
    ArrayList<Notes> localDataSet;
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView textView1, textView2;
        public ViewHolder(View view) {
            super(view);
            textView1 = view.findViewById(R.id.textView1);
            textView2 = view.findViewById(R.id.textView2);
        }

        public TextView getTextView1() {
            return textView1;
        }
        public TextView getTextView2() {
            return textView2;
        }
    }

    public BiswalAdapter(ArrayList<Notes> dataSet) {
        localDataSet = dataSet;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.view_all_notes, viewGroup, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {

        viewHolder.getTextView1().setText(localDataSet.get(position).getTitle());
        viewHolder.getTextView2().setText(localDataSet.get(position).getNote());
    }

    @Override
    public int getItemCount() {
        return localDataSet.size();
    }
}
