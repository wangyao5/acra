package org.acra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

import android.util.Log;

public class HttpUtils {
    public static void doPost(Properties parameters,
            URLConnection synoConn) throws UnsupportedEncodingException,
            IOException {
        // Construct data
        StringBuilder dataBfr = new StringBuilder();
        Iterator<Object> iKeys = parameters.keySet().iterator();
        while (iKeys.hasNext()) {
            if (dataBfr.length() != 0) {
                dataBfr.append('&');
            }
            String key = (String)iKeys.next();
            dataBfr.append(URLEncoder.encode(key, "UTF-8")).append('=').append(
                    URLEncoder.encode((String)parameters.get(key), "UTF-8"));
        }
        // POST data
        synoConn.setDoOutput(true);
        OutputStreamWriter wr = new OutputStreamWriter(synoConn
                .getOutputStream());
        wr.write(dataBfr.toString());
        wr.flush();
        wr.close();
        StringBuffer response = new StringBuffer();
        
        BufferedReader rd = new BufferedReader(new InputStreamReader(synoConn
                .getInputStream()));
        
        String line;
        while ((line = rd.readLine()) != null) {
            Log.i("CrashReport", line);
            response.append(line);
        }
        rd.close();

        String strResponse = response.toString();

    }


}
