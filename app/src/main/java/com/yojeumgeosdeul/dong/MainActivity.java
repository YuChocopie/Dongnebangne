package com.yojeumgeosdeul.dong;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.View;
import android.widget.EditText;
import com.yojeumgeosdeul.dong.adapter.MainAdapter;
import com.yojeumgeosdeul.dong.model.MainList;

import java.util.ArrayList;

public class MainActivity extends BaseActivity {
    private static final int SEARCH_ADDRESS_ACTIVITY = 10000;
    
    private EditText et_address;
    
    ArrayList<MainList> list = new ArrayList<MainList>();
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MainList mainList = new MainList("@drawable/excafe", "사뿐사뿐", "망원동 ", "수익율 : 8.3%",
                "달성률 : 40%", "10일 20시간 남음", "장소 : 서울특별시 강남구 역삼동 테헤란로 142");
        MainList mainList1 = new MainList("@drawable/excafe","아메리카노장인","가락동","수익율 : 4.2%",
                "달성률 : 12%","3일 1시간 남음","장소 : 서울특별시 가락시장로 12-4");
        MainList mainList2 = new MainList("@drawable/excafe","빚은","신사동","수익율 : 5.5%",
                "달성률 : 54%","12일 17시간 남음","서울특별시 신사로 127");
        MainList mainList3 = new MainList("@drawable/excafe","블링블링","문래동","수익율 : 2.9%",
                "달서률 : 77%","1일 23시간 남음","서울특별시 문래로 9");
        MainList mainList4 = new MainList("@drawable/excafe","건강한 의자","청담동","수익율 : 6.0%",
                "달성률 : 81%","14일 9시간 남음","서울특별시 청담로 88-43");
        
        list.add(mainList);
        list.add(mainList1);
        list.add(mainList2);
        list.add(mainList3);
        list.add(mainList4);
        
        
        
        // 리사이클러뷰에 LinearLayoutManager 객체 지정.
        RecyclerView recyclerView = findViewById(R.id.rvMain);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        
        // 리사이클러뷰에 SimpleTextAdapter 객체 지정.
        MainAdapter adapter = new MainAdapter(list);
        recyclerView.setAdapter(adapter);
        View item_recycler_main = findViewById(R.id.item_recycler_main);
    
    }
    
    public void btnClick(View view) {
        String choice = "";
        switch (view.getId()) {
            case R.id.btnChatty:
                choice = "chatty";
                onClickBottomBar(choice);
                break;
            
            case R.id.btnMap:
                choice = "map";
                onClickBottomBar(choice);
                break;
            
            case R.id.btnMyPage:
                choice = "mypage";
                onClickBottomBar(choice);
                break;
        }
        
    }
    
    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        
        super.onActivityResult(requestCode, resultCode, intent);
        
        switch (requestCode) {
            
            case SEARCH_ADDRESS_ACTIVITY:
                
                if (resultCode == RESULT_OK) {
                    
                    String data = intent.getExtras().getString("data");
                    if (data != null)
                        et_address.setText(data);
                    
                }
                break;
        }
    }
}