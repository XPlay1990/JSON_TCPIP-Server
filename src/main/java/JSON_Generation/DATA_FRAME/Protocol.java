
package JSON_Generation.DATA_FRAME;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Protocol {

    @SerializedName("prot_name")
    @Expose
    private String protName;
    @SerializedName("prot_id")
    @Expose
    private Integer protId;
    @SerializedName("prot_version")
    @Expose
    private String protVersion;

    public String getProtName() {
        return protName;
    }

    public void setProtName(String protName) {
        this.protName = protName;
    }

    public Integer getProtId() {
        return protId;
    }

    public void setProtId(Integer protId) {
        this.protId = protId;
    }

    public String getProtVersion() {
        return protVersion;
    }

    public void setProtVersion(String protVersion) {
        this.protVersion = protVersion;
    }

}
