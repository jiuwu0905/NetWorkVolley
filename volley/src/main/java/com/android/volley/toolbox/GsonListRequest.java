/*
 * Copyright (C) 2011 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.android.volley.toolbox;

import android.text.TextUtils;
import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.bean.Info;
import com.android.volley.encrypt.DES;
import com.android.volley.tool.VolleyErrorListener;
import com.android.volley.tool.VolleyListener;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import java.lang.reflect.Type;
import java.net.URLDecoder;
import java.util.Map;

/**
 * A request for retrieving a T type response body at a given URL that also
 * optionally sends along a JSON body in the request specified.
 * 
 * @param <T>
 *            JSON type of response expected
 */
public class GsonListRequest<T> extends Request<T> {

	private final Listener<T> mListener;

	private Type type;

	private boolean decryption;

	private Map<String,String> mPostParams = null;

	public GsonListRequest(String url, Type type, Listener<T> listener,
			ErrorListener errorListener) {
		this(Method.DEPRECATED_GET_OR_POST, url, type, listener, errorListener);
	}
	
	
	public GsonListRequest(String url, Type type, Listener<T> listener,
			ErrorListener errorListener,boolean decryption) {
		this(Method.DEPRECATED_GET_OR_POST, url, type, listener, errorListener ,decryption);
	}

	
	public GsonListRequest(String url, Type type, VolleyListener<T> listener,
			VolleyErrorListener errorListener,boolean decryption) {
		this(Method.DEPRECATED_GET_OR_POST, url, type, listener, errorListener ,decryption);
		if(errorListener != null){
			errorListener.method = listener.methodName;
		}

	}


	public void setPostParams(Map<String,String> map){
		this.mPostParams = map;
		if(VolleyLog.RESULT_DEBUG) {
			Log.e("Terry", "======================= postparams ===================");
			Log.e("Terry", mPostParams.toString());
		}
	}


	@Override
	protected Map<String, String> getParams() throws AuthFailureError {
		return mPostParams;
	}

	public GsonListRequest(int method, String url, Type type,
			Listener<T> listener, ErrorListener errorListener) {
		this(method, url, type, listener, errorListener, false);
	}

	public GsonListRequest(int method, String url, Type type,
			Listener<T> listener, ErrorListener errorListener,
			boolean decryption) {
		super(method, url, errorListener);
		mListener = listener;
		this.type = type;
		this.decryption = decryption;
	}



	@Override
	protected void deliverResponse(T response) {
		mListener.onResponse(response);
	}

	// @Override
	// abstract protected Response<T> parseNetworkResponse(NetworkResponse
	// response);

	@SuppressWarnings("unchecked")
	@Override
	protected Response<T> parseNetworkResponse(NetworkResponse response) {
		VolleyError error;
		String jsonString = null;
		try {
			jsonString = new String(response.data,
					HttpHeaderParser.parseCharset(response.headers) );
			if (decryption) {
                if(TextUtils.isEmpty(mDesKey)){
                    throw new VolleyError("do you forget to set the deskey");
                }
				jsonString = URLDecoder.decode(DES.Decrypt(jsonString, mDesKey), "utf-8");
			}
			if(VolleyLog.RESULT_DEBUG) {
				Log.e("Terry", "======================= Result ===================");
				Log.e("Terry", jsonString);
			}
			return (Response<T>) Response.success(
					new Gson().fromJson(jsonString, type),HttpHeaderParser.parseCacheHeaders(response));
		}  catch (Exception e) {
			Info info = getInfo(jsonString);
			return Response.error(new ParseError(e,info));
		}
	}



	private Info getInfo(String jsonString){
		if(jsonString == null) return null;
		try {
			return new Gson().fromJson(jsonString, Info.class);
		} catch (JsonSyntaxException e) {
			e.printStackTrace();
			return null;
		}
	}




}
