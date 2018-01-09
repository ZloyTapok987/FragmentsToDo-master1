package com.example.vv.fragments;

import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        WebFragment webFragment=new WebFragment();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TitleFragment fragment=new TitleFragment();
        Bundle bundle=new Bundle();
        bundle.putString("url","http://google.com");
        webFragment.setArguments(bundle);
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE)
        {
            getSupportFragmentManager().beginTransaction().add(R.id.titile,fragment).add(R.id.web,webFragment).commit();
        }
        else getSupportFragmentManager().beginTransaction().add(R.id.f,fragment).commit();
    }
    public void click(String url)
    {
        WebFragment webFragment=new WebFragment();
        Bundle bundle=new Bundle();
        bundle.putString("url",url);
        webFragment.setArguments(bundle);
        if (getResources().getConfiguration().orientation==Configuration.ORIENTATION_LANDSCAPE)
            getSupportFragmentManager().beginTransaction().replace(R.id.web,webFragment).addToBackStack(null).commit();
        else
        {
            getSupportFragmentManager().beginTransaction().replace(R.id.f,webFragment).addToBackStack(null).commit();
        }
    }
}


