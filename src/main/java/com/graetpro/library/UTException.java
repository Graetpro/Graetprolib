package com.graetpro.library;

import android.content.Context;

public class UTException extends Exception{
    private Context context;
    public UTException(){
        super();
    }
    @Override
    public void printStackTrace()
    {
        UTActivity.print(context,this.toString());
        super.printStackTrace();
    }
    public void setContext(Context c){
        this.context=c;
    }
}
