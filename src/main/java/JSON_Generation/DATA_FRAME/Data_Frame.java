package JSON_Generation.DATA_FRAME;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Data_Frame {

    @SerializedName("header")
    @Expose
    private Header header;
    @SerializedName("data")
    @Expose
    private Data data;

    public Header getHeader() {
        return header;
    }

    public void setHeader(Header header) {
        this.header = header;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    /**
     *
     */
    public void toJson() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try (FileWriter filewriter = new FileWriter("Test_Frame.json")) {
            gson.toJson(this, filewriter);
            filewriter.flush();
        } catch (IOException ex) {
            Logger.getLogger(Data_Frame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static Data_Frame fromJSON(String json) {
        Gson gson = new GsonBuilder().create();
        Data_Frame fromJson = gson.fromJson(json, Data_Frame.class);
        return fromJson;
    }
}
