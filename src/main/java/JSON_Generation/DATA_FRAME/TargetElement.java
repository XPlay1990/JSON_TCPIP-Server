
package JSON_Generation.DATA_FRAME;

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
    @SerializedName("configuration")
    @Expose
    private Configuration configuration;
    @SerializedName("dataset")
    @Expose
    private Dataset dataset;

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

    public Configuration getConfiguration() {
        return configuration;
    }

    public void setConfiguration(Configuration configuration) {
        this.configuration = configuration;
    }

    public Dataset getDataset() {
        return dataset;
    }

    public void setDataset(Dataset dataset) {
        this.dataset = dataset;
    }

}
