package com.yojeumgeosdeul.dong;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.dinuscxj.progressbar.CircleProgressBar;

import java.util.ArrayList;
import java.util.List;

public class MyPageActivity extends AppCompatActivity  {

    
    private MyPageRecyclerAdapter adapter;
    private static final String DEFAULT_PATTERN = "%d%%";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_page);


        CircleProgressBar circleProgressBar;
       // circleProgressBar.setMax(100);
       // int max = circleProgressBar.getProgress();
       // circleProgressBar.setProgress(70);
        circleProgressBar = (CircleProgressBar)findViewById(R.id.circleprogressbar);
        
        circleProgressBar.setProgressFormatter(new CircleProgressBar.ProgressFormatter() {
            @Override
            public CharSequence format(int progress, int max) {
                final String DEFAULT_PATTERN = "%d퍼센트";
                return String.format(DEFAULT_PATTERN, (int) ((float) progress / (float) max * 100));
            }
        });
        circleProgressBar.setProgressFormatter(null);
        circleProgressBar.setMax(100);
        circleProgressBar.setProgress(70);



       // circleProgressBar.setProgress(70);



        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.recyclerView);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        List<MyPageFunding> dataList = new ArrayList<>();

        dataList.add(new MyPageFunding("망원동에서 버블티가게","목표금액 : 200,000원","펀딩된 자산 : 10,000원","내가 펀딩한 자산 : 5,000원",
                "투자인원 : 10명", "진행률 : 10%",circleProgressBar));
        dataList.add(new MyPageFunding("가락시장에서 양념가게","목표금액 : 1,000,000원","펀딩된 자산 : 20,000원","내가 펀딩한 자산 : 1000원",
                "투자인원 : 20명","진행률 : 20%",circleProgressBar));

        adapter = new MyPageRecyclerAdapter(dataList);
        recyclerView.setAdapter(adapter);


    }



}