package com.example.nutritionscanner;

import android.content.Context;
import android.widget.TextView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;
import org.w3c.dom.Text;

import java.util.HashMap;
import java.util.Map;

public class HTTPSingleton{
    private static HTTPSingleton instance;
    private RequestQueue requestQueue;
    private static Context ctx;

    private HTTPSingleton(Context context) {
        ctx = context;
        requestQueue = getRequestQueue();
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

    public void getUPCInfo(String upc, final TextView calories, final TextView carb, final TextView protein, final TextView fat) {
        System.out.println("nutrition");
        String url = String.format(
                "https://trackapi.nutritionix.com/v2/search/item?upc=%s", upc);

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONObject food = response.getJSONArray("foods").getJSONObject(0);
                            FoodItem f = new FoodItem(food);
                            StringBuilder display = new StringBuilder();
                            display.append(f.getBrandName()).append(": ").append(f.getName());
                            display.append("\n").append("Calories:").append(f.getCalories());
                            display.append("\n").append("Fat:").append(f.getTotalFat());
                            display.append("\n").append("Proteins:").append(f.getProtein());
                            display.append("\n").append("Carb:").append(f.getCarbohydrates());

                            calories.setText("Calories: " + f.getCalories());
                            carb.setText("Carbohydrates: " + f.getCarbohydrates());
                            protein.setText("Protein: " + f.getProtein());
                            fat.setText("Fat: " + f.getTotalFat());

                            System.out.println("Response: " + f.getName());
                        } catch(Exception e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        error.printStackTrace();
                    }
                }){
            @Override
            public Map<String, String> getParams() {
                Map<String, String> params = new HashMap<>();
                params.put("nix_item_id", "513fc9e73fe3ffd40300109f");
                return params;
            }

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("Content-Type", "application/json; charset=utf-8");
                params.put("x-app-id", "8ef8e926");
                params.put("x-app-key","46a141f61c0b8924383776395cdd9636");
                return params;
            }
        };

        // Access the RequestQueue through your singleton class.
        getInstance(ctx).addToRequestQueue(jsonObjectRequest);
    }

}
