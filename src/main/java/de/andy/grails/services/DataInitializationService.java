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
package de.andy.grails.services;

import de.andy.grails.model.DataGenerator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

/**
 * Service responsible for initializing application data.
 *
 * @since 0.1
 */
@Service
@Slf4j
public class DataInitializationService {

    /**
     * Data generator.
     */
    private final DataGenerator generator;

    /**
     * Ctor.
     *
     * @param gen Data generator.
     */
    public DataInitializationService(final DataGenerator gen) {
        this.generator = gen;
    }

    /**
     * Initialize application data when the application is ready.
     */
    @EventListener(ApplicationReadyEvent.class)
    public void initializeData() {
        log.info("Initializing application data...");
        final var videos = generator.generateVideosIfNecessary();
        log.info("{} videos generated.", videos);
        final var conf = generator.generateConfigurationIfNecessary();
        log.info("{} configuration entities generated.", conf);
        log.info("Application data initialization completed.");
    }
}
