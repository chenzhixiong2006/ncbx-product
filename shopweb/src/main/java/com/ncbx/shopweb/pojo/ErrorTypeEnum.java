package com.ncbx.shopweb.pojo;

public enum ErrorTypeEnum {
	ERROR_PARAM(1, "ERROR_PARAM","参数类型错误"),
	ERROR_SERVER(2, "ERROR_SERVER","服务器类型错误"),
	ERROR_NONE(3,"ERROR_NONE","无错误"),
	ERROR_EXISTED(4,"ERROR_EXISTED","存在"),
	ERROR_NOT_EXISTED(5,"ERROR_NOT_EXISTED","不存在"),
	ERROR_ORDER(6, "ERROR_ORDER","订单类型错误"),
	ERROR_USER(7, "INFO_USER","用户类型错误");

	private int code;
	private String desc;
	private String cnDesc;//中文描述

	ErrorTypeEnum(int code, String desc,String cnDesc) {
		this.code = code;
		this.desc = desc;
		this.cnDesc = cnDesc;
	}

	public static String getDesc(int code) {
		for (ErrorTypeEnum businessType : ErrorTypeEnum.values()) {
			if (businessType.getCode() == code) {
				return businessType.getDesc();
			}
		}
		return "";
	}

	public static ErrorTypeEnum getEnum(int code) {
		for (ErrorTypeEnum businessType : ErrorTypeEnum.values()) {
			if (businessType.getCode() == code) {
				return businessType;
			}
		}
		return null;
	}

	public int getCode() {
		return code;
	}

	public String getDesc() {
		return desc;
	}

	public String getCnDesc() {
		return cnDesc;
	}
}
