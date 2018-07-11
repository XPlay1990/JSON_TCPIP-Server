
package com.example;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Hardware {

    @SerializedName("iftype")
    @Expose
    private String iftype;
    @SerializedName("ifconfig")
    @Expose
    private Ifconfig ifconfig;

    public String getIftype() {
        return iftype;
    }

    public void setIftype(String iftype) {
        this.iftype = iftype;
    }

    public Ifconfig getIfconfig() {
        return ifconfig;
    }

    public void setIfconfig(Ifconfig ifconfig) {
        this.ifconfig = ifconfig;
    }

}
