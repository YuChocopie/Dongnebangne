package com.yojeumgeosdeul.dong;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

public class WebViewActivity extends BaseActivity {
private WebView daum_webView;
private TextView daum_result;
private Handler handler;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_web_view);
    daum_result = (TextView) findViewById(R.id.daum_result);
    // WebView 초기화
    init_webView();
    // 핸들러를 통한 JavaScript 이벤트 반응
    handler = new Handler();
    
}

@SuppressLint("SetJavaScriptEnabled")
public void init_webView() {
    daum_webView = (WebView) findViewById(R.id.daum_webview);
    daum_webView.getSettings().setJavaScriptEnabled(true);//자바스크립트 허용
    daum_webView.getSettings().setLoadWithOverviewMode(true);//컨텐츠가 웹뷰보다 클 경우 스크린 크기에 맞게 조정
    // WebView 설정
  //  daum_webView.getSettings().setDomStorageEnabled(true);
    daum_webView.getSettings().setSupportMultipleWindows(false);
    // JavaScript의 window.open 허용
    daum_webView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
    // JavaScript이벤트에 대응할 함수를 정의 한 클래스를 붙여줌
    daum_webView.addJavascriptInterface(new AndroidBridge(), "TestApp");
    // web client 를 chrome 으로 설정
    daum_webView.setWebChromeClient(new WebChromeClient());
    // webview url load. php 파일 주소
    daum_webView.loadUrl("https://YuChocopie.github" +
            ".io/Dongnebangne/app/src/main/java/com/yojeumgeosdeul/dong/assets/daum.html");
}

private class AndroidBridge {
    @JavascriptInterface
    public void setAddress(final String arg1, final String arg2, final String arg3) {
        handler.post(new Runnable() {
            @Override
            public void run() {
                daum_result.setText(String.format("(%s) %s %s", arg1, arg2, arg3));
                // WebView를 초기화 하지않으면 재사용할 수 없음
                init_webView();
            }
        });
    }
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

}