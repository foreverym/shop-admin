package com.wy.shop.common.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 异常基类
 */
public class BizException extends Exception {
	private static final long serialVersionUID = 1L;
	protected static final Logger logger = LoggerFactory.getLogger(BizException.class);

	/**
	 * 异常信息
	 */
	protected String msg;

	/**
	 * 具体异常码
	 */
	protected String code;

	public BizException(String code, String msgFormat, Object... args) {
		super(String.format(msgFormat, args));
		this.code = code;
		this.msg = String.format(msgFormat, args);
	}

	public BizException() {
		super();
	}

	public BizException(String message, Throwable cause) {
		super(message, cause);
	}

	public BizException(Throwable cause) {
		super(cause);
	}

	public BizException(String message) {
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
	public BizException newInstance(String msgFormat, Object... args) {
		return new BizException(this.code, msgFormat, args);
	}

	public BizException print() {
		logger.warn("==>[], code:[], msg:[]", this.getClass().getSimpleName(), this.code, this.msg);
		return this;
	}
}
