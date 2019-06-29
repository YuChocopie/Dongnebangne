package com.yojeumgeosdeul.dong;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;


import net.daum.mf.map.api.MapPOIItem;
import net.daum.mf.map.api.MapPoint;
import net.daum.mf.map.api.MapView;


public class MapActivity extends BaseActivity {
    
  
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map112);
    
        MapView mapView = new MapView(this);
    
        ViewGroup mapViewContainer = (ViewGroup)findViewById(R.id.mapView);
    
        mapViewContainer.addView(mapView);
        
        MapPOIItem marker = new MapPOIItem();
        marker.setItemName("핀테크 기술지원센터");
        marker.setTag(0);
        marker.setMapPoint(MapPoint.mapPointWithGeoCoord(37.494990,127.120382));
        marker.setMarkerType(MapPOIItem.MarkerType.BluePin); // 기본으로 제공하는 BluePin 마커 모양.
        marker.setSelectedMarkerType(MapPOIItem.MarkerType.RedPin); // 마커를 클릭했을때, 기본으로 제공하는 RedPin 마커 모양.
        
        MapPOIItem marker1 = new MapPOIItem();
        marker1.setItemName("가락시장역");
        marker1.setTag(1);
        marker1.setMapPoint(MapPoint.mapPointWithGeoCoord(37.492544, 127.118694));
        marker1.setMarkerType(MapPOIItem.MarkerType.RedPin);
        marker1.setSelectedMarkerType(MapPOIItem.MarkerType.RedPin);
    
        mapView.addPOIItem(marker);
        mapView.setMapCenterPoint(MapPoint.mapPointWithGeoCoord(37.494990, 127.120382), true);
    
    
    
        
        
      
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