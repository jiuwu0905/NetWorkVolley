
package com.android.volley.eventtype;


/**
	@author Terry<br>
 *	@Time 2015年7月16日下午3:44:31<br>
 */
public class EventRequestOk {
	
	
	public boolean isDataEmpty;
	public String message;
	
	
	public EventRequestOk(){
	}
	
	public EventRequestOk(boolean isDataEmpty){
		this(isDataEmpty,null);
	}
	
	public EventRequestOk(String message){
		this(false, message);
	}
	
	public EventRequestOk(boolean isDataEmpty, String message){
		this.isDataEmpty = isDataEmpty;
		this.message = message;
	}
	
}
