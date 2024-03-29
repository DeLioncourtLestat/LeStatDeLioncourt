package com.example.lider_express;

import android.util.Log;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class JsonZapros extends Thread {
    String position;
    String stolb27,stolb28,stolb29,stolb30,stolb31,stolb32,stolb33,stolb34,stolb35,stolb36,stolb37,stolb38,stolb39,
            stolb40,stolb41,stolb42,stolb43,stolb44,stolb45,stolb46,stolb47,stolb48,stolb49,stolb50,stolb51,stolb52,stolb53;
    String result = null;
    String line = null;
    InputStream is = null;

    public void run() {
        // создаем лист для отправки запросов
        ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
        // один параметр, если нужно два и более просто добоовляем также
        nameValuePairs.add(new BasicNameValuePair("position", position));
        nameValuePairs.add(new BasicNameValuePair("stolb27", stolb27));
        nameValuePairs.add(new BasicNameValuePair("stolb28", stolb28));
        nameValuePairs.add(new BasicNameValuePair("stolb29", stolb29));
        nameValuePairs.add(new BasicNameValuePair("stolb30", stolb30));
        nameValuePairs.add(new BasicNameValuePair("stolb31", stolb31));
        nameValuePairs.add(new BasicNameValuePair("stolb32", stolb32));
        nameValuePairs.add(new BasicNameValuePair("stolb33", stolb33));
        nameValuePairs.add(new BasicNameValuePair("stolb34", stolb34));
        nameValuePairs.add(new BasicNameValuePair("stolb35", stolb35));
        nameValuePairs.add(new BasicNameValuePair("stolb36", stolb36));
        nameValuePairs.add(new BasicNameValuePair("stolb37", stolb37));
        nameValuePairs.add(new BasicNameValuePair("stolb38", stolb38));
        nameValuePairs.add(new BasicNameValuePair("stolb39", stolb39));
        nameValuePairs.add(new BasicNameValuePair("stolb40", stolb40));
        nameValuePairs.add(new BasicNameValuePair("stolb41", stolb41));
        nameValuePairs.add(new BasicNameValuePair("stolb42", stolb42));
        nameValuePairs.add(new BasicNameValuePair("stolb43", stolb43));
        nameValuePairs.add(new BasicNameValuePair("stolb44", stolb44));
        nameValuePairs.add(new BasicNameValuePair("stolb45", stolb45));
        nameValuePairs.add(new BasicNameValuePair("stolb46", stolb46));
        nameValuePairs.add(new BasicNameValuePair("stolb47", stolb47));
        nameValuePairs.add(new BasicNameValuePair("stolb48", stolb48));
        nameValuePairs.add(new BasicNameValuePair("stolb49", stolb49));
        nameValuePairs.add(new BasicNameValuePair("stolb50", stolb50));
        nameValuePairs.add(new BasicNameValuePair("stolb51", stolb51));
        nameValuePairs.add(new BasicNameValuePair("stolb52", stolb52));
        nameValuePairs.add(new BasicNameValuePair("stolb53", stolb53));
        //  подключаемся к php запросу и отправляем в него id
        try {
            HttpClient httpclient = new DefaultHttpClient();
            HttpPost httppost = new HttpPost("http://peremoga.tech/Download.php");
            httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs, "UTF-8"));
            HttpResponse response = httpclient.execute(httppost);
            HttpEntity entity = response.getEntity();
            is = entity.getContent();
            Log.e("pass 1", "connection success ");
        } catch (Exception e) {
            Log.e("Fail 1", e.toString());
        }
        // получаем ответ от php запроса в формате json
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(is, "UTF-8"), 8);
            StringBuilder sb = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
            is.close();
            result = sb.toString();
            Log.e("pass 2", "connection success" + result);
        } catch (Exception e) {
            Log.e("Fail 2", e.toString());
        }
        // обрабатываем полученный json
        try {
            JSONObject json_data = new JSONObject(result);
            position= (json_data.getString("a"));
            Log.e("pass 3", position);
        } catch (Exception e) {
            Log.e("Fail 3", e.toString());
        }
    }
    // принемаем id при запуске потока
    public void start(String idp) {
        this.position = idp;
        this.start();
    }
    public void download(String positionb,String stolb27b,String stolb28b,String stolb29b,String stolb30b,String stolb31b,String stolb32b,String stolb33b,String stolb34b,String stolb35b,String stolb36b,String stolb37b,String stolb38b,String stolb39b, String stolb40b,String stolb41b,String stolb42b,String stolb43b,String stolb44b,String stolb45b,String stolb46b,String stolb47b,String stolb48b,String stolb49b,String stolb50b,String stolb51b,String stolb52b,String stolb53b) {
        this.position = positionb;
        this.stolb27 = stolb27b;
        this.stolb28 = stolb28b;
        this.stolb29 = stolb29b;
        this.stolb30 = stolb30b;
        this.stolb31 = stolb31b;
        this.stolb32 = stolb32b;
        this.stolb33 = stolb33b;
        this.stolb34 = stolb34b;
        this.stolb35 = stolb35b;
        this.stolb36 = stolb36b;
        this.stolb37 = stolb37b;
        this.stolb38 = stolb38b;
        this.stolb39 = stolb39b;
        this.stolb40 = stolb40b;
        this.stolb41 = stolb41b;
        this.stolb42 = stolb42b;
        this.stolb43 = stolb43b;
        this.stolb44 = stolb44b;
        this.stolb45 = stolb45b;
        this.stolb46 = stolb46b;
        this.stolb47 = stolb47b;
        this.stolb48 = stolb48b;
        this.stolb49 = stolb49b;
        this.stolb50 = stolb50b;
        this.stolb51 = stolb51b;
        this.stolb52 = stolb52b;
        this.stolb53 = stolb53b;

        this.start();
    }
    public String reposition() {
        return position;
    }
}
