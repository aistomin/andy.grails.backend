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
 * @todo: Issue #56. Let's remove the checkstyle warning suppression.
 */
@SuppressWarnings({
    "checkstyle:MagicNumber",
})
class ConfigurationControllerTest extends IntegrationTest {

    /**
     * Test that we correctly render our social media links to frontend.
     */
    @Test
    void testSocialMediaLinks() {
        final var response = template.exchange(
            "/configuration/social/media/links",
            HttpMethod.GET,
            null,
            new ParameterizedTypeReference<List<SocialMediaLinkDto>>() { }
        );
        final var links = response.getBody();
        Assertions.assertEquals(3, links.size());
    }
}
