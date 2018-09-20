package com.example.rany.moviescrapdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

public class DetailActivity extends AppCompatActivity {

    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        webView = findViewById(R.id.webview);
        // enable javescript
        webView.getSettings().setJavaScriptEnabled(true);
        Bundle bundle = getIntent().getExtras();
        webView.loadUrl(bundle.getString("url"));

    }
}
