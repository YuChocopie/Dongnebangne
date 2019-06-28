package com.yojeumgeosdeul.dong;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

public class BaseActivity extends AppCompatActivity {
    
    public void onClickBottomBar(String name) {
        switch (name) {
            case "main":
                Intent intentMain = new Intent(BaseActivity.this, MainActivity.class);
                startActivity(intentMain);
                finishAffinity();
                break;
            case "map":
                Intent intentMap = new Intent(BaseActivity.this, MapActivity.class);
                startActivity(intentMap);
                finishAffinity();
                break;
            case "chatty":
                Intent intentChatty = new Intent(BaseActivity.this, ChattyActivity.class);
                startActivity(intentChatty);
                finishAffinity();
                break;
            case "mypage":
                Intent intentMypage = new Intent(BaseActivity.this, MyPageActivity.class);
                startActivity(intentMypage);
                finishAffinity();
                break;
        }
        
    }
}
