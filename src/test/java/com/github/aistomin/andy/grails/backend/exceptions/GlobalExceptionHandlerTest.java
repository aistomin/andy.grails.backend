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

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import com.github.aistomin.andy.grails.backend.controllers.test.TestExceptionController;
import com.github.aistomin.andy.grails.backend.model.DataGenerator;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

/**
 * Global exception handling tests.
 *
 * @since 0.3
 */
@WebMvcTest(controllers = TestExceptionController.class)
@Import({
    GlobalExceptionHandler.class,
    GlobalExceptionHandlerTest.TestConfig.class
})
class GlobalExceptionHandlerTest {

    /**
     * Mock MVC.
     */
    @Autowired
    private MockMvc mockMvc;

    /**
     * Check that we correctly handle any uncaught exception.
     *
     * @throws Exception If something goes wrong.
     */
    @Test
    void testHandleUncaughtException() throws Exception {
        mockMvc.perform(get("/test/error"))
            .andExpect(status().isInternalServerError())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(
                jsonPath("$.status").value(
                    HttpStatus.INTERNAL_SERVER_ERROR.value()
                )
            )
            .andExpect(
                jsonPath("$.message").value("Internal server error occurred.")
            );
    }

    /**
     * We mock data generator here.
     *
     * @since 0.3
     * @todo: Issue #96. Let's decouple DataGenerator from Application and
     * remove this test configuration.
     */
    @TestConfiguration
    static class TestConfig {

        /**
         * Mock data generator.
         *
         * @return Mock object.
         */
        @Bean
        public DataGenerator dataGenerator() {
            return Mockito.mock(DataGenerator.class);
        }
    }
}
