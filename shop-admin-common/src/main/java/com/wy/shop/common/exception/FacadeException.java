package com.wy.shop.common.exception;

import com.wy.shop.common.constants.ExceptionConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 异常基类
 */
public class FacadeException extends Exception {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LoggerFactory.getLogger(FacadeException.class);

	public static final FacadeException FACADE_JSON_CONVERT_ERROR = new FacadeException(
			ExceptionConstants.FACADE_JSON_CONVERT_ERROR, "Parameter conversion failed, JSON string exception");
	public static final FacadeException FACADE_JSON_IS_NULL = new FacadeException(
			ExceptionConstants.FACADE_JSON_IS_NULL, "Parameter conversion failed, JSON is empty");
	public static final FacadeException FACADE_UNHANDLE_FOUND = new FacadeException(
			ExceptionConstants.FACADE_INVALID_METHOD, "Invalid method name parameter");

	/**
	 * 异常信息
	 */
	protected String msg;

	/**
	 * 具体异常码
	 */
	protected String code;

	public FacadeException(String code, String msgFormat, Object... args) {
		super(String.format(msgFormat, args));
		this.code = code;
		this.msg = String.format(msgFormat, args);
	}

	public FacadeException() {
		super();
	}

	public FacadeException(String message, Throwable cause) {
		super(message, cause);
	}

	public FacadeException(Throwable cause) {
		super(cause);
	}

	public FacadeException(String message) {
		super(message);
	}

	public String getMsg() {
		return msg;
	}

	public String getCode() {
		return code;
	}

	/**
	 * 实例化异常
	 */
	public FacadeException newInstance(String msgFormat, Object... args) {
		return new FacadeException(this.code, msgFormat, args);
	}

	public FacadeException print() {
		logger.warn("==>FacadeException, code:" + this.code + ", msg:" + this.msg);
		return this;
	}
}
