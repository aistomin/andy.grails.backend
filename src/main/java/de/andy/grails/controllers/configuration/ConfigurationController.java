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
package de.andy.grails.controllers.configuration;

import de.andy.grails.services.ConfigurationService;
import de.andy.grails.services.mappers.WebLinkMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

/**
 * Configuration controller.
 *
 * @since 0.3
 */
@RestController
@RequestMapping("/configuration")
@Slf4j
public class ConfigurationController {

    /**
     * Configuration service.
     */
    private final ConfigurationService conf;

    /**
     * Web link mapper.
     */
    private final WebLinkMapper webLinkMapper;

    /**
     * Ctor.
     *
     * @param service Configuration service.
     * @param mapper Web link mapper.
     */
    public ConfigurationController(
        final ConfigurationService service,
        final WebLinkMapper mapper
    ) {
        this.conf = service;
        this.webLinkMapper = mapper;
    }

    /**
     * Get web links to our social media profiles, channels etc.
     *
     * @return Web links.
     */
    @GetMapping(path = "/web/links")
    public List<WebLinkDto> webLinks() {
        log.info("ConfigurationController.webLinks is called .....");
        final var links = conf.findAllWebLinks()
            .stream()
            .map(webLinkMapper::toDto)
            .toList();
        log.info(
            "ConfigurationController.webLinks returns {} links.",
            links.size()
        );
        return links;
    }
}
