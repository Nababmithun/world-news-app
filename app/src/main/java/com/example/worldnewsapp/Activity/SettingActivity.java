package com.example.worldnewsapp.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.example.worldnewsapp.GellaryActivity.GellaryActivityPic2;
import com.example.worldnewsapp.GellaryActivity.GellaryNewsActivity;
import com.example.worldnewsapp.R;
import com.example.worldnewsapp.RatingActivity.RatingActivity;

import java.util.ArrayList;

public class SettingActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Window window = getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_setting);



    }


    public void backBtn(View view) {


        onBackPressed();
        startActivity(new Intent(SettingActivity.this, MainActivity.class));
        finish();

    }

    public void Rating(View view) {

        Intent intent=new Intent(SettingActivity.this, MainActivity.class);
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
