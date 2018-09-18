
package JSON_Generation.DATA_FRAME;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DataDescr {

    @SerializedName("data_type")
    @Expose
    private String dataType;
    @SerializedName("data_value")
    @Expose
    private Integer dataValue;

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public Integer getDataValue() {
        return dataValue;
    }

    public void setDataValue(Integer dataValue) {
        this.dataValue = dataValue;
    }

}
