package com.graetpro.library.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.graetpro.library.R;

public class UTDialogLoadingCycle extends UTDialog {
    public TextView tv;
    public ProgressBar pb;

    public UTDialogLoadingCycle(@NonNull Context context) {
        super(context);
        setContentView(R.layout.cycledialog);
        tv =findViewById(R.id.loadingTextView1);
        pb = findViewById(R.id.loadingProgressBar1);
    }
    public void setText(String text){
        tv.setText(text);
    }
}