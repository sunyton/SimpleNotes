package com.example.suny.simplenotes.utils;

/**
 * Created by suny on 2017/5/15.
 */

public class InfoBean {

    private String _id;
    private String body;
    private String weather;
    private String location;
    private String time_ri;
    private String time_yue;
    private String time_week;
    private String time_hm;

    public String getTime_ri() {
        return time_ri;
    }

    public void setTime_ri(String time_ri) {
        this.time_ri = time_ri;
    }

    public String getTime_yue() {
        return time_yue;
    }

    public void setTime_yue(String time_yue) {
        this.time_yue = time_yue;
    }

    public String getTime_week() {
        return time_week;
    }

    public void setTime_week(String time_week) {
        this.time_week = time_week;
    }

    public String getTime_hm() {
        return time_hm;
    }

    public void setTime_hm(String time_hm) {
        this.time_hm = time_hm;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
