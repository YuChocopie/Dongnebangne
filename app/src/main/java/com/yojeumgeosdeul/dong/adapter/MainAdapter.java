package com.yojeumgeosdeul.dong.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.yojeumgeosdeul.dong.BaseActivity;
import com.yojeumgeosdeul.dong.MainActivity;
import com.yojeumgeosdeul.dong.MainDetailActivity;
import com.yojeumgeosdeul.dong.R;
import com.yojeumgeosdeul.dong.model.MainList;

import java.net.URI;
import java.util.ArrayList;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {
    
    private ArrayList<MainList> mData = null;
    
    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView ivMainItem;
        TextView tvMainStore;
        TextView tvMainStoreDong;
        TextView tvGainPersent;
        TextView tvMainPersent;
        TextView tvTime;
        TextView tvLocation;
        View layout;
        
        ViewHolder(View itemView) {
            super(itemView);
            ivMainItem = itemView.findViewById(R.id.ivMainItem);
            tvMainStore = itemView.findViewById(R.id.tvMainStore);
            tvMainStoreDong = itemView.findViewById(R.id.tvMainStoreDong);
            tvGainPersent = itemView.findViewById(R.id.tvGainPersent);
            tvMainPersent = itemView.findViewById(R.id.tvMainPersent);
            tvTime = itemView.findViewById(R.id.tvTime);
            tvLocation = itemView.findViewById(R.id.tvLocation);
            layout = itemView.findViewById(R.id.item_recycler_main);
        }
        
    }
    
    public MainAdapter(ArrayList<MainList> list) {
        mData = list;
    }
    
    @Override
    public MainAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        
        View view = inflater.inflate(R.layout.item_main_recyclerview, parent, false);
        MainAdapter.ViewHolder vh = new MainAdapter.ViewHolder(view);
        
        return vh;
    }
  /*
    ivMainItem
            tvMainStore
    tvMainStoreDong
            tvGainPersent
    tvMainPersent
            tvTime
    tvLocation
    */
    
    @Override
    public void onBindViewHolder(MainAdapter.ViewHolder holder, final int position) {
//        holder.ivMainItem.setImageURI(Uri.parse(mData.get(position).getIvMainItem()));
        holder.tvMainStore.setText(mData.get(position).getTvMainStore());
        holder.tvMainStoreDong.setText(mData.get(position).getTvMainStoreDong());
        holder.tvGainPersent.setText(mData.get(position).getTvGainPersent());
        holder.tvMainPersent.setText(mData.get(position).getTvMainPersent());
        holder.tvTime.setText(mData.get(position).getTvTime());
        holder.tvLocation.setText(mData.get(position).getTvLocation());
        holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View holder) {
                Intent intent = new Intent(holder.getContext(), MainDetailActivity.class);
                holder.getContext().startActivities(new Intent[]{intent});
            }
        });
    }
    
    @Override
    public int getItemCount() {
        return mData.size();
    }
}
