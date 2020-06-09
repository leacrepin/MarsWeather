package com.infres.meteomars.model;

import androidx.annotation.NonNull;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;

public class Sol implements Serializable {

    private int id;
    private Double temp_avg;
    private Double temp_min;
    private Double temp_max;
    private Double pression_avg;
    private Double pression_min;
    private Double pression_max;


    public Sol(String id, JSONObject jsonObject) throws JSONException {
        this.fromJSON(id, jsonObject);
    }

    private void fromJSON(String id, JSONObject jsonObject) throws JSONException {
        this.id = Integer.parseInt(id);

        JSONObject at = jsonObject.getJSONObject("AT");

        this.temp_min = at.getDouble("mn");
        this.temp_max = at.getDouble("mx");
        this.temp_avg = at.getDouble("av");

        JSONObject pre = jsonObject.getJSONObject("PRE");
        this.pression_min = pre.getDouble("mn");;
        this.pression_max = pre.getDouble("mx");
        this.pression_avg = pre.getDouble("av");
    }

    @NonNull
    @Override
    public String toString() {
        return String.valueOf(this.id);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Double getTemp_avg() {
        return temp_avg;
    }

    public void setTemp_avg(Double temp_avg) {
        this.temp_avg = temp_avg;
    }

    public Double getTemp_min() {
        return temp_min;
    }

    public void setTemp_min(Double temp_min) {
        this.temp_min = temp_min;
    }

    public Double getTemp_max() {
        return temp_max;
    }

    public void setTemp_max(Double temp_max) {
        this.temp_max = temp_max;
    }

    public Double getPression_avg() {
        return pression_avg;
    }

    public void setPression_avg(Double pression_avg) {
        this.pression_avg = pression_avg;
    }

    public Double getPression_min() {
        return pression_min;
    }

    public void setPression_min(Double pression_min) {
        this.pression_min = pression_min;
    }

    public Double getPression_max() {
        return pression_max;
    }

    public void setPression_max(Double pression_max) {
        this.pression_max = pression_max;
    }
}
