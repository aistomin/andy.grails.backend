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

import jakarta.validation.ConstraintViolationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * Global exception handler.
 *
 * @since 0.3
 */
@ControllerAdvice
@Slf4j
public final class GlobalExceptionHandler
    extends ResponseEntityExceptionHandler {

    /**
     * Ctor.
     */
    public GlobalExceptionHandler() {
        super();
    }

    /**
     * Answer the framework's own request errors (unknown URL, wrong HTTP
     * method, malformed parameter, etc.) with the status the framework
     * assigned to them.
     *
     * A request we reject is the caller's mistake, not ours: only the server
     * errors are logged as errors, so that the error log contains nothing but
     * the problems that need our action.
     *
     * @param ex The exception raised by the framework.
     * @param body The body suggested by the framework, we replace it.
     * @param headers The response headers.
     * @param code The HTTP status assigned by the framework.
     * @param request The current request.
     * @return Error response.
     */
    @Override
    protected ResponseEntity<Object> handleExceptionInternal(
        final Exception ex,
        final Object body,
        final HttpHeaders headers,
        final HttpStatusCode code,
        final WebRequest request
    ) {
        final var status = HttpStatus.valueOf(code.value());
        if (status.is5xxServerError()) {
            log.error("Request failed with {}.", status, ex);
        } else {
            log.warn("Request rejected with {}: {}", status, ex.getMessage());
        }
        return new ResponseEntity<>(
            new ErrorResponse(status, status.getReasonPhrase()),
            headers,
            status
        );
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
     * Handle constraint violation exceptions (e.g. invalid path variables).
     *
     * @param ex The constraint violation exception.
     * @return Error response.
     */
    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ErrorResponse handleConstraintViolationException(
        final ConstraintViolationException ex
    ) {
        return new ErrorResponse(HttpStatus.BAD_REQUEST, ex.getMessage());
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
