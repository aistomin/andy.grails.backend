/*
 * Copyright (c) 2025 Andrej Istomin
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package de.andy.grails.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Global exception handler.
 *
 * @since 0.3
 */
@ControllerAdvice
@Slf4j
public final class GlobalExceptionHandler {

    /**
     * Ctor.
     */
    public GlobalExceptionHandler() {
    }

    /**
     * Handle any exception that is not caught and processed by dedicated
     * handlers.
     *
     * @param error The error that was uncaught.
     * @return Error response.
     */
    @ExceptionHandler(Throwable.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public ErrorResponse handleUncaughtException(final Throwable error) {
        log.error("Uncaught application error.", error);
        return new ErrorResponse(
            HttpStatus.INTERNAL_SERVER_ERROR,
            "Internal server error occurred."
        );
    }

    /**
     * Handle exception that we throw when requested resource is not found.
     *
     * @param ex The not found exception.
     * @return Error response.
     */
    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public ErrorResponse handleNotFoundException(final NotFoundException ex) {
        return new ErrorResponse(HttpStatus.NOT_FOUND, ex.getMessage());
    }
}
