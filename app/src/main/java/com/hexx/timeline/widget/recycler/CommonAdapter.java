package com.hexx.timeline.widget.recycler;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;

/**
 * Created by Hexx on 2018/12/20 11:53
 * Desc：通用adapter
 */
public abstract class CommonAdapter<D, H extends CommonAdapter.BaseHolder<D>>
        extends RecyclerView.Adapter<H> {

    private Context mContext;
    private List<D> mData;
    private H mHolder;

    public CommonAdapter(Context context) {
        mContext = context;
        mData = new ArrayList<>();
    }

    public abstract H getHolder(ViewGroup viewGroup);

    @NonNull
    @Override
    public H onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return mHolder = getHolder(viewGroup);
    }

    @Override
    public void onBindViewHolder(@NonNull H holder, int i) {
        holder.bindData(mData.get(i));
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }


    public void add(List<D> data) {
        int lastPosition = mData.size();
        mData.addAll(data);
        notifyItemRangeChanged(lastPosition, mData.size() - lastPosition);
    }

    public void add(D data) {
        int lastPosition = mData.size();
        mData.add(data);
        notifyItemRangeChanged(lastPosition, mData.size() - lastPosition);
    }

    public void remove(int index) {
        notifyItemRemoved(index);
        mData.remove(index);
    }

    public abstract static class BaseHolder<D> extends RecyclerView.ViewHolder {
        public BaseHolder(Context context, int ResId, ViewGroup viewGroup) {
            this(LayoutInflater.from(context).inflate(ResId, viewGroup, false));
        }

        private BaseHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public abstract void bindData(D data);
    }

}
