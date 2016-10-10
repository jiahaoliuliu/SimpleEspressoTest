package com.jiahaoliuliu.simpleespressotest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class SimpleWebViewActivity extends ChildActivity {

    private static final String WEB_URL = "http://www.jiahaoliuliu.com";
    private static final String WEB_URL_2 = "http://www.google.com";

    private WebView mSimpleWebView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_web_view);

        // Link the views
        mSimpleWebView = (WebView) findViewById(R.id.simple_web_view);

        // Enable the web view
        mSimpleWebView.getSettings().setJavaScriptEnabled(true);
        mSimpleWebView.setWebViewClient(new WebViewClient());
        mSimpleWebView.loadUrl(WEB_URL);
//        mSimpleWebView.loadUrl(WEB_URL_2);
    }

    @Override
    public void onBackPressed() {
        // Capture the back button if the web view can go back
        if (mSimpleWebView.canGoBack()) {
            mSimpleWebView.goBack();
            return;
        }

        super.onBackPressed();
    }
}
