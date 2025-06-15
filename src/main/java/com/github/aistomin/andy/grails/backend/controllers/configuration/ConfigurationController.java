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

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Arrays;
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
     * Get social media links to our profiles and channels.
     *
     * @return Social media links.
     */
    @GetMapping(path = "/social/media/links")
    public List<SocialMediaLinkDto> socialMediaLinks() {
        return Arrays.asList(
            new SocialMediaLinkDto(
                0L,
                SocialMedia.YOUTUBE,
                "https://youtube.com/channel/"
            ),
            new SocialMediaLinkDto(
                1L,
                SocialMedia.INSTAGRAM,
                "https://www.instagram.com/"
            ),
            new SocialMediaLinkDto(
                2L,
                SocialMedia.FACEBOOK,
                "https://facebook.com/"
            )
        );
    }
}
