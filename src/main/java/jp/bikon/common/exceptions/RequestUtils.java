package jp.bikon.common.exceptions;

import org.springframework.util.StringUtils;

/**
 * Copyright (c) 2017 Jase Batchelor. All rights reserved.
 *
 * @author jase
 */
public final class RequestUtils {

    private RequestUtils() {
        throw new AssertionError();
    }

    /**
     * Ensures that an object reference passed as a parameter to the calling method is not null.
     *
     * @param <T> the entity type
     * @param reference an object reference
     * @return the non-null reference that was validated
     * @throws ResourceNotFoundException if {@code reference} is null
     */
    public static <T> T checkNotNull(final T reference) {
        if (reference == null) {
            throw new ResourceNotFoundException();
        }
        return reference;
    }

    /**
     * Ensures that an object reference passed as a parameter to the calling method is not null.
     *
     * @param <T> the entity type
     * @param reference an object reference
     * @return the non-null reference that was validated
     * @throws BadRequestException if {@code reference} is null
     */
    public static <T> T checkNotNullFromRequest(final T reference) {
        if (reference == null) {
            throw new BadRequestException();
        }
        return reference;
    }

    /**
     * Returns {@link ResourceNotFoundException} if false.
     * @param value {@link boolean}
     */
    public static void checkExists(final boolean value) {
        if (!value) {
            throw new ResourceNotFoundException();
        }
    }

    /**
     * Ensure that values are equal.
     *
     * @param strA {@link String} first string to check
     * @param strB {@link String} second string to check
     */
    public static void checkEqual(final String strA, final String strB) {

        if (!StringUtils.hasText(strA) || !StringUtils.hasText(strB)) {
            throw new BadRequestException();
        }

        if (!strA.equals(strB)) {
            throw new BadRequestException();
        }
    }
}
