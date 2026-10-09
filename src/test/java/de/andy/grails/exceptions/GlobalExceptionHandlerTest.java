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
    }
}
