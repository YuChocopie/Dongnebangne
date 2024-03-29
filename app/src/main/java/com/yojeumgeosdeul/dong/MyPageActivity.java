package com.yojeumgeosdeul.dong;

import android.animation.ValueAnimator;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.TextView;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.dinuscxj.progressbar.CircleProgressBar;
import com.google.gson.Gson;


import java.util.ArrayList;
import java.util.List;

import static android.view.ViewTreeObserver.*;

public class MyPageActivity extends BaseActivity {
    
    private MyPageRecyclerAdapter adapter;

    private CircleProgressBar circleProgressBar;
    private View header;
    List<MyPageFunding> dataList = new ArrayList<>();
    RecyclerView recyclerView;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_page);
     /*
        String url = "https://dev-openapi.kbstar.com:8443/hackathon/getAccountBalance";
        StringRequest request = new StringRequest(
                Request.Method.GET,
                url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        processResponse(response);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
        
                    }
                }
        );
    
    */
      //  request.setShouldCache(false);
       // AppHelper.requestQueue.add(request);
        
        
        
        
        TextView textCustomer = (TextView) findViewById(R.id.textCustomer);
        TextView textCustomerContent = (TextView) findViewById(R.id.textCustomerContent);
        TextView textPresent = (TextView) findViewById(R.id.textPresent);
        TextView topText = (TextView) findViewById(R.id.topText);
        TextView topClick = (TextView) findViewById(R.id.topClick);
        TextView presentContent = (TextView) findViewById(R.id.presentContent);
        TextView textPlace = (TextView) findViewById(R.id.textPlace);
        ImageView imageQR = (ImageView) findViewById(R.id.imageQR);
        ConstraintLayout constraintLayout = (ConstraintLayout) findViewById(R.id.constraintLayout);
        
        textCustomer.setTypeface(null, Typeface.BOLD);
        
        textPresent.setTypeface(null, Typeface.BOLD);
        
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        
        
       
        
        
        int chk = 1;//사장일 경우 0, 고객일 경우 1
        if (chk == 0) {
    
            //click 사업자로 변경
            topText.setText("펀딩 글을 쓰려면 ");
            topText.setTextColor(getResources().getColor(R.color.MainBlue));
            topClick.setTextColor(getResources().getColor(R.color.MainBlue));
            
            //사장님 이미지 변경
            ImageView imageCustomer = (ImageView) findViewById(R.id.imageCustomer);
            imageCustomer.setImageResource(R.drawable.ic_char_2);
    
    
            //사업자 QR코드 숨기기
            imageQR.setVisibility(View.GONE);
            
            //사업자로 이름 변경 , 사업자 내용으로 변경
            textCustomer.setText("사 업 자");
            textCustomerContent.setText("사업자님 반가워요!\n펀딩을 받아볼 수 있어요!");
            
            
            //자산현황 숨기기
            textPresent.setVisibility(View.GONE);
            presentContent.setVisibility(View.GONE);
            
            //펀드작성
            topClick.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

    
                    Intent i = new Intent(getApplicationContext(), MyPageFundingMake.class);
                    startActivityForResult(i, 101);

                }
            });
            //백그라운드 색상변경
            constraintLayout.setBackgroundTintList(getResources().getColorStateList(R.color.MainBlue));
            
            //사업자일 경우(리사이클러뷰)
            dataList.add(new MyPageFunding("망원동에서 버블티가게", "목표금액 : 100,000,000원", "펀딩된 자산 : 10,000,000원",
                    "투자인원 : 2명", "진행률 : 10%", "", circleProgressBar));
            dataList.add(new MyPageFunding("가락시장에서 생선가게", "목표금액 : 200,000,000원", "펀딩된 자산 : 40,000,000원",
                    "투자인원 : 3명", "진행률 : 20%", "", circleProgressBar));
            dataList.add(new MyPageFunding("가로수길에서 악세사리가게", "목표금액 : 150,000,000원", "펀딩된 자산 : 100,000,000원",
                    "투자인원 : 2명", "진행률 : 67%", "", circleProgressBar));
            
         //   header = getLayoutInflater().inflate(R.layout.item_mypage_funding, null, false);
           // TextView textMyFunding = (TextView) header.findViewById(R.id.textMyFunding);
            //textMyFunding.setVisibility(View.GONE);
    
    
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
    
                    AlertDialog.Builder builder = new AlertDialog.Builder(MyPageActivity.this);
                    builder.setTitle("QR CODE를 인식해주세요");
                    builder.setView(R.layout.page_dialog);
                    
                    AlertDialog alertDialog = builder.create();
                    alertDialog.show();



                }
            });
            
            //백그라운드 색상 변경
            constraintLayout.setBackgroundTintList(getResources().getColorStateList(R.color.MainOrange));
            
            
            //고객일 경우(리사이클러뷰)
    
            dataList.add(new MyPageFunding("망원동에서 버블티가게", "목표금액 : 100,000,000원", "펀딩된 자산 : 10,000,000원", "내가 펀딩한 자산 : 5,000,000원",
                    "투자인원 : 2명", "진행률 : 10%", circleProgressBar));
            dataList.add(new MyPageFunding("가락시장에서 생선가게", "목표금액 : 200,000,000원", "펀딩된 자산 : 40,000,000원", "내가 펀딩한 자산 : 10,000,000원",
                    "투자인원 : 3명", "진행률 : 20%", circleProgressBar));
            dataList.add(new MyPageFunding("가로수길에서 악세사리가게", "목표금액 : 150,000,000원", "펀딩된 자산 : 100,000,000원", "내가 펀딩한 자산 : 50,000,000원",
                    "투자인원 : 2명", "진행률 : 67%", circleProgressBar));
    
            //맨위에 글자 clikc눌렀을 경우 -> 채팅으로
            topClick.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    
                    Intent i = new Intent(getApplicationContext(), ChattyActivity.class);
                    startActivity(i);
    
                }
            });
        }
        
        recyclerView = (RecyclerView)findViewById(R.id.recyclerView);
        
        recyclerView.setLayoutManager(layoutManager);
        adapter = new MyPageRecyclerAdapter(dataList);
        recyclerView.setAdapter(adapter);

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 101) {
            if (resultCode == RESULT_OK) {
                String name = data.getStringExtra("name");
                String location = data.getStringExtra("location");
                String goal = data.getStringExtra("goal");
                
                
                dataList.add(new MyPageFunding(location + "에서 " + name, "목표금액 : " + goal + "원", "펀딩된 자산 : 0원", "투자인원 : 0원", "진행률 : 0%",
                        "", circleProgressBar));
                recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
                RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
                recyclerView.setLayoutManager(layoutManager);
                adapter = new MyPageRecyclerAdapter(dataList);
                recyclerView.setAdapter(adapter);
            }
        }
    }

    /*
    public void processResponse(String response){
        Gson gson = new Gson();
        DataList dataList = gson.fromJson(response,DataList.class);
        Dataitem dataitem = gson.fromJson(response,Dataitem.class);


        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        TextView presentContent = (TextView)findViewById(R.id.presentContent);
        presentContent.setText(dataitem.계좌잔액);
        
    }

    */
    
    
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
/*
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
 
*/
    
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
