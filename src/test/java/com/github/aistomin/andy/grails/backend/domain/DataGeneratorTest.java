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
package com.github.aistomin.andy.grails.backend.domain;

import com.github.aistomin.andy.grails.backend.utils.IntegrationTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Tests for {@link DataGenerator}.
 *
 * @since 1.0
 */
class DataGeneratorTest extends IntegrationTest {

    /**
     * Data generator.
     */
    @Autowired
    private DataGenerator generator;

    /**
     * Check that DataGenerator.generateVideosIfNecessary() generates data only
     * once.
     */
    @Test
    void generateVideosIfNecessary() {
        Assertions.assertEquals(
            0, generator.generateVideosIfNecessary()
        );
    }

    /**
     * Check that DataGenerator.generateConfigurationIfNecessary() generates
     * data only once.
     */
    @Test
    void generateConfigurationIfNecessary() {
        Assertions.assertEquals(
            0, generator.generateConfigurationIfNecessary()
        );
    }
}
