
package JSON_Generation.PASSAT_DATA_FRAME;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Dataset {

    @SerializedName("timestamp")
    @Expose
    private Integer timestamp;
    @SerializedName("data_array")
    @Expose
    private List<DataArray> dataArray = null;

    public Integer getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Integer timestamp) {
        this.timestamp = timestamp;
    }

    public List<DataArray> getDataArray() {
        return dataArray;
    }

    public void setDataArray(List<DataArray> dataArray) {
        this.dataArray = dataArray;
    }

}
