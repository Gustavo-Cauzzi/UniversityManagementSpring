package com.gestao.exceptions;


public class MsgErroException extends Exception {

	private static final long serialVersionUID = -6965036355089243942L;

	public MsgErroException() {
		super();
	}

	public MsgErroException(String error) {
		super(error);
	}

	public MsgErroException(Throwable throwable) {
		super(throwable);
	}

	public MsgErroException(String error, Throwable throwable) {
		super(error, throwable);
	}

}
