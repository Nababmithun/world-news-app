package com.example.worldnewsapp.GellaryActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.worldnewsapp.R;
import com.example.worldnewsapp.RatingActivity.RatingActivity;

public class GellaryActivitypic4 extends AppCompatActivity {
    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gellary_activitypic4);
        webView = (WebView) findViewById(R.id.webview);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("https://en.prothomalo.com/photo/gallery/195300/The-Stateless-Violinist-image-184560");

        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
    }

    @Override
    public void onBackPressed() {
        if (webView.canGoBack()) {
            webView.goBack();
        } else {
            super.onBackPressed();
        }
    }

    public void backBtn(View view) {




        onBackPressed();
        startActivity(new Intent(GellaryActivitypic4.this, GellaryNewsActivity.class));
        finish();
    }

    public void Rating(View view) {


        Intent intent=new Intent(GellaryActivitypic4.this, RatingActivity.class);
        startActivity(intent);


    }

    public void Sharing(View view) {


        Intent i =new Intent(Intent.ACTION_SEND);
        i.setType("text/plain");
        String subject="World News BD";
        String body="NewsPaper app";
        i.putExtra(Intent.EXTRA_SUBJECT,subject);
        i.putExtra(Intent.EXTRA_TEXT,body);
        startActivity(Intent.createChooser(i,"share Via"));
    }
}