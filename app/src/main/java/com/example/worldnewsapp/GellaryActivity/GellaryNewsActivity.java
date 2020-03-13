package com.example.worldnewsapp.GellaryActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.worldnewsapp.Activity.MainActivity;
import com.example.worldnewsapp.R;
import com.example.worldnewsapp.RatingActivity.RatingActivity;
import com.example.worldnewsapp.WebView.ListNews;

public class GellaryNewsActivity extends AppCompatActivity {



    private  ImageView imageView1,imageView2,imageView3,imageView4,imageView5,imageView6,imageView7,imageView8,imageView9,imageView10,imageView11,imageView12;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gellary_news);




        imageView1=findViewById(R.id.pic1);
        imageView2=findViewById(R.id.pic2);
        imageView3=findViewById(R.id.pic3);
        imageView4=findViewById(R.id.pic4);
        imageView5=findViewById(R.id.pic5);
        imageView6=findViewById(R.id.pic6);
        imageView7=findViewById(R.id.pic7);
        imageView8=findViewById(R.id.pic8);
        imageView9=findViewById(R.id.pic9);
        imageView10=findViewById(R.id.pic10);
        imageView11=findViewById(R.id.pic11);
        imageView12=findViewById(R.id.pic12);






        imageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent=new Intent(GellaryNewsActivity.this, GellaryActivityPic1.class);
                startActivity(intent);

            }
        });

        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(GellaryNewsActivity.this, GellaryActivityPic2.class);
                startActivity(intent);
            }
        });

        imageView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentt=new Intent(GellaryNewsActivity.this, GellaryActivitypic3.class);
                startActivity(intentt);
            }
        });

        imageView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intenttt=new Intent(GellaryNewsActivity.this, GellaryActivitypic4.class);
                startActivity(intenttt);
            }
        });

        imageView5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 Intent intentttt = new Intent(GellaryNewsActivity.this, GellaryActivityPic5.class);
                 startActivity(intentttt);
            }
        });


        imageView6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent=new Intent(GellaryNewsActivity.this, GellaryActivitypic6.class);
                startActivity(intent);

            }
        });
        imageView7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(GellaryNewsActivity.this,GellaryActivitypic7.class);
                startActivity(intent);
            }
        });

        imageView8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(GellaryNewsActivity.this,GellaryActivitypic8.class);
                startActivity(intent);
            }
        });

        imageView9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(GellaryNewsActivity.this,GellaryActivitypic9.class);
                startActivity(intent);
            }
        });


        imageView10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(GellaryNewsActivity.this,GellaryActivitypic10.class);
                startActivity(intent);
            }
        });



        imageView11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                Intent  intent=new Intent(GellaryNewsActivity.this,GellaryActivitypic11.class);
                startActivity(intent);



            }
        });


        imageView12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(GellaryNewsActivity.this,GellaryActivitypic12.class);
                startActivity(intent);
            }
        });


    }

    public void backBtn(View view) {

        onBackPressed();
        startActivity(new Intent(GellaryNewsActivity.this, MainActivity.class));
        finish();


    }

    public void Rating(View view) {


        Intent intent=new Intent(GellaryNewsActivity.this, RatingActivity.class);
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
