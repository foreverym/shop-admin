package com.wy.shop.common.exception;


import com.wy.shop.common.constants.ExceptionConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ValidatorException extends Exception {

	private static final long serialVersionUID = 1L;
	private static final Logger logger = LoggerFactory.getLogger(ValidatorException.class);

	public static final ValidatorException VALIDATOR_PARAM_IS_NULL = new ValidatorException(
			ExceptionConstants.VALIDATOR_PARAM_IS_NULL, "参数校验失败,参数中存在Null或空内容");

	public static final ValidatorException VALIDATOR_PARAM_IS_INVALID = new ValidatorException(
			ExceptionConstants.VALIDATOR_PARAM_IS_INVALID, "参数校验失败,参数不合法");
	/**
	 * 异常信息
	 */
	protected String msg;

	/**
	 * 具体异常码
	 */
	protected String code;

	public ValidatorException(String code, String msgFormat, Object... args) {
		super(String.format(msgFormat, args));
		this.code = code;
		this.msg = String.format(msgFormat, args);
	}

	public ValidatorException() {
		super();
	}

	public ValidatorException(String message, Throwable cause) {
		super(message, cause);
	}

	public ValidatorException(Throwable cause) {
		super(cause);
	}

	public ValidatorException(String message) {
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
	public ValidatorException newInstance(String msgFormat, Object... args) {
		return new ValidatorException(this.code, msgFormat, args);
	}

	public ValidatorException print() {
		logger.warn("==>ValidatorException, code:" + this.code + ", msg:" + this.msg);
		return this;
	}
}
