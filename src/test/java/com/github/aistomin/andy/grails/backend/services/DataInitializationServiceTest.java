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
package com.github.aistomin.andy.grails.backend.services;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.github.aistomin.andy.grails.backend.model.DataGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

/**
 * Tests for DataInitializationService.
 *
 * @since 0.1
 */
@ExtendWith(MockitoExtension.class)
class DataInitializationServiceTest {

    /**
     * Count of expected test videos.
     */
    public static final int EXPECTED_VIDEOS = 5;

    /**
     * Count of expected test configurations.
     */
    public static final int EXPECTED_CONFIG = 3;

    /**
     * Mock data generator.
     */
    @Mock
    private DataGenerator generator;

    /**
     * Test that data initialization is called when application is ready.
     */
    @Test
    void testInitializeData() {
        when(generator.generateVideosIfNecessary())
            .thenReturn(EXPECTED_VIDEOS);
        when(generator.generateConfigurationIfNecessary())
            .thenReturn(EXPECTED_CONFIG);
        final var service = new DataInitializationService(generator);
        service.initializeData();
        verify(generator, times(1)).generateVideosIfNecessary();
        verify(generator, times(1)).generateConfigurationIfNecessary();
    }
}
