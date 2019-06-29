package com.yojeumgeosdeul.dong;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;


import net.daum.mf.map.api.MapView;


public class MapActivity extends BaseActivity {
    
  
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map112);
    
        MapView mapView = new MapView(this);
    
        ViewGroup mapViewContainer = (ViewGroup)findViewById(R.id.mapView);
        
        mapViewContainer.addView(mapView);
        
      
    }
    
   
    
    
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
                
            case R.id.btnMyPage:
                choice = "mypage";
                onClickBottomBar(choice);
                break;
        }
        
    }
    
    
}