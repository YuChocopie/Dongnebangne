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
        MainList mainlist = new MainList("dd", "", "dd", "dd", "dd", "dd", "dd");
        for (int i = 0; i < 5; i++) {
            list.add(mainlist);
        }
        
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