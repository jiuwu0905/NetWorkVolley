
package com.android.volley.eventtype;


/**
	@author Terry<br>
 *	@Time 2015年7月17日上午8:53:55<br>
 */
public class ErrorEvent {
	
	public String method;
	public String msg;
	
	public ErrorEvent(){}
	
	public ErrorEvent(String method){
		this.method = method;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	

}
