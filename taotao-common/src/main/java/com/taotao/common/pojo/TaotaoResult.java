package com.taotao.common.pojo;

import java.io.Serializable;

/**
 * 
 * @ClassName TaotaoResult
 * @author wuyunhuan
 * @date 2019/05/14
 */
public class TaotaoResult implements Serializable {

	private Integer status;

	private String msg;

	private Object data;

	public static TaotaoResult build(Integer status, String msg, Object data) {
		return new TaotaoResult(status, msg, data);
	}

	public static TaotaoResult ok(Object data) {
		return new TaotaoResult(data);
	}

	public static TaotaoResult ok() {
		return new TaotaoResult(null);
	}

	public TaotaoResult() {

	}

	public static TaotaoResult build(Integer status, String msg) {
		return new TaotaoResult(status, msg, null);
	}

	public TaotaoResult(Integer status, String msg, Object data) {
		this.status = status;
		this.msg = msg;
		this.data = data;
	}

	public TaotaoResult(Object data) {
		this.status = 200;
		this.msg = "OK";
		this.data = data;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

}
