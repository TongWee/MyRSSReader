package com.myrssreader.ui.Subscribe;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
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
public class SubscribeAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<FeedItem> mDataset = new ArrayList<>();
    private Context context;

    public SubscribeAdapter(Context context) {
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder mViewHolder;
        View view = LayoutInflater.from(context).inflate(R.layout.list_home_item, parent, false);
        mViewHolder = new ViewHolder(view);
        return mViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        FeedItem feedItem = mDataset.get(position);
        ViewHolder viewHolder = (ViewHolder)holder;

        if(feedItem.getDescription()!=null)
            viewHolder._ListFeedDescription.setText(Html.fromHtml(feedItem.getDescription()));
        if(feedItem.getTitle()!=null)
            viewHolder._ListFeedTitle.setText(Html.fromHtml(feedItem.getTitle()));
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
    static class ViewHolder extends RecyclerView.ViewHolder{
        @Bind(R.id.list_feed_title)
        TextView _ListFeedTitle;
        @Bind(R.id.list_feed_description)
        TextView _ListFeedDescription;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
