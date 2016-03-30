package com.inwatch.sdk.main.net;

import com.inwatch.sdk.util.Util;

import java.io.IOException;
import java.util.HashMap;

import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;



public class InwatchHttpClient {

    OkHttpClient client = new OkHttpClient();

    private String imei;

    private String appid;

    private String appkey;

    private static String URL_LOGIN = "";

    private static InwatchHttpClient inwatchHttpClient;

    public static final MediaType JSON
            = MediaType.parse("application/json; charset=utf-8");


    public InwatchHttpClient(String imei,String appid,String appkey){
        this.imei = imei;
        this.appid = appid;
        this.appkey = appkey;
    }

    public static void init(String imei,String appid,String appkey){
        inwatchHttpClient = new InwatchHttpClient(imei,appid,appkey);
    }

    /**
     *
     * @return
     */
    public static InwatchHttpClient getInstance(){
        return inwatchHttpClient;
    }

    public Response sendMessage(String url, RequestBody requestBody) throws IOException {
        Request request = new Request.Builder().url(url).addHeader("imei",imei)
                .addHeader("appid",appid)
                .addHeader("appkey",appkey)
                .post(requestBody).build();
        return client.newCall(request).execute();
    }


    public void syncSendMessage(String url, RequestBody requestBody, Callback callback){
        Request request = new Request.Builder().url(url).addHeader("imei",imei)
                .addHeader("appid",appid)
                .addHeader("appkey",appkey)
                .post(requestBody).build();

        client.newCall(request).enqueue(callback);

    }


    public static void login(String username,String password,Callback callback){
        HashMap<String,String> map = new HashMap<String,String>();
        map.put("username",username);
        map.put("password",password);
        RequestBody requestBody = RequestBody.create(JSON, Util.hashMapToJson(map));
        inwatchHttpClient.syncSendMessage(URL_LOGIN,requestBody,callback);


    }


    public static void register(String username,String password,String mailAddress,String tel,Callback callback){

    }

}
