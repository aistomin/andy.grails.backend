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
package de.andy.grails.domain;

import de.andy.grails.model.DataGenerator;
import de.andy.grails.utils.IntegrationTest;
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
     * Expected length of the text file.
     */
    private static final int EXPECTED_TEXT_LENGTH = 2428;

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
    void testGenerateVideosIfNecessary() {
        Assertions.assertEquals(
            0, generator.generateVideosIfNecessary()
        );
    }

    /**
     * Check that DataGenerator.generateConfigurationIfNecessary() generates
     * data only once.
     */
    @Test
    void testGenerateConfigurationIfNecessary() {
        Assertions.assertEquals(
            0, generator.generateConfigurationIfNecessary()
        );
    }

    /**
     * Check that we correctly read a text file from resources.
     */
    @Test
    void testReadFile() {
        final var text = generator.readFile("videos/sarabande.txt");
        Assertions.assertTrue(text.startsWith("Lorem ipsum dolor sit amet"));
        Assertions.assertTrue(text.endsWith("Quisque ac faucibus tortor.\n"));
        Assertions.assertEquals(EXPECTED_TEXT_LENGTH, text.length());
        Assertions.assertThrows(
            RuntimeException.class,
            () -> generator.readFile("non-existing.txt")
        );
    }
}
