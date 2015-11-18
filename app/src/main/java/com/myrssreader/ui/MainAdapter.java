package com.myrssreader.ui;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.myrssreader.R;

/**
 * Created by Tong on 2015/11/18.
 */
public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {

    @Override
    public MainAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.main_list_item,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MainAdapter.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
    public static class ViewHolder extends RecyclerView.ViewHolder{
        private TextView tv_title;
        private TextView tv_content;
        public ViewHolder(View itemView){
            super(itemView);
            tv_title = (TextView)itemView.findViewById(R.id.tv_main_list_title);
            tv_content = (TextView)itemView.findViewById(R.id.tv_main_list_content);
        }
    }
}
