package com.example.nutritionscanner;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class HTTPSingleton{
    private static HTTPSingleton instance;
    private RequestQueue requestQueue;
    private static Context ctx;

    private HTTPSingleton(Context context) {
        requestQueue = getRequestQueue();
        ctx = context;
    }

    public static synchronized HTTPSingleton getInstance(Context context) {
        if (instance == null) {
            instance = new HTTPSingleton(context);
        }
        return instance;
    }

    public RequestQueue getRequestQueue() {
        if (requestQueue == null) {
            // getApplicationContext() is key, it keeps you from leaking the
            // Activity or BroadcastReceiver if someone passes one in.
            requestQueue = Volley.newRequestQueue(ctx.getApplicationContext());
        }
        return requestQueue;
    }

    public <T> void addToRequestQueue(Request<T> req) {
        getRequestQueue().add(req);
    }
}
