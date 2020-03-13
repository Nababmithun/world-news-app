package com.example.worldnewsapp.Activity;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.example.worldnewsapp.Adapter.ListSourceAdapter;
import com.example.worldnewsapp.Common.Common;
import com.example.worldnewsapp.Communicate.BdJobActivity;
import com.example.worldnewsapp.Communicate.ContactActivity;
import com.example.worldnewsapp.GellaryActivity.GellaryNewsActivity;
import com.example.worldnewsapp.Interface.NewsService;
import com.example.worldnewsapp.LiveTVActivity.ChannelActivity;
import com.example.worldnewsapp.Model.WebSite;
import com.example.worldnewsapp.NewsFeedActivity.NewsFeedActivity;
import com.example.worldnewsapp.R;
import com.example.worldnewsapp.WebSideListBD.WebListActivity;
import com.google.android.material.navigation.NavigationView;
import com.google.gson.Gson;
import dmax.dialog.SpotsDialog;
import io.paperdb.Paper;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    RecyclerView listWebsite;
    RecyclerView.LayoutManager layoutManager;
    NewsService mmService;
    ListSourceAdapter adapter;
    AlertDialog dialog;
    SwipeRefreshLayout swipeLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = findViewById(R.id.drowar);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
         drawer.addDrawerListener(toggle);
         toggle.syncState();
         navigationView.setNavigationItemSelectedListener(this);





        //Init cache
        Paper.init(this);

        //Init Service
        mmService = Common.getNewsService();

        //Init View
        swipeLayout = (SwipeRefreshLayout)findViewById(R.id.swipeRefresh);
        swipeLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                loadWebsiteSource(true);
            }
        });

        listWebsite = (RecyclerView)findViewById(R.id.list_source);
        listWebsite.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        listWebsite.setLayoutManager(layoutManager);

        dialog = new SpotsDialog(this);

        loadWebsiteSource(false);

    }


    private void loadWebsiteSource(boolean isRefreshed) {
        if(!isRefreshed)
        {

            String cache = Paper.book().read("cache");
            if(cache != null && !cache.isEmpty() && !cache.equals("null")) // If have cache
            {
                WebSite website = new Gson().fromJson(cache,WebSite.class); // Convert cache from Json to Object
                adapter = new ListSourceAdapter(getBaseContext(),website);
                adapter.notifyDataSetChanged();
                listWebsite.setAdapter(adapter);
            }
            else // If not have cache
            {
                dialog.show();
                //Fetch new data
                mmService.getSources().enqueue(new Callback<WebSite>() {
                    @Override
                    public void onResponse(Call<WebSite> call, Response<WebSite> response) {
                        adapter  = new ListSourceAdapter(getBaseContext(),response.body());
                        adapter.notifyDataSetChanged();
                        listWebsite.setAdapter(adapter);

                        //Save to cache
                        Paper.book().write("cache",new Gson().toJson(response.body()));

                        dialog.dismiss();

                    }

                    @Override
                    public void onFailure(Call<WebSite> call, Throwable t) {

                    }
                });
            }
        }
        else // If from Swipe to Refresh
        {

            swipeLayout.setRefreshing(true);
            //Fetch new data
            mmService.getSources().enqueue(new Callback<WebSite>() {
                @Override
                public void onResponse(Call<WebSite> call, Response<WebSite> response) {
                    adapter  = new ListSourceAdapter(getBaseContext(),response.body());
                    adapter.notifyDataSetChanged();
                    listWebsite.setAdapter(adapter);


                    //Save to cache
                    Paper.book().write("cache",new Gson().toJson(response.body()));

                    //Dismiss refresh progressring
                    swipeLayout.setRefreshing(false);
                }

                @Override
                public void onFailure(Call<WebSite> call, Throwable t) {

                }
            });





        }



    }




    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drowar);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }








    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);


        return true;
    }


    @Override
    // This method is called whenever an item in the options menu is selected.
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            Intent settingsIntent = new Intent(this, SettingActivity.class);
            startActivity(settingsIntent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }




   @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            Intent intent=new Intent(MainActivity.this, MainActivity.class);
            startActivity(intent);

        } else if (id == R.id.nav_statement) {

            startActivity(new Intent(MainActivity.this, NewsFeedActivity.class));

        } else if (id == R.id.gelleryyy) {


            startActivity(new Intent(MainActivity.this, GellaryNewsActivity.class));



        }else if (id==R.id.onlinenews){
            startActivity(new Intent(MainActivity.this, ChannelActivity.class));


        }else if (id==R.id.websidelist)
        {
            startActivity(new Intent(MainActivity.this, WebListActivity.class));


        }else if (id==R.id.contract)
        {
            startActivity(new Intent(MainActivity.this, ContactActivity.class));

        }
        else if (id==R.id.bdjob)
        {

            startActivity(new Intent(MainActivity.this, BdJobActivity.class));

        }else if (id==R.id.nav_share)
        {

            Intent i =new Intent(Intent.ACTION_SEND);
            i.setType("text/plain");
            String subject="World News BD";
            String body="NewsPaper app";
            i.putExtra(Intent.EXTRA_SUBJECT,subject);
            i.putExtra(Intent.EXTRA_TEXT,body);
            startActivity(Intent.createChooser(i,"share Via"));



        }
        else if (id==R.id.logouttt)
        {

            System.exit(1);;

        }

        DrawerLayout drawer = findViewById(R.id.drowar);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


}
