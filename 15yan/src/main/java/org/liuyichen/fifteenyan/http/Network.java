package org.liuyichen.fifteenyan.http;

import com.facebook.stetho.okhttp.StethoInterceptor;
import com.squareup.okhttp.OkHttpClient;

import org.liuyichen.fifteenyan.Const;

/**
 * Created by liuchen on 15/7/4.
 * and ...
 */
public class Network {


    private static OkHttpClient okHttpClient = null;

    public static final OkHttpClient getOkClient() {

        if (okHttpClient == null) {
            synchronized (Network.class) {

                if (okHttpClient == null) {
                    okHttpClient = new OkHttpClient();
                }
                if (Const.isDebug()) {
                    okHttpClient.networkInterceptors().add(new StethoInterceptor());
                }
            }
        }
        return okHttpClient;
    }
}
