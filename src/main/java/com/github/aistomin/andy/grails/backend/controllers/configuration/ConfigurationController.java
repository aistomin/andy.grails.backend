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
package com.github.aistomin.andy.grails.backend.controllers.configuration;

import com.github.aistomin.andy.grails.backend.services.ConfigurationService;
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
     * Ctor.
     *
     * @param service Configuration service.
     */
    public ConfigurationController(final ConfigurationService service) {
        this.conf = service;
    }

    /**
     * Get social media links to our profiles and channels.
     *
     * @return Social media links.
     */
    @GetMapping(path = "/social/media/links")
    public List<SocialMediaLinkDto> socialMediaLinks() {
        log.info("ConfigurationController.socialMediaLinks is called .....");
        final var links = conf.findAllSocialMediaLinks();
        log.info(
            "ConfigurationController.socialMediaLinks returns {} links.",
            links.size()
        );
        return links;
    }
}
