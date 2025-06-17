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
package com.github.aistomin.andy.grails.backend.controllers.videos;

import com.github.aistomin.andy.grails.backend.utils.IntegrationTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import java.util.List;

/**
 * Test for {@link VideoController}.
 *
 * @since 0.1
 * @todo: Issue #56. Let's remove the checkstyle warning suppression.
 */
@SuppressWarnings({
    "checkstyle:MagicNumber",
})
class VideoControllerTest extends IntegrationTest {

    /**
     * Test that we correctly render videos over the API.
     */
    @Test
    void testListVideos() {
        final var response = template.exchange(
            "/videos",
            HttpMethod.GET,
            null,
            new ParameterizedTypeReference<List<VideoDto>>() { }
        );
        final var videos = response.getBody();
        Assertions.assertEquals(9, videos.size());
        Assertions.assertEquals(
            "Klaus Schindler - Zeit für Träume // Andrej Istomin",
            videos.get(0).title()
        );
    }

    /**
     * Test that we correctly render the video that is found by ID.
     */
    @Test
    void testFindById() {
        final var response = template.exchange(
            "/videos/6",
            HttpMethod.GET,
            null,
            new ParameterizedTypeReference<VideoDto>() { }
        );
        final var video = response.getBody();
        Assertions.assertEquals(6L, video.id());
        Assertions.assertEquals(
            "Greensleeves(English traditional) // Andrej Istomin",
            video.title()
        );
    }
}
