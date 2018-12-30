package com.graetpro.library;

import android.os.*;

import java.io.*;
import java.net.*;
import java.text.SimpleDateFormat;

public class Util {
    public Util() {
        File file = new File(getSdcard0Path());
        if (!file.exists()) {
            file.mkdirs();
        }
    }

    private File createFile(String FileName) {
        return new File(getSdcard0Path(), FileName);
    }

    public static void downloadFile(final String furl, final String name) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    URL url = new URL(furl);
                    HttpURLConnection con = (HttpURLConnection) url.openConnection();
                    con.setReadTimeout(5000);
                    con.setConnectTimeout(5000);
                    con.setRequestProperty("Charset", "UTF-8");
                    con.setRequestMethod("GET");
                    if (con.getResponseCode() == 200) {
                        InputStream is = con.getInputStream();//获取输入流
                        FileOutputStream fileOutputStream = null;//文件输出流
                        if (is != null) {
                            Util fileUtils = new Util();
                            fileOutputStream = new FileOutputStream(fileUtils.createFile(name));//指定文件保存路径，代码看下一步
                            byte[] buf = new byte[1024];
                            int ch;
                            while ((ch = is.read(buf)) != -1) {
                                fileOutputStream.write(buf, 0, ch);//将获取到的流写入文件中
                            }
                        }
                        if (fileOutputStream != null) {
                            fileOutputStream.flush();
                            fileOutputStream.close();
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public static String getSdcard0Path() {
        return Environment.getExternalStorageDirectory().toString();
    }
    public static class date{
        public static String getNowTime(){
            SimpleDateFormat sdf=new SimpleDateFormat("hh:mm:ss");
            String date=sdf.format(new java.util.Date());
            return date;
        }
        public static String getNowYear(){
            SimpleDateFormat sdf=new SimpleDateFormat("yyyy");
            String date=sdf.format(new java.util.Date());
            return date;
        }
        public static String getNowMouth(){
            SimpleDateFormat sdf=new SimpleDateFormat("MM");
            String date=sdf.format(new java.util.Date());
            return date;
        }
        public static String getNowDey(){
            SimpleDateFormat sdf=new SimpleDateFormat("dd");
            String date=sdf.format(new java.util.Date());
            return date;
        }
        public static String getNowHour(){
            SimpleDateFormat sdf=new SimpleDateFormat("hh");
            String date=sdf.format(new java.util.Date());
            return date;
        }
        public static String getNowMinus(){
            SimpleDateFormat sdf=new SimpleDateFormat("mm");
            String date=sdf.format(new java.util.Date());
            return date;
        }
        public static String getNowSecond(){
            SimpleDateFormat sdf=new SimpleDateFormat("ss");
            String date=sdf.format(new java.util.Date());
            return date;
        }
    }
}

