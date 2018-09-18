
package JSON_Generation.DATA_FRAME;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Target {

    @SerializedName("target_element")
    @Expose
    private TargetElement targetElement;

    public TargetElement getTargetElement() {
        return targetElement;
    }

    public void setTargetElement(TargetElement targetElement) {
        this.targetElement = targetElement;
    }

}
