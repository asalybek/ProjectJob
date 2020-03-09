package com.example.firstprojectjob.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Knp {
    @SerializedName("transfer_types")
    private List<String> transferTypes;
    @SerializedName("code")
    private String code;
    @SerializedName("name")
    private String name;
    @SerializedName("is_individuals")
    private boolean is_individuals;
    @SerializedName("is_corporate")
    private boolean is_corporate;
    @SerializedName("is_resident")
    private boolean is_resident;
    @SerializedName("is_non_resident")
    private boolean is_non_resident;

    public List<String> getTransferTypes() {
        return transferTypes;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public boolean isIs_individuals() {
        return is_individuals;
    }

    public boolean isIs_corporate() {
        return is_corporate;
    }

    public boolean isIs_resident() {
        return is_resident;
    }

    public boolean isIs_non_resident() {
        return is_non_resident;
    }
}
