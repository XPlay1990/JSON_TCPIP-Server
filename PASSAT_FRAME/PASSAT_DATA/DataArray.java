
package com.example;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DataArray {

    @SerializedName("data_descr")
    @Expose
    private DataDescr dataDescr;

    public DataDescr getDataDescr() {
        return dataDescr;
    }

    public void setDataDescr(DataDescr dataDescr) {
        this.dataDescr = dataDescr;
    }

}
