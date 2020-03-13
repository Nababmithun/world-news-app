package com.example.worldnewsapp.WebView;

import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.appcompat.app.AppCompatActivity;

import com.example.worldnewsapp.Activity.MainActivity;
import com.example.worldnewsapp.R;
import com.example.worldnewsapp.RatingActivity.RatingActivity;

import dmax.dialog.SpotsDialog;

public class DetailArticle extends AppCompatActivity {

    WebView webView;
    AlertDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_article);

        dialog = new SpotsDialog(this);
        dialog.show();
        //WebView
        webView = (WebView)findViewById(R.id.webView);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebChromeClient(new WebChromeClient());
        webView.setWebViewClient(new WebViewClient(){

            //press Ctrl+O

            @Override
            public void onPageFinished(WebView view, String url) {
                dialog.dismiss();
            }
        });

        if(getIntent() != null)
        {
            if(!getIntent().getStringExtra("webURL").isEmpty())
                webView.loadUrl(getIntent().getStringExtra("webURL"));
        }
    }

    public void backBtn(View view) {



        onBackPressed();
        startActivity(new Intent(DetailArticle.this, MainActivity.class));
        finish();
    }

    public void Rating(View view) {


        Intent intent=new Intent(DetailArticle.this, RatingActivity.class);
        startActivity(intent);

    }

    public void sharing(View view) {

        Intent i =new Intent(Intent.ACTION_SEND);
        i.setType("text/plain");
        String subject="World News BD";
        String body="NewsPaper app";
        i.putExtra(Intent.EXTRA_SUBJECT,subject);
        i.putExtra(Intent.EXTRA_TEXT,body);
        startActivity(Intent.createChooser(i,"share Via"));



    }
}
