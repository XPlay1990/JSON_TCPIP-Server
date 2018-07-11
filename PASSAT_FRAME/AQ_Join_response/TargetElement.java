
package com.example;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TargetElement {

    @SerializedName("target_name")
    @Expose
    private String targetName;
    @SerializedName("target_uuid")
    @Expose
    private String targetUuid;
    @SerializedName("created")
    @Expose
    private String created;
    @SerializedName("result")
    @Expose
    private Result result;

    public String getTargetName() {
        return targetName;
    }

    public void setTargetName(String targetName) {
        this.targetName = targetName;
    }

    public String getTargetUuid() {
        return targetUuid;
    }

    public void setTargetUuid(String targetUuid) {
        this.targetUuid = targetUuid;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

}
