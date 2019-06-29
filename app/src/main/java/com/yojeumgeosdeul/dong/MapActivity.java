package com.yojeumgeosdeul.dong;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.util.AttributeSet;
import android.view.View;
import com.google.android.gms.maps.*;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapActivity extends BaseActivity implements OnMapReadyCallback {
    
    private GoogleMap googleMap;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map112);
    
        SupportMapFragment mapFragment = (SupportMapFragment)getSupportFragmentManager().findFragmentById(R.id.map);
        
        mapFragment.getMapAsync(this);
        
    }
    
   
    
    @Override
    public void onMapReady(GoogleMap googleMap) {
        LatLng SEOUL = new LatLng(37.56, 126.97);
    
        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.position(SEOUL);
        markerOptions.title("서울");
        markerOptions.snippet("한국의 수도");
        googleMap.addMarker(markerOptions);
    
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(SEOUL));
        googleMap.animateCamera(CameraUpdateFactory.zoomTo(10));
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