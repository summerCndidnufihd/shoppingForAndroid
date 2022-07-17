package com.zhy.http.okhttp.callback;

import java.io.IOException;

import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by zhy on 15/12/14.
 */
public abstract class StringCallback extends Callback<String>
{
    @Override
    public String parseNetworkResponse(Response response, int id) throws IOException
    {
        return response.body().string();
    }

    public abstract void onError(Request request, Exception e);

    public abstract void onResponse(String response);
}
