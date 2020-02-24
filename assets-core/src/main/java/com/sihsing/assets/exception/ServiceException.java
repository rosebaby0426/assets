package com.sihsing.assets.exception;

/**
 *  Christine 2020/01/06
 *  自定義Exception，捕捉全域的異常處理
 */
@SuppressWarnings("serial")
public class ServiceException extends RuntimeException {

	public ServiceException() {
	}

	public ServiceException(String paramString) {
		super(paramString);
	}

	public ServiceException(Throwable paramThrowable) {
		super(paramThrowable);
	}

	public ServiceException(String paramString, Throwable paramThrowable) {
		super(paramString, paramThrowable);
	}

}
