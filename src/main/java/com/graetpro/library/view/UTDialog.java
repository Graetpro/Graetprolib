package com.graetpro.library.view;

import android.app.Dialog;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.WindowManager;

import com.graetpro.library.R;

public class UTDialog extends Dialog
{
    static DisplayMetrics dm;
    WindowManager.LayoutParams wmlp;
    int screenWidth,screenHeight;
    public UTDialog(Context c){
        super(c, R.style.NormalDialog);
        init(c);

    }
    public UTDialog(Context c,int style){
        super(c,style);
        init(c);
    }
    public void setSize(int w,int h){
        wmlp.width = w;
        wmlp.height = h;
        this.getWindow().setAttributes(wmlp);
    }
    private void init(Context c){
        dm =c.getResources().getDisplayMetrics();
        wmlp=this.getWindow().getAttributes();
        screenWidth = getScreenWidth();
        screenHeight = getScreenHight();
    }
    public static int getScreenWidth(){
        return dm.widthPixels;
    }
    public static int getScreenHight(){
        return dm.heightPixels;
    }
}
