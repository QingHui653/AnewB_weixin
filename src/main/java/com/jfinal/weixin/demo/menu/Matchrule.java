
package com.jfinal.weixin.demo.menu;

public class Matchrule {
	//用户分组id，可通过用户分组管理接口获取
	private String group_id;
	//性别：男（1）女（2），不填则不做匹配
	private String sex;
	//国家信息
	private String country;
	//省份信息
	private String province;
	//城市信息
	private String city;
	//客户端版本，当前只具体到系统型号：IOS(1), Android(2),Others(3)，不填则不做匹配
	private String client_platform_type;
	//语言信息
	private String language;
	public String getGroup_id() {
		return group_id;
	}
	public void setGroup_id(String group_id) {
		this.group_id = group_id;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getClient_platform_type() {
		return client_platform_type;
	}
	public void setClient_platform_type(String client_platform_type) {
		this.client_platform_type = client_platform_type;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	
	
}
