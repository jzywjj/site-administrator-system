package com.lft.common;

import lombok.Getter;

/**
 * 自定义异常
 */
@Getter
public class CommonException extends Exception  {

    /**
	 * 
	 */
	private static final long serialVersionUID = 2536067423256167407L;
	private RCode resultCode;

    public CommonException(RCode resultCode) {
        this.resultCode = resultCode;
    }
}
