package com.webleader.appms.bean.setting;

/**
 * @className DeviceParameter
 * @description 设备参数表
 * @author ding
 * @date 2017年3月31日 下午3:36:26
 * @version 1.0.0
 */
public class DeviceParameter {
	private String deviceId;// 设备ID

	private String deviceName;// 设备名称

	private String password;// 密码

	private Integer printLevel;// 信息打印级别

	private Integer modbusPort;// modbus端口

	private String macAddr;// mac地址

	private String ipAddr;// ip地址

	private String mask;// 子网掩码

	private String gateway;// 网管

	private Boolean onDhcp;// 是否使用DHCP

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

	@Override
	public String toString() {
		return "DeviceParameter [deviceId=" + deviceId + ", deviceName=" + deviceName + ", password=" + password
				+ ", printLevel=" + printLevel + ", modbusPort=" + modbusPort + ", macAddr=" + macAddr + ", ipAddr="
				+ ipAddr + ", mask=" + mask + ", gateway=" + gateway + ", onDhcp=" + onDhcp + "]";
	}
}