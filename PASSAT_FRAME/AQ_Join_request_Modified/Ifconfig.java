
package com.example;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Ifconfig {

    @SerializedName("portname")
    @Expose
    private String portname;
    @SerializedName("bitrate")
    @Expose
    private Integer bitrate;
    @SerializedName("data_bits")
    @Expose
    private Integer dataBits;
    @SerializedName("stop_bits")
    @Expose
    private Integer stopBits;
    @SerializedName("parity_bits")
    @Expose
    private String parityBits;
    @SerializedName("port")
    @Expose
    private Integer port;
    @SerializedName("hostname")
    @Expose
    private String hostname;
    @SerializedName("target_ip")
    @Expose
    private String targetIp;
    @SerializedName("eth_name")
    @Expose
    private String ethName;

    public String getPortname() {
        return portname;
    }

    public void setPortname(String portname) {
        this.portname = portname;
    }

    public Integer getBitrate() {
        return bitrate;
    }

    public void setBitrate(Integer bitrate) {
        this.bitrate = bitrate;
    }

    public Integer getDataBits() {
        return dataBits;
    }

    public void setDataBits(Integer dataBits) {
        this.dataBits = dataBits;
    }

    public Integer getStopBits() {
        return stopBits;
    }

    public void setStopBits(Integer stopBits) {
        this.stopBits = stopBits;
    }

    public String getParityBits() {
        return parityBits;
    }

    public void setParityBits(String parityBits) {
        this.parityBits = parityBits;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public String getHostname() {
        return hostname;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    public String getTargetIp() {
        return targetIp;
    }

    public void setTargetIp(String targetIp) {
        this.targetIp = targetIp;
    }

    public String getEthName() {
        return ethName;
    }

    public void setEthName(String ethName) {
        this.ethName = ethName;
    }

}
