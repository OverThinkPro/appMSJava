package com.webleader.appms.bean.setting;

public class DeviceParameter {
    private String deviceId;

    private String deviceName;

    private String password;

    private Integer printLevel;

    private Integer modbusPort;

    private String macAddr;

    private String ipAddr;

    private String mask;

    private String gateway;

    private Boolean onDhcp;

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId == null ? null : deviceId.trim();
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName == null ? null : deviceName.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Integer getPrintLevel() {
        return printLevel;
    }

    public void setPrintLevel(Integer printLevel) {
        this.printLevel = printLevel;
    }

    public Integer getModbusPort() {
        return modbusPort;
    }

    public void setModbusPort(Integer modbusPort) {
        this.modbusPort = modbusPort;
    }

    public String getMacAddr() {
        return macAddr;
    }

    public void setMacAddr(String macAddr) {
        this.macAddr = macAddr == null ? null : macAddr.trim();
    }

    public String getIpAddr() {
        return ipAddr;
    }

    public void setIpAddr(String ipAddr) {
        this.ipAddr = ipAddr == null ? null : ipAddr.trim();
    }

    public String getMask() {
        return mask;
    }

    public void setMask(String mask) {
        this.mask = mask == null ? null : mask.trim();
    }

    public String getGateway() {
        return gateway;
    }

    public void setGateway(String gateway) {
        this.gateway = gateway == null ? null : gateway.trim();
    }

    public Boolean getOnDhcp() {
        return onDhcp;
    }

    public void setOnDhcp(Boolean onDhcp) {
        this.onDhcp = onDhcp;
    }
}