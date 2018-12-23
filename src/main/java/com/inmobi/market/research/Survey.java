package com.inmobi.market.research;

import java.util.Map;

/**
 * Created By Ankit Choudhary on 05/12/18
 */
public class Survey {

    private String id;

    private String deviceId;

    private int count;

    private Map<String, String> headers;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public void setHeaders(Map<String, String> headers) {
        this.headers = headers;
    }

    @Override
    public String toString() {
        return "Survey{" +
                "id='" + id + '\'' +
                ", deviceId='" + deviceId + '\'' +
                ", count=" + count +
                '}';
    }
}
