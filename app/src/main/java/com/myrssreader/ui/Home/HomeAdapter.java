package com.myrssreader.ui.Home;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.myrssreader.R;
import com.myrssreader.bean.FeedRespose;
import com.myrssreader.ui.OnItemClickListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import me.grantland.widget.AutofitTextView;

/**
 * Created by Tong on 2015/11/23.
 */
public class HomeAdapter extends RecyclerView.Adapter {
    private List<FeedRespose> mData = new ArrayList<>();
    private Context context;
    private OnItemClickListener onItemClickListener;

    public HomeAdapter(Context context) {
        this.context = context;
    }

    /**
     * 响应订阅频道点击操作
     *
     * @param onItemClickListener 回调函数
     */
    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ViewHolder mViewHolder;
        View view = LayoutInflater.from(context).inflate(R.layout.list_main_item, parent, false);
        mViewHolder = new ViewHolder(view);
        return mViewHolder;
    }

    public FeedRespose getFeedList(int position) {
        return mData.get(position);
    }

    /**
     * 数据与UI绑定
     *
     * @param holder   viewHolder
     * @param position 位置
     */
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {

        FeedRespose feedRespose = mData.get(position);
        ViewHolder viewHolder = (ViewHolder) holder;

        if (feedRespose.getTitle() == null)
            viewHolder._TvMainListTitle.setText("未命名");
        else
            viewHolder._TvMainListTitle.setText(feedRespose.getTitle());

        if (feedRespose.getDescription() == null || feedRespose.getDescription().equals(""))
            viewHolder._TvMainListDescription.setVisibility(View.GONE);
        else
            viewHolder._TvMainListDescription.setText(feedRespose.getDescription());

        if (onItemClickListener != null) {
            viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onItemClickListener.onItemClickListener(view, position, "homeFragment");
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public void addItems(List<FeedRespose> feedRespose) {
        mData.addAll(getItemCount(), feedRespose);
        notifyDataSetChanged();
    }

    public void addItem(FeedRespose feedRespose) {
        if (feedRespose != null) {
            mData.add(feedRespose);
            notifyDataSetChanged();
        }
    }

    /**
     * This class contains all butterknife-injected Views & Layouts from layout file 'list_main_item.xml'
     * for easy to all layout elements.
     *
     * @author ButterKnifeZelezny, plugin for Android Studio by Avast Developers (http://github.com/avast)
     */
    static class ViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.tv_main_list_title)
        AutofitTextView _TvMainListTitle;
        @Bind(R.id.tv_main_list_description)
        AutofitTextView _TvMainListDescription;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
