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
package com.github.aistomin.andy.grails.backend.exceptions;

import lombok.Data;
import org.springframework.http.HttpStatus;

/**
 * Error response that we return to frontend.
 *
 * @since 0.3
 */
@Data
public final class ErrorResponse {

    /**
     * HTTP error status.
     */
    private final Integer status;

    /**
     * Error message.
     */
    private final String message;

    /**
     * Ctor.
     *
     * @param error HTTP error status.
     * @param msg Error message.
     */
    public ErrorResponse(final HttpStatus error, final String msg) {
        this.status = error.value();
        this.message = msg;
    }
}
