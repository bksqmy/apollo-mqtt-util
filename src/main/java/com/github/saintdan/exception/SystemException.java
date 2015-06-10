package com.github.saintdan.exception;

import com.github.saintdan.enums.ErrorType;

/**
 * Abstract superclass for all exceptions related to an
 * {@link SystemException} object being invalid for whatever reason.
 *
 * @author <a href="http://github.com/saintdan">Liao Yifan</a>
 * @date 6/10/15
 * @since JDK1.8
 */
public abstract class SystemException extends Exception {

    /**
     * Error Type
     */
    private ErrorType errorType;

    /**
     * Constructs an {@code SystemException} with the specified message and root cause.
     *
     * @param msg the {@link ErrorType}
     * @param t   the root cause
     */
    public SystemException(ErrorType msg, Throwable t) {
        super(msg.name() + ": " + msg.value(), t);
        this.errorType = msg;
    }

    /**
     * Constructs an {@code SystemException} with the specified message and no root cause.
     *
     * @param msg the {@link ErrorType}
     */
    public SystemException(ErrorType msg) {
        super(msg.name() + ": " + msg.value());
        this.errorType = msg;
    }

    /**
     * Constructs an {@code SystemException}
     */
    public SystemException() {
        this(ErrorType.SYS0001);
    }


    private ErrorType obtainErrorType() {
        if (errorType == null) {
            return ErrorType.SYS0001;
        }
        return errorType;

    }

    /**
     * Get error type
     *
     * @return {@link ErrorType}
     */
    public ErrorType getErrorType() {
        return obtainErrorType();
    }

    /**
     * Get error code
     *
     * @return error code
     */
    public String getErrorCode() {
        return obtainErrorType().name();
    }

    /**
     * Get error msg
     *
     * @return error msg
     */
    public String getErrorMsg() {
        return obtainErrorType().value();
    }
}