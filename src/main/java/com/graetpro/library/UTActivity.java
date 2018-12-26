package com.graetpro.library;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

abstract public class UTActivity extends AppCompatActivity {
    public abstract void appOnCreate();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        beforeViewLoad();
        appOnCreate();
        afterViewLoad();
    }
    public void beforeViewLoad(){

    }
    public void afterViewLoad(){

    }
    public void startService(Class<?> cass){
        startService(new Intent(getThisContext(),cass));
    }
    public void startActivity(Class<?> cass){
        startActivity(new Intent(getThisContext(),cass));
    }
    public Context getThisContext(){
        return UTActivity.this;
    }
    public void showToast(String s){
        Toast.makeText(getThisContext(),s,Toast.LENGTH_SHORT).show();
    }
    public static void print(Context c,String s){
        Toast.makeText(c,s,Toast.LENGTH_SHORT).show();
    }
}