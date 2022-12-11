package by.wotcalculator.application.domain.models.api;

import com.google.gson.annotations.SerializedName;

import java.util.HashMap;

public class ResponseBody {

    @SerializedName("status")
    private String status;

    @SerializedName("meta")
    private Meta meta;

    @SerializedName("data")
    private HashMap<Integer, Tank> data;

    public String getStatus() {
        return this.status;
    }

    public Meta getMeta() {
        return this.meta;
    }

    public HashMap<Integer, Tank> getData() {
        return this.data;
    }
}
