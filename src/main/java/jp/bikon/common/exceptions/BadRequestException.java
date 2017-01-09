package jp.bikon.common.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Copyright (c) 2017 Jase Batchelor. All rights reserved.
 *
 * @author jase
 */
@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Bad request") // 400
public final class BadRequestException extends RuntimeException {

    private static final long serialVersionUID = -1L;
}
