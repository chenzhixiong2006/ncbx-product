package com.ncbx.shopweb.pojo;

/**
 * 错误结果枚举类，这里包括系统中所有的错误
 * @author win7
 * 系统错误由四块组成：错误码、错误级别、错误类型、错误描述
 */
public enum ResponseCodeEnum {
	SUCCEED(10000, ErrLevelEnum.INFO, ErrorTypeEnum.ERROR_NONE,"操作成功"),
	USER_NOT_EXIST_ERROR(70001, ErrLevelEnum.ERROR, ErrorTypeEnum.ERROR_USER,"用户不存在"),
	USER_OR_PASSWORD_ERROR(70002, ErrLevelEnum.ERROR, ErrorTypeEnum.ERROR_USER,"用户名或密码错误"),
	USER_NOT_LOGIN_ERROR(70003, ErrLevelEnum.ERROR, ErrorTypeEnum.ERROR_USER,"未登陆");
	
	 
	private int code;//错误码
	private ErrLevelEnum level;//日志级别
	private ErrorTypeEnum errcode;//错误类型
	private String desc;//错误描述

	ResponseCodeEnum(int code, ErrLevelEnum level, ErrorTypeEnum errcode, String desc) {
	  this.code = code;
	  this.level = level;
	  this.errcode = errcode;
	  this.desc = desc;
	}


	public static String getDesc(int code) {
	  for (ResponseCodeEnum failReasonEnum : ResponseCodeEnum.values()) {
	    if (failReasonEnum.getCode() == code) {
	      return failReasonEnum.getDesc();
	    }
	  }
	  return "";
	}

	public static ResponseCodeEnum getEnum(int code) {
	  for (ResponseCodeEnum failReasonEnum : ResponseCodeEnum.values()) {
	    if (failReasonEnum.getCode() == code) {
	      return failReasonEnum;
	    }
	  }
	  return null;
	}


	public int getCode() {
		return code;
	}


	public ErrLevelEnum getLevel() {
		return level;
	}


	public ErrorTypeEnum getErrcode() {
		return errcode;
	}


	public String getDesc() {
		return desc;
	}
}
