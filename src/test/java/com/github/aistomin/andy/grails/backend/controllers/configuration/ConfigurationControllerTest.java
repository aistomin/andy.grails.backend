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

import com.github.aistomin.andy.grails.backend.utils.IntegrationTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import java.util.List;

/**
 * Test for {@link ConfigurationController}.
 *
 * @since 0.3
 */
class ConfigurationControllerTest extends IntegrationTest {

    /**
     * Count of the links that we store for test.
     */
    public static final int EXPECTED_LINKS_COUNT = 4;

    /**
     * Test that we correctly render our social media links to frontend.
     */
    @Test
    void testSocialMediaLinks() {
        final var response = template.exchange(
            "/configuration/social/media/links",
            HttpMethod.GET,
            null,
            new ParameterizedTypeReference<List<SocialMediaLinkDto>>() {
            }
        );
        final var links = response.getBody();
        Assertions.assertEquals(EXPECTED_LINKS_COUNT, links.size());
        final var youtube = links.stream().filter(dto ->
            dto.socialMedia() == SocialMedia.YOUTUBE
        ).findFirst().get();
        Assertions.assertEquals(
            "https://www.youtube.com/@andygrails", youtube.url()
        );
        final var instagram = links.stream().filter(dto ->
            dto.socialMedia() == SocialMedia.INSTAGRAM
        ).findFirst().get();
        Assertions.assertEquals(
            "https://www.instagram.com/andy.grails/", instagram.url()
        );
        final var facebook = links.stream().filter(dto ->
            dto.socialMedia() == SocialMedia.FACEBOOK
        ).findFirst().get();
        Assertions.assertEquals(
            "https://www.facebook.com/profile.php?id=100074082643728",
            facebook.url()
        );
        final var github = links.stream().filter(dto ->
            dto.socialMedia() == SocialMedia.GITHUB
        ).findFirst().get();
        Assertions.assertEquals(
            "https://github.com/aistomin",
            github.url()
        );
    }
}
