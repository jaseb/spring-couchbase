package jp.bikon.common.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Copyright (c) 2017 Jase Batchelor. All rights reserved.
 *
 * @author jase
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Entity not found") // 404
public final class ResourceNotFoundException extends RuntimeException {

    private static final long serialVersionUID = -1L;
}
