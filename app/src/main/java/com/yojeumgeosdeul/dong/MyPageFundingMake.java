package com.yojeumgeosdeul.dong;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MyPageFundingMake extends AppCompatActivity {
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_page_funding_make);
    
       
        TextView textSending = (TextView)findViewById(R.id.textSending);
        
        
        
        textSending.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                
                
                EditText editName = (EditText) findViewById(R.id.editName);
                EditText editLoaction = (EditText)findViewById(R.id.editLocation);
                EditText editGoal = (EditText)findViewById(R.id.editGoal);
    
                String name = editName.getText().toString();
                String location = editLoaction.getText().toString();
                String goal = editGoal.getText().toString();
                
                Intent intent = new Intent();
                intent.putExtra("name",name);
                intent.putExtra("location",location);
                intent.putExtra("goal",goal);
                setResult(Activity.RESULT_OK, intent);
    
                finish();
            }
        });
        
        
        
    }
}
