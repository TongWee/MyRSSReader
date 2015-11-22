package com.myrssreader.ui.Home;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.myrssreader.R;
import com.myrssreader.bean.FeedItem;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Tong on 2015/11/21.
 */
public class HomeAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<FeedItem> mDataset = new ArrayList<>();
    private Context context;

    public HomeAdapter(Context context) {
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder mViewHolder;
        View view = LayoutInflater.from(context).inflate(R.layout.list_home_item, parent, false);
        mViewHolder = new FeedViewHolder(view);
        return mViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        FeedItem feedItem = mDataset.get(position);
        FeedViewHolder feedViewHolder = (FeedViewHolder)holder;
        feedViewHolder._ListFeedDescription.setText(feedItem.getDescription());
        feedViewHolder._ListFeedTitle.setText(feedItem.getTitle());
    }

    @Override
    public int getItemCount() {
        int feedCount = mDataset.size();
        return feedCount;
    }

    public void addItems(List<FeedItem> feedItems){
        mDataset.addAll(getItemCount(),feedItems);
        notifyDataSetChanged();
    }

    public FeedItem getFeedItem(int position){
        return mDataset.get(position);
    }

    public void refreshItems(List<FeedItem> feedItems){
        mDataset.clear();
        mDataset.addAll(feedItems);
        notifyDataSetChanged();
    }
    /**
     * This class contains all butterknife-injected Views & Layouts from layout file 'list_home_item.xml'
     * for easy to all layout elements.
     *
     * @author ButterKnifeZelezny, plugin for Android Studio by Avast Developers (http://github.com/avast)
     */
    static class FeedViewHolder extends RecyclerView.ViewHolder{
        @Bind(R.id.list_feed_title)
        TextView _ListFeedTitle;
        @Bind(R.id.list_feed_description)
        TextView _ListFeedDescription;

        FeedViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
