package com.graetpro.library;

import android.util.Log;

public class UTLog {
    public static void s(String text){
        Log.wtf("["+Util.date.getNowTime()+"]",text);
    }
}
