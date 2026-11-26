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

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import de.andy.grails.utils.IntegrationTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.server.ResponseStatusException;

/**
 * Global exception handling tests.
 *
 * @since 0.3
 */
@Import({
    GlobalExceptionHandlerTest.FailingController.class,
    GlobalExceptionHandler.class
})
class GlobalExceptionHandlerTest extends IntegrationTest {

    /**
     * Web application context.
     */
    @Autowired
    private WebApplicationContext webApplicationContext;

    /**
     * Mock MVC.
     */
    private MockMvc mockMvc;

    /**
     * Setup mock MVC.
     */
    @BeforeEach
    void setUp() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext)
            .build();
    }

    /**
     * Check that we correctly handle any uncaught exception.
     *
     * @throws Exception If something goes wrong.
     */
    @Test
    void testHandleUncaughtException() throws Exception {
        mockMvc.perform(get("/failing-endpoint"))
            .andExpect(status().isInternalServerError())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(
                jsonPath("$.status").value(
                    HttpStatus.INTERNAL_SERVER_ERROR.value()))
            .andExpect(
                jsonPath("$.message")
                    .value("Internal server error occurred.")
            );
    }

    /**
     * Check that an unknown URL is answered with 404.
     *
     * @throws Exception If something goes wrong.
     */
    @Test
    void testHandleUnknownUrl() throws Exception {
        mockMvc.perform(get("/wp-login.php"))
            .andExpect(status().isNotFound())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(
                jsonPath("$.status").value(HttpStatus.NOT_FOUND.value()))
            .andExpect(jsonPath("$.message").value("Not Found"));
    }

    /**
     * Check that a wrong HTTP method is answered with 405.
     *
     * @throws Exception If something goes wrong.
     */
    @Test
    void testHandleWrongHttpMethod() throws Exception {
        mockMvc.perform(post("/videos"))
            .andExpect(status().isMethodNotAllowed())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(
                jsonPath("$.status").value(
                    HttpStatus.METHOD_NOT_ALLOWED.value()))
            .andExpect(jsonPath("$.message").value("Method Not Allowed"));
    }

    /**
     * Check that a non-numeric ID is answered with 400.
     *
     * @throws Exception If something goes wrong.
     */
    @Test
    void testHandleNonNumericId() throws Exception {
        mockMvc.perform(get("/videos/abc"))
            .andExpect(status().isBadRequest())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(
                jsonPath("$.status").value(HttpStatus.BAD_REQUEST.value()))
            .andExpect(jsonPath("$.message").value("Bad Request"));
    }

    /**
     * Check that a server error raised with its own status keeps that status.
     *
     * @throws Exception If something goes wrong.
     */
    @Test
    void testHandleServerErrorWithOwnStatus() throws Exception {
        mockMvc.perform(get("/unavailable-endpoint"))
            .andExpect(status().isServiceUnavailable())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(
                jsonPath("$.status").value(
                    HttpStatus.SERVICE_UNAVAILABLE.value()))
            .andExpect(jsonPath("$.message").value("Service Unavailable"));
    }

    /**
     * Controller that always blows up, so that the handler has something to
     * handle.
     *
     * @since 1.0
     */
    @RestController
    static final class FailingController {

        /**
         * Ctor.
         */
        FailingController() {
        }

        /**
         * Simulate an unhandled error in the controller.
         *
         * @return Nothing, the call always fails.
         */
        @GetMapping("/failing-endpoint")
        String throwError() {
            throw new IllegalStateException("Simulated failure");
        }

        /**
         * Simulate a server error that carries its own HTTP status.
         *
         * @return Nothing, the call always fails.
         */
        @GetMapping("/unavailable-endpoint")
        String throwUnavailable() {
            throw new ResponseStatusException(HttpStatus.SERVICE_UNAVAILABLE);
        }
    }
}
