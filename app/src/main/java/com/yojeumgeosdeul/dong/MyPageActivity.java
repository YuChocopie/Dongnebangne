package com.yojeumgeosdeul.dong;

import android.animation.ValueAnimator;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.TextView;
import com.dinuscxj.progressbar.CircleProgressBar;

import java.util.ArrayList;
import java.util.List;

import static android.view.ViewTreeObserver.*;

public class MyPageActivity extends BaseActivity {
    
    
    private MyPageRecyclerAdapter adapter;
    //  private static final String DEFAULT_PATTERN = "%d%%";
    CircleProgressBar circleProgressBar;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_page);
        
        TextView textCustomer = (TextView) findViewById(R.id.textCustomer);
        TextView textCustomerContent = (TextView) findViewById(R.id.textCustomerContent);
        TextView textPresentFunding = (TextView) findViewById(R.id.textPresentFunding);
        TextView textPresent = (TextView) findViewById(R.id.textPresent);
        TextView topText = (TextView) findViewById(R.id.topText);
        TextView topClick = (TextView) findViewById(R.id.topClick);
        TextView presentContent = (TextView) findViewById(R.id.presentContent);
        TextView textPlace = (TextView) findViewById(R.id.textPlace);
        ImageView imageQR = (ImageView) findViewById(R.id.imageQR);
        ConstraintLayout constraintLayout = (ConstraintLayout) findViewById(R.id.constraintLayout);
        
        textCustomer.setTypeface(null, Typeface.BOLD);
        textPresent.setTypeface(null, Typeface.BOLD);
        textPresentFunding.setTypeface(null, Typeface.BOLD);
        // textPlace.setTypeface(null,Typeface.BOLD);
        
        
        //맨위에 글자 clikc눌렀을 경우
        topClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            
            }
        });
        
        
        int chk = 0;//사장일 경우 0, 고객일 경우 1
        if (chk == 1) {
            //click 사업자로 변경
            topText.setText("펀딩 글을 쓰려면 ");
            topText.setTextColor(getResources().getColor(R.color.MainBlue));
            topClick.setTextColor(getResources().getColor(R.color.MainBlue));
            textPresentFunding.setTextColor(getResources().getColor(R.color.MainBlue));
            
            //사업자 QR코드 숨기기
            imageQR.setVisibility(View.GONE);
            
            //사업자로 이름 변경 , 사업자 내용으로 변경
            textCustomer.setText("사 업 자");
            textCustomerContent.setText("사업자님 반가워요!\n펀딩을 받아볼 수 있어요!");
            
            
            //자산현황 숨기기
            textPresent.setVisibility(View.GONE);
            presentContent.setVisibility(View.GONE);
            topClick.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                
                }
            });
            
            //백그라운드 색상변경
            constraintLayout.setBackgroundTintList(getResources().getColorStateList(R.color.MainBlue));
        } else {
            //고객으로 이름 변경
            textCustomer.setText("고 객");
            textCustomerContent.setText("QR코드로 할인을 받아보세요!");
            
            
            //사업자 등록을 원하면 Click!
            topText.setText("사업자 등록을 원하면 ");
            topText.setTextColor(getResources().getColor(R.color.MainOrange));
            topClick.setTextColor(getResources().getColor(R.color.MainOrange));
            textPresentFunding.setTextColor(getResources().getColor(R.color.MainOrange));
            
            //내 자산현황 보여줌
            textPresent.setText("내 자산 현황");
            textPresent.setTextColor(getResources().getColor(R.color.MainOrange));
            presentContent.setVisibility(View.VISIBLE);
            //textPresentContent.setVisibility(View.VISIBLE);
            //고객 QR코드 보이기
            imageQR.setVisibility(View.VISIBLE);
            imageQR.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    
                    Intent intent = new Intent(String.valueOf(MyPagePopupActivity.class));
                    startActivity(intent);
                    
                    
                }
            });
            
            //백그라운드 색상 변경
            constraintLayout.setBackgroundTintList(getResources().getColorStateList(R.color.MainOrange));
        }
        
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        
        List<MyPageFunding> dataList = new ArrayList<>();
        
        dataList.add(new MyPageFunding("망원동에서 버블티가게", "목표금액 : 200,000원", "펀딩된 자산 : 10,000원", "내가 펀딩한 자산 : 5,000원",
                "투자인원 : 10명", "진행률 : 10%", circleProgressBar));
        dataList.add(new MyPageFunding("가락시장에서 양념가게", "목표금액 : 1,000,000원", "펀딩된 자산 : 20,000원", "내가 펀딩한 자산 : 1000원",
                "투자인원 : 20명", "진행률 : 20%", circleProgressBar));
        
        adapter = new MyPageRecyclerAdapter(dataList);
        recyclerView.setAdapter(adapter);
    }
    @Override
    protected void onResume() {
        super.onResume();
        if (circleProgressBar != null){
            circleProgressBar = findViewById(R.id.circleprogressbar);
            circleProgressBar.setProgressFormatter(new CircleProgressBar.ProgressFormatter() {
                @Override
                public CharSequence format(int progress, int max) {
                    final String DEFAULT_PATTERN = "%d퍼센트";
                    return String.format(DEFAULT_PATTERN, (int) ((float) progress / (float) max * 100));
                }
            });
            circleProgressBar.setMax(100);
            circleProgressBar.setProgress(70);
        }
    }


//    void callGraph() {
////        new ViewTreeObserver.OnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
////
////
////            circleProgressBar.setProgressFormatter((progress, max) -> {
////                final String DEFAULT_PATTERN = "%d퍼센트"; return String.format(DEFAULT_PATTERN
////                        , (int) ((float) progress / (float) max * 100)); });
////
//////            public void onGlobalLayout() {
//////                circleProgressBar.setProgress(70);
//////                circleProgressBar.setProgressFormatter(new CircleProgressBar.ProgressFormatter() {
//////                    @Override
//////                    public CharSequence format(int progress, int max) {
//////                        final String DEFAULT_PATTERN
//////                                = "%d퍼센트";
//////                        return String.format(DEFAULT_PATTERN, (int) ((float) progress / (float) max * 100));
//////                    }
//////                });
//////            }
////        }) {
////
////        };
////    }
/////*
//        circleProgressBar = (CircleProgressBar)findViewById(R.id.circleprogressbar);
//        circleProgressBar.setProgressFormatter(new CircleProgressBar.ProgressFormatter() {
//            @Override
//            public CharSequence format(int progress, int max) {
//                final String DEFAULT_PATTERN = "%d퍼센트";
//                return String.format(DEFAULT_PATTERN, (int) ((float) progress / (float) max * 100));
//            }
//        });
//        circleProgressBar.setMax(100);
//        circleProgressBar.setProgress(70);
//*/
//
    
    public void btnClick(View view) {
        String choice = "";
        switch (view.getId()) {
            case R.id.btnHome:
                choice = "main";
                onClickBottomBar(choice);
                break;
            
            case R.id.btnChatty:
                choice = "chatty";
                onClickBottomBar(choice);
                break;
            
            case R.id.btnMap:
                choice = "map";
                onClickBottomBar(choice);
                break;
        }
        
    }
    
}
