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
package com.github.aistomin.andy.grails.backend;

import com.github.aistomin.andy.grails.backend.domain.DataGenerator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

/**
 * Main application class.
 */
@SpringBootApplication
@Slf4j
public class Application {

    /**
     * Data generator.
     */
    private final DataGenerator generator;

    /**
     * Ctor.
     *
     * @param gen Data generator.
     */
    protected Application(final DataGenerator gen) {
        this.generator = gen;
    }

    /**
     * Command line runner.
     *
     * @param ctx Application context.
     * @return Runner.
     */
    @Bean
    public CommandLineRunner commandLineRunner(final ApplicationContext ctx) {
        return args -> {
            log.info("Application is starting .....");
            final var videos = generator.generateVideosIfNecessary();
            log.info("{} videos generated.", videos);
            final var conf = generator.generateConfigurationIfNecessary();
            log.info("{} configuration entities generated.", conf);
            log.info("Application is up and running.");
        };
    }

    /**
     * The application's entry point.
     *
     * @param args Command line arguments.
     */
    public static void main(final String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
