package by.wotcalculator.application.domain.models.api;

import com.google.gson.annotations.SerializedName;

public class Tank {

    @SerializedName("name")
    private String name;

    @SerializedName("description")
    private String description;

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }
}
