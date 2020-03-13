package com.example.worldnewsapp.NewsFeedActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.worldnewsapp.Activity.MainActivity;
import com.example.worldnewsapp.R;
import com.example.worldnewsapp.RatingActivity.RatingActivity;
import com.example.worldnewsapp.WebView.ListNews;

public class NewsFeedActivity extends AppCompatActivity {




    private TextView newsfeed1,newsfeed2,newsfeed3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_feed);


        newsfeed1=findViewById(R.id.next1);
        newsfeed2=findViewById(R.id.next2);
        newsfeed3=findViewById(R.id.next3);


        newsfeed1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent=new Intent(NewsFeedActivity.this, NewsActivityFeed1.class);
                startActivity(intent);



            }
        });



        newsfeed2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent=new Intent(NewsFeedActivity.this, NewsActivityFeed2.class);
                startActivity(intent);



            }
        });



        newsfeed3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                Intent intent=new Intent(NewsFeedActivity.this, NewsActivityFedd3.class);
                startActivity(intent);
            }
        });

    }





    public void backBtn(View view) {


        onBackPressed();
        startActivity(new Intent(NewsFeedActivity.this, MainActivity.class));
        finish();
    }

    public void Rating(View view) {


        Intent intent=new Intent(NewsFeedActivity.this, RatingActivity.class);
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
