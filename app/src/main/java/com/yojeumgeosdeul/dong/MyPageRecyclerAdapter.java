package com.yojeumgeosdeul.dong;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dinuscxj.progressbar.CircleProgressBar;

import java.util.List;

public class MyPageRecyclerAdapter extends RecyclerView.Adapter<MyPageRecyclerAdapter.ViewHolder> {

    private final List<MyPageFunding> mDataList;

    public MyPageRecyclerAdapter(List<MyPageFunding> mDataList) {
        this.mDataList = mDataList;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        TextView textPlace;
        TextView textGoal;
        TextView textFunding;
        TextView textMyFunding;
        TextView textPeople;
//        TextView textProgress;
        CircleProgressBar circleProgressBar;

        public ViewHolder(View view){
            super(view);
            textPlace = view.findViewById(R.id.textPlace);
            textGoal = view.findViewById(R.id.textGoal);
            textFunding = view.findViewById(R.id.textFunding);
            textMyFunding = view.findViewById(R.id.textMyFunding);
            textPeople = view.findViewById(R.id.textPeople);
//            textProgress = view.findViewById(R.id.textProgress);
            circleProgressBar = view.findViewById(R.id.circleprogressbar);
        }


    }

    @NonNull
    @Override
    public MyPageRecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_mypage_funding,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyPageRecyclerAdapter.ViewHolder viewHolder, int i) {
        MyPageFunding mypageFunding = mDataList.get(i);
        viewHolder.textFunding.setText(mypageFunding.getFunding());
//        viewHolder.textProgress.setText(mypageFunding.getProgress());
        viewHolder.textPeople.setText(mypageFunding.getPeople());
        viewHolder.textMyFunding.setText(mypageFunding.getMyFunding());
        viewHolder.textGoal.setText(mypageFunding.getGoal());
        viewHolder.textPlace.setText(mypageFunding.getPlace());
        viewHolder.circleProgressBar.getProgress();

    }

    @Override
    public int getItemCount() {
        return mDataList.size();
    }


}

