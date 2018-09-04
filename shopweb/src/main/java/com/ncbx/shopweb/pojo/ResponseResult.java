package com.ncbx.shopweb.pojo;

/**
 * controller响应结果对象
 * @author win7
 *
 */
public class ResponseResult {
	/**
	 * 结果码
	 */
	private int code;
	
	/**
	 * 结果内容
	 */
	private String result;
	public ResponseResult() {}
	public ResponseResult(int code, String result) {
		this.code = code;
		this.result = result;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
}
