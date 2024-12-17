package com.pukka.cloud.metanlp;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class HandleUrl {
    public String handleUrl(String url) throws UnsupportedEncodingException {
        //处理url，拿到形参
        Map<String, String> params = new HashMap<>();
        int queryIndex = url.indexOf('?');
        if (queryIndex != -1) {
            String queryString = url.substring(queryIndex + 1);
            String[] pairs = queryString.split("&");
            for (String pair : pairs) {
                int idx = pair.indexOf('=');
                if (idx > 0) {
                    String key = pair.substring(0, idx);
                    String value = pair.substring(idx + 1);
                    params.put(key, value);
                }
            }
        }
        //拼接
        String lastUrl = url.split("\\?")[0];
        lastUrl=lastUrl+"?";
        Iterator var7 = params.entrySet().iterator();
        Map.Entry temp;
        while(var7.hasNext()) {
            temp = (Map.Entry)var7.next();
            lastUrl=lastUrl+temp.getKey()+"="+ URLEncoder.encode(temp.getValue().toString(),"UTF-8")+"&";
        }
        return lastUrl;
    }
}
