package com.yi.ziyue.net;

import com.android.volley.AuthFailureError;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Map;

/**
 * Created by Yi on 16/3/4.
 */
public class NetHelper {
    private ImageLoader imageLoader;
    private RequestQueue requestQueue;

    public NetHelper() {
        //单例 queue 对象 和 imageLoader 对象
        SingleQueue singleQueue = SingleQueue.getInstance();
        requestQueue = singleQueue.getQueue();
        imageLoader = new ImageLoader(requestQueue, new MemoryCache());
    }

    public ImageLoader getImageLoader() {
        return imageLoader;
    }

    //泛型返回网络请求信息方法
    public <T> void getInfo(String start, final String id, String end, final Class<T> cls, final VolleyNetListener listener) {
        String url = start + id + end;
        final ArrayList<T> list = new ArrayList<>();
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray array = response.getJSONArray(id);
                    for (int i = 0; i < array.length(); i++) {
                        T t = new Gson().fromJson(array.getJSONObject(i).toString(), cls);
                        list.add(t);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                listener.getSucceedArrayList(list);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                listener.getFailed("网络不好,请稍等");
            }
        });
        requestQueue.add(jsonObjectRequest);
    }


    public void getInformation(String url, final Map head, final VolleyNetListener netListener) {

        JsonObjectRequest request = new JsonObjectRequest(url, null, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {
                //成功回调,返回给 Activity

                netListener.getSucceed(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                //错误回调,返回给 Activity
                netListener.getFailed("拉取失败");
            }
        }) {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {

                if (head != null) { //如果有头信息则返回头信息
                    return head;
                }

                return super.getHeaders();
            }
        };

        //添加请求队列
        requestQueue.add(request);


    }

//    public void getInformationStringRequest(String url, final Map head, final VolleyNetListener netListener) {
//
//        StringRequest request = new StringRequest(url, null, new Response.Listener<String>() {
//
//            @Override
//            public void onResponse(String response) {
//                //成功回调,返回给 Activity
//
//                netListener.getSucceed(response);
//                netListener.getSucceedString(response);
//            }
//        }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                //错误回调,返回给 Activity
//                Gson gson = new Gson();
//
//                netListener.getFailed("拉取失败");
//            }
//        }) {
//            @Override
//            public Map<String, String> getHeaders() throws AuthFailureError {
//
//                if (head != null) { //如果有头信息则返回头信息
//                    return head;
//                }
//
//                return super.getHeaders();
//            }
//        };
//
//        //添加请求队列
//        requestQueue.add(request);
//
//
//    }


    public void getInformationString(String url, final Map head, final VolleyNetListener netListener) {
        StringRequest request = new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                netListener.getSucceedString(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                netListener.getFailed("加载失败");
            }
        })

        {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                if (head != null) {
                    return head;
                }
                return super.getHeaders();
            }
        };
        // 添加请求队列
        requestQueue.add(request);
    }

}
