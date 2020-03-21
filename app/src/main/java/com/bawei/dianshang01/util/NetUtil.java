package com.bawei.dianshang01.util;

import android.util.Log;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * 工具类
 */
public class NetUtil {
    //单例模式
    private static final NetUtil NET_UTIL = new NetUtil();
    private NetUtil(){
    }
    public static NetUtil getNetUtil() {
        return NET_UTIL;
    }
    //流转字符串
    private String ioToString(InputStream inputStream) throws IOException {
        int len = -1;
        byte[] bytes = new byte[1024];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        while ((len = inputStream.read(bytes)) != -1){
            byteArrayOutputStream.write(bytes,0,len);
        }
        return new String(byteArrayOutputStream.toByteArray());
    }
    //请求字符串
    public String doGet(String httpUrl) {
        InputStream inputStream = null;
        try {
            URL url = new URL(httpUrl);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.setConnectTimeout(5000);
            urlConnection.setReadTimeout(5000);
            urlConnection.connect();
            int responseCode = urlConnection.getResponseCode();
            if(responseCode == 200){
                Log.i("Tag",responseCode + "请求成功！");
                inputStream = urlConnection.getInputStream();
                String json = ioToString(inputStream);
                Log.i("Tag",json);
                return json;
            } else {
                Log.e("Tag",responseCode + "请求失败！");
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            Log.e("Tag", "请求失败！");
            return null;
        } finally {
            //关闭流
            if(inputStream != null){
                try {
                    Log.i("Tag", "finally执行");
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
