package com.iamstevenliu.smarthome.NetTool;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by dinotech on 15/11/24.
 */
public  class NetManagerQueue {
    public  static final String baseUrl = "";




    public static void sendLoginRequest(String userName, String userPassword ,NetCallBckInterface netCallBck){


        new  LoginRequest(netCallBck).execute(baseUrl);




    }


    public  static  class  LoginRequest extends AsyncTask<String,String,String>{


        private String  responceString;
        private  NetCallBckInterface  callBckInterface;

      public    LoginRequest(NetCallBckInterface  callBack){

            callBckInterface = callBack;

        }


        @Override
        protected String doInBackground(String... params) {
            HttpURLConnection connnecttion = null;
            try {

                URL loginUrl = new URL(baseUrl);

                connnecttion = (HttpURLConnection) loginUrl.openConnection();
                connnecttion.setRequestMethod("GET");
                connnecttion.setConnectTimeout(10000);
                connnecttion.setReadTimeout(5000);
                InputStream  is = connnecttion.getInputStream();
                int http_respocecode = connnecttion.getResponseCode();
                if (http_respocecode ==200){
                    cancel(true);

                }
                 responceString =getStringFromInputStream(is);
                is.close();


            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }


            return  responceString;
        }

        @Override
        protected void onCancelled() {
            super.onCancelled();
        }

        @Override
        protected void onPostExecute(String result) {

            System.out.println("result"+result);
            callBckInterface.loginSuccess(result);
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }
    }



    public  static  String getStringFromInputStream( InputStream is) throws IOException {
        BufferedReader br = null;
        StringBuilder sb = new StringBuilder();
        String line;
        br = new BufferedReader(new InputStreamReader(is));
        while ((line = br.readLine())!=null){
            sb.append(line);

        }
        if (br!=null){
            br.close();
        }

        return sb.toString();
    }


}

