package by.wotcalculator.application.domain.models.api;

import com.google.gson.annotations.SerializedName;

public class Meta {

    @SerializedName("count")
    private int count;

    @SerializedName("page_total")
    private int totalPages;

    @SerializedName("total")
    private int total;

    @SerializedName("limit")
    private int limit;

    @SerializedName("page")
    private int page;

    public int getCount() {
        return this.count;
    }

    public int getTotalPages() {
        return this.totalPages;
    }

    public int getTotal() {
        return this.total;
    }

    public int getLimit() {
        return this.limit;
    }

    public int getPage() {
        return this.page;
    }
}
