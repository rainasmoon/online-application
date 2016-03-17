package com.rainasmoon.onepay.util;

import java.io.PrintStream;
import java.io.PrintWriter;

/**
 * 异常基类
 */
public class ApplicationException extends RuntimeException {

	private static final long serialVersionUID = 5895564360062475935L;
	private Throwable nestedThrowable = null;

	public ApplicationException() {
		super();
	}

	public ApplicationException(String msg) {
		super(msg);
	}

	public ApplicationException(Throwable nestedThrowable) {
		this.nestedThrowable = nestedThrowable;
	}

	public ApplicationException(String msg, Throwable nestedThrowable) {
		super(msg);
		this.nestedThrowable = nestedThrowable;
	}

	@Override
	public void printStackTrace() {
		super.printStackTrace();
		if (nestedThrowable != null) {
			nestedThrowable.printStackTrace();
		}
	}

	@Override
	public void printStackTrace(PrintStream ps) {
		super.printStackTrace(ps);
		if (nestedThrowable != null) {
			nestedThrowable.printStackTrace(ps);
		}
	}

	@Override
	public void printStackTrace(PrintWriter pw) {
		super.printStackTrace(pw);
		if (nestedThrowable != null) {
			nestedThrowable.printStackTrace(pw);
		}
	}
}
