package com.yi.ziyue.net;

import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Yi on 16/3/4.
 */
public interface VolleyNetListener<T> {
    //新闻页面标签
    static final String TABS_URL = "http://c.m.163.com/nc/topicset/ios/subscribe/manage/listspecial.html";
    //标签对应新闻内容 拼接 Tid
    static final String NEXT_HEAD_URL = "http://c.m.163.com/nc/article/list/";
    static final String NEXT_END_URL = "/0-20.html";
    //阅读页面
    static final String RECOMMEND_HEAD_URL = "http://c.3g.163.com/recommend/getSubDocPic?";
    static final String RECOMMEND_END_URL = "from=yuedu&size=20&passport=&devId=3BraG2WOLoaaKIKXATJ9mQ%3D%3D&lat=DOFOFDTJN%2BtjpQ9%2B7nR9aA%3D%3D&lon=OrA3PNTui7p1B%2BRhEhoqYg%3D%3D&version=5.4.9&net=wifi&ts=1456736448&sign=FR0SrDLfnyUaERn5QkJLNVgjVdO7cE2CYQ43l97lEoZ48ErR02zJ6%2FKXOnxX046I&encryption=1&canal=huawei_news";
    //话题页面
    static final String THEME_URL = "http://c.3g.163.com/newstopic/list/expert/0-10.html";
    //视听页面
    static final String SEE_URL = "http://c.3g.163.com/nc/video/home/0-10.html";
    //24小时要闻
    static final String HOUR_24_HEAD = "http://c.m.163.com/nc/article/list/";
    static final String HOUR_24_TID = "T1429173683626";
    static final String HOUR_24_END = "/0-20.html";
    //搜索
    static final String SEARCH_HOT = "http://c.m.163.com/nc/search/hotWord.html";

    /**
     * 定向搜索
     *
     * @param jsonObject
     * <p/>
     * http://c.m.163.com/search/comp/MA%3D%3D/20/卡卡.html?deviceId=NjIxRUNGMzItQUUzMi00M0I5LTg3NkYtQkMxOTNDOUQ0REIy&version=NS41LjM%3D&channel=5aS05p2h
     * 卡卡为自己拼接的搜索内容字符串
     */
    static final String SEARCH_REQUEST_HEAD = "http://c.m.163.com/search/comp/MA%3D%3D/20/";
    static final String SEARCH_REQUEST_END = ".html?deviceId=NjIxRUNGMzItQUUzMi00M0I5LTg3NkYtQkMxOTNDOUQ0REIy&version=NS41LjM%3D&channel=5aS05p2h";
    //天气接口
    static final String WEATHER_URL = "https://api.heweather.com/x3/weather?cityid=CN101070201&key=54dd112a18b143fea86b5bd0e0895cd3";
    //电台接口
    static final String RADIO_URL = "http://c.3g.163.com/nc/topicset/android/radio/index.html";

    void getSucceed(JSONObject jsonObject);

    void getSucceedString(String s);

    void getFailed(String s);

    void getSucceedArrayList(ArrayList<T> ts);


}
