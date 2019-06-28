package com.yojeumgeosdeul.dong;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainDetailActivity extends AppCompatActivity {
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_detail);


//그래프에 들어갈 수치 배열
        double[] points = {5.0, 3.1, 2.7, 3.2, 4.1};
    
        GraphView graphview = findViewById(R.id.GraphView);

//단위는 1씩, 원점은 0, 총 10줄로 나누어진 그래프를 그린다
        graphview.setPoints(points, 1, 0, 10);
        graphview.drawForBeforeDrawView();
    }
}
